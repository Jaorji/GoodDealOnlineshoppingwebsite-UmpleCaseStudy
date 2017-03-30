<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.Cart"%>
<%
int goodsID=Integer.parseInt(request.getParameter("id"));
float goodsPrice=Float.parseFloat(request.getParameter("price"));
int number = 1;
Cart cartForm = new Cart();
cartForm.setId(goodsID);
cartForm.setPrice(goodsPrice);
cartForm.setNumber(number);
boolean flag=true;

System.out.println("cart "+session.getAttribute("cart"));
List cart=(List)session.getAttribute("cart");
if(cart==null){
 cart=new ArrayList<>();
}else{
for(int i=0;i<cart.size();i++){
   Cart form=(Cart)cart.get(i);
   if(form.getId()==cartForm.getId()){
     form.setNumber(number++);
     cart.set(i, form);
     flag=false;

   }
}
}
if(flag)
cart.add(cartForm);
session.setAttribute("cart",cart);
System.out.println("put into cart"+session);
for(int i=0;i<cart.size();i++){
	System.out.println("ssss"+cart.toArray());
}
out.println("<script language='javascript'>alert('Put into Cart!');window.close();</script>");
%>
