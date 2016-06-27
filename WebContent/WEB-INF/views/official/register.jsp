<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<title>新用户注册</title>
				<link rel="stylesheet" type="text/css"
					href="${base}/res/css/official/reset.css" />
				<link rel="stylesheet" type="text/css"
					href="${base}/res/css/official/index.css" />
</head>
<body>
	<%@ include file='./header.jsp'%>
	<div class="MainCon" style="padding: 50px 0 0 0;">
		<div class="warp_area">
			<div class="BackBox clear" style="background: #fff; border: none;">
				<div class="BackCon">
					<form id="userbasic" action="">
						<h2>帐号注册</h2>
						<div>
							<p class="BackTxt BackBorder">
								<span class="BackTitCon">注册邮箱<i>*</i></span><input name="email"
									type="text" placeholder="请输入注册邮箱" /><span class="BackTi">“请输入帐号信息"或“该邮箱已被注册”</span>
							</p>
							<p class="BackTxt">
								<span class="BackTitCon">密码<i>*</i></span><input name="pwd"
									type="password" placeholder="请输入6-20位密码" /><span
									class="BackTi">请输入6-20位的数字与字母的组合</span>
							</p>
							<p class="BackTxt">
								<span class="BackTitCon">确认密码<i>*</i></span><input name="pwd1"
									type="password" placeholder="请再次输入密码" /><span class="BackTi">请输入6-20位的数字与字母的组合</span>
							</p>
					</form>

					<form id="advertiser" action="">
						<p class="BackTxt">
							<span class="BackTitCon">用户类型<i>*</i></span><select name="type"><option
									value="1">个人</option>
								<option value="2">企业</option></select>
						</p>
						<p class="BackTxt">
							<span class="BackTitCon">企业名称<i>*</i></span><input name="company"
								type="password" placeholder="请输入企业名称" />
						</p>
						<p class="BackTxt">
							<span class="BackTitCon">联系人<i>*</i></span><input name="contact"
								type="password" placeholder="请输入联系人" />
						</p>
						<p class="BackTxt">
							<span class="BackTitCon">联系方式<i>*</i></span><input name="mobile"
								type="password" placeholder="请输入联系方式" />
						</p>
						<p class="BackTxt">
							<span class="BackTitCon">验证码<i>*</i></span><input class="YanTxt"
								id="js-yzm" type="text" placeholder="验证码" /><span
								class="YanMa"><img id="js-image" onclick="createimg()" src="${base}/function/common/img/createimg" width="80" height="37" /></span><span class="BackTi">验证码错误</span>
						</p>
					</form>
				</div>
				<p class="BackTxt" style="text-align: center; width: 570px;">
					<input name="checkbox" id="js-isconsent" type="checkbox" value="" />&nbsp;&nbsp;<a
						href="javascript:void(0)" onclick="checkXieYi(this)">我已阅读并同意</a><a
						href="#">《优效用户协议》</a>
				</p>
				<p class="BackTxt" style="text-align: center; width: 570px;">
					<input name="" type="button" onclick="register()" value="立即注册" />
				</p>
				<p class="BackTxt BackLogin"
					style="text-align: center; width: 570px;">
					已有帐号，<a href="${base}/official/login">登录</a>
				</p>
			</div>
			<!--BackCon-->
		</div>
		<!--Account-->
	</div>
	<!--warp_area-->
	</div>
	<%@ include file='./footer.jsp'%>
</body>
</html>
<script src="${base}/res/js/common/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script src="${base}/res/js/common/address/area.js"
	type="text/javascript"></script>
<script src="${base}/res/js/official/register.js" type="text/javascript"></script>
<script src="${base}/res/js/common/basepath.js" id="basepath"
	data="${base}" type="text/javascript"></script>
