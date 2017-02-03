//弹出窗口  
    function pop(){  
        //将窗口居中  
        makeCenter();  
    }  
  //弹出窗口  
    function pop2(){  
        //将窗口居中  
        makeCenter2();  
    }  
    //弹出窗口  
    function pop3(){  
        //将窗口居中  
        makeCenter3();  
    } 
  
    //隐藏窗口  
    function hide() {  
        $('#choose-box-wrapper').css("display", "none");  
    }  
    
    //隐藏窗口  
    function hide2() {  
        $('#choose-box-wrapper2').css("display", "none");  
    }  
  //隐藏窗口  
    function hide3() {  
        $('#choose-box-wrapper3').css("display", "none");  
    }  
    //获取选择值  
    function doSelect() {  
        var list = $(".class-item-ck");  
        var text = "";  
        var value = "";  
        var s = $('.fang-gang:last').val()+"->";
        list.each(function () {  
            if ($(this).is(':checked')) {  
                value =value+$(this).attr("value")+" ";  
            };  
        });  
        $('.fang-gang:last').val(s+value);
        //关闭弹窗  
        hide();  
    };  
    //获取选择值  
    function doSelect2() {  
        var list = $(".class-item-ck2");  
        var text = "";  
        var value = ""; 
        $('.taishang').empty();
        list.each(function () {  
            if ($(this).is(':checked')) {  
                value =$(this).attr("value"); 
                	$('.taishang').append("<input type=\"text\" class=\"form-control taishang-user\" readonly=\"readonly\" value="+value+">");	
             
                
            };  
        });  
        //关闭弹窗  
        hide2();  
    }; 
    //获取选择值  
    function doSelect3() {  
        var list = $(".class-item-ck3");  
        var text = "";  
        var value = ""; 
        $('.maima').empty();
        list.each(function () {  
            if ($(this).is(':checked')) {  
                value =$(this).attr("value"); 
                	$('.maima').append("<input type=\"text\" class=\"form-control maima-user\" readonly=\"readonly\" value="+value+">");	
             
                
            };  
        });  
        //关闭弹窗  
        hide3();  
    }; 
  
    function makeCenter()  
    {  
        $('#choose-box-wrapper').css("display","block");  
        $('#choose-box-wrapper').css("position","absolute");  
        $('#choose-box-wrapper').css("top", Math.max(0, (($(window).height() - $('#choose-box-wrapper').outerHeight()) / 2) + $(window).scrollTop()) + "px");  
        $('#choose-box-wrapper').css("left", Math.max(0, (($(window).width() - $('#choose-box-wrapper').outerWidth()) / 2) + $(window).scrollLeft()) + "px");  
    }  
    function makeCenter2()  
    {  
        $('#choose-box-wrapper2').css("display","block");  
        $('#choose-box-wrapper2').css("position","absolute");  
        $('#choose-box-wrapper2').css("top", Math.max(0, (($(window).height() - $('#choose-box-wrapper2').outerHeight()) / 2) + $(window).scrollTop()) + "px");  
        $('#choose-box-wrapper2').css("left", Math.max(0, (($(window).width() - $('#choose-box-wrapper2').outerWidth()) / 2) + $(window).scrollLeft()) + "px");  
    } 
    function makeCenter3()  
    {  
        $('#choose-box-wrapper3').css("display","block");  
        $('#choose-box-wrapper3').css("position","absolute");  
        $('#choose-box-wrapper3').css("top", Math.max(0, (($(window).height() - $('#choose-box-wrapper3').outerHeight()) / 2) + $(window).scrollTop()) + "px");  
        $('#choose-box-wrapper3').css("left", Math.max(0, (($(window).width() - $('#choose-box-wrapper3').outerWidth()) / 2) + $(window).scrollLeft()) + "px");  
    } 
