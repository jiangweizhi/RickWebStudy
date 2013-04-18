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
    	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	</head>

	<body>
		<div id="divTest">Hello Rick</div>
		<form:form id="commentForm" method="post" action="/comment/postComment.xhtml" enctype="multipart/form-data">
			<div>
				<%-- <a href="<c:url value="/home.xhtml" />">Home</a>
				<img src="<c:url value="/static/images/hello.gif"/>" /> --%>
				<textarea id="txtComment" rows="3" cols="20"></textarea>
				<input type="button" id="btnPost" value="Post Message" />
			</div>
			<input type="hidden" id="hidPostMessage" name="commentValue" />
		</form:form>
		<div>
			<a href="<c:url value="/image.xhtml" />">Jump to Image Function Page</a>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$("#divTest").data("rick", "Rick Jiang0").data("rick2", "Rick Jiang1");
			var myValue = $("#divTest").data("rick2");
			alert(myValue);
			$("#btnPost").bind("click", function(){
				//alert($("#txtComment").val());
				$("#hidPostMessage").val($("#txtComment").val());
				$("#commentForm").submit();
			});
			
			/* var url = "http://wangiv2-w7/NameCardRestService/GetRestDatas.ashx?functionName=listfavourites&params={domainID: \"chensa7\",sortByField: \"Name\",sortOrder: \"A\",numRecord: \"10\",lastRecordIndex: \"0\"}";
			$.ajax({
				type:'GET',
				url:url,
				//data:"{functionName:listfavourites;params:{%22domainID%22:%22chensa7%22,%22sortByField%22:%22Name%22,%22sortOrder%22:%22A%22,%22numRecord%22:%225%22,%22lastRecordIndex%22:%220%22}}",
				dataType:'json',
				success:function(data) {
				    alert("Success:" + data.responseCode);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Search failed\n" + XMLHttpRequest.status + XMLHttpRequest.readyState + "\nresponseText:" + XMLHttpRequest.responseText + "\nresponseBody:" + XMLHttpRequest.responseBody + "\n" + textStatus + "\n" + errorThrown);
					return null;
				}
			}); */
			
			//var url = "http://wangiv2-w7/NameCardRestService/GetRestDatas.ashx?functionName=listfavourites&params={domainID: \"chensa7\",sortByField: \"Name\",sortOrder: \"A\",numRecord: \"10\",lastRecordIndex: \"0\"}";
			/* var url = "http://wangiv2-w7/NameCardRestService/GetRestDatas.ashx";
			jQuery.support.cors = true;
			$.ajax({
				type:'GET',
				url:url,
				data: {functionName:"listfavourites",params:"{domainID:\"chensa7\",sortByField: \"Name\",sortOrder: \"A\",numRecord: \"10\",lastRecordIndex: \"0\"}"},
				dataType:'json',
				contentType: "application/json;charset=utf-8",
				cache:false,
				success:function(data) {
				    alert("Success:" + data.responseCode);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Search failed\n" + XMLHttpRequest.status + XMLHttpRequest.readyState + "\nresponseText:" + XMLHttpRequest.responseText + "\nresponseBody:" + XMLHttpRequest.responseBody + "\n" + textStatus + "\n" + errorThrown);
					return null;
				}
			}); */
			
			/* var url = "http://wangiv2-w7/NameCardRestService/GetRestDatas.ashx?functionName=listfavourites&params={domainID: \"chensa7\",sortByField: \"Name\",sortOrder: \"A\",numRecord: \"10\",lastRecordIndex: \"0\"}";
			jQuery.support.cors = true;
			$.ajax({
				type:'GET',
				url:url,
				dataType:'json',
				cache:false,
				success:function(data) {
				    alert("Success:" + data.responseCode);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Search failed\n" + XMLHttpRequest.status + XMLHttpRequest.readyState + "\nresponseText:" + XMLHttpRequest.responseText + "\nresponseBody:" + XMLHttpRequest.responseBody + "\n" + textStatus + "\n" + errorThrown);
					return null;
				}
			}); */
			//$.get(url, {functionName:"listfavourites", params:"{domainID:\"chensa7\",sortByField: \"Name\",sortOrder: \"A\",numRecord: \"10\",lastRecordIndex: \"0\"}"}, function(data){alert(data);});
		});
	</script>
</html>
