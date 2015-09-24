<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
    <head> 
		<style type="text/css">
		.errors {
			background-color:#FFCCCC;
			border:1px solid #CC0000;
			width:400px;
			margin-bottom:8px;
		}
		.errors li{ 
			list-style: none; 
		}
		body {
		    background: #252525;
		    font-family: 'Open Sans';
		    font-weight: 300;
		}
		
		</style>
    <title>Liste utilisateur </title> 
    </head> 
 
	<body >
		<h2>
		<s:property value="message"/></h2> 
		<s:if test="hasActionErrors()">
		   <div class="errors">
		      <s:actionerror/>
		   </div>
		</s:if>
		<s:form action="loginAction">
			<s:textfield key="global.username" name="username"/>
			<s:password key="global.password" name="password"/>
			<s:submit key="global.submit" name="submit"/>
		</s:form>
	</body>
</html>
