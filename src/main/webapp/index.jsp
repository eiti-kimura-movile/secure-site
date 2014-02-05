<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header">
	<jsp:include page="menu.jsp" />
</div>
<div id="logo" class="container">
	<h1><a href="#" class="icon icon-tasks"><span>Secure-Site A Spring Security CAS Integration</span></a></h1>
</div>
<div id="page" class="container">
	<div id="content">
		<div class="title">
			<h2>Welcome to this sample secure site</h2>
			<span class="byline"><br/><img src="http://www.gravatar.com/avatar/7b24d7d1e77aa802d1f7a4b4908eb1c1.png" style="float:left:height:5%;width:5%"/> Developed by Eiti Kimura</span>
		</div> 
		<p> This web application was developed using Java, <a href="http://www.gradle.org/" link="nofollow">Gradle</a> and Spring Security and shows how to integrate an application with <a href="http://www.jasig.org/cas" rel="nofollow">CAS</a> (Central Autentication Service). <br/> 
		    To run the application we can use the embedded <a href="" link="nofollow">Jetty</a> gradle plug-in:</p>
		 <p>Type in the console:</p>
		 <pre>$ gradle clean jettyRun</pre>
		 <p>The webserver will be started and application deployed, everything should be up and running on port 9090. The port can be configured in build.gradle file.</p>
		 
		 <pre> :clean <br/> :compileJava <br/> :jettyRun <br/> > Building 80% > :jettyRun > Running at http://localhost:9090/secure-site</pre>		
		<p>This is <strong>TwoColours</strong>, a free, fully standards-compliant CSS template designed by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>. The photos in this template are from <a href="http://fotogrph.com/"> Fotogrph</a>. This free website template is released under a <a href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attributions 3.0</a> license</p>
	</div>
	<div id="sidebar"><a href="#" class="image image-full"><img src="images/pic05.jpg" alt="" /></a></div>
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.</p>
</div>
</body>
</html>
