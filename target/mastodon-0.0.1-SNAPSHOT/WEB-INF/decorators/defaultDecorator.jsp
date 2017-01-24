<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
 <head>
 <title><sitemesh:write property='title'/></title>
 <sitemesh:write property='head'/>
 </head>
 
 <body>
<div class="navbar">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Title</a>
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="/mastodon/">Home</a>
			</li>
			<li>
				<a href="pizza">Link</a>
			</li>
		</ul>
	</div>
</div>

<div>
 <sitemesh:write property='body'/>
</div>
<!-- Latest compiled and minified CSS & JS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="//code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
 </body>
</html>