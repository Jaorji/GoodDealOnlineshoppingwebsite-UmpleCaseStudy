/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.DAO;
import java.sql.*;
import java.util.*;
import com.ji.tool.*;
import com.ji.Entity.*;

// line 5 "../../../MemberDao.ump"
public class MemberDao
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MemberDao Attributes
  private PreparedStatement ps;
  private Connection connection;

  //MemberDao Associations
  private JDBConnection jdbc;
  private Member member;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MemberDao(PreparedStatement aPs, Connection aConnection, JDBConnection aJdbc, Member aMember)
  {
    ps = aPs;
    connection = aConnection;
    if (!setJdbc(aJdbc))
    {
      throw new RuntimeException("Unable to create MemberDao due to aJdbc");
    }
    if (!setMember(aMember))
    {
      throw new RuntimeException("Unable to create MemberDao due to aMember");
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

  public Member getMember()
  {
    return member;
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

  public boolean setMember(Member aNewMember)
  {
    boolean wasSet = false;
    if (aNewMember != null)
    {
      member = aNewMember;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    jdbc = null;
    member = null;
  }

  // line 16 "../../../MemberDao.ump"
   public  MemberDao(){
    jdbc = new JDBConnection(connection);
    connection = jdbc.getConnection();
  }

  // line 22 "../../../MemberDao.ump"
   public boolean updatePassword(String password, Integer id){
    try {
      ps = connection.prepareStatement("update db_member set password=? where id=?");
      ps.setString(1, password);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
      return false;
    }
  }

  // line 38 "../../../MemberDao.ump"
   public Member selectFind(String name, String result){
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from db_member where userName=? and answer=?");
      ps.setString(1, name);
      ps.setString(2, result);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
         member.setId(Integer.valueOf(rs.getString(1)));
        member.setFirstName(rs.getString(2));
        member.setLastName(rs.getString(3));
        member.setBirthday(rs.getString(4));
        member.setUserName(rs.getString(5));      
        member.setPassword(rs.getString(6));
        member.setEmailAddress(rs.getString(7));        
        member.setProfession(rs.getString(8));
        member.setQuestion(rs.getString(9));
        member.setAnswer(rs.getString(10));
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return member;
  }

  // line 65 "../../../MemberDao.ump"
   public Member selectMember(String name){
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from db_member where userName=?");
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setFirstName(rs.getString(2));
        member.setLastName(rs.getString(3));
        member.setBirthday(rs.getString(4));
        member.setUserName(rs.getString(5));      
        member.setPassword(rs.getString(6));
        member.setEmailAddress(rs.getString(7));        
        member.setProfession(rs.getString(8));
        member.setQuestion(rs.getString(9));
        member.setAnswer(rs.getString(10));
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return member;
  }

  // line 92 "../../../MemberDao.ump"
   public boolean deleteMember(Integer id){
    try {
      ps = connection.prepareStatement("delete from db_member where id=?");
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

  // line 107 "../../../MemberDao.ump"
   public void insertMember(Member form){
    try {
      ps = connection.prepareStatement("insert into db_member values (null,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, form.getFirstName());
      ps.setString(2, form.getLastName());
      ps.setString(3, form.getBirthday());
      ps.setString(4, form.getUserName());
      ps.setString(5, form.getPassword());
      ps.setString(6, form.getEmailAddress());
      ps.setString(7, form.getProfession());
      ps.setString(8, form.getQuestion());
      ps.setString(9, form.getAnswer());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  // line 127 "../../../MemberDao.ump"
   public void updateMember(Member form){
    try {
      ps = connection.prepareStatement("update db_member set firstName=?,lastName=?,birthday=?,userName=?,password=?,emailAddress=?,profession=?,question=?,answer=? where id=?");
       ps.setString(1, form.getFirstName());
      ps.setString(2, form.getLastName());
      ps.setString(3, form.getBirthday());
      ps.setString(4, form.getUserName());
      ps.setString(5, form.getPassword());
      ps.setString(6, form.getEmailAddress());
      ps.setString(7, form.getProfession());
      ps.setString(8, form.getQuestion());
      ps.setString(9, form.getAnswer());
      ps.setString(10, String.valueOf(form.getId()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
  }

  // line 151 "../../../MemberDao.ump"
   public List<Member> selectMember(){
    List<Member> list = new ArrayList<Member>();
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from db_member order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
      member = new Member();
      member.setId(Integer.valueOf(rs.getString(1)));
        member.setFirstName(rs.getString(2));
        member.setLastName(rs.getString(3));
        member.setBirthday(rs.getString(4));
        member.setUserName(rs.getString(5));      
        member.setPassword(rs.getString(6));
        member.setEmailAddress(rs.getString(7));        
        member.setProfession(rs.getString(8));
        member.setQuestion(rs.getString(9));
        member.setAnswer(rs.getString(10));
        list.add(member);
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return list;
  }

  // line 179 "../../../MemberDao.ump"
   public Member selectOneMember(Integer id){
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from db_member where id=?");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setFirstName(rs.getString(2));
        member.setLastName(rs.getString(3));
        member.setBirthday(rs.getString(4));
        member.setUserName(rs.getString(5));      
        member.setPassword(rs.getString(6));
        member.setEmailAddress(rs.getString(7));        
        member.setProfession(rs.getString(8));
        member.setQuestion(rs.getString(9));
        member.setAnswer(rs.getString(10));
      }
    }
    catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return member;
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ps" + "=" + (getPs() != null ? !getPs().equals(this)  ? getPs().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "connection" + "=" + (getConnection() != null ? !getConnection().equals(this)  ? getConnection().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "jdbc = "+(getJdbc()!=null?Integer.toHexString(System.identityHashCode(getJdbc())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "member = "+(getMember()!=null?Integer.toHexString(System.identityHashCode(getMember())):"null")
     + outputString;
  }
}