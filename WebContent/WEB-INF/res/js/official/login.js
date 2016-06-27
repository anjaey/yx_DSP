/**
 * 用户登录 
 */
var basepath = document.getElementById('basepath').getAttribute('data');
$(function(){
	$("#js-login").click(function(){
		login();
	});
	loginReCaptchaShow();
});

function loginReCaptchaShow() {
	$.ajax({
		type: "GET",
		url: basepath + "/function/common/img/loginReCaptchaShow",
		dataType: "json",
		success: function(data){
			if (data) {
				data = data.postcountadx;
				if (data > 3) {
					$("#loginForm_pwd_checkingCode").show();
				}
			}
		}
	});
}
/**  
 * 登录
 */
function login() {
	var param = {};
	param.email = $("#js-username").val();
	param.pwd = $("#js-pwd").val();
	
	if (param.email == null || param.email == "" || param.email == undefined) {
		$("#js-username").parent().find("span[class='BackTi']").html("请输入帐号信息");
		return false;
	} else {
		$("#js-username").parent().find("span[class='BackTi']").html("");
	}
	
	var pwdreg = /^(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{4,23}$/;
	if (!pwdreg.test(param.pwd)) {
		$("#js-pwd").parent().find("span[class='BackTi']").html("请输入6-20位的数字与字母的组合");
		return false;
	} else {
		$("#js-pwd").parent().find("span[class='BackTi']").html("");
	}
	
//	param.yanzeng = $(".YanCon").val();
	param.state = 1;
	$.ajax({
		type: "POST",
		url: basepath + "/official/user/login",
		data: param,
		dataType: "json",
		success: function(data){
//			loginReCaptchaShow();
			if (data.state == 0 || data.state == 2) {
				alert("登录失败, 账号密码错误！");
			}

			if (data.state == 1) {
				location.href =  basepath + "/admin/toadminindex";
			}
			
			if (data.state == 10) {
				alert("验证码错误或失效，请重新输入！");
				createimg();
			}
		}
	});
}

/**
 * 生成图片
 */
function createimg() {
	$("#js-image").attr("src", basepath + "/common/createimg?t=" + Math.random() + "&state=1");
}
