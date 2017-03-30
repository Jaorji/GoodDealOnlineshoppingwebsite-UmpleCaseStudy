/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.ActionForm;

// line 7 "../../../User.ump"
public class User extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private int id;
  private String firstName;
  private String lastName;
  private String birthday;
  private String password;
  private String emailAddress;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User()
  {
    super();
    id = 0;
    firstName = "";
    lastName = "";
    birthday = "";
    password = "";
    emailAddress = "";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthday(String aBirthday)
  {
    boolean wasSet = false;
    birthday = aBirthday;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmailAddress(String aEmailAddress)
  {
    boolean wasSet = false;
    emailAddress = aEmailAddress;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getBirthday()
  {
    return birthday;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "birthday" + ":" + getBirthday()+ "," +
            "password" + ":" + getPassword()+ "," +
            "emailAddress" + ":" + getEmailAddress()+ "]"
     + outputString;
  }
}