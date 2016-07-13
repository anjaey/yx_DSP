var basepath = document.getElementById('basepath').getAttribute('data');
var userid;
var uploadFilePath;

$(function(){
	
});

/**
 * 注册
 */
function insertUser() {
	var username= $(".js-username").val();
	var pwd= $(".js-pwd").val();
	var newpwd= $(".js-newpwd").val();
	var compellation= $(".js-compellation2").val();
	
	var values = new Array();
	values.push(username);	
	values.push(pwd);
	values.push(newpwd);
	var expressions = new Array();
	expressions.push("");
	expressions.push("");
	expressions.push("");
	var showmsgs = new Array();
	showmsgs.push(".js-username");
	showmsgs.push(".js-pwd");
	showmsgs.push(".js-newpwd");
	
	if (pwd != newpwd) {
		alert("输入的密码不一致，请查看！");

		$(".addUser_Dialog").dialog("open");
		return;
	}
	
	
	var bool = expression(values, showmsgs , expressions);
	if (!bool) {
		$(".addUser_Dialog").dialog("open");
		return;
	}
	
	var param = {};
	param.username = username;
	param.pwd = pwd;
	param.newpwd = newpwd;
	param.compellation = compellation;
	
	var basepath = document.getElementById('basepath').getAttribute('data');
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/addUser",
		data: param,
		dataType: "json",
		success: function(data){
			if (data) {
				if (data.returned == 100) {
					alert("用户名重复，请重新输入！");
				} else {
					$(".js-username").val("");
					$(".js-pwd").val("");
					$(".js-newpwd").val("");
				}
			}
		}
	});
}
