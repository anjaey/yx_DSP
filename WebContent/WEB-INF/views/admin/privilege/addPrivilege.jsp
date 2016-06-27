<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<TITLE>ZTREE DEMO - checkbox</TITLE>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base}/res/js/ztree/demo.css" type="text/css">
<link rel="stylesheet" href="${base}/res/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${base}/res/js/common/jquery.min-1.9.1.js"></script>
<script type="text/javascript" src="${base}/res/js/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${base}/res/js/ztree/jquery.ztree.excheck.min.js"></script>

<SCRIPT type="text/javascript">
	var zTree;
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		}
	};

	/* var zNodes = [ {
		id : 1,
		pId : 0,
		name : "系统管理",
		nameen : "",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "角色管理",
		open : true
	}, {
		id : 111,
		pId : 11,
		name : "角色授权"
	}, {
		id : 112,
		pId : 11,
		name : "用户角色"
	}, {
		id : 115,
		pId : 11,
		name : "角色设置"
	}, {
		id : 113,
		pId : 111,
		name : "添加授权",
		nameen : "tjsq"
	}, {
		id : 114,
		pId : 112,
		name : "添加用户角色信息",
		nameen : "tjyhjsxx"
	}, {
		id : 116,
		pId : 115,
		name : "添加角色",
		nameen : "tjjs"
	} ]; */

	$(document).ready(function() {
		$.ajax({
			type: "POST",
			url: "${base}/privilege/navigation/findUserNavPrivilegeAndFunction",
			dataType: "json",
			success: function(data){
				$.fn.zTree.init($("#treeDemo"), setting, data);
			}
		});
	});

	//得到选中值, 并保存
	function getcheckedData() {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);

		var navPrivilege = new Array();
		var navFunctionRole = new Array();

		for (var i = 0; i < nodes.length; i++) {
			var isParent = nodes[i].isParent;
			if (!isParent) { //表示最后一级，没有了最后一级
				var functionRole = {};
				functionRole.functionId = nodes[i].funid;
				functionRole.navid = nodes[i].pId;
				functionRole.functionNameen = nodes[i].functionNameen;
				navFunctionRole.push(functionRole);
			} else {
				var privilege = {};

				if (nodes[i].pId == null) { //顶级
					privilege.navid = nodes[i].id;
					privilege.parentid = 0;
				} else {
					privilege.navid = nodes[i].id;
					privilege.parentid = nodes[i].pId;
				}
				navPrivilege.push(privilege);
			}
		}
		var param = {};
		
		param.navPri = JSON.stringify(navPrivilege);
		param.funPri = JSON.stringify(navFunctionRole);
		$.ajax({
			type: "POST",
			url: "${base}/privilege/navigation/addPrivilege",
			dataType: "json",
			data: param,
			success: function(data){
				alert("授权成功！");
			}
		});
		
	}
</SCRIPT>
</HEAD>

<BODY>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="right">
			<ul class="info">
				<li>
					<button value="得到选中值" onclick="getcheckedData()">得到选中值</button>
				</li>
			</ul>
			</ul>
		</div>
	</div>
</BODY>
</HTML>