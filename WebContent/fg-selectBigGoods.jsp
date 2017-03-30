<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Goods" %>
<%@page import="com.ji.Entity.Brand" %>
<%List bigList=(List)request.getAttribute("list");%>
<%List smallList=(List)request.getAttribute("smallList");%>
<%
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*4;
int over=(number+1)*4;
int count=pageNumber-over;

if(count<=0){
  over=pageNumber;
  }
%>
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
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
<%if(bigList.size()==0){%><br><br><br><br>No Goods Information<br><br><br><br><%}else{%>
           <%
              for(int i=start;i<over;i++){
              Goods bigForm=(Goods)bigList.get(i);
            %>
<br>
		<table width="67%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="4" height="120"><input name="pricture<%=i%>" type="image" src="<%=bigForm.getPicture()%>" width="140" height="126"></td>
            <td width="64%" height="30"><div align="center"><%=bigForm.getName()%></div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">
            <%if(String.valueOf(bigForm.getMark()).equals("0")){%>
              Original Price：<%=bigForm.getPrice()%>$
            <%}else{%>
             <font color="#FF0000"> Sale Price：<%=bigForm.getSalePrice()%>$</font>
            <%}%>
            </div></td>
          </tr>
          <tr>
            <td height="30"><div align="center"><%=bigForm.getDescription()%></div></td>
          </tr>
          <tr>
            <td height="30"> <div align="center">  <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
              <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=bigForm.getId()%>','','width=500,height=200');">Detail Information</a>
				
				    <%}else{%>
				   You should sign in to buy!
			    
				   <%}%>
			    </div></td>
          </tr>
        </table>
		<%}}%><br>
        <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="13%"><%=maxPage%> Page in Total</td>
            <td width="16%"><%=pageNumber%> Items</td>
            <td width="14%">Page <%=number+1%></td>
            <td width="19%"><%if((number+1)==1){%>
      Pre
        <%}else{%>
        <a href="goodsAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number-1%>">Pre</a></td>
            <%}%>
            <td width="18%"><%if(maxPage<=(number+1)){%>
      Next
        <%}else{%>
        <a href="goodsAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number+1%>">Next</a></td>
            <%}%>
           
          </tr>
        </table>
	
	
	
	
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
