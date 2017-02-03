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
            <li><a href="game">开始</a></li>
            <li><a href="static">统计</a></li>
          <li class="active"><a href="setting">设置</a></li>
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
                <th>上台场次</th>
                <th>胡牌次数</th>
                <th>上台胜率</th>
                <th>暗杠</th>
                <th>明杠</th>
                <th>放杠</th>
                <th>买马次数</th>
                 <th>买马成功</th>
                <th>买马胜率</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    </div>
    <div class="row">
   <button class="btn btn-primary" id="back">返回</button>
    </div>
    <input name="roundId" type="hidden" value="${roundId}" id="roundId"/>
</body>
<script type="text/javascript" src="/majiong/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/majiong/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/majiong/static/js/datatables/jquery.dataTables.js"></script>
<script type="text/javascript" src="/majiong/static/js/datatables/dataTables.bootstrap.js"></script>
<script type="text/javascript" >

$.ajax({  
    type : "GET",  //提交方式  
    url : "getUserStatic",//路径  
    dataType:"json",      
    data:{},
    success : function(result) {//返回数据根据结果进行相应的处理
    	for(var i = 0;i<result.length;i++){
    		$('tbody').append("<tr>"+
    	   	 	      "<td>"+result[i].name+"</td>"+
    	   	 	  "<td>"+result[i].attend+"</td>"+
    	   	 	"<td>"+result[i].attendSuccess+"</td>"+
    	   	 "<td>"+result[i].attendRate+"</td>"+
    	   	"<td>"+result[i].an+"</td>"+
    	   	"<td>"+result[i].ming+"</td>"+
    	   	"<td>"+result[i].fang+"</td>"+
    	   	"<td>"+result[i].maTotal+"</td>"+
    	 	"<td>"+result[i].maSuccess+"</td>"+
    	 	"<td>"+result[i].maRate+"</td>"+
    	   	       "</tr>");	
    	}
   	 	
    }
});
</script>
</html>