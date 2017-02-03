<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN">
<html>
 <head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="/majiong/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/majiong/static/css/layer.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
.btn-group{
 margin-top:5px;
 maring-right:5px
}
 .form-control{
     display: inline-block;
     width:120px;
     margin:0 5px 0 5px
 }  
 #action{
 margin-top:10px
 }  
 h3{
 background-color:#eee
 } 
 .fang-gang{
 width:200px
 }  
 .dropdown-toggle{
 margin-right:10px
 } 

       </style>
<title>Majiong BigData</title>

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



<div class="container">
<div class="row">
<h3 style="display:inline-block">台上</h3>
<button type="button" class="btn btn-success" id="add-attend">
        选人
       
    </button>
<div class="row taishang">

</div>
</div>
<div class="row">
<h3 style="display:inline-block">买马</h3>
<button type="button" class="btn btn-success" id="add-ma">增加</button>
<div class="row maima">

	
</div>
</div>

<button type="button" class="btn btn-primary" id="action">开局</button>
 <input type="hidden" name="roundId" id="roundId" />  
  <input type="hidden" name="gameId" id="gameId" value="${gameId}" />
<div class="row result hide">
<h2>结果</h2>
<h3>台上</h3>
<div class="row">
<div class="btn-group hu">
    <div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        胡牌
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu users result-users">
    </ul>
    </div>
</div>	
<input type="text" style="display:inline-block" class="form-control" id="hu"  readonly="readonly">
</div>
<div class="row">
<div class="btn-group ming">
    <div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        明杠
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu users result-users">
    </ul>
    </div>
</div>	
</div>
<div class="row">
<div class="btn-group an">
    <div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        暗杠
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu users result-users">
    </ul>
    </div>
</div>	
</div>
<div class="row">
<div class="btn-group fang">
    <div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        放杠
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu users result-users">
    </ul>
    </div>
</div>	
</div>
<h3>买马</h3>
<div class="row ma-row"></div>
<div class="row">
<button type="button" class="btn btn-success" id="clean">清空结果</button>
<button type="button" class="btn btn-success" id="end">结束</button>
</div>
</div>
</div>

    <!--alert layer-->  
    <div id="choose-box-wrapper">  
     <div class="row">
 <div class="checkbox">
    <label id="checkbox">
    </label>
   
  </div>	
</div>
  <button type="button" class="btn btn-success" id="choose-end">确定</button>
    </div>  
    <!--alert layer--> 
    
        <!--alert layer2-->  
    <div id="choose-box-wrapper2">  
     <div class="row">
 <div class="checkbox">
    <label id="checkbox2">
    </label>
  </div>	
</div>
  <button type="button" class="btn btn-success" id="add-attend-end">确定</button>
    </div>  
    <!--alert layer2-->
    
            <!--alert layer3-->  
    <div id="choose-box-wrapper3">  
     <div class="row">
 <div class="checkbox">
    <label id="checkbox3">
    </label>
  </div>	
</div>
  <button type="button" class="btn btn-success" id="add-ma-end">确定</button>
    </div>  
    <!--alert layer2--> 
</body>
 <script type="text/javascript" src="/majiong/static/js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript" src="/majiong/static/js/bootstrap.js"></script>
 <script type="text/javascript" src="/majiong/static/js/layer.js"></script>
 <script type="text/javascript">

 $.ajax({  
     type : "POST",  //提交方式  
     url : "getUser",//路径  
     data : {  
        
     },//数据，这里使用的是Json格式进行传输  
     success : function(result) {//返回数据根据结果进行相应的处理  
    	 for(var i=0;i<result.length;i++) {
    		 //var user = "<li><a href=\"#\">"+result[i].name+"</a></li>"
    		 //   $('#users').append(user);
    		 //$('.users').append(user);
    		 $('#checkbox2').append("<input type=\"checkbox\" class=\"checkbox-name class-item-ck2\"value=\""+result[i].name+"\">"+result[i].name);
    		 $('#checkbox3').append("<input type=\"checkbox\" class=\"checkbox-name class-item-ck3\"value=\""+result[i].name+"\">"+result[i].name);
    		}
    	 $('.choose').find('li a').click(function(){
    		 $(this).parent().parent().prev().text($(this).text());
    	 });
     }  
 }); 
 $('#add-attend').click(function(){
	 pop2();
 });
 $('#add-attend-end').click(function(){
	 doSelect2();
 });
 $('#add-ma').click(function(){
	pop3();
 });
 $('#add-ma-end').click(function(){
	 doSelect3();
 });

 $('#action').click(function(){
	 $(this).hide();
	 $('.result').removeClass('hide');
	 var attendPeoples =[];
	 $('.taishang-user').each(function(){
		 var attend = $(this).val();
		 attendPeoples.push(attend);
	 });
	 
	 var maPeoples = [];
	 $('.maima-user').each(function(){
		 if(!$(this).hasClass('hide')){
			 var attend = $(this).val();
			 maPeoples.push(attend);	 
		 }
	 });
	 var saveData = {"attendPeoples":attendPeoples.toString(),"buyHorsePeoples":maPeoples.toString(),"gameId":$("#gameId").val()};
	 $.ajax({  
	     type : "POST",  //提交方式  
	     url : "addRound",//路径  
	     dataType:"json",      
         //contentType:"application/json",               
         //data:JSON.stringify(attendPeoples),
         data:saveData,
	     success : function(result) {//返回数据根据结果进行相应的处理  
	    	 alert(result.mes);
	    	 $('#roundId').val(result.mes);
	    	 for(var i = 0;i<attendPeoples.length;i++){
	    		 $('#checkbox').append("<input type=\"checkbox\" class=\"checkbox-name class-item-ck\"value=\""+attendPeoples[i]+"\">"+attendPeoples[i]);	 
	    	 }
	    	 $('.result-users').empty();
	    	 for(var i=0;i<attendPeoples.length;i++) {
	    		 var user = "<li><a href=\"#\">"+attendPeoples[i]+"</a></li>"
	    		    $('.result-users').append(user);
	    		}
	    	 for(var i = 0;i<maPeoples.length;i++){
	    		 $('.ma-row').append("<div class=\"row\"><input type=\"text\" class=\"form-control ma-text\" readonly=\"readonly\" value=\""+maPeoples[i]+"\">"+
	    		 "<div class=\"btn-group ma-select\"><button type=\"button\" class=\"btn btn-default dropdown-toggle ma-total\" data-toggle=\"dropdown\">4"+
	    			        "<span class=\"caret\"></span></button>"+
	    			    "<ul class=\"dropdown-menu\" role=\"menu\">"+
	    			    "<li><a href=\"#\">3</a></li><li><a href=\"#\">2</a></li><li><a href=\"#\">1</a></li><li><a href=\"#\">0</a></li></ul></div>"+"中"+
	    			    "<div class=\"btn-group ma-select\"><button type=\"button\" class=\"btn btn-default dropdown-toggle ma-success\" data-toggle=\"dropdown\">4"+
    			        "<span class=\"caret\"></span></button>"+
    			    "<ul class=\"dropdown-menu\" role=\"menu\">"+
    			    "<li><a href=\"#\">3</a></li><li><a href=\"#\">2</a></li><li><a href=\"#\">1</a></li><li><a href=\"#\">0</a></li></ul></div></div>");	 
	    	 }
	    	 $('.ma-select').find('li a').click(function(){
	    		 $(this).parent().parent().prev().text($(this).text());
	    	 });
	    	 $('.hu').find('li a').click(function(){
	    		 $('#hu').val($(this).text());
	    		 //$(this).parent().parent().parent().append("<input type="text" style="display:inline-block" class="form-control hide" readonly="readonly">")
	    	 });
	    	 $('.ming').find('li a').click(function(){
	    		$(this).parent().parent().parent().append("<input type=\"text\" class=\"form-control ming-gang\" readonly=\"readonly\" value=\""+$(this).text()+"\">");
	    	 });
	    	 $('.an').find('li a').click(function(){
	    		 $(this).parent().parent().parent().append("<input type=\"text\" class=\"form-control an-gang\" readonly=\"readonly\" value=\""+$(this).text()+"\">");
	    	 });
	    	 $('.fang').find('li a').click(function(){
	    		 $(this).parent().parent().parent().append("<input type=\"text\" class=\"form-control fang-gang\" readonly=\"readonly\" value=\""+$(this).text()+"\">");
	    		 pop();
	    		 
	    		 //$(this).parent().parent().parent().append("<input type=\"text\" class=\"form-control\" readonly=\"readonly\" value=\""+$(this).text()+"\">");
	    	 });
	    	 
	    	 $('#choose-end').click(function(){
	    		 doSelect();
	    	 });
	     }
	 });
	 $('#clean').click(function(){
		 $('#hu').val("");
		 $('.ming-gang').remove();
		 $('.an-gang').remove();
		 $('.fang-gang').remove();
	 });
	 $('#end').click(function(){
		 var hu = $('#hu').val();
		 var ming = [];
		 var an=[];
		 var fang = [];
		 var ma = [];
		 var maTotal = [];
		 var maSuccess = [];
		 $('.ming-gang').each(function(){
			 var s = $(this).val();
			 ming.push(s);
		 });
		 $('.an-gang').each(function(){
			 var s = $(this).val();
			 an.push(s);
		 });
		 $('.fang-gang').each(function(){
			 var s = $(this).val();
			 fang.push(s);
		 });
		 $('.ma-text').each(function(){
			 var s = $(this).val();
			 ma.push(s);
		 });
		 $('.ma-total').each(function(){
			 var s = $(this).text();
			 maTotal.push(s);
		 });
		 $('.ma-success').each(function(){
			 var s = $(this).text();
			 maSuccess.push(s);
		 });
		 var roundId = $("#roundId").val();
		 var saveData = {"hu":hu.toString(),"ming":ming.toString(),"an":an.toString(),"fang":fang.toString(),"roundId":roundId,"maName":ma.toString(),"maTotal":maTotal.toString(),"maSuccess":maSuccess.toString()};
		 $.ajax({  
		     type : "POST",  //提交方式  
		     url : "endRound",//路径  
		     dataType:"json",      
	         //contentType:"application/json",               
	         //data:JSON.stringify(attendPeoples),
	         data:saveData,
		     success : function(result) {//返回数据根据结果进行相应的处理
		    	 window.open("getRound?roundId="+$('#roundId').val(),"_self");
		     }
		 });
		 
	 });
 });

 
 
 </script>
</html>
