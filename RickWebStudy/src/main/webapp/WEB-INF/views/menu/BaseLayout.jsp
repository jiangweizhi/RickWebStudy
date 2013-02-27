<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>   
  <link type="text/css" rel="stylesheet" media="all" href="<c:url value="/static/css/public.css"/>" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
  <script djconfig="parseOnLoad: true" src="<c:url value="/resources/dojo/dojo.js"/>" type="text/javascript"></script>
  <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>	
  <script type="text/javascript" src="<c:url value="/static/resources/jquery/1.6/jquery.js" />"></script>
  <script type="text/javascript">dojo.require("dojo.parser");</script>
 <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/lightbox.css" />" type="text/css" media="screen" />
 <script type="text/javascript" src="<c:url value="/static/js/lightbox.js" />"></script>
 <script language="JavaScript" src="<c:url value="/static/js/gen_validatorv4.js" />"  type="text/javascript" xml:space="preserve"></script>
 <link href="<c:url value="/static/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />" rel="stylesheet" type="text/css"/>
 <style type="text/css" xml:space="preserve">
	.error_strings{ font-family:Verdana; font-size:14px; color:#660000; background-color:#ff0;}
 </style>
 <script type="text/javascript" src="<c:url value="/static/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/jqueryform/2.8/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/json2.js" />"></script>
 <title>Cloudesign</title>	
 
</head>
<body>
<div id="allcontent">
    	<div class="head"><tiles:insertAttribute name="header" /></div>
    	<div class="menu"><tiles:insertAttribute name="navigation" /></div>
     	<div class="login"><tiles:insertAttribute name="login" /></div>
		<div class="con">
			<div class="conright">
			<tiles:insertAttribute name="sidebar" />
			<tiles:insertAttribute name="body" /></div>
		</div>
		<div id="copyright"><tiles:insertAttribute name="footer" /></div>
</div>

<script>
	MvcUtil = {};
	MvcUtil.showSuccessResponse = function (text, element) {
		MvcUtil.showResponse("success", text, element);
	};
	MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
		MvcUtil.showResponse("error", text, element);
	};
	MvcUtil.showResponse = function(type, text, element) {
		var responseElementId = element.attr("id") + "Response";
		var responseElement = $("#" + responseElementId);
		if (responseElement.length == 0) {
			responseElement = $('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>').insertAfter(element);
		} else {
			responseElement.replaceWith('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>');
			responseElement = $("#" + responseElementId);
		}
		responseElement.fadeIn("slow");
	};
	MvcUtil.xmlencode = function(xml) {
		//for IE 
		var text;
		if (window.ActiveXObject) {
		    text = xml.xml;
		 }
		// for Mozilla, Firefox, Opera, etc.
		else {
		   text = (new XMLSerializer()).serializeToString(xml);
		}			
		    return text.replace(/\&/g,'&'+'amp;').replace(/</g,'&'+'lt;')
	        .replace(/>/g,'&'+'gt;').replace(/\'/g,'&'+'apos;').replace(/\"/g,'&'+'quot;');
	};
</script>
</body>
</html>