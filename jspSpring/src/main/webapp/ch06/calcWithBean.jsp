<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="www.dream.bb.model.CalcReqBean"%>
<!-- C:\JavaWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP 결과물
	<jsp:useBean id="myReq" scope="page"
		class="www.dream.bb.model.CalcReqBean" />
	<jsp:setProperty name="myReq" property="*" />
	<%= myReq.calc() %>
	<br> ${ myReq.calc() }
	<br> ${ myReq.operandFirst }
	<br> ${ myReq.arr[1] }
</body>
</html>