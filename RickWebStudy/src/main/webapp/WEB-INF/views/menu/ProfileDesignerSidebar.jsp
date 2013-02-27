<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<security:authorize ifAllGranted="ROLE_DESIGNER">
<div class="control">Control Panel</div>		
<div class="panel">
	<div class="control_bt">
		<a href="/userprofile/designerportfolio.xhtml">Portfolio</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/myprojects.xhtml">My Project</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/updatedesigneraccount.xhtml">Account & password</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/editpayment.xhtml">Transaction</a>
	</div>
</div>
</security:authorize>