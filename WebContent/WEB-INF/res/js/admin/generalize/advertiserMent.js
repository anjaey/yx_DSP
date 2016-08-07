/**
 * 推广--广告相关js
 * 
 */

//网络环境
var dd_011 = "dd_011";
//运营商
var dd_012 = "dd_012";
//设备类型
var dd_013 = "dd_013";
//爱好
var dd_005 = "dd_005";
//操作系统
var dd_010 = "dd_010";
//性别
var dd_014 = "dd_014";
//年龄
var dd_015 = "dd_015";

//广告id
var advertiserMentid;
//步奏切换
var thisStep=0;

var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
};

/**
 * 添加按钮点击添加
 */
function addAdvertiser() {
	//隐藏保存按钮
	$(".js-botton-sub").hide();
	toaddAdvertiser();
}

/**
 * 跳转到添加/修改页面
 */
function toaddAdvertiser() {
	$("#js-advertiser-find").hide();
	$("#js-advertiser-add").show();
	
	$("#js-advertiserMentByActivity-info").hide();
	
	//制空id
	advertiserMentid = null;  
	
	init();
	
	//字典数据
	findDictInfoToCollimation();
	
	//省市地址
	findAddress();
	
	//查询活动
	findActivityAllByUserId();
}

/**
 * 
 * 在新增广告中
 * 的下一步
 * 此方法用于设置在添加广告的页面右边显示添加的广告信息。
 * 
 */
function nextAdvertiserMentAdd() {
	var isshow = $("#js-addadvertiserMent-Info-div").is(":visible");
	if (isshow) {
		//设置
		var activity = {};
		var advertiserment = {};
		
		getAdvertiserMentBasicInfo_private(activity, advertiserment);

		setrightInfoHtml(activity, advertiserment);
	}
	
	//判断第三的一个步骤是否显示中(显示中表示添加 否则表示 修改)，并且是否是在修改的情况下，如果是 当前按钮隐藏下一步，以及显示保存按钮
	isshow = $("#js-next-4").is(":visible");

	if (!isshow) {  //在修改状态下
		if (thisStep == 1) {
			//隐藏下一步的按钮
			$("#js-next-button").hide();
		}
	}
	
	
}

/**
 * 设置新增/修改 广告时右边显示的内容
 */
function setrightInfoHtml(activity, advertiserment) {
	var iscreateActivity = $("input[name='tghd']:checked").attr("value");
	if (iscreateActivity == 0) {  //创建新的活动
		$(".js-activity-name-td").html(activity.name);
	} else {
		$(".js-activity-name-td").html(advertiserment.activitystr);
	}
	$(".js-activity-start-time-td").html(activity.starttime);
	$(".js-activity-end-time-td").html(activity.endtime);
	$(".js-activity-quota-td").html(activity.quota);
	$(".js-advertiser-ment-td").html(advertiserment.name);
	$(".js-advertiser-generalize-td").html(advertiserment.popularizetypestr);
	$(".js-advertiser-path-td").html(advertiserment.path);
	$(".js-advertiser-tag-td").html(advertiserment.tradetag);
}

function init() {
	//移除选项卡click
	$(".tab_menu").unbind("click");
	
	
	$(".stepChange input[type=button]").click(function(){
		if($(this).hasClass("lastBtn")){
			thisStep-=1;
			if(thisStep==0){
				$(this).hide();
			}
			$(".nextBtn").show();
			$(".submitBtn").hide();

			$(".stepCn .stepSingle").removeClass("stepSingle_focus");
			$(".stepCn .stepSingle").eq(thisStep).addClass("stepSingle_focus");

			$(".tab_contentWrapper .tab_content").hide();
			$(".tab_contentWrapper .tab_content").eq(thisStep).show();
		}else if($(this).hasClass("nextBtn")){
			thisStep+=1;
			
			if(thisStep>2){
				$(this).hide();
				$(".submitBtn").show();
			}
			$(".lastBtn").show();

			$(".stepCn .stepSingle").removeClass("stepSingle_focus");
			$(".stepCn .stepSingle").eq(thisStep).addClass("stepSingle_focus");

			$(".tab_contentWrapper .tab_content").hide();
			$(".tab_contentWrapper .tab_content").eq(thisStep).show();
		}
	});
}

/**
 * 
 * 查询所有的广告数据,并且必须根据活动id 
 * 以及其他条件
 * 
 */
