<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
	<head>
		<script type="text/javascript" src="<c:url value="/static/resources/jquery/1.6/jquery.js" />"></script>
    	<title>Hello Rick</title>
	</head>

	<body>
		<div>Hello Rick</div>
		<form:form id="commentForm" method="post" action="/comment/postComment.xhtml" enctype="multipart/form-data">
			<div>
				<a href="<c:url value="/home.xhtml" />">Home</a>
				<img src="<c:url value="/static/images/hello.gif"/>" />
				<textarea id="txtComment" rows="3" cols="20"></textarea>
				<input type="button" id="btnPost" value="Post Message" />
			</div>
			<input type="hidden" id="hidPostMessage" name="commentValue" />
		</form:form>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnPost").bind("click", function(){
				//alert($("#txtComment").val());
				$("#hidPostMessage").val($("#txtComment").val());
				$("#commentForm").submit();
			});
		});
	</script>
</html>
