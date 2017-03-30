<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Goods"%>
<jsp:useBean id="big" scope="page" class="com.ji.DAO.TypeDao"/>
<jsp:useBean id="small" scope="page" class="com.ji.DAO.BrandDao"/>
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
 function deleteType(date) {
  if(confirm("Confirm Delete？")){
    window.location="TypeAction.do?action=3&id="+date;
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
            <td><div align="center"><strong>Goods Information</strong></div></td>
          </tr>
        </table>
        <br>
				  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="14%" height="25"><div align="center">ID</div></td>
          <td width="19%"><div align="center">Name</div></td>
          <td width="14%"><div align="center">Type</div></td>
          <td width="14%"><div align="center">Brand</div></td>
          <td width="14%"><div align="center">If Sale</div></td>
          <td width="25%"><div align="center">Operation</div></td>
        </tr>
		     <%for(int i=start;i<over;i++){
            Goods form=(Goods)list.get(i);

      %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><a href="<%=form.getPicture()%>" target="_blank"><%=form.getName()%></a></div></td>

          <td><div align="center"><%=big.selectName(form.getType().getId())%></div></td>

          <td><div align="center"><%=small.selectName(form.getBrand().getId())%></div></td>
          <td><div align="center"><%if(form.getStatus().equals("NotSale")){%>no<%}else{%>yes<%}%></div></td>
          <td><div align="center"><a href="goodsAction.do?action=5&id=<%=form.getId()%>">Detail Information</a>
		 
		
		 
		  </div></td>
          <%}%>  </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%"><%=maxPage%> Page in Total</td>
          <td width="16%"><%=pageNumber%> Items</td>
          <td width="14%">Page <%=number+1%></td>
          <td width="19%"><%if((number+1)==1){%>  
	  Pre 
        <%}else{%>
		
		<a href="goodsAction.do?action=8&i=<%=number-1%>&brandId=<%=request.getParameter("brandId")%>">
		  Pre</a></td>
          <%}%>
          <td width="18%"><%if(maxPage<=(number+1)){%>
            Next
              <%}else{%>
	 
		<a href="goodsAction.do?action=8&i=<%=number+1%>&brandId=<%=request.getParameter("brandId")%>">下一页</a>
<%}%>


        

        </tr>
      </table>
		
		
		
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />


















</body>
</html>
