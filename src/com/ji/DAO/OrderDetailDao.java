/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 7 "../../../OrderDetailDao.ump"
public class OrderDetailDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderDetailDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //OrderDetailDao Associations
  private JDBConnection jdbc;
  private OrderDetail orderDetail;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderDetailDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, OrderDetail aOrderDetail)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create OrderDetailDao due to aJdbc");
    }
    if (!setOrderDetail(aOrderDetail))
    {
      throw new RuntimeException("Unable to create OrderDetailDao due to aOrderDetail");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPs(PreparedStatement aPs)
  {
    boolean wasSet = false;
    ps = aPs;
    wasSet = true;
    return wasSet;
  }

  public boolean setConnection(Connection aConnection)
  {
    boolean wasSet = false;
    connection = aConnection;
    wasSet = true;
    return wasSet;
  }

  public PreparedStatement getPs()
  {
    return ps;
  }

  public Connection getConnection()
  {
    return connection;
  }

  public JDBConnection getJdbc()
  {
    return jdbc;
  }

  public OrderDetail getOrderDetail()
  {
    return orderDetail;
  }

  public boolean setJdbc(JDBConnection aNewJdbc)
  {
    boolean wasSet = false;
    if (aNewJdbc != null)
    {
      jdbc = aNewJdbc;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setOrderDetail(OrderDetail aNewOrderDetail)
  {
    boolean wasSet = false;
    if (aNewOrderDetail != null)
    {
      orderDetail = aNewOrderDetail;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    orderDetail = null;
  }

  // line 17 "../../../OrderDetailDao.ump"
   public  OrderDetailDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 21 "../../../OrderDetailDao.ump"
   public List<OrderDetail> selectOrderDetailNumber(String number){
    List<OrderDetail> list =new ArrayList<OrderDetail>();
  OrderDetail orderDetail=null;
  Member member=new Member();
  Address address=new Address();
     Goods goodsForm= new Goods();
      GoodsDao goodsDao= new GoodsDao();
  try {
    ps = connection.prepareStatement("select * from db_orderDetail where orderNumber=?");
    ps.setString(1,number);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
      orderDetail=new OrderDetail();
      orderDetail.setId(Integer.valueOf(rs.getString(1)));
      orderDetail.setOrderNumber(rs.getString(2));
      orderDetail.setPrice(Double.parseDouble(rs.getString(3)));
      orderDetail.setQuantity(Integer.parseInt(rs.getString(4)));
   
      goodsForm = goodsDao.selectOneGoods(Integer.parseInt(rs.getString(5)));
      orderDetail.addGood(goodsForm);
      list.add(orderDetail);
    }
  }
  catch (SQLException ex) {
	  ex.printStackTrace();
  }
    return list;
  }

  // line 51 "../../../OrderDetailDao.ump"
   public void insertOrderDetail(OrderDetail form){
    try {
      ps = connection.prepareStatement("insert into db_orderDetail values (null,?,?,?,?,?)");
      ps.setString(1, form.getOrderNumber());
      ps.setDouble(2, form.getPrice());
      ps.setInt(3, form.getQuantity());
     for(int i=0;i<form.getGoods().size();i++){
      ps.setInt(4, form.getGood(i).getId());}
      ps.setInt(5, form.getOrder().getId());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 68 "../../../OrderDetailDao.ump"
   public void deleteOrderDetail(String number){
    try {
      ps = connection.prepareStatement("delete from db_orderDetail where orderNumber=?");
      ps.setString(1,number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ps" + "=" + (getPs() != null ? !getPs().equals(this)  ? getPs().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "jdbc = "+(getJdbc()!=null?Integer.toHexString(System.identityHashCode(getJdbc())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderDetail = "+(getOrderDetail()!=null?Integer.toHexString(System.identityHashCode(getOrderDetail())):"null")
     + outputString;
  }
}