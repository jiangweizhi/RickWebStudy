<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/static/resources/jquery/jquery-1.7.2.js" />"></script>
<title>Insert title here</title>
</head>
<body>
	<div>This is the Result Page of Comments</div>
	<div>
		<textarea id="txtComment" rows="3" cols="20"></textarea>
		<input type="button" id="btnPost" value="Post Message" />
	</div>
	<div>
		<input type="button" id="btnGetComment" value="GetComment" />
	</div>
	<div>
		Below is table:
		<table id="commentTable">
			
		</table>
	</div>
	<script type="text/javascript">
		function makeContent(result){
			var content = "";
			var times;
			for(var i=0;i<result.length;i++){
				times = new Date(result[i].createdAt);
				content += "<tr><td>"+result[i].content+"</td><td>"+times.toLocaleDateString()+" "+times.toLocaleTimeString()+"</td></tr>";
			}
			return content;
		}
	
		function getComment(){
			$.ajax({
				type:"get",
				url:"/comment/getComment.xhtml",
				dataType:"json",
				success:function(result){
					var content = makeContent(result);
					$("#commentTable").html(content);
				},
				error: function(){
					alert('error');
				}
			});
		};
		
		function postComment(){
			var comment = $("#txtComment").val();
			$.ajax({
				type:"post",
				url:"/comment/postComment2.xhtml",
				data: "commentValue="+comment,
				dataType:"json",
				success:function(result){
					var content = makeContent(result);
					$("#commentTable").html(content);
					$("#txtComment").val("");
				},
				error: function(){
					alert('error');
				}
			});
		};
		
	
		$(document).ready(function(){
			$("#btnGetComment").bind("click", function(){
				getComment();
			});
			$("#btnPost").bind("click", function(){
				postComment();
			});
		});
	</script>
</body>
</html>