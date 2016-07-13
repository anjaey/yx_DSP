
var basepath = document.getElementById('basepath').getAttribute('data');
$(function(){
	$("head").prepend("<link rel='icon' href='" + basepath + "/res/images/admin/adx/logotop.ico' type='image/x-ico' />" +
			"</link>");
	
	$("#js-userquit").click(function(){
		quitUserLogin();
	});
	
	
	
	findUserPwdisUnalterable();
});

/**
 * 退出登录
 */
function quitUserLogin() {
	$.ajax({
		type: "GET",
		url: basepath + "/admin/adx/quitLogin",
		dataType: "json",
		success: function(data){
			window.location.href = basepath + "/admin/adx/login";
		}
	});
}

/**
 * 轮训查看用户的状态。
 */
function findUserPwdisUnalterable() {
	setInterval(findUserState, 5000);
}

function findUserState() {
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/findUserInfoUnalterable",
		dataType: "json",
		success: function(data){
			if (data) {
				if (data.returned == 0) {  //用户异常
					alert("你的用户被管理员锁定或者更改了你的密码，请重新登录！");
					quitUserLogin();
					window.location.href = basepath + "/admin/adx/login";
				}
			}
		}
	});
}