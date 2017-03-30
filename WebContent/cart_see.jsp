<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.Cart"%>
<jsp:useBean id="dao" scope="page" class="com.ji.DAO.GoodsDao"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
	<br><br>
	<strong>My cart</strong>	<div align="center"><br>
              <%if(session.getAttribute("cart")==null){%>
           You didn't put anything in your cart！！！
           <%}else{%>

        </div>
        <form method="post" action="cart_modify.jsp" name="form">
		  <table width="92%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
          <tr>
            <td width="16%" height="28"><div align="center">ID</div></td>
            <td width="23%"><div align="center">Name</div></td>
            <td width="22%"><div align="center">Price</div></td>
            <td width="22%"><div align="center">Number</div></td>
            <td width="17%"><div align="center">Total Price</div></td>
          </tr>
            <%
            double sum=0;
         List cart=(List)session.getAttribute("cart");
        for(int i=0;i<cart.size();i++){
          Cart form=(Cart)cart.get(i);
          
          sum=sum+form.getNumber()*(form.getPrice());
          System.out.print("sum="+sum);
        %>
          <tr>
            <td height="28"><div align="center"><%=i+1%></div></td>
            <td><div align="center"><%=dao.selectOneGoods(new Integer(form.getId())).getName()%></div></td>
            <td><div align="center"><%=form.getPrice()%>$</div></td>
            <td><div align="center"><input name="num<%=i%>" size="7" type="text"  value="<%=form.getNumber()%>" onBlur="check(this.form)"></div></td>
            <td><div align="center"><%=form.getNumber()*form.getPrice()%>$</div></td>
          </tr>
		     <script language="javascript">
			
			function check(myform){
				if(isNaN(myform.num<%=i%>.value) || myform.num<%=i%>.value.indexOf('.',0)!=-1){
					alert("Wrong input");myform.num<%=i%>.focus();return;}
				if(myform.num<%=i%>.value==""){
					alert("Input how many items you want to buy:");myform.num<%=i%>.focus();return;}
				myform.submit();
			}
			
		</script>
          <%}%>
        </table>

        </form>

<table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
		<td height="10">&nbsp;		</td>
        <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
		</tr>
      <tr align="center" valign="middle">
        <td height="21" class="tableBorder_B1">&nbsp;</td>
        <td height="21" colspan="-3" align="left" >Total price is：$<%=sum%></td>
      </tr>
      <tr align="center" valign="middle">
        <td height="21" colspan="2"> <a href="index.jsp">Continue Shopping</a> | <a href="cart_checkOut.jsp">Check Out</a> | <a href="cart_clear.jsp">Clear Cart</a> | <a href="#">Change Number</a></td>
        </tr>
</table>

<%}%>
	
	
	
</td>
  </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>




















</body>
</html>
