<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 上传表单的特点
		1.method="post"
		2.enctype="multipart/form-data"
		2.<input type="file"...>
	 -->
	<form action="${pageContext.request.contextPath}/upload/doUpload.do" method="post" enctype="multipart/form-data">
	上传文件:<input type="file" name="file" id="file"><br>
	<input type="submit" value="上传">
	
	</form>
</body>
</html>