<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Goods" %>
<jsp:useBean id="newGood" scope="page" class="com.ji.DAO.GoodsDao"/>
<%List nowList =newGood.selectSale("NotSale");
System.out.println("nowList"+nowList);%>
<%List freeList =newGood.selectSale("sale");
System.out.println("freeList"+freeList);%>
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
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	


    <div align="center">
        <%System.out.println("freeList"+!freeList.isEmpty());
        if(!freeList.isEmpty()){%>
        <br>
        <img src="image/fg_right02.jpg">
    </div>
    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
        <tr> 
		  <%
              int free=1;
              if(freeList.size()>1){
              free=freeList.size();
              }

              for(int i=0;i<free;i++)
              {
                Goods newGoods=(Goods)freeList.get(i);
                %>
            <td valign="top">			<table width="257" height="136" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#999999">
              <tr>
                <td width="33%" height="80" rowspan="5" bgcolor="#FFFFFF"><input name="picture<%=i%>" type="image" src="<%=newGoods.getPicture()%>" width="140" height="126"></td>
                <td width="67%" height="20" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getName()%></div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center" style="text-decoration:line-through;color:#910402">Original Price：<%=newGoods.getPrice()%>$</div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">NowPrice：<%=newGoods.getSalePrice()%>$</font></div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getDescription()%></div></td>
              </tr>
              <tr>
                <td height="13" bgcolor="#FFFFFF"><div align="center" class="linkBlack">
                <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=500,height=200');">Detail Information</a></div>
                <%}else{%>
                           You should sign in to buy!</td>
                          <%}%>
              </tr>
            </table></td>
            <%}%>
        </tr>
        
        
        
</table>


<div align="center">
    <%}%><%System.out.println("nowList"+!nowList.isEmpty());
        if(!nowList.isEmpty()){ %>
    <img src="image/fg_right01.jpg">
</div>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
    
          <tr>
            <td height="215" valign="top">
			<%
              int now=1;
            
             if(session.getAttribute("form")!=null){
            	  if(nowList.size()>1){
                      now=nowList.size();
                      }
             }
              for(int i=0;i<now;i++)
              {
            	  System.out.println("noew"+now);
            	  System.out.println("noew"+session.getAttribute("form"));
                Goods newGoods=(Goods)nowList.get(i);
                %><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>				<table width="99%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
                  <tr>
                    <td height="150" bordercolor="#666666" >
                      <table width="96%"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC" >
                        <tr>
                          <td width="36%" rowspan="4" bgcolor="#FFFFFF"><div align="center">
                              <input name="picture<%=i%>" type="image" src="<%=newGoods.getPicture()%>" width="110" height="100">
                          </div></td>
                          <td width="64%" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getName()%></div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">Price：<%=newGoods.getPrice()%>$</font></div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center"><%=newGoods.getDescription()%></div></td>
                        </tr>
                        <tr>
                          <td  bgcolor="#FFFFFF" class="linkBlack"  align="center">
                              <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                              <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=500,height=200');">Detail Information</a>
                              <%}else{%>
                           You should sign in to buy!</td>
                          <%}%>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table>
			<%}%>
			
			
			
			</td>
			 
		       
          </tr>
</table>
<%} %>











</td>
  </tr>
</table>

	<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
