
/**
 * 推广--活动相关js
 * 
 */
var basepath = document.getElementById('basepath').getAttribute('data');
var activityidinfo;

//活动id
var activityid;
$(function() {
	//修改限额
	$(".updateQuota_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "600",
		height: "200",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
				
				//修改
				var param = {};
				param.id = activityid;
				param.everydayquota = $("#js-activity-everyday-uota").val();
				updateActivity(param);
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	
	//修改出价
	$(".updateBid_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "600",
		height: "200",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
				updateAdvertiserMentInfoPriceBidSub();
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	
	//修改期限对话框
	$(".updateDeadline_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "500",
		height: "300",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
				//修改
				var param = {};
				param.id = activityid;
				param.starttime = $("#js-activity-startTime").val();
				
				if ($("#js-activity-ischecked").is(":checked")) {
					param.popularizetimetype = 0;
				} else {
					param.popularizetimetype = 1;
					param.endtime = $("#js-activity-endTime").val();
				}
				updateActivity(param);
				
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	
	//修改期限对话框打开
	$(".J_updateDeadline").click(function(){
		$(".updateDeadline_Dialog").dialog("open");
	});
	
	//勾选无限期
	$(".J_deadline").click(function(){
		if($(this).is(":checked")){
			$(".J_endTime").hide();
		}else{
			$(".J_endTime").show();
		}
	});

	//find
	findActivityPage(1);
});

/**
 * 切换到活动
 */
function toActivity() {
	$("#js-activity-info").show();
	$("#js-advertiserMent-info").hide(); 
	$("#js-creativeInfoByAdvertiserMent-info").hide(); 
	$("#js-advertiserMentByActivity-info").hide(); 
	findActivityPage();
}

/**
 * 切换到广告
 */
function toAdvertiserMent() {
	$("#js-advertiserMent-info").show(); 
	$("#js-activity-info").hide();
	$("#js-creativeInfoByAdvertiserMent-info").hide(); 
	$("#js-advertiserMentByActivity-info").hide(); 
	findAdvertiserMentPage();
}

/**
 * 查看活动详情
 * 
 */
function findActivityInfo(id) {
	var activityInfo;
	$.ajax({
		type : "POST",
		url : basepath + "/admin/popularizeActivity/findActvityInfo?id=" + id,
		async : false,
		dataType : "JSON",
		success : function(data) {
			activityInfo = data;
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
	return activityInfo;
}

/**
 * 修改限额
 * 
 */
function updateActivityQuota(id) {
	activityid = id;
	//修改限额对话框打开
	$(".updateQuota_Dialog").dialog("open");
	var activityInfo = findActivityInfo(id);

	$("#js-activity-everyday-uota").val(activityInfo.everydayquota);
}

/**
 * 批量修改活动状态
 */
function updateActivityStates(state) {
	var checkedValue = $.util.getCheckedBox("js-activity-list-checkbox");
	for (var i = 0; i < checkedValue.length; i ++) {
		var checkedid = checkedValue[i];
		var param = {};
		param.id = checkedid;
		param.state = state;
		updateActivity(param, false);
	}
}

/**
 * 修改期限
 * 
 */
function updateActivityDeadline(id) {
	activityid = id;
	
	//修改期限对话框打开
	$(".updateDeadline_Dialog").dialog("open");
	var activityInfo = findActivityInfo(id);

	$("#js-activity-startTime").val(activityInfo.starttimeformat);
	if (activityInfo.popularizetimetype == 0) {
		$("#js-activity-ischecked").attr("checked", true);
		$(".J_endTime").hide();
	} else {
		$("#js-activity-ischecked").attr("checked", false);
	}
	
	$("#js-activity-endTime").val(activityInfo.endtimeformat);
}

/**
 * 修改活动信息
 * 
 */
function updateActivity(param, isrefresh) {
	$.ajax({
		type : "POST",
		url : basepath + "/admin/popularizeActivity/updateActvity",
		data : param,
		dataType : "JSON",
		success : function(map) {
			if (!isrefresh) {
				findActivityPage();
			}
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

//分页
function pg_targetPage_js(num) {
	$("#pg_targetPage").val(num);
	findActivityPage(num);
}

/**
 * 查询推广活动
 * 
 */
function findActivityPage(num) {
	var form_data = $("#di_find_form").serialize();
	$.ajax({
		type : "POST",
		url : basepath + "/admin/popularizeActivity/findPopularizeActivityListAndPage",
		data : form_data,
		dataType : "JSON",
		success : function(map) {
			var data = map.data;
			var queryPageStr = map.queryPageStr;
			$("#di_tbody").html(data);
			$("#di_queryPage").html(queryPageStr);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

