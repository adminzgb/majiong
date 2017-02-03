<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/majiong/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/majiong/static/css/dataTables/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
<title>majiong bigdata</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">麻将大数据</a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul class="nav navbar-nav">
         <li><a href="index">首页</a></li>
            <li class="active"><a href="game">开始</a></li>
            <li><a href="static">统计</a></li>
          <li><a href="setting">设置</a></li>
        </ul>
    </div>
    </div>
</nav>
<div class="table-responsive">
  <table class="table">
    <caption>数据统计</caption>
        <thead>
            <tr>
                <th>姓名</th>
                <th>胡</th>
                <th>明杠</th>
                <th>暗杠</th>
                <th>放杠</th>
                <th>买马</th>
                <th>本场</th>
                <th>累计</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    </div>
    <input name="roundId" type="hidden" value="${roundId}" id="roundId"/>
    <input name="gameId" type="hidden" value="${gameId}" id="gameId"/>
    <div class="row">
    <button class="btn btn-primary" id="continue">下一局</button>
    <button class="btn btn-primary" id="back">主页</button>
    </div>
    
</body>
<script type="text/javascript" src="/majiong/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/majiong/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/majiong/static/js/datatables/jquery.dataTables.js"></script>
<script type="text/javascript" src="/majiong/static/js/datatables/dataTables.bootstrap.js"></script>
<script type="text/javascript" >

$.ajax({  
    type : "GET",  //提交方式  
    url : "getRoundPost",//路径  
    dataType:"json",      
    data:{"roundId":$('#roundId').val()},
    success : function(result) {//返回数据根据结果进行相应的处理
    	for(var i = 0;i<result.length;i++){
    		$('tbody').append("<tr>"+
    	   	 	      "<td>"+result[i].name+"</td>"+
    	   	 	  "<td>"+result[i].hu+"</td>"+
    	   	 	"<td>"+result[i].ming+"</td>"+
    	   	 "<td>"+result[i].an+"</td>"+
    	   	"<td>"+result[i].fang+"</td>"+
    	   	"<td>"+result[i].ma+"</td>"+
    	   	"<td>"+result[i].roundTotal+"</td>"+
    	   	"<td>"+result[i].gameTotal+"</td>"+
    	   	       "</tr>");	
    	}
   	 	
    }
});

$('#continue').click(function(){
	window.open('game?gameId='+$('#gameId').val(),'_self');
});
</script>
</html>