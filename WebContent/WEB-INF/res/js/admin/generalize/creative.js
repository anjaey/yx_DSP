/**
 * 推广--创意相关js
 * 
 */
//缓存广告id
var advertisermentidinfo;

$(function() {
	//新增创意对话框
	$(".addOriginality_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "700",
		height: "350",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
				addCreativeInfoSub();
				alert("添加成功");
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	
	//打开创意
	$(".lookOriginality_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "500",
		height: "350",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	
	//新增创意对话框打开
	$(".J_addOriginality").click(function(){				
		$(".addOriginality_Dialog").dialog("open");
	});

	//字典数据
	findDictInfoToCollimation();
});

/**
 * 打开新增创意
 * 
 */
function addCreativeInfo() {
	//查看创意对话框打开		
	$(".addOriginality_Dialog").dialog("open");
}

/**
 * 
 * 打开创意图片
 * 
 * 暂时只支持图片格式
 */
function viewCreativeImg(path) {
	$(".lookOriginality_Dialog").dialog("open");
	$("#js-creative-img").attr("str", path);
}

/**
 * 从创意中切换到广告
 */
function toAdvertiserMent1() {
	//关闭活动
	$("#js-activity-info").hide();
	
	//关闭创意
	$("#js-creativeInfoByAdvertiserMent-info").hide();
	
	//显示广告
	$("#js-advertiserMentByActivity-info").show();
}

/**
 * 
 * 查询创意信息
 * 
 */
function findAdvertisertPage(advertisermentid) {
	advertisermentidinfo = advertisermentid;
	
	//关闭活动
	$("#js-activity-info").hide();
	
	//显示创意
	$("#js-creativeInfoByAdvertiserMent-info").show();
	
	//关闭广告
	$("#js-advertiserMentByActivity-info").hide();
	
	var form_data = $("#di_find_form1").serialize();
	
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/findAdvertiserListAndPage?advertisementid=" + advertisermentid,
		data : form_data,
		dataType : "JSON",
		success : function(map) {
			var data = map.data;
			var queryPageStr = map.queryPageStr;
			$("#di_tbody3").html(data);
			$("#di_queryPage3").html(queryPageStr);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 提交创意信息
 */
function addCreativeInfoSub() {
	//创意
	var param = {};
	param.creativetype = $("#js-creativetype").val();
	param.advertisermodality = $("#js-advertisermodality").val();
	param.size = $("#js-size").val();
	param.advertisementid = advertisermentidinfo;
	
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/addCreative",
		data : param,
		dataType : "JSON",
		success : function(map) {
			findAdvertisertPage(advertisermentidinfo);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 修改创意信息
 */
function updateCreative(param) {
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/updateCreative",
		data : param,
		dataType : "JSON",
		success : function(map) {
			findAdvertisertPage(advertisermentidinfo);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 批量修改创意状态
 */
function updateCreativeStates(state) {
	var checkedValue = $.util.getCheckedBox("js-creative-id");
	for (var i = 0; i < checkedValue.length; i ++) {
		var checkedid = checkedValue[i];
		var param = {};
		param.id = checkedid;
		param.state = state;
		updateCreative(param);
	}
}

/**
 * 批量删除创意信息
 * 
 */
function deleteCreativeByid() {
	var checkedValue = $.util.getCheckedBox("js-creative-id");
	var arrayjsonid = [];
	for (var i = 0; i < checkedValue.length; i ++) {
		var param = {};
		param.id = checkedValue[i];
		arrayjsonid[i] = param;
	}
	arrayjsonid = JSON.stringify(arrayjsonid);
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/deleteCreativeByid?Arrayjsonid=" + arrayjsonid,
		data : arrayjsonid,
		dataType : "JSON",
		success : function(map) {
			findAdvertisertPage(advertisermentidinfo);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}
