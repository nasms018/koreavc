<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="www.dream.bb.service.SCalc" %>
    <!-- C:\JavaWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP 결과물
내장객체 종류를 compile된 코드에서 찾아보자<br>

<h2> 결과 : <%= SCalc.calc(request) %> </h2>
</body>
</html>