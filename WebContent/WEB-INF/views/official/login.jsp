<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>用户登录</title>
		
		<link rel="stylesheet" type="text/css" href="${base}/res/css/official/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${base}/res/css/official/index.css"/>
	</head>
	<body>
		<%@ include file='./header.jsp'%>
        <div class="BackBox clear" style="background:#fff;border:none;padding: 150px 0 200px 0;">
        	<div class="BackCon">
            	<h2>帐号登录</h2>
                <div>
                    <p class="BackTxt BackBorder"><span class="BackTitCon">用户名<i>*</i></span><input id = "js-username" name="text" type="text" placeholder="请输入注册邮箱" /><span class="BackTi"></span></p>
                    <p class="BackTxt"><span class="BackTitCon">密码<i>*</i></span><input id="js-pwd" name="text" type="password" placeholder="请输入6-20位密码" /><span class="BackTi"></span></p>
	                <p class="BackTxt" style="text-align:center; width:570px;"><input id="js-login" name="" type="button" value="立即登录" /></p>
					<%-- <img id="js-image" onclick="createimg()" src="${base}/function/common/img/createimg" width="116" height="39" /> --%>
	            </div><!--BackCon-->
	        </div><!--Account-->
	    </div><!--warp_area-->
		<%@ include file='./footer.jsp'%>
	</body>
</html>
<script>
function checkXieYi(o){
	if($('input[name="checkbox"]').is(':checked')){
		$('input[name="checkbox"]').prop('checked', false);
	} else {
		$('input[name="checkbox"]').prop('checked', true);
	}
}
</script>
<script src="${base}/res/js/common/jquery-1.8.3.min.js" type="text/javascript"></script>
<script data="${base}" id="basepath" src="${base}/res/js/official/login.js" type="text/javascript"></script>