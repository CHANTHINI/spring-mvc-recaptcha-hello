<%@ taglib tagdir='/WEB-INF/tags' prefix='sc'%>
<html>
<head>
	<title>Captcha Entry Form</title>
</head>
<body>
Are you human? <font color="red">${message}</font>
<br/>
<form action="/ReCaptchaHelloWorld/recaptcha" method="post"> 
	<sc:captcha/>
	<input type="submit" value="submit"/> 
</form>
</body>
</html>
