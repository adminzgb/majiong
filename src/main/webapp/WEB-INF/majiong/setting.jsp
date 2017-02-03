<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN">
<html>
 <head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="/majiong/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
.form-control{
	width:20%;
	margin-left:10px;
}
.row{
	margin-top:10px;
}
</style>
<title>Majiong BigData</title>
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
<div class="container">
<div class="row">
<span>用户：</span>
<button class="btn btn-primary" id="all">查看当前用户</button>
<button class="btn btn-primary" id="add">增加用户</button>
</div>
<div class="row">
<span style="display:inline-block">胡牌</span><input style="display:inline-block" class="form-control" type="text" name="hu" id="hu" />
</div>
<div class="row">
<span style="display:inline-block">明杠</span><input style="display:inline-block" class="form-control" type="text" id="ming" name="ming"/>
</div>
<div class="row">
<span style="display:inline-block">暗杠</span><input style="display:inline-block" class="form-control" type="text" id="an" name="an"/>
</div>
<div class="row">
<span style="display:inline-block">放杠</span><input style="display:inline-block" class="form-control" type="text" id="fang" name="fang"/>
</div>
<input type="hidden" id="setting-id"/>
<div class="row">
<button class="btn btn-primary" id="save">保存</button>
<button class="btn btn-primary" id="back">返回主页</button>
</div>
</div>
</head>
<body>

</body>
 <script type="text/javascript" src="/majiong/static/js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
 	$('#begin').click(function(){
 		window.open("game","_self");
 	});
 	 $.ajax({  
 	     type : "GET",  //提交方式  
 	     url : "getSetting",//路径  
 	     data:{  
 	     },
 	     success : function(result) {//返回数据根据结果进行相应的处理  
 	    	 $('#hu').val(result.hu);
 	    	$('#an').val(result.an);
 	    	$('#fang').val(result.fang);
 	    	$('#ming').val(result.ming);
 	    	$('#setting-id').val(result.id);
 	     }  
 	 });
 	$('#save').click(function(){
 		 var hu = $('#hu').val();
	    	var an = $('#an').val();
	    	var fang = $('#fang').val();
	    	var ming = $('#ming').val();
	    	var id=$('#setting-id').val();
	    	 $.ajax({  
	     	     type : "POST",  //提交方式  
	     	     url : "changeSetting",//路径  
	     	     data:{  
	     	    	 "hu":hu,
	     	    	 "an":an,
	     	    	 "fang":fang,
	     	    	 "ming":ming,
	     	    	 "id":id
	     	     },
	     	     success : function(result) {//返回数据根据结果进行相应的处理  
	     	    	
	     	     }  
	     	 });
 	});
 	
 	$('#back').click(function(){
 		window.open('index','_self');
 	});

 	$('#all').click(function(){
 		window.open('getUsersView','_self');
 	});
 	
 
 
 
 </script>
</html>
