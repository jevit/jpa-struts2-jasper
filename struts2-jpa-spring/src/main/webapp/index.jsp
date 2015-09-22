<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/styles.css" media="screen" />
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
