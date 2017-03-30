<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.ji.Entity.Member"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title></title>
</head>
<%
  String memberlink="connection.jsp";
  String orderlink="connection.jsp";
  String shoppinglink="connection.jsp";
  Member form=null;
  if(session.getAttribute("form")!=null){
  form=(Member)session.getAttribute("form");
  memberlink="memberAction.do?action=5&id="+form.getId();
  orderlink="cart_detail.jsp";
  shoppinglink="cart_see.jsp";
  }
%>
<body>
<table width="766" height="26" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_top01.jpg">
  <tr>
    <td width="627">&nbsp;</td>
    <td width="139" valign="top"><table width="125" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="70" height="23" valign="bottom"><font color="#FFFFFF"><a href="#" class="a4">English</a></font></td>
        <td width="55" valign="bottom"><font color="#FFFFFF"><a href="#" class="a4">French</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="766" height="56" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_top2.jpg">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC" background="image/fg_top03.jpg">
      <tr align="center">
        <td width="117" height="31" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="index.jsp" class="a4">Home</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="bg-resultTen.jsp" class="a4">Rank</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="goodsAction.do?action=14&status=NotSale" class="a4">New Arrival</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="goodsAction.do?action=15&status=sale" class="a4">Sale</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="<%=orderlink%>" class="a4">Order</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="<%=shoppinglink%>" class="a4">Cart</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="<%=memberlink%>" class="a4">Modify</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.mingrisoft.com')" class="a4">Set as Home</a></td>
      </tr>	
</table>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="image/fg_top.jpg" width="766" height="117"></td>
  </tr>
</table>































</body>
</html>
