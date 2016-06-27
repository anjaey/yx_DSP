/**
 * 用户登录 
 */

var basepath = document.getElementById('basepath').getAttribute('data');
$(function(){
	//新增对话框、权限对话框
	$(".updatePwd_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "400",
		height: "200",
		modal: true,
		show: "scale",
		buttons: {
			"立即跳转": function() {
				$(this).dialog("close");
				location.href = basepath + "/admin/adx/login";
			}
		},
	});
	$(".J_updatePwd").click(function(){
		findUserinfo();
	});
});

var countdownIndex = 5;
var setIntervalid;
function countdown() {
	countdownIndex--;
	$(".js-countdown").text(countdownIndex);
	if (countdownIndex == 0) {
		clearInterval(setIntervalid);
		$(this).dialog("close");
		location.href = basepath + "/admin/adx/login";
	}		
}

/**
 * 修改密码
 */
function findUserinfo() {
	var param = {};
	param.newpwd = $(".newpassword").val();
	param.oldpwd = $(".password").val();
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/updateUserPwd",
		data: param,
		dataType: "json",
		success: function(data){
			if (data.state == 0) {
				alert("原密码错误");
			} else {
				$(".updatePwd_Dialog").dialog("open");
				setIntervalid = setInterval("countdown()", 1000);
			}
		}
	});
}
