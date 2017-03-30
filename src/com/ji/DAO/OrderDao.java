/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../OrderDao.ump"
public class OrderDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //OrderDao Associations
  private JDBConnection jdbc;
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Order aOrder)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create OrderDao due to aJdbc");
    }
    if (!setOrder(aOrder))
    {
      throw new RuntimeException("Unable to create OrderDao due to aOrder");
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

  public Order getOrder()
  {
    return order;
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

  public boolean setOrder(Order aNewOrder)
  {
    boolean wasSet = false;
    if (aNewOrder != null)
    {
      order = aNewOrder;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    order = null;
  }

  // line 16 "../../../OrderDao.ump"
   public  OrderDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 20 "../../../OrderDao.ump"
   public List<Order> selectOrderHead(Integer id){
    List<Order> list=new ArrayList<Order>();
    Order order = null;
     Member memberForm = new Member();
       MemberDao memberDao = new MemberDao();
       Address addressForm= new Address();
        AddressDao addressDao = new AddressDao();
   try {
     ps = connection.prepareStatement("select * from db_order where memberId=?");
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {
       order = new Order();
       order.setId(Integer.valueOf(rs.getString(1)));
       order.setOrderNumber(rs.getString(2));
       order.setPaymentMethod(rs.getString(3));
       order.setShipmentMethod(rs.getString(4));
       order.setMessage(rs.getString(5));
        
       addressForm = addressDao.selectOneAddress(Integer.valueOf(rs.getString(6)));
       order.setAddress(addressForm);
      
       memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(7)));
       order.setMember(memberForm);
       if (rs.getString(8).equals("paid")){
    	   
    	   order.makePayment();
    	  
       }else if(rs.getString(8).equals("shipped")){
           order.makePayment();
    	   order.ship();
       }
       else if(rs.getString(8).equals("delivered")){
         order.makePayment();
    	   order.ship();
    	   order.confirmedDelivery();
       }
       list.add(order);

     }
   }
   catch (SQLException ex) {
	   ex.printStackTrace();
   }
   return list;
  }

  // line 70 "../../../OrderDao.ump"
   public Order selectOrderNumber(String number){
    Order order = null;
    Member memberForm = new Member();
       MemberDao memberDao = new MemberDao();
        Address addressForm= new Address();
        AddressDao addressDao = new AddressDao();
    try {
      ps = connection.prepareStatement("select * from db_order where orderNumber=?");
      ps.setString(1, number);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new Order();
      order.setId(Integer.valueOf(rs.getString(1)));
       order.setOrderNumber(rs.getString(2));
       order.setPaymentMethod(rs.getString(3));
       order.setShipmentMethod(rs.getString(4));
       order.setMessage(rs.getString(5));
       
       addressForm = addressDao.selectOneAddress(Integer.valueOf(rs.getString(6)));
       order.setAddress(addressForm);
       
       memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(7)));
       if (rs.getString(8).equals("paid")){
    	   
    	   order.makePayment();
    	   
       }else if(rs.getString(8).equals("shipped")){
          order.makePayment();
    	   order.ship();
       }
       else if(rs.getString(8).equals("delivered")){
        order.makePayment();
         order.ship();
    	   order.confirmedDelivery();
       }
       order.setMember(memberForm);

      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return order;
  }

  // line 116 "../../../OrderDao.ump"
   public void updateStatusOrder(String number){
    try {
      ps = connection.prepareStatement("update db_order set status = 'paid' where orderNumber=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 128 "../../../OrderDao.ump"
   public void updateStatusOrderShip(String number){
    try {
      ps = connection.prepareStatement("update db_order set status = 'shipped' where orderNumber=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 140 "../../../OrderDao.ump"
   public void updateStatusOrderDeliver(Integer id){
    try {
      ps = connection.prepareStatement("update db_order set status = 'delivered' where id=?");
      ps.setInt(1, id);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 153 "../../../OrderDao.ump"
   public boolean deleteOrder(String number){
    try {
      ps = connection.prepareStatement("delete from db_order where orderNumber=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
      return false;
    }
  }

  // line 168 "../../../OrderDao.ump"
   public List<Order> selectOrderSign(String sign){
    List<Order> list = new ArrayList<Order>();
    Order order = null;
    Member memberForm = new Member();
       MemberDao memberDao = new MemberDao();
        Address addressForm= new Address();
        AddressDao addressDao = new AddressDao();
    try {
      if (sign == null) {
        ps = connection.prepareStatement("select * from db_order order by id DESC");
      }
      else {
        ps = connection.prepareStatement("select * from db_order where status=? order by id DESC");
        ps.setString(1, sign);
      }
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new Order();
         order.setId(Integer.valueOf(rs.getString(1)));
       order.setOrderNumber(rs.getString(2));
       order.setPaymentMethod(rs.getString(3));
       order.setShipmentMethod(rs.getString(4));
       order.setMessage(rs.getString(5));
       
       addressForm = addressDao.selectOneAddress(Integer.valueOf(rs.getString(6)));
       order.setAddress(addressForm);
       
       memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(7)));
       order.setMember(memberForm);
       if (rs.getString(8).equals("paid")){
    	   
    	   order.makePayment();
    	  
       }else if(rs.getString(8).equals("shipped")){
           order.makePayment();
    	   order.ship();
       }
       else if(rs.getString(8).equals("delivered")){
        order.makePayment();
    	   order.ship();
    	   order.confirmedDelivery();
       }
        list.add(order);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 218 "../../../OrderDao.ump"
   public List<Order> selectOrderList(){
    List<Order> list=new ArrayList<Order>();
	    Order order = null;
	     Member memberForm = new Member();
	       MemberDao memberDao = new MemberDao();
	       Address addressForm= new Address();
	        AddressDao addressDao = new AddressDao();
	   try {
	     ps = connection.prepareStatement("select * from db_order order by id DESC");
	    
	     ResultSet rs = ps.executeQuery();
	     while (rs.next()) {
	       order = new Order();
	       order.setId(Integer.valueOf(rs.getString(1)));
	       order.setOrderNumber(rs.getString(2));
	       order.setPaymentMethod(rs.getString(3));
	       order.setShipmentMethod(rs.getString(4));
	       order.setMessage(rs.getString(5));
	        
	       addressForm = addressDao.selectOneAddress(Integer.valueOf(rs.getString(6)));
	       order.setAddress(addressForm);
	      
	       memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(7)));
	       order.setMember(memberForm);
	     
	       if (rs.getString(8).equals("paid")){
	    	   
	    	   order.makePayment();
	    	   
	       }else if(rs.getString(8).equals("shipped")){
	    	   order.makePayment();
	    	   order.ship();
	    	   System.out.println("ppppp"+order.getStatus());
	       }
	       else if(rs.getString(8).equals("delivered")){
	    	   order.makePayment();
	    	   order.ship();
	    	   order.confirmedDelivery();
	       }
	       list.add(order);

	     }
	   }
	   catch (SQLException ex) {
		   ex.printStackTrace();
	   }
	   return list;
  }

  // line 268 "../../../OrderDao.ump"
   public void insertOrderDetail(Order form){
    try {
      ps = connection.prepareStatement("insert into db_order values (null,?,?,?,?,?,?,?)");
      ps.setString(1, form.getOrderNumber());    
      ps.setString(2, form.getPaymentMethod());
      ps.setString(3, form.getShipmentMethod());
      ps.setString(4, form.getMessage());
      ps.setString(5, String.valueOf(form.getAddress().getId()));
      ps.setString(6,String.valueOf(form.getMember().getId()));
       ps.setString(7,String.valueOf(form.getStatus()));
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
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null")
     + outputString;
  }
}