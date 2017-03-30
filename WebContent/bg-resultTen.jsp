<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Goods"%>
<jsp:useBean id="goods" scope="page" class="com.ji.DAO.GoodsDao"/>
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
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	<%
        List list=goods.selectGoodsNumber();
		int number=list.size();
		if(number>10){
		number=10;
	}%>
	Sale TOP<%=number%>	
	<br><br>
      <%  for(int i=0;i<number;i++){
          Goods form=(Goods)list.get(i);
        %>
        The First<%=i+1%>
		<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="4" height="84"><div align="center">
                <input name="pricture<%=i%>" type="image" src="<%=form.getPicture()%>" width="110" height="100">
            </div></td>
            <td width="64%" height="21"><div align="center"><%=form.getName()%></div></td>
          </tr>
          <tr>
            <td height="21"><div align="center">Price：<%=form.getPrice()%>$</div></td>
          </tr>
          <tr>
            <td height="21"><div align="center"><%=form.getDescription()%></div></td>
          </tr>
          <tr>
          
            <td height="21" align="center">  <%if(session.getAttribute("form")!=null){%>
			<a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=form.getId()%>','','width=500,height=200');">Detail Information</a>
            <%}else{%>
           You should sign in to buy</td>
            <%}%>
          </tr>
        </table><br>
		<%}%>
	
	
	
	
	
	
	
	
	
	
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
