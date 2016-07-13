var basepath = document.getElementById('basepath').getAttribute('data');
var id;
var insertOrUpdate = 0;  // 1 为修改  0 添加
$(function(){
	//新增对话框、修改对话框
	$(".addUser_Dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: "750",
		height: "500",
		modal: true,
		show: "scale",
		buttons: {
			"确定":function() {
				$(this).dialog("close");
				if (insertOrUpdate == 0) {
					addRole();
				}
				
				if (insertOrUpdate == 1) {
					updateRole(id);
				}
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
	

	findRoleInfoPage();
	
	//新增对话框打开
	$(".J_addData").click(function(){
		$(".addUser_Dialog").dialog("open");
		$(".addUser_Dialog").attr("title", "添加角色");
		insertOrUpdate = 0;
		$(".js-name").val("");
		findRole();
	});
});


//删除角色	
function deleteData(idinfo) {
	var id = idinfo;
	delRole(id);
}

/**
 * 修改
 * @param idinfo
 */
function updateData(idinfo) {
	$(".addUser_Dialog").dialog("open");
	$(".addUser_Dialog").attr("title", "修改角色");
	insertOrUpdate = 1;
	id = idinfo;
	findRole();
	findRoleByid(id);
}

//处理顶级全选
function clickAll(_this) {
	if ($(_this).attr("checked")) {
		$(_this).parent().parent().find("input").attr("checked", true);
	} else {
		$(_this).parent().parent().find("input").attr("checked", false);
	}
}

//处理第二级选中父级和子级
function clickParent2(_this, i) {
	if ($(_this).attr("checked")) {
		//选中子级
		$(_this).parent().parent().find("input").attr("checked", true);
		
		//选中父级
		$(_this).parents().find("input[name='navinfo1']").eq(0).attr("checked", true);
	} else {
		$(_this).parent().parent().find("input").attr("checked", false);
		//需要判断父级下面是否有选中的子级
		var clicks = $(_this).parents().find("input[name='navinfo1']").eq(0).parent().parent().find("input:checked").length;
		if (clicks == 1) {
			//取消父级的选中状态
			$(_this).parents().find("input[name='navinfo1']").eq(0).attr("checked", false);
		}
	}
}


//处理最低层选中父级
function clickParent(_this, i) {
	if ($(_this).attr("checked")) {
		//选中二级
		$(_this).parent().parent().find("td:first").find("input").attr("checked", true);
		
		//选中顶级
		$(_this).parents().find("input[name='navinfo1']").eq(0).attr("checked", true);
	} else {
		
		//查看同级的input 的选中数量
		var clicks = $(_this).parent().parent().find("td").find("input:checked").length;
		if (clicks == 1) {
			$(_this).parent().parent().find("td:first").find("input").attr("checked", false);
		}

		//判断顶级是否有其他元素被选中,如果大于0表示有选中其他的 
		clicks = $(_this).parents().find("input[name='navinfo1']").eq(0).parent().parent().find("input[name='navinfo2']:checked").length;
		if (clicks == 0) {
			$(_this).parents().find("input[name='navinfo1']").eq(0).attr("checked", false);
		}
	}
}

/**
 * 查询所有导航，用于设置权限
 * 
 */
function findRole() {
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/findAllNavigation",
		async : false,
		dataType: "json",
		success: function(data){
			$(".js-navtableinfo").remove();
			//处理顶级
			for (var i = 0; i < data.length; i ++ ) {
				var trinfo = '<tr class="js-navtableinfo"><th style="vertical-align: top;"><input onclick="clickAll(this)" value=' + data[i].id + ' name="navinfo1" type="checkbox" id="checkbox1" />'+
				data[i].title+'</th><td>';
				
				//处理2级
				var nav1Listmap = data[i].nav1Listmap;
				var table = '<table class="permissionList w ha">';
				for (var j = 0; j < nav1Listmap.length; j ++ ){
					//处理3级
					table += '<tr><td class="navtb"><input onclick="clickParent2(this, ' + i + ')" type="checkbox" value=' + nav1Listmap[j].id + ' name="navinfo2" id="checkbox1" /><label for="">' +
					nav1Listmap[j].title + ':</label></td>';
					
					var nav2Listmap = nav1Listmap[j].nav2Listmap;
					for (var k = 0; k < nav2Listmap.length; k ++ ){
						table += '<td class="navtb"><input onclick="clickParent(this, ' + i + ')" name="navinfo3" value=' + nav2Listmap[k].id + ' type="checkbox" id="checkbox1" /><label for="">' +
						nav2Listmap[k].title + '</label></td>';
					}
					table += '<tr>';
				}
				table += "</td></table>";
				
				trinfo += table + "<tr>";
				$("#js-navtable").append(trinfo);
			}
		}
	});
}

/**
 * 删除角色信息
 */
function delRole(id) {
	var param = {};
	param.id = id;
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/delRoleInfo",
		data: param,
		async : false,
		dataType: "json",
		success: function(data){
			pg_targetPage_js(1);//刷新当前页面.
		}
	});
}

