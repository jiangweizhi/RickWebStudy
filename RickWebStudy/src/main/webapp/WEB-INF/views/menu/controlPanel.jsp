<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<security:authorize ifAllGranted="ROLE_USER">
<div class="control">Control Panel</div>		
<div class="panel">
	<div class="control_bt">
		<a href="/userprofile/clientportfolio.xhtml">Portfolio</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/myprojects.xhtml">My Project</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/resetpassword.xhtml">Account & password</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/payment-transaction.xhtml">Transaction</a>
	</div>
</div>
</security:authorize>
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
		<a href="/userprofile/resetpassword.xhtml">Account & password</a>
	</div>
	<div class="control_bt">
		<a href="/userprofile/payment-transaction.xhtml">Transaction</a>
	</div>
</div>
</security:authorize>
<security:authorize ifAllGranted="ROLE_ADMIN">
<div class="control">Control Panel</div>		
<div class="panel">
	<div class="control_bt">
		<a href="/userprofile/processpayment.xhtml"><spring:message code="sidebar.PaymentforPosting"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="ProcessPaymentTaskFee.action"><spring:message code="sidebar.PaymentforTask"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="ProcessWithdraw.action"><spring:message code="sidebar.MoneyRefund"></spring:message></a>
	</div>
	<div class="control_bt">
		<a href="RegDesigner.action"><spring:message code="sidebar.CreateStep3designer"></spring:message></a>
	</div>
</div>
</security:authorize>