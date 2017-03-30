/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 6 "../../../TypeDao.ump"
public class TypeDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TypeDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //TypeDao Associations
  private JDBConnection jdbc;
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TypeDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Type aType)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create TypeDao due to aJdbc");
    }
    if (!setType(aType))
    {
      throw new RuntimeException("Unable to create TypeDao due to aType");
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

  public Type getType()
  {
    return type;
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

  public boolean setType(Type aNewType)
  {
    boolean wasSet = false;
    if (aNewType != null)
    {
      type = aNewType;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    type = null;
  }

  // line 15 "../../../TypeDao.ump"
   public  TypeDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 21 "../../../TypeDao.ump"
   public String selectName(Integer id){
    String name = null;
    try {
      this.ps = connection.prepareStatement("select * from db_type where id=?");
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("name");
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return name;
  }

  // line 37 "../../../TypeDao.ump"
   public boolean deleteBig(Integer id){
    try {
      ps = connection.prepareStatement("delete from db_type where id=?");
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
      return false;
    }
  }

  // line 52 "../../../TypeDao.ump"
   public void insertBig(String name){
    try {
      ps = connection.prepareStatement("insert into db_type values (null,?)");
      ps.setString(1, name);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 64 "../../../TypeDao.ump"
   public List<Type> selectBig(){
    List<Type> list = new ArrayList<Type>();
    Type big = null;
    try {
      this.ps = connection.prepareStatement("select * from db_type order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new Type();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setName(rs.getString(2));
        list.add(big);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 83 "../../../TypeDao.ump"
   public Type selectOneType(Integer id){
    Type type = null;
		    try {
		      ps = connection.prepareStatement("select * from db_type where id=?");
		      ps.setInt(1, id.intValue());
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		        type = new Type();
		        type.setId(Integer.valueOf(rs.getString(1)));
		        type.setName(rs.getString(2));
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return type;
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ps" + "=" + (getPs() != null ? !getPs().equals(this)  ? getPs().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "jdbc = "+(getJdbc()!=null?Integer.toHexString(System.identityHashCode(getJdbc())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "type = "+(getType()!=null?Integer.toHexString(System.identityHashCode(getType())):"null")
     + outputString;
  }
}