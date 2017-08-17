<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%  
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + path+"/";  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="images/tool.ico">
<link rel="icon" href="images/tool.ico" type="image/x-icon" />
<link rel="Bookmark" href="images/tool.ico" type="image/x-icon" />
<link rel="shortcut icon" href="images/tool.ico" type="image/x-icon" />
<script type="text/javascript">

	var timer = null;

	function delaySubmitForm(){
		var checkbox = document.getElementById("checkbox");
		if(checkbox.checked) {
			document.getElementById("rownum").focus();
			timer = setTimeout("document.forms[0].submit()",5000);
		} else {
			clearTimeout(timer);
		}
		
		//document.getElementById("rownum").focus();
	}


</script>

<title>获取用户绑卡短信验证码</title>

</head>
<body onload="javaScript:delaySubmitForm();">
	<table id="main" border="0" cellpadding="3" cellspacing="1" width="100%" align="center" style="background-color: #b9d8f3;">
		<tr style="text-align: left; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			<td colspan="7">
				<a href="list" target="_self">返回</a>
			</td>
		</tr>
		<c:if test="${message != null }">
		<tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			<td colspan="7"><c:out value="${message }"></c:out></td>
		</tr>
		</c:if>
		<tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			<td colspan="7">
				<form action="${action }" method="get">
					<c:out value="是否自动刷新(10秒)"></c:out><input id="checkbox" name="checkbox" type="checkbox" value="checkbox" <c:out value="${checkbox }"></c:out> onchange="javaScript:delaySubmitForm();"/>
					<c:out value="点击'查询'可直接刷新"></c:out><input type="submit" name="查询" value="查询" />
					<c:out value="  当前显示条数:"></c:out><input type="text" id="rownum" name="rownum" value="${rownum }" />
				</form>
			</td>
		</tr>
		<tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			
			<td>
				<c:out value="手机号"></c:out>
			</td>
			
			<td>
				<c:out value="姓名"> </c:out>
			</td>
			
			<td>
				<c:out value="身份证号"></c:out>
			</td>
			
			<td>
				<c:out value="银行卡号"></c:out>
			</td>
			
			<td>
				<c:out value="商户号"></c:out>
			</td>
			
			<td>
				<c:out value="验证码"></c:out>
			</td>
			
			<td>
				<c:out value="验证状态/获取验证码次数"></c:out>
			</td>
			
		</tr>
		
		<c:if test="${messageValidate != null }">
		<c:forEach items="${messageValidate }" var="item">
		
		<tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			<td>
				<c:out value="${item['mobile'] }"></c:out>
			</td>
			<td>
				<c:out value="${item['customerName'] }"></c:out>
			</td>
			<td>
				<c:out value="${item['idNumber'] }"></c:out>
			</td>
			
			<td>
				<c:out value="${item['bankNo'] }"></c:out>
			</td>
			<td>
				<c:out value="${item['merchantNo'] }"></c:out>
			</td>
			
			<td>
				<c:if test="${item['idCode']=='YES'}">
		        <c:out value="重新发送"></c:out>
		        </c:if>
		        <c:if test="${item['idCode']!='YES'}">
		        <c:out value="${item['idCode'] }"></c:out>
		       </c:if>
			</td>
			<td>
			    <c:if test="${item['idCode']=='YES'}">
		        <c:out value="已验证"></c:out>
		        </c:if>
			 
		        <c:if test="${item['idCode']!='YES'}">
		        <c:out value="未验证"></c:out>
		        </c:if>
			 
				<c:out value="/"></c:out>
				<c:out value="${item['validateCount'] }"></c:out>
			</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>