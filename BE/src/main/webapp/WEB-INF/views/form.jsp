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
<img src="img/item/rollie.jpg">
<form action="/item/list" method="POST" enctype="multipart/form-data" >
파일<input type="file" id="img" name="img"><br>
설명<input type="text" id="description" name="description"><br>
원가<input type = "number" name="cost">
양<input type="number" name ="quantity">
코드<input type="text" name="code">
name<input type="text" name="name">
카테고리<input type="text" name= "category">
여는날<input type="text" name="openingDate">
공개날<input type="text" name="ipoDate">
거래날<input type="text" name="tradingDate">
청산<input type="text" name="clearingDate">
<input type="submit">
</form>
</body>
</html>
