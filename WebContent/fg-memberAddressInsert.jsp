<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Address"%>
<%@page import="com.ji.Entity.Member"%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("Con not be Blank");
return false;
}
}
}
</script>
<script  type= "text/javascript" src = "country.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
 <%Member form=(Member)request.getAttribute("form");%>
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
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>Add Address Information</strong></div></td>
          </tr>
        </table>
        <br>
        <form name="form" method="post" action="memberAddress_add.jsp"  onSubmit="checkEmpty(form)">
        <table width="74%" height="60"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
              <td height="30"><div align="center">Country：</div></td>
              <td><select id="country" name="country"></select><td>
              </tr>
              <tr>
              <td height="30"><div align="center">State：</div></td>
              <td> <select name="state" id="state"></select>
              
              <script language="javascript">
            populateCountries("country", "state");
           
        </script>
        </td>
        </tr>
        <tr>
                <td height="30"><div align="center">city：</div></td>
                <td><input type="text" name="city"></td>
                </tr>
                <tr>
                <td height="30"><div align="center">StreetNumber：</div></td>
                <td><input type="text" name="streetNumber"></td>

             </tr>
             <tr>
                <td height="30"><div align="center">StreetName：</div></td>
                <td><input type="text" name="streetName"></td>

             </tr>
             <tr> 
                <td height="30"><div align="center">Post Code：</div></td>
                <td><input type="text" name="postalCode"></td>
             </tr>
             <tr>
             
               <td height="30"><div align="center">Telephone：</div></td>
              <td><input type="text" name="telephone"></td>
             </tr>
        </table>
     <br>
   
     <input type="image" name="Submit" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear01.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back01.gif"></a>
</form>
    </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true" />















</body>
</html>
