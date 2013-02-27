<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize ifAllGranted="ROLE_USER">
	<div style="float: right">
		<p>
			<a href="/userprofile/logout.xhtml"><spring:message
					code="homePage.logout" />
			</a>
		</p>
	</div>
	
	<div style="float: right">
		<p>
			Welcome,<a href="/userprofile/clientportfolio.xhtml"> <c:if test="${pageContext.request.userPrincipal != null}">${pageContext.request.userPrincipal.name} </c:if> 
		  </a>
		  
		</p>
	</div>
</security:authorize>
<security:authorize ifAllGranted="ROLE_ADMIN">
	<div style="float: right">
		<p>
			<a href="/userprofile/logout.xhtml"><spring:message
					code="homePage.logout" />
			</a>
		</p>
	</div>
	
	<div style="float: right">
		<p>
			Welcome, 
			<a href="/userprofile/adminportfolio.xhtml"> 
			<c:if test="${pageContext.request.userPrincipal != null}">${pageContext.request.userPrincipal.name}</c:if></a>
		</p>
	</div>
	
</security:authorize>
<security:authorize ifAllGranted="ROLE_DESIGNER">
	<div style="float: right">
		<p>
			<a href="/userprofile/logout.xhtml"><spring:message
					code="homePage.logout" />
			</a>
		</p>
	</div>
	
	<div style="float: right">
		<p>
			Welcome, <a href="/userprofile/designerportfolio.xhtml"> <c:if test="${pageContext.request.userPrincipal != null}">${pageContext.request.userPrincipal.name} 										</c:if> 
		  </a>
		  
		</p>
	</div>
	
</security:authorize>
<security:authorize ifAllGranted="ROLE_ANONYMOUS">
	<div id="register">
		<p>
			<a href="/userprofile/register.xhtml"><spring:message code="homePage.register" />
			</a>
		</p>
	</div>
	<div id="login">
		<p>
			<a HREF="/userprofile/login-form.xhtml"><spring:message code="homePage.login" />
			</a>
		</p>
	</div>
</security:authorize>
