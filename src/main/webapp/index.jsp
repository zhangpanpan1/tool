<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

	<%-- 测试 --%>
	<%--<jsp:forward page="/test/loadAccount.action?accountNo=345"/>--%>
	<%--<jsp:forward page="/test/findAccountByMerchant.action?merchantId=3064863"/>--%>
	<%--<jsp:forward page="/test/validateMerchant.action?id=1728880"/>--%>
	<%--<jsp:forward page="/test/unvalidateMerchant.action?id=1728880"/>--%>
	<%--<jsp:forward page="/test/existBankCard.action?backId=6228480402564622940"/>--%>
	<%--<jsp:forward page="/test/unbundAccountCount.action?accountNo=1728880"/>--%>
	<%--<jsp:forward page="/test/unbundAccount.action?accountNo=1728880"/>--%>


	<jsp:forward page="app/indexKsn.action"></jsp:forward>
	<marquee behavior="scroll" direction="left" loop="-1">
		<font size="72" color="#656565">我是测试数据.......</font>
	</marquee>
</body>
</html>