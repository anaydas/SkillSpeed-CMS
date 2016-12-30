<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/article/addComment" commandName="comments" method="POST">
<h1 align="center">${articleName}</h1><br>
	 <img style="margin:0px auto;display:block" src="data:image/jpeg;base64,${articleImage}"/>
	<textarea style="margin:0px auto;display:block" rows="50" cols="80" readonly="readonly">${articleBody}</textarea>
	
	<form:textarea path="commentDetails"/>
	<input type="submit" name="Add Comment" value="comment">
</form:form>	
</body>
</html>