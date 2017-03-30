/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../BrandDao.ump"
public class BrandDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BrandDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //BrandDao Associations
  private JDBConnection jdbc;
  private Brand brand;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BrandDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Brand aBrand)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create BrandDao due to aJdbc");
    }
    if (!setBrand(aBrand))
    {
      throw new RuntimeException("Unable to create BrandDao due to aBrand");
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

  // line 15 "../../../BrandDao.ump"
   public  BrandDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 20 "../../../BrandDao.ump"
   public List<Brand> selectOneBigId(Integer bigId){
    List<Brand> list = new ArrayList<Brand>();
	Brand small = null;
	Type typeForm = new Type();
	TypeDao typeDao = new TypeDao();
	    
	  try {
	    this.ps = connection.prepareStatement("select * from db_brand where typeId=?");
		ps.setString(1, bigId.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		  small = new Brand();
		  small.setId(Integer.valueOf(rs.getString(1)));
		  small.setName(rs.getString(2));
		  typeForm = typeDao.selectOneType(Integer.valueOf(rs.getString(3)));
		  small.setType(typeForm);
				
		  list.add(small);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
  }

  // line 44 "../../../BrandDao.ump"
   public Brand selectOneBrand(Integer id){
    Brand small = null;
		Type typeForm = new Type();
	    TypeDao typeDao = new TypeDao();
	    
		try {
			this.ps = connection
					.prepareStatement("select * from db_brand where id=?");
			ps.setString(1, id.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new Brand();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setName(rs.getString(2));
				typeForm = typeDao.selectOneType(Integer.valueOf(rs.getString(3)));
				small.setType(typeForm);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return small;
  }

  // line 67 "../../../BrandDao.ump"
   public String selectName(Integer id){
    String name = null;
		try {
			this.ps = connection
					.prepareStatement("select * from db_brand where id=?");
			ps.setString(1, id.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return name;
  }

  // line 84 "../../../BrandDao.ump"
   public boolean deleteSmall(Integer id){
    try {
			ps = connection.prepareStatement("delete from db_brand where id=?");
			ps.setString(1, id.toString());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
  }

  // line 97 "../../../BrandDao.ump"
   public void updateSmall(Brand form){
    try {
			ps = connection.prepareStatement("update db_brand set name=?,typeId=? where id=?");
			ps.setString(1, form.getName());
			ps.setInt(2, form.getType().getId());			
			ps.setString(3, String.valueOf(form.getId()));
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
  }

  // line 111 "../../../BrandDao.ump"
   public void insertSmall(Brand form){
    try {
			ps = connection.prepareStatement("insert into db_brand values (null,?,?)");
			ps.setString(1, form.getName());
			ps.setInt(2, form.getType().getId());			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
  }

  // line 123 "../../../BrandDao.ump"
   public Brand selectOneBig(Integer id){
    Brand small = null;
    Type typeForm = new Type();
    TypeDao typeDao = new TypeDao();
		try {
			this.ps = connection
					.prepareStatement("select * from db_brand where id=?");
			ps.setString(1, id.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new Brand();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setName(rs.getString(2));
				typeForm = typeDao.selectOneType(Integer.valueOf(rs.getString(3)));
				small.setType(typeForm);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return small;
  }

  // line 147 "../../../BrandDao.ump"
   public List<Brand> selectSmall(){
    List<Brand> list = new ArrayList<Brand>();
			Brand small = null;
		Type typeForm = new Type();
	    TypeDao typeDao = new TypeDao();
		try {
			this.ps = connection.prepareStatement("select * from db_brand order by id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new Brand();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setName(rs.getString(2));
				typeForm = typeDao.selectOneType(Integer.valueOf(rs.getString(3)));
				small.setType(typeForm);
				
				list.add(small);
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