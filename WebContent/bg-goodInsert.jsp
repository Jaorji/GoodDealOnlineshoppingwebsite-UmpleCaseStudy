<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.upload.FormFile" %>
<%@page import="com.ji.Entity.Type"%>
<%@page import="com.ji.Entity.Brand"%>
<%@page import="com.ji.Entity.Goods" %>
<jsp:useBean id="big" scope="page" class="com.ji.DAO.TypeDao"/>
<jsp:useBean id="small" scope="page" class="com.ji.DAO.BrandDao"/>
<jsp:useBean id="dao" scope="page" class="com.ji.DAO.GoodsDao"/>
<%
List bigList=big.selectBig();
String id=(String)request.getAttribute("typeId");
if(id==null||id.equals("")){			//当id值为空时，设置id值为-1
id="-1";					//当id值为空时，没有选择任何一个商品大类别名称，因此不会出现商品小类别名称
}


Integer bigId=Integer.parseInt(id);
List smallList=small.selectOneBigId(bigId);
%>
<script language="javascript">
function checkEmpty(form){
		
for(i=0;i<form.length-1;i++){
	//alert(i+"jj"+form.elements[i].value);
if(form.elements[i].value==""){
alert("Can not be Blank");
return false;
}
}
if(isNaN(document.form.pirce.value)){
window.alert("Price should be numbers");
return false;
}
}
function ChangeItem(){
var big=document.form.typeId.value;
window.location.href="goodsAction.do?action=2&typeId="+big;
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
            <td><div align="center"><strong>Add Goods</strong></div></td>
          </tr>
        </table>
        <br>

  <form action="goodsAction.do?action=3" method="post"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;Type</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;
              <select name="typeId" onChange="ChangeItem()"><option value="">Please Select</option>
          <%for(int i=0;i<bigList.size();i++){
            Type bigForm=(Type)bigList.get(i);
            %>

          <option value="<%=bigForm.getId()%>" <%if(bigId.equals(bigForm.getId())){out.println("selected");}%>> 
        
		  <%=big.selectName(bigForm.getId())%>
		  </option>
            <%}%>
            </select></td>
            <td width="20%">&nbsp;&nbsp;Brand</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;
              <select name="brandId"><option value="1" selected>Please Select</option>
             <%for(int i=0;i<smallList.size();i++){
               Brand smallForm=(Brand)smallList.get(i);
               %>
               <option value="<%=smallForm.getId()%>"><%=smallForm.getName()%></option>    
               
               <%}%>
            </select></td>
          </tr>
          <tr>
            <td height="25">&nbsp;&nbsp;Goods Name</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="name" type="text" size="20" ></td>
            <td>&nbsp;&nbsp;Manufacturer</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="manufacturer" type="text" size="20"></td>
          </tr>
          <tr>
            <td height="27">&nbsp;&nbsp;Price</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="pirce" type="text" size="20" ></td>
            <td>&nbsp;&nbsp;Sale Price</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="salePirce"" type="hidden" size="20" value="0">Not a sale item</td>
          </tr>
		  
		 <tr>
            <td height="28">&nbsp;&nbsp;Picture</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="formFile" type="file" id="formFile"></td>
            
          </tr>
		  
		  
          <tr>
          <td height="28">&nbsp;&nbsp;NumberInInventory</td>
            <td  bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="numberInInventory" type="text" size="20""></td>
            <td height="28">&nbsp;&nbsp;Description</td>
            <td  bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="description" type="text" size="20""></td>
          </tr>
        </table><br>
    
     <input type="image" class="input1" width="51" height="20" src="image/save.jpg">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear01.gif"/></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back01.gif"/></a>
	  </form>
	
	
	
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />























</body>
</html>