/**
 * 查看角色详情
 */
function findRoleByid(id) {
	var param = {};
	param.id = id;
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/findRoleByid",
		data: param,
		async : false,
		dataType: "json",
		success: function(data){
			var name = data.name;
			$(".js-name").val(name);
			
			//把角色选中
			var navs = data.navs;
			for (var i = 0; i < navs.length; i ++) {
				$(".js-navtableinfo").find("input[value='" + navs[i].navid  + "']").attr("checked", true);
			}
		}
	});
}
	
/**
 * 修改角色信息
 */
function updateRole(id) {
	var param = {};
	param.id = id;
	param.name = $(".js-name").val();
	getNavInfo(param);
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/updateRoleInfo",
		data: param,
		async : false,
		dataType: "json",
		success: function(data){
			pg_targetPage_js(1);//刷新当前页面.
		}
	});
}

/**
 * 得到权限信息
 */
function getNavInfo(param) {
	var param1 = {};
	//顶级
	var navinfo1 = $("input[name='navinfo1']:checked");
	var navinfo1s = [];
	for (var i = 0; i < navinfo1.length; i++) {
		var navinfojson = {};
		navinfojson.id = navinfo1[i].value;
		navinfo1s[i] = navinfojson;
	}
	
	//二级
	var navinfo2 = $("input[name='navinfo2']:checked");
	var navinfo2s = [];
	for (var i = 0; i < navinfo2.length; i++) {
		var navinfojson = {};
		navinfojson.id = navinfo2[i].value;
		navinfo2s[i] = navinfojson;
	}
	
	//三级
	var navinfo3 = $("input[name='navinfo3']:checked");
	var navinfo3s = [];
	for (var i = 0; i < navinfo3.length; i++) {
		var navinfojson = {};
		navinfojson.id = navinfo3[i].value;
		navinfo3s[i] = navinfojson;
	}
	
	param1.navinfo1 = navinfo1s;
	param1.navinfo2 = navinfo2s;
	param1.navinfo3 = navinfo3s;
	
	param.navinfo = JSON.stringify(param1);
 }


//分页
function pg_targetPage_js(num) {
	$("#pg_targetPage").val(num);
	findRoleInfoPage();
}

//查询用户信息
function findRoleInfoPage() {
	try {
		var form_data = $("#di_find_form").serialize();
		$.ajax({
			type : "GET",
			url : basepath + "/admin/adx/findAllRoleAndPage",
			data : form_data,
			dataType : "JSON",
			success : function(map) {
				var data = map.data;
				var queryPageStr = map.queryPageStr;
				$("#di_tbody").html(data);
				$("#di_queryPage").html(queryPageStr);
				base_init_logs();
			},
			error : function(e) {
				throw "系统繁忙，请稍候再试！";
			}
		});
	} catch (e) {
		alert(e);
	}
}

/**
 * 新增角色信息
 */
function addRole() {
	var param = {};
	param.id = id;
	param.name = $(".js-name").val();
	getNavInfo(param);
	$.ajax({
		type: "POST",
		url: basepath + "/admin/adx/addRoleInfo",
		data: param,
		dataType: "json",
		success: function(data){
			pg_targetPage_js(1);//刷新当前页面.
		}
	});
}