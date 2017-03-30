/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../GoodsDao.ump"
public class GoodsDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GoodsDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //GoodsDao Associations
  private JDBConnection jdbc;
  private Goods goodsForm;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GoodsDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Goods aGoodsForm)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create GoodsDao due to aJdbc");
    }
    if (!setGoodsForm(aGoodsForm))
    {
      throw new RuntimeException("Unable to create GoodsDao due to aGoodsForm");
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

  public Goods getGoodsForm()
  {
    return goodsForm;
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

  public boolean setGoodsForm(Goods aNewGoodsForm)
  {
    boolean wasSet = false;
    if (aNewGoodsForm != null)
    {
      goodsForm = aNewGoodsForm;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    goodsForm = null;
  }

  // line 15 "../../../GoodsDao.ump"
   public  GoodsDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 20 "../../../GoodsDao.ump"
   public void updateGoodsNumber(int number, Integer id){
    try {
      ps = connection.prepareStatement("update db_goods set numberInInventory=numberInInventory-? where id=?");
      ps.setInt(1, number);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 34 "../../../GoodsDao.ump"
   public void managerPrice(Goods form){
    try {
      ps = connection.prepareStatement("update db_goods set salePrice=?,status=? where id=?");
      ps.setDouble(1,(double) form.getSalePrice());
      ps.setString(2, String.valueOf(form.getStatus()));
      ps.setInt(3, form.getId());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 48 "../../../GoodsDao.ump"
   public List<Goods> selectSale(String status){
    List<Goods> list = new ArrayList<Goods>();
    Goods goods = null;
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
    try {
      ps = connection.prepareStatement("select * from db_goods where status=? order by id DESC");
      ps.setString(1, status);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
        goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 87 "../../../GoodsDao.ump"
   public void insertGoods(Goods form){
    try {
      ps = connection.prepareStatement("insert into db_goods values (null,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, form.getName());
      ps.setString(2, form.getDescription());
      ps.setDouble(3, (double)form.getPrice());
      ps.setInt(4, form.getNumberInInventory());
      ps.setString(5, form.getPicture());
      ps.setDouble(6, (double)form.getSalePrice());
      ps.setString(7,form.getManufacturer());
      ps.setInt(8,form.getType().getId());
      ps.setInt(9,form.getBrand().getId());
      ps.setString(10,String.valueOf(form.getStatus()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 108 "../../../GoodsDao.ump"
   public void deleteGoods(Integer id){
    try {
      ps = connection.prepareStatement("delete from db_goods where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 122 "../../../GoodsDao.ump"
   public Goods selectOneGoods(Integer id){
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
	Goods goods = new Goods();
    try {
      ps = connection.prepareStatement("select * from db_goods where id=? order by id DESC");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {   
      goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
       goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return goods;
  }

  // line 159 "../../../GoodsDao.ump"
   public List<Goods> selectSmall(Integer small){
    List<Goods> list = new ArrayList<Goods>();
    Goods goods = null;
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
    try {
      ps = connection.prepareStatement("select * from db_goods where brandId=? order by id DESC");
      ps.setInt(1, small.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
       goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
        goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 198 "../../../GoodsDao.ump"
   public List<Goods> selectBig(Integer big){
    List<Goods> list = new ArrayList<Goods>();
    Goods goods = null;
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
    try {
      ps = connection.prepareStatement("select * from db_goods where typeId=? order by id DESC");
      ps.setInt(1, big.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
        goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 238 "../../../GoodsDao.ump"
   public List<Goods> selectGoods(){
    List<Goods> list = new ArrayList<Goods>();
    Goods goods = null;
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
    try {
      ps = connection.prepareStatement("select * from db_goods order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
         goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
         goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 278 "../../../GoodsDao.ump"
   public List<Goods> selectGoodsNumber(){
    List<Goods> list = new ArrayList<Goods>();
    Goods goods = null;
    Type type = new Type();
    TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
    try {
      ps = connection.prepareStatement("select * from db_goods order by numberInInventory DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
          goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setName(rs.getString(2));
        goods.setDescription(rs.getString(3));
        goods.setPrice(Double.valueOf(rs.getString(4))); 
        goods.setNumberInInventory(Integer.valueOf(rs.getString(5)));
        goods.setPicture(rs.getString(6));
        goods.setSalePrice(Double.valueOf(rs.getString(7)));
        goods.setManufacturer(rs.getString(8));
        type = typeDao.selectOneType(Integer.valueOf(rs.getString(9)));
        goods.setType(type);
        brand = brandDao.selectOneBrand(Integer.valueOf(rs.getString(10)));
        goods.setBrand(brand);
        if(rs.getString(11).equals("sale")){
        goods.changePrice();
        }else{
        goods.backToOriginalPrice();
        }
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ps" + "=" + (getPs() != null ? !getPs().equals(this)  ? getPs().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "jdbc = "+(getJdbc()!=null?Integer.toHexString(System.identityHashCode(getJdbc())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "goodsForm = "+(getGoodsForm()!=null?Integer.toHexString(System.identityHashCode(getGoodsForm())):"null")
     + outputString;
  }
}