<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.Cart"%>
<%
List cart=(List)session.getAttribute("cart");
List newcart=new ArrayList();
for(int i=0;i<cart.size();i++){
	String number=request.getParameter("num"+i);
	Cart mygoodselement=(Cart)cart.get(i);
	String num=request.getParameter("num"+i);
	try{
	int newnum=Integer.parseInt(num);
	mygoodselement.setNumber(newnum);
	if(newnum!=0){
		newcart.add(mygoodselement);}
	}catch(Exception e){
		out.println("<script language='javascript'>alert('Wrong input!');history.back();</script>");
		return;
	}
}
session.setAttribute("cart",newcart);
response.sendRedirect("cart_see.jsp");
%>
