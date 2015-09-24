<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/styles.css" media="screen" />
 
</head>
<body>
	<div class="login">
		<div class="main">
			<h1>Identification</h1>
			<s:if test="hasActionMessages()">
			   <div class="welcome">
			      <s:actionmessage/>
			   </div>
			</s:if>
			<h4>
				<s:property value="getText('welcome.hello')" /> : 
				<s:property value="username"/>
			</h4>
		</div>
	 </div>
 
</body>
</html>