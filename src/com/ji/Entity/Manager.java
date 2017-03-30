/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

// line 5 "../../../Manager.ump"
public class Manager extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String accountName;
  private int ifAdmin;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager()
  {
    super();
    accountName = "";
    ifAdmin = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountName(String aAccountName)
  {
    boolean wasSet = false;
    accountName = aAccountName;
    wasSet = true;
    return wasSet;
  }

  public boolean setIfAdmin(int aIfAdmin)
  {
    boolean wasSet = false;
    ifAdmin = aIfAdmin;
    wasSet = true;
    return wasSet;
  }

  public String getAccountName()
  {
    return accountName;
  }

  public int getIfAdmin()
  {
    return ifAdmin;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "accountName" + ":" + getAccountName()+ "," +
            "ifAdmin" + ":" + getIfAdmin()+ "]"
     + outputString;
  }
}