<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN">
<html>
 <head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="/majiong/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<title>Majiong BigData</title>
<div class="container">
<h2>麻将大数据</h2>
<ul class="nav nav-pills nav-stacked">
  <li class="active"><a href="#">首页</a></li>
  <li><a href="game">开始</a></li>
  <li><a href="statics">统计</a></li>
  <li><a href="setting">设置</a></li>
</ul>
</div>
</head>
<body>

</body>
 <script type="text/javascript" src="/majiong/static/js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
 	$('#begin').click(function(){
 		window.open("game","_self");
 	});
 	$('#setting').click(function(){
 		window.open("setting","_self");
 	});
 
 
 
 </script>
</html>
