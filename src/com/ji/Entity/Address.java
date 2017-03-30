/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;

// line 4 "../../../Address.ump"
public class Address
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Address Attributes
  private int id;
  private String country;
  private String province;
  private String city;
  private String streetNumber;
  private String streetName;
  private String postalCode;
  private String telephone;

  //Address Associations
  private Member member;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Address()
  {
    id = 0;
    country = "";
    province = "";
    city = "";
    streetNumber = "";
    streetName = "";
    postalCode = "";
    telephone = "";
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

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }

  public boolean setProvince(String aProvince)
  {
    boolean wasSet = false;
    province = aProvince;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setStreetNumber(String aStreetNumber)
  {
    boolean wasSet = false;
    streetNumber = aStreetNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setStreetName(String aStreetName)
  {
    boolean wasSet = false;
    streetName = aStreetName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelephone(String aTelephone)
  {
    boolean wasSet = false;
    telephone = aTelephone;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getCountry()
  {
    return country;
  }

  public String getProvince()
  {
    return province;
  }

  public String getCity()
  {
    return city;
  }

  public String getStreetNumber()
  {
    return streetNumber;
  }

  public String getStreetName()
  {
    return streetName;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public Member getMember()
  {
    return member;
  }

  public boolean hasMember()
  {
    boolean has = member != null;
    return has;
  }

  public boolean setMember(Member aMember)
  {
    boolean wasSet = false;
    Member existingMember = member;
    member = aMember;
    if (existingMember != null && !existingMember.equals(aMember))
    {
      existingMember.removeAddress(this);
    }
    if (aMember != null)
    {
      aMember.addAddress(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (member != null)
    {
      Member placeholderMember = member;
      this.member = null;
      placeholderMember.removeAddress(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "country" + ":" + getCountry()+ "," +
            "province" + ":" + getProvince()+ "," +
            "city" + ":" + getCity()+ "," +
            "streetNumber" + ":" + getStreetNumber()+ "," +
            "streetName" + ":" + getStreetName()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "telephone" + ":" + getTelephone()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "member = "+(getMember()!=null?Integer.toHexString(System.identityHashCode(getMember())):"null")
     + outputString;
  }
}