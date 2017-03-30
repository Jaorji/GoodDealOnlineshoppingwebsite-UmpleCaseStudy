<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Order"%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;
int over=(number+1)*6;
int count=pageNumber-over;
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteOrder(date) {
  if(confirm("Are you sure to delete？")){
    window.location="orderAction.do?action=2&orderNumber="+date;
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
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF">
	
	
	
<br>
	

	<table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
      <tr>
        <td><div align="center"><strong>Order Check</strong></div></td>
      </tr>
    </table>	<br>
	    <table width="96%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">

	    <tr bgcolor="#DCDCDC">
          <td width="15%" height="25"><div align="center">Order Number</div></td>
          <td width="14%"><div align="center">User Name</div></td>

         <td width="16%"><div align="center">If ship</div></td>
   <td width="29%"><div align="center">Operate</div></td>
   <td width="29%"><div align="center">Status</div></td>
        </tr>
        <%for(int i=start;i<over;i++){
      Order form=(Order)list.get(i);
          %>
        <tr align="center" bgcolor="#FFFFFF">
          <td height="25" align="center"><%=form.getOrderNumber()%></td>
          <td align="center"><%=form.getMember().getUserName()%></td>

		  <td align="center"><% if(form.getStatusFullName().equals("paid")||form.getStatusFullName().equals("NotPaid")){%>
                    <a href="orderAction.do?action=0&status=<%=form.getStatusFullName()%>">No</a>
                    <%}else{%>
                    <a href="orderAction.do?action=0&status=<%=form.getStatusFullName()%>">Yes</a>
          <%}%></td>
        <td align="center"><a href="orderAction.do?action=3&orderNumber=<%=form.getOrderNumber()%>">Order Detail</a>
                             &nbsp;&nbsp;
	     <%if(form.getStatusFullName().equals("shipped")||form.getStatusFullName().equals("delivered")){%>
		 Sent
		 <%}else if(form.getStatusFullName().equals("paid")){%>
		  <a href="orderAction.do?action=1&orderNumber=<%=form.getOrderNumber()%>">Send</a>
		 <%}else{%>
		  <a href="orderAction.do?action=1&status=<%=form.getStatusFullName()%>&orderNumber=<%=form.getOrderNumber()%>">Send</a>
		 <%}%>
		 &nbsp;&nbsp;
		 <a href="javascript:deleteOrder('<%=form.getOrderNumber()%>')">Delete</a></td>
		
		 <td align="center"><%=form.getStatusFullName()%></td>
		 
        </tr>
       
        <%}%>
        
      </table><br>
<%if(request.getParameter("status")==null){%>
  <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
    <td width="17%"><%=maxPage%>Page In Total</td>
    <td width="22%"><%=pageNumber%>Items</td>
    <td width="26%">Page<%=number+1%></td>
    <td width="19%"><%if((number+1)==1){%> Pre<%}else{%><a href="orderAction.do?action=0&i=<%=number-1%>">Pre</a></td><%}%>
    <td width="16%"><%if(maxPage<=(number+1)){%>Next<%}else{%><a href="orderAction.do?action=0&i=<%=number+1%>">Next</a></td><%}%>
   </tr>
 </table>
<%}else{%>
 <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
    <td width="14%"><%=maxPage%>Page in total</td>
    <td width="18%"><%=pageNumber%>Items</td>
    <td width="22%">Page<%=number+1%></td>
    <td width="16%"><%if((number+1)==1){%> Pre<%}else{%><a href="orderAction.do?action=0&i=<%=number-1%>&status=<%=request.getParameter("status")%>">Pre</a></td><%}%>
    <td width="12%"><%if(maxPage<=(number+1)){%>Next<%}else{%><a href="orderAction.do?action=0&i=<%=number+1%>&status=<%=request.getParameter("status")%>">Next</a></td><%}%>
    <td width="18%"><a href="orderAction.do?action=0">Back</a></td>
   </tr>
 </table>


<%}%>	</td>
  </tr>
</table><jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
