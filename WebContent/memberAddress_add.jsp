<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.Address"%>
<%@ page import="com.ji.Entity.Member" %>
<jsp:useBean id="addressDao" scope="page" class="com.ji.DAO.AddressDao"/>
<jsp:useBean id="memberDao" scope="page" class="com.ji.DAO.MemberDao"/>
<%
Member mform=(Member)session.getAttribute("form");
Member memberForm = new Member();
String country=request.getParameter("country");
String province=request.getParameter("state");
String city=request.getParameter("city");
String streetNumber=request.getParameter("streetNumber");
String streetName=request.getParameter("streetName");
String postalCode=request.getParameter("postalCode");
String telephone=request.getParameter("telephone");

Address addressForm= new Address();
addressForm.setCountry(country);
addressForm.setProvince(province);
addressForm.setCity(city);
addressForm.setStreetNumber(streetNumber);
addressForm.setStreetName(streetName);
addressForm.setPostalCode(postalCode);
addressForm.setTelephone(telephone);
memberForm = memberDao.selectOneMember(Integer.valueOf(mform.getId()));
addressForm.setMember(memberForm);
boolean flag=true;
Address address=(Address)session.getAttribute("addressForm");
/*if(address==null){
 address=new ArrayList<>();
}else{
	for(int i=0;i<address.size();i++){
     address.set(i, addressForm);
     flag=false;
	}
}*/
if(flag)
//address.add(addressForm);
session.setAttribute("addressForm",addressForm);
addressDao.insertAddress(addressForm);
out.println("<script language='javascript'>alert('Add Address!');window.location.href='fg-updateMember.jsp';</script>");
%>