function findAdvertiserMentPageAndActivity(activityid) {
	
	activityidinfo = activityid; //缓存id
	
	//关闭活动
	$("#js-activity-info").hide();
	
	//关闭创意
	$("#js-creativeInfoByAdvertiserMent-info").hide();
	
	//显示广告
	$("#js-advertiserMentByActivity-info").show();
	
	var form_data = $("#di_find_form2").serialize();
	form_data = form_data + "&activity=" + activityid;
	
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/findAdvertiserMentListAndPageByActivity",
		data : form_data,
		dataType : "JSON",
		success : function(map) {
			var data = map.data;
			var queryPageStr = map.queryPageStr;
			$("#di_tbody2").html(data);
			$("#di_queryPage2").html(queryPageStr);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}


/**
 * 
 * 查询所有的广告信息
 * 
 */
function findAdvertiserMentPage() {
	var form_data = $("#di_find_form1").serialize();
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/findAdvertiserMentListAndPage",
		data : form_data,
		dataType : "JSON",
		success : function(map) {
			var data = map.data;
			var queryPageStr = map.queryPageStr;
			$("#di_tbody1").html(data);
			$("#di_queryPage1").html(queryPageStr);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 修改广告信息
 */
function updateAdvertiserMent(param) {
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/updateAdvertiserMent",
		data : param,
		dataType : "JSON",
		success : function(map) {
			findAdvertiserMentPageAndActivity(activityidinfo);
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}


/**
 * 批量修改广告状态
 */
function updateAdvertiserMentStates(state) {
	var checkedValue = $.util.getCheckedBox("js-advertiserMent-id");
	for (var i = 0; i < checkedValue.length; i ++) {
		var checkedid = checkedValue[i];
		var param = {};
		var basic = {};
		basic.id = checkedid;
		basic.state = state;
		basic = JSON.stringify(basic);
		param.basic = basic;
		updateAdvertiserMent(param);
	}
}


/**
 * 查询省市 地址
 * 
 */
function findAddress() {
	$.ajax({
		type: "POST",
		async : false,
		url: basepath + "/admin/address/findAddressProvincesAndCreateTree",
		dataType: "json",
		success: function(data){
			$.fn.zTree.init($("#addressTree"), setting, data);
		}
	});
}

/**
 * url 类型参数到json
 * @param param
 * @returns {___anonymous1877_1878}
 */
function parseJson(param)
{
    var obj={};
    var keyvalue=[];
    var key="",value="";       
    var paraString = param.split("&");
    for(var i in paraString)
    {
        keyvalue=paraString[i].split("=");
        key=keyvalue[0];
        value=keyvalue[1];
        obj[key]=value;            
    }        
    return obj;
}

/**
 * 查询这个用户创建的所有正常的活动
 */
function findActivityAllByUserId() {
	$("select[name='js-activity-id'] option").remove();
	$.ajax({
		async : false,
		type : "POST",
		url : basepath + "/admin/popularizeActivity/findPopularizeActivityList",
		dataType : "JSON",
		success : function(data) {
			for (var i = 0; i < data.length; i ++) {
				$("select[name='js-activity-id']").append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
			}
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 得到广告基本信息
 * 
 */
function getAdvertiserMentBasicInfo_private(activityInfo, advertiserMentBasic) {
	advertiserMentBasic.name = $("input[name='js-advertiserMent-name']").val();
	advertiserMentBasic.popularizetype = $("input[name='js-advertiseMent-popularize-type']").val();
	advertiserMentBasic.popularizetypestr = $("select[name='js-advertiseMent-popularize-type'] option:selected").text();
	advertiserMentBasic.path = $("input[name='js-advertiseMent-path']").val();
	advertiserMentBasic.PVMonitoringAddress = $("input[name='js-advertiseMent-PV-monitoring-address']").val();
	advertiserMentBasic.tradetag = $("input[name='js-advertiseMent-trade-tag1']").val() + "-" + $("input[name='js-advertiseMent-trade-tag2']").val();
	
	//活动
	var iscreateActivity = $("input[name='tghd']:checked").attr("value");
	if (iscreateActivity == 0) {  //创建新的活动
		//活动
		activityInfo.name = $("input[name='js-activity-name']").val();
		activityInfo.everydayquota = $("input[name='js-activity-everydayQuota']").val();
		//时间类型
		if (!$("#js-activity-type").is(":checked")) {
			activityInfo.endtime = $("input[name='js-activity-endTime']").val();
		}
		activityInfo.starttime = $("input[name='js-activity-startTime']").val();
	} else {
		//选中的活动
		advertiserMentBasic.activityid = $("select[name='js-activity-id']").val(); 
		advertiserMentBasic.activitystr = $("select[name='js-activity-id'] option:selected").text(); 
	}
}


/**
 * 
 * 得到广告信息
 * 
 */
function getAdvertiserMentInfo() {
	var param = {};
	
	//广告基本信息
	var advertiserMentBasic = {};
	
	//活动基本信息
	var activityInfo = {};
	
	//得到设置的数据
	getAdvertiserMentBasicInfo_private(activityInfo, advertiserMentBasic);
	
	//设置广告基本信息的id
	if (advertiserMentid && advertiserMentid != "" && advertiserMentid != null) {
		advertiserMentBasic.id = advertiserMentid;
	}
	
	//广告瞄准信息
	var advertiserMentCollimation = {};
	advertiserMentCollimation.starttime = $("input[name='js-advertisement-start-time']").val();
	advertiserMentCollimation.endtime = $("input[name='js-advertisement-end-time']").val();
	
	//操作系统
	var dd_010_son = $("input[class='" + dd_010 + "']:checked");
	var operatingSystem = private_createDictJson(dd_010_son);
	advertiserMentCollimation.operatingsystemvaluejson = operatingSystem;
	
	//网络环境
	var dd_011_son = $("input[class='" + dd_011 + "']:checked");
	var networkenvironment = private_createDictJson(dd_011_son);
	advertiserMentCollimation.networkenvironmentvaluejson = networkenvironment;
	
	//运营商
	var dd_012_son = $("input[class='" + dd_012 + "']:checked");
	var operator = private_createDictJson(dd_012_son);
	advertiserMentCollimation.operatorvaluejson = operator;
	
	//设备类型
	var dd_013_son = $("input[class='" + dd_013 + "']:checked");
	var devicetype = private_createDictJson(dd_013_son);
	advertiserMentCollimation.devicetypevaluejson = devicetype;
	
	//性别
	var dd_014_son = $("input[class='" + dd_014 + "']:checked");
	var sex = private_createDictJson(dd_014_son);
	advertiserMentCollimation.sexvaluejson = sex;
	
	//年龄
	var dd_015_son = $("input[class='" + dd_015 + "']:checked");
	var age = private_createDictJson(dd_015_son);
	advertiserMentCollimation.agevaluejson = age;
	
	//爱好
	var dd_005_son = $("input[class='" + dd_005 + "']:checked");
	var interest = private_createDictJson(dd_005_son);
	advertiserMentCollimation.interestvaluejson = interest;
	
	//目标区域
	var addressTree = $.fn.zTree.getZTreeObj("addressTree").getCheckedNodes(true); 
	var addressTrees = new Array();
	for (var i = 0; i < addressTree.length; i ++) {
		var addressjson = {};
		var addressname = addressTree[i].name;
		addressjson.address = addressname;
		addressTrees.push(addressjson);
	}
	advertiserMentCollimation.areavaluejson = addressTrees;
	
	
	//广告定价信息
	var advertisementpricing = $("#js-advertisement-pricing-from").serialize();
	advertisementpricing = parseJson(advertisementpricing);
	param.basic = JSON.stringify(advertiserMentBasic);
	param.pricing = JSON.stringify(advertisementpricing);
	param.collimation = JSON.stringify(advertiserMentCollimation);
	param.activityInfo = JSON.stringify(activityInfo);
	
	//创意
	var creative = $("#js-creative-from").serialize();
	creative = parseJson(creative);
	param.creative = JSON.stringify(creative);

	return param;
}

/**
 * 提交修改广告信息
 * 
 */
function submitAdvertiserMentUpdate() {
	var param = getAdvertiserMentInfo();
	updateAdvertiserMent(param);
}

/**
 * 
 * 提交添加广告信息
 * 
 */
function submitAdvertiserMent() {
	var param = getAdvertiserMentInfo();
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/addAdvertiserMent",
		dataType : "JSON",
		data:param,
		success : function(data) {
			alert("提交成功！");
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
	
}

/**
 * 生成list字典json
 */
function private_createDictJson(data) {
	var dicts = new Array();
	for (var i = 0; i < data.length; i ++) {
		var dict = {};
		var key = data[i].value;
		dict.key = key;
		dicts.push(dict);
	}
	return dicts;
}

/**
 * 查询字典
 * 
 * @param key
 * @param value
 * @param parentkey
 */
function private_append_dict(key, value, parentkey) {
	$("#" + parentkey + " tr").append('<td><input type="checkbox" value="' + key + '" class="' + parentkey + '" />' + 
	'<label for="czxt1">' + value + '</label></td>');
}

/**
 * 查询瞄准字典信息
 */
function findDictInfoToCollimation() {
	$.ajax({
		type : "POST",
		async : false,
		url : basepath + "/admin/generalizeManager/findDictInfoToCollimation",
		dataType : "JSON",
		success : function(data) {
			var dd_005_data = data.dd_005;
			for (var i = 0; i < dd_005_data.length; i ++) {
				private_append_dict(dd_005_data[i].keyid, dd_005_data[i].value, dd_005);
			}
			
			var dd_010_data = data.dd_010;
			for (var i = 0; i < dd_010_data.length; i ++) {
				private_append_dict(dd_010_data[i].keyid, dd_010_data[i].value, dd_010);
			}
			var dd_011_data = data.dd_011;
			for (var i = 0; i < dd_011_data.length; i ++) {
				private_append_dict(dd_011_data[i].keyid, dd_011_data[i].value, dd_011);
			}
			
			var dd_012_data = data.dd_012;
			for (var i = 0; i < dd_012_data.length; i ++) {
				private_append_dict(dd_012_data[i].keyid, dd_012_data[i].value, dd_012);
			}
			
			var dd_013_data = data.dd_013;
			for (var i = 0; i < dd_013_data.length; i ++) {
				private_append_dict(dd_013_data[i].keyid, dd_013_data[i].value, dd_013);
			}
			
			var dd_014_data = data.dd_014;
			for (var i = 0; i < dd_014_data.length; i ++) {
				private_append_dict(dd_014_data[i].keyid, dd_014_data[i].value, dd_014);
			}
			
			var dd_015_data = data.dd_015;
			for (var i = 0; i < dd_015_data.length; i ++) {
				$("." + dd_015).append("<option value='" + dd_015_data[i].value + "'>" + dd_015_data[i].value + "</option>");
			}

			var dd_016_data = data.dd_016;
			for (var i = 0; i < dd_016_data.length; i ++) {
				$("select[name='js-advertiseMent-popularize-type']").append("<option value='" + dd_016_data[i].keyid + "'>" + dd_016_data[i].value + "</option>");
			}
			
			var dd_017_data = data.dd_017;
			for (var i = 0; i < dd_017_data.length; i ++) {
				$("select[name='creativetype']").append("<option value='" + dd_017_data[i].keyid + "'>" + dd_017_data[i].value + "</option>");
			}
			var dd_018_data = data.dd_018;
			for (var i = 0; i < dd_018_data.length; i ++) {
				$("select[name='advertisermodality']").append("<option value='" + dd_018_data[i].keyid + "'>" + dd_018_data[i].value + "</option>");
			}
			var dd_019_data = data.dd_019;
			for (var i = 0; i < dd_019_data.length; i ++) {
				$("select[name='size']").append("<option value='" + dd_019_data[i].keyid + "'>" + dd_019_data[i].value + "</option>");
			}
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
}

/**
 * 修改广告信息 出价。
 */
function updateAdvertiserMentPriceBid(id) {
	advertiserMentid = id;
	
	//修改修改最高出价对话框打开
	$(".updateBid_Dialog").dialog("open");
	var advertiserMentinfo = findAdvertiserMentById(id);

	$("input[name='js-advertiserMent-check-best-bid-price']").val(advertiserMentinfo.pricing.checkbestbidprice);
	
}

/**
 * 提交修改广告最高出价信息
 */
function updateAdvertiserMentInfoPriceBidSub() { 
	var param = {};
	var pricing = {};
	pricing.basicid = advertiserMentid;
	pricing.checkbestbidprice = $("input[name='js-advertiserMent-check-best-bid-price']").val();
	
	param.pricing = JSON.stringify(pricing);
	updateAdvertiserMent(param);
}

/**
 * 勾选广告的瞄准信息
 * 信息来自字典信息
 */
function checkedCollimationPrivate(checkboxClasName, boxvalue) {
	var checkebox = $("." + checkboxClasName);
	for (var i = 0; i < checkebox.length; i ++) {
		var isnull = false;  //默认不存在当前字典值
		for (var o = 0; o < boxvalue.length; o ++) {
			if ($(checkebox[i]).val() == boxvalue[o].key) { //如果当前字典值存在，勾选
				isnull = true;
				break;
			}
		}
		$(checkebox[i]).attr("checked", isnull);
	}
	
}

/**
 * 修改广告信息
 */
function updateAdvertiserMentInfo(id) {
	//改变步数,在修改时只有3个步骤
	$("#js-next-4").hide();
	$("#js-next-5").hide();
	//默认显示保存按钮
	$(".js-botton-sub").show();
	
	toaddAdvertiser();
	
	advertiserMentid = id;
	
	//查询广告信息
	var advertiserMentInfo = findAdvertiserMentById(id);
	
	$("select[name='js-activity-id']").val(advertiserMentInfo.activityid);
	
	var activity = advertiserMentInfo.activity;
	
	//置为空
	$("input[name='js-activity-name']").val("");
	$("input[name='js-activity-type']").attr("checked", false);
	$("input[name='js-activity-endTime']").val("");
	$("input[name='js-activity-startTime']").val("");
	$("input[name='js-activity-everydayQuota']").val("");

	//广告
	$("input[name='js-advertiserMent-name']").val(advertiserMentInfo.name);
	$("input[name='js-advertiseMent-popularize-type']").val(advertiserMentInfo.popularizetype);
	$("input[name='js-advertiseMent-path']").val(advertiserMentInfo.path);
	$("input[name='js-advertiseMent-PV-monitoring-address']").val(advertiserMentInfo.pvmonitoringaddress);
	$("input[name='js-advertiseMent-trade-tag1']").val(advertiserMentInfo.tradetag.split[0]);
	$("input[name='js-advertiseMent-trade-tag2']").val(advertiserMentInfo.tradetag.split[1]);

	//瞄准信息
	var collimation = advertiserMentInfo.collimation;
	var devicetypevaluejson = collimation.devicetypevaluejson;  //设备类型  
	var operatorvaluejson = collimation.operatorvaluejson;  //运营商    
	var networkenvironmentvaluejson = collimation.networkenvironmentvaluejson; //网络环境
	var operatingsystemvaluejson = collimation.operatingsystemvaluejson;  // 操作系统
	var sexvaluejson = collimation.sexvaluejson;  // 性别
	var agevaluejson = collimation.agevaluejson;  // 年龄
	var interestvaluejson = collimation.interestvaluejson;  //兴趣爱好
	
	//设置选中。 如果当前广告存在字典数据时，选中这个checkbox
	checkedCollimationPrivate(dd_013, $.parseJSON(devicetypevaluejson));
	checkedCollimationPrivate(dd_012, $.parseJSON(operatorvaluejson));
	checkedCollimationPrivate(dd_011, $.parseJSON(networkenvironmentvaluejson));
	checkedCollimationPrivate(dd_010, $.parseJSON(operatingsystemvaluejson));
	checkedCollimationPrivate(dd_015, $.parseJSON(sexvaluejson));
	checkedCollimationPrivate(dd_015, $.parseJSON(agevaluejson));
	checkedCollimationPrivate(dd_005, $.parseJSON(interestvaluejson));
	
	//设置定价信息
	var pricing = advertiserMentInfo.pricing;
	if (pricing.chargeway == 1) {
		$("input[name='chargeway'][value='1']").attr("checked", true);
	} else {
		$("input[name='chargeway'][value='2']").attr("checked", true);
	}
	
	$("input[name='checkbestbidprice']").val(pricing.checkbestbidprice);
	$("input[name='dayexpenditurequota']").val(pricing.dayexpenditurequota);
	$("select[name='exposurefrequencyunit']").val(pricing.exposurefrequencyunit);
	$("select[name='checkfrequeunit']").val(pricing.checkfrequeunit);
	$("input[name='exposurefrequencyno']").val(pricing.exposurefrequencyno);
	$("input[name='checkfrequeeveryoneno']").val(pricing.checkfrequeeveryoneno);
	
	var collimation = advertiserMentInfo.collimation;
	
	//设置右边信息框
	setrightInfoHtml(activity, advertiserMentInfo);
}

/**
 * 
 * 查询广告信息
 */
function findAdvertiserMentById(advertiserMentid) {
	var advertiserMentInfo;
	$.ajax({
		type : "POST",
		url : basepath + "/admin/generalizeManager/findAdvertiserMentByid?advertisermentid=" + advertiserMentid,
		dataType : "JSON",
		async : false,
		success : function(data) {
			advertiserMentInfo = data;
		},
		error : function(e) {
			throw "系统繁忙，请稍候再试！";
		}
	});
	return advertiserMentInfo;
}


