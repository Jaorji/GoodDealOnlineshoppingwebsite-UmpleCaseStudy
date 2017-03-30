/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../ManagerDao.ump"
public class ManagerDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ManagerDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //ManagerDao Associations
  private JDBConnection jdbc;
  private Manager manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ManagerDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Manager aManager)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create ManagerDao due to aJdbc");
    }
    if (!setManager(aManager))
    {
      throw new RuntimeException("Unable to create ManagerDao due to aManager");
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

  public Manager getManager()
  {
    return manager;
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

  public boolean setManager(Manager aNewManager)
  {
    boolean wasSet = false;
    if (aNewManager != null)
    {
      manager = aNewManager;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    manager = null;
  }

  // line 15 "../../../ManagerDao.ump"
   public  ManagerDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 21 "../../../ManagerDao.ump"
   public void insertManager(Manager form){
    try {

      ps = connection.prepareStatement("insert into db_manager values (null,?,?,?,?,?,?,?)");
      ps.setString(1, form.getFirstName());
      ps.setString(2, form.getLastName());
      ps.setString(3, form.getBirthday());
      ps.setString(4, form.getPassword());
      ps.setString(5, form.getEmailAddress());
      ps.setString(6, form.getAccountName());
      ps.setInt(7, 0);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 40 "../../../ManagerDao.ump"
   public void updateManagerPassword(Manager form){
    try {
      ps = connection.prepareStatement("update db_manager set password=? where accountName=?");
      ps.setString(1, form.getPassword());
      ps.setString(2, form.getAccountName());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 55 "../../../ManagerDao.ump"
   public void deleteManager(Integer id){
    try {
      ps = connection.prepareStatement("delete from db_manager where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 67 "../../../ManagerDao.ump"
   public List<Manager> selectManager(){
    List<Manager> list = new ArrayList<Manager>();
    Manager manager = null;
    try {
      ps = connection.prepareStatement("select * from db_manager order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new Manager();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setFirstName(rs.getString(2));
        manager.setLastName(rs.getString(3));
        manager.setBirthday(rs.getString(4));
        manager.setPassword(rs.getString(5));
        manager.setEmailAddress(rs.getString(6));
        manager.setAccountName(rs.getString(7));
          manager.setIfAdmin(Integer.valueOf(rs.getString(8)));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 92 "../../../ManagerDao.ump"
   public Manager selectOne(String account){
    Manager manager = null;
    try {
      ps = connection.prepareStatement("select * from db_manager where accountName=?");
      ps.setString(1, account);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new Manager();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setFirstName(rs.getString(2));
        manager.setLastName(rs.getString(3));
        manager.setBirthday(rs.getString(4));
        manager.setPassword(rs.getString(5));
        manager.setEmailAddress(rs.getString(6));
        manager.setAccountName(rs.getString(7));
          manager.setIfAdmin(Integer.valueOf(rs.getString(8)));
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return manager;
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ps" + "=" + (getPs() != null ? !getPs().equals(this)  ? getPs().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "jdbc = "+(getJdbc()!=null?Integer.toHexString(System.identityHashCode(getJdbc())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null")
     + outputString;
  }
}