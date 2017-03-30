<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Type"%>
<%@page import="com.ji.Entity.Brand"%>
<%@page import="com.ji.Entity.Goods"%>
<jsp:useBean id="big" scope="page" class="com.ji.DAO.TypeDao"/>
<jsp:useBean id="small" scope="page" class="com.ji.DAO.BrandDao"/>
<%
Goods goodsForm=(Goods)request.getAttribute("form");

%>

<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("Can not be blank");
return false;
}
}
if(isNaN(document.form.salePrice.value)){
window.alert("Price just can be price");
return false;
}
if(document.form.salePrice.value==document.form.price.value){
window.alert("The price should be the same with original price,Please reinput£¡£¡£¡");
return false;
}
if(document.form.salePrice.value-document.form.price.value>0){


window.alert("Sale price should not be higher than original price£¡£¡£¡");
return false;
}

}

</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Background System</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>


<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>Set as a sale item</strong></div></td>
          </tr>
        </table>
        <br>
		
		 <form name="form" method="post" action="goodsAction.do?action=11&id=<%=goodsForm.getId()%>&status=sale" onSubmit="return checkEmpty(form)">
        <table width="90%" height="233"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;Type</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;<%=big.selectName(goodsForm.getType().getId())%></td>
            <td width="20%">&nbsp;&nbsp;Brand</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;<%=small.selectName(goodsForm.getBrand().getId())%></td>
          </tr>
          <tr>
            <td height="26">&nbsp;&nbsp;Name</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;<%=goodsForm.getName()%></td>
            <td>&nbsp;&nbsp;Manufacturer</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;<%=goodsForm.getManufacturer()%></td>
          </tr>
          <tr>
            <td height="26">&nbsp;&nbsp;Sale Price</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="oldSalePrice" type="hidden" value="<%=goodsForm.getPrice()%>"><%=goodsForm.getPrice()%>$</td>
            <td>&nbsp;&nbsp;If Sale</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <%if(goodsForm.getStatus().equals("NotSale")){%>no<%}else{%>yes<%}%></td>
          </tr>
          <tr>
            <td height="23">&nbsp;&nbsp;Description</td>
            <td bgcolor="#FFFFFF" >&nbsp;&nbsp;<%=goodsForm.getDescription()%></td>
		    <td>&nbsp;&nbsp;Sale price</td>
            <td bgcolor="#FFFFFF">
            &nbsp;
              <input name="salePrice" type="text" size="12" >
            <input type="submit" name="Submit" value="Submit">           </td>
          </tr>
          <tr>
            <td height="79">&nbsp;&nbsp;Picture</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="imageField" type="image" src="<%=goodsForm.getPicture()%>" width="140" height="126"></td>
          </tr>
        </table>  </form>              
        <table width="90%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="87%" height="29" align="right">&nbsp;&nbsp;&nbsp;</td>
            <td width="13%"> <a href="javascript:history.back();">Back</a></td>
          </tr>
        </table>
		
		
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />





































</body>
</html>
