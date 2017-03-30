/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../AddressDao.ump"
public class AddressDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddressDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //AddressDao Associations
  private JDBConnection jdbc;
  private Brand brand;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AddressDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Brand aBrand)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create AddressDao due to aJdbc");
    }
    if (!setBrand(aBrand))
    {
      throw new RuntimeException("Unable to create AddressDao due to aBrand");
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

  public Brand getBrand()
  {
    return brand;
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

  public boolean setBrand(Brand aNewBrand)
  {
    boolean wasSet = false;
    if (aNewBrand != null)
    {
      brand = aNewBrand;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    brand = null;
  }

  // line 15 "../../../AddressDao.ump"
   public  AddressDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 21 "../../../AddressDao.ump"
   public Address selectOneAddress(Integer addressId){
    Address address = null;
    Member memberForm = new Member();
    MemberDao memberDao = new MemberDao();
	  try {
	    this.ps = connection.prepareStatement("select * from db_address where id=?");
		ps.setString(1, addressId.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		  address = new Address();
	   	  address.setId(Integer.valueOf(rs.getString(1)));
	      address.setCountry(rs.getString(2));
		  address.setProvince(rs.getString(3));
		  address.setCity(rs.getString(4));
		  address.setStreetNumber(rs.getString(5));
		  address.setStreetName(rs.getString(6));
		  address.setPostalCode(rs.getString(7));
		  address.setTelephone(rs.getString(8));
		  memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(9)));
	      address.setMember(memberForm);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return address;
  }

  // line 48 "../../../AddressDao.ump"
   public boolean deleteAddress(Integer id){
    try {
      ps = connection.prepareStatement("delete from db_address where id=?");
	  ps.setString(1, id.toString());
	  ps.executeUpdate();
	  ps.close();
	  return true;
	} catch (SQLException ex) {
	  ex.printStackTrace();
	  return false;
	}
  }

  // line 62 "../../../AddressDao.ump"
   public void updateAddress(Address form){
    try {
      ps = connection.prepareStatement("update db_address set country=?,province=?,city=?,streetNumber=?,streetName=?,postalCode=?,telephone=? where id=?");
	  ps.setString(1, form.getCountry());
	  ps.setString(2, form.getCity());
	  ps.setString(3, form.getProvince());
	  ps.setString(4, form.getStreetNumber());
	  ps.setString(5, form.getStreetName());
	  ps.setString(6, form.getPostalCode());
      ps.setString(7, form.getTelephone());
	  ps.executeUpdate();
	  ps.close();
	 } catch (SQLException ex) {
		ex.printStackTrace();
	}
  }

  // line 80 "../../../AddressDao.ump"
   public void insertAddress(Address form){
    try {
      ps = connection.prepareStatement("insert into db_address values (null,?,?,?,?,?,?,?,?)");
	  ps.setString(1, form.getCountry());
	  ps.setString(2, form.getProvince());
	  ps.setString(3, form.getCity());
	  ps.setString(4, form.getStreetNumber());
	  ps.setString(5, form.getStreetName());
	  ps.setString(6, form.getPostalCode());
	  ps.setString(7, form.getTelephone());
	  ps.setString(8, String.valueOf(form.getMember().getId()));
	  ps.executeUpdate();
	  ps.close();
	} catch (SQLException ex) {
	  ex.printStackTrace();
	}
  }

  // line 99 "../../../AddressDao.ump"
   public List<Address> selectAddress(){
    List<Address> list = new ArrayList<Address>();
	Address address = null;
	Member memberForm = new Member();
	MemberDao memberDao = new MemberDao();
	  try {
	    this.ps = connection.prepareStatement("select * from db_address order by id DESC");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		address = new Address();
		address.setId(Integer.valueOf(rs.getString(1)));
		address.setCountry(rs.getString(2));
		address.setProvince(rs.getString(3));
		address.setCity(rs.getString(4));
		address.setStreetNumber(rs.getString(5));
		address.setStreetName(rs.getString(6));
		address.setPostalCode(rs.getString(7));
		address.setTelephone(rs.getString(8));
		memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(9)));
	    address.setMember(memberForm);
		list.add(address);
		}
		} catch (SQLException ex) {
		   ex.printStackTrace();
		}
		return list;
  }

  // line 126 "../../../AddressDao.ump"
   public List<Address> selectMemberAddress(Integer id){
    List<Address> list = new ArrayList<Address>();
	Address address = null;
	Member memberForm = new Member();
	MemberDao memberDao = new MemberDao();
	  try {
	    this.ps = connection.prepareStatement("select * from db_address where memberId=?");
	    ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		address = new Address();
		address.setId(Integer.valueOf(rs.getString(1)));
		address.setCountry(rs.getString(2));
		address.setProvince(rs.getString(3));
		address.setCity(rs.getString(4));
		address.setStreetNumber(rs.getString(5));
		address.setStreetName(rs.getString(6));
		address.setPostalCode(rs.getString(7));
		address.setTelephone(rs.getString(8));
		memberForm = memberDao.selectOneMember(Integer.valueOf(rs.getString(9)));
	    address.setMember(memberForm);
		list.add(address);
		}
		} catch (SQLException ex) {
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
            "  " + "brand = "+(getBrand()!=null?Integer.toHexString(System.identityHashCode(getBrand())):"null")
     + outputString;
  }
}