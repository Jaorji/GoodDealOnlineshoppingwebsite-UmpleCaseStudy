/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.tool;
import java.sql.*;

// line 3 "../../../JDBConnection.ump"
public class JDBConnection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JDBConnection Attributes
  private Connection connection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JDBConnection(Connection aConnection)
  {
    connection = aConnection;
    // line 9 "../../../JDBConnection.ump"
    try {
    		    
    			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
    		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gooddeal", "root", ""); 
    		} catch (Exception ex) {
    			System.out.println("connection fail!");
    		}
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setConnection(Connection aConnection)
  {
    boolean wasSet = false;
    connection = aConnection;
    wasSet = true;
    return wasSet;
  }

  public Connection getConnection()
  {
    return connection;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}