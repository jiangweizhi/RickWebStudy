<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<security:authorize ifAllGranted="ROLE_ADMIN">
<div class="control">Control Panel</div>		
<div class="panel">
	<div class="control_bt">
		<a href="/userprofile/processpayment.xhtml"><spring:message code="sidebar.PaymentforPosting"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/processpaymenttaskfee.xhtml"><spring:message code="sidebar.PaymentforTask"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/processwithdraw.xhtml"><spring:message code="sidebar.MoneyRefund"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/regdesigner.xhtml"><spring:message code="sidebar.CreateStep3designer"></spring:message></a>
	</div>
</div>
</security:authorize>