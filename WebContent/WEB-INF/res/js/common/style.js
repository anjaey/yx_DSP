$(function(){
	//用户中心下拉框
	$(".J_selectMenu").hover(function(){
		$(this).find(".selectList").show();
	},function(){
		$(this).find(".selectList").hide();
	});
	//联系客服
	$(".relationService_switch").click(function(){
		if($(".relationService_way").width()!==0){
			$(".relationService_way").animate({width:'0px',borderWidth:'0px'},300);
			
		}else{				
			$(".relationService_way").animate({width:'254px',borderWidth:'1px'},300);
		}
	});
	//菜单
	$(".menu_single").click(function(){
		$(".menu_single").removeClass("menuFocus");
		$(this).addClass("menuFocus");
	});
	//选项卡
	$(".tab_menuList .tab_menu").click(function(){
		$(".tab_menuList .tab_menu").removeClass("focus");
		$(this).addClass("focus");
		
		$(".tab_contentWrapper .tab_content").hide();
		$(".tab_contentWrapper .tab_content").eq($(this).index()).show();
	});
	
	//隔行叉色
	$(".dataTable tr:even").addClass("dataTbodyTr_even");
	//盘旋焦点
	var thisIndex;
	$(".dataTableCn").on({
		mouseover: function() {
			$(this).parent("tr").addClass("dataTbodyTr_focus");
			thisIndex = $(this).index();
			$(".dataTable tr").each(function(i) {
				$(this).find("td").eq(thisIndex).addClass("dataTbodyTr_focus");
			});
		},
		mouseout: function(){
			$(this).parent("tr").removeClass("dataTbodyTr_focus");
			thisIndex = $(this).index();
			$(".dataTable tr").each(function(i) {
				$(this).find("td").eq(thisIndex).removeClass("dataTbodyTr_focus");
			});
		},
	},".dataTable td");
	//全选反选
	$(".dataTable").each(function(i){
		$(".dataTable").eq(i).find("thead :checkbox").click(function(){
			if ($(this).is(":checked")) {
				$(".dataTable").eq(i).find("tbody tr td :checkbox").attr("checked", "checked");				
			} else {
				$(".dataTable").eq(i).find("tbody tr td :checkbox").removeAttr("checked", "checked");				
			}			
		})
	});
	$(".dataTableCn").on({
		click: function() {
			var thisTable=$(this).parents(".dataTable");
			thisTable.find("tbody :checkbox").each(function(i) {				
				if ($(this).is(":checked")) {
					thisTable.find("thead :checkbox").attr("checked", "checked");
				} else {
					thisTable.find("thead :checkbox").removeAttr("checked");
					return false;
				}
			});
		}
	}, ".dataTable tbody :checkbox");


});