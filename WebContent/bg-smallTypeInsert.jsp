<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Type"%>
<jsp:useBean id="big" scope="page" class="com.ji.DAO.TypeDao"/>

<%List list=big.selectBig();%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("Can not be Blank");
return false;
}
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
            <td><div align="center"><strong>Add Brand Information</strong></div></td>
          </tr>
        </table>
        <br>
		  <form action="smallTypeAction.do?action=2" method="post"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%" height="60"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="25%" height="30"><div align="center">Select Type</div></td>
            <td width="75%" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;
			
              <select name="typeId" >
              <option value="">Please Select</option>
			<%for(int i=0;i<list.size();i++){
                          Type form=(Type)list.get(i);
                          %>
                <option value="<%=form.getId()%>"><%=form.getName()%></option>
                          <%}%>
		    </select>		    </td>
          </tr>
           <tr>
            <td width="25%" height="30"><div align="center">Brand Name</div></td>
            <td width="75%" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
             <input name="name" type="text" size="50"></td>
          </tr>
         
        </table>

       <br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear01.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back01.gif"></a>

	  </form>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />











</body>
</html>
