
var userid;
var uploadFilePath;

$(function(){
	//初始化地址
	_init_area();
	
	$("#register").click(function(){
		register();
	});
});

/**
 * 生成图片
 */
function createimg() {
	$("#js-image").attr("src", basepath + "/common/createimg?t=" + Math.random() + "&state=1");
}

/**
 * 注册
 */
function register() {
	if(!$("#js-isconsent").attr("checked")) {
		alert("必须同意服务协议");
	}
	
	var yzm = $("#js-yzm").val();
	
	var param = {};
	var userbasic = $("#userbasic").serializeArray();
	param.userbasic = userbasic;
	
	var advertiser = $("#advertiser").serializeArray();
	param.advertiser = advertiser;

	param.yzm = yzm;
	var jsonstr = JSON.stringify(param);
	
	param = {};
	param.data = jsonstr;
	
	$.ajax({
		type: "POST",
		url: basepath + "/official/user/register",
		data: param,
		dataType: "json",
		success: function(data){
			if (data) {
				if (data.returned == 100) {
					alert("用户名重复，请重新输入！");
				} else if (data.returned == 10){
					alert("验证码错误");
				}
				else {
					$(".js-username").val("");
					$(".js-pwd").val("");
					$(".js-newpwd").val("");
				}
			}
		}
	});
}
