<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length-1;i++){
if(form.elements[i].value==""){
alert("Can not be empty");
return false;
}
}
}
function quit() {
  if(confirm("Are you confirm to log out？")){
    window.location.href="loginOut.jsp";
	}
  }
</script>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<%@page import="com.ji.Entity.Member"%>
<jsp:useBean id="countTime" scope="page" class="com.ji.tool.CountTime"/>


<body>
<!--左侧01-->
	<%if(session.getAttribute("form")==null){%>		
	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left1.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="16">&nbsp;</td>
          </tr>
        </table>
        <form name="form" method="post" action="memberAction.do?action=1" onSubmit="return checkEmpty(form)">
          <table width="185" border="0" align="center">
            <tr>
              <td width="60" height="25">UserName：</td>
              <td width="115"> <input name="userName" type="text" size="17"></td>
            </tr>
            <tr>
              <td height="25">password：</td>
              <td><input name="password" type="password" size="17"></td>
            </tr>
			 <tr >
              <td height="26"><input type="submit" class="input1"  src="image/fg-land.gif"  height="20" ></td>
             
			 </tr>
			 <tr  >
			  <td height="26"><a href="fg-memberRegister.jsp">Register</a></td>
              <td height="26"><a href="fg-One.jsp">Forget&nbsp;Password？</a></td>
              </tr>	  
          </table>
		  </form>
		  </td>
      </tr>
    </table>
	<%}else{
	   Member form=(Member)session.getAttribute("form");
	%>

	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left1.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="30">&nbsp;</td>
          </tr>
        </table>
       
          <table width="167" border="0" align="center">
            <tr>
              <td width="161" height="25"><font color="#FB6801"><%=form.getUserName()%>,</font>Welcome</td>
              </tr>
            <tr>
              <td height="25"><%=countTime.currentlyTime()%></td>
              </tr>
			 <tr>
              <td height="25" >UserName：<%=form.getUserName()%></td>
              </tr>	 
			  <tr>
              <td height="20" align="right" valign="middle"><a href="javascript:quit()">Log Out</a></td>
              </tr>	
          </table>
	  </td>
     </tr>
    </table>
		<%}%>
	<!--左侧02-->		
       
            













</body>
</html>
