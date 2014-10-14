<html>
<head><style type="text/css">
.welcome {
	background-color:#DDFFDD;
	border:1px solid #009900;
	width:200px;
}
.welcome li{ 
	list-style: none; 
}
</style>
</head>
<body><title><s:text name="HelloWorld.message"/></title> 
<h2>Hello World!</h2>
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>
<s:property value="getText('welcome.hello')" /> : 
<s:property value="username"/>
 
 
</body>
</html>
