<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="/god" method="POST" enctype="multipart/form-data" >
<input type="file" id="img" name="img"><br>
<input type="text" id="description" name="description"><br>
<input type="submit">
</form>
</body>
</html>
