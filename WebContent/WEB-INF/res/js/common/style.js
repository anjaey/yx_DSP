$(function() {
	//子菜单
	$(".subMenuType").click(function() {
		$(".subMenuList").hide();
		$(".subMenuType").removeClass("focus");
		$(this).next(".subMenuList").show(300);
		$(this).addClass("focus");
	});
	//面包屑导航
	$(".crumbsNavCn .crumbsNav:last-child").css({
		"background": "none",
		"color": "#bbbbbb"
	});
	//筛选收折
	$(".J_openScreen").click(function() {
		$(this).parents(".screenCn").find(".screenList").stop(true, true)
		$(this).parents(".screenCn").find(".screenList").slideToggle('speed');
	});
	$(".J_closeScreen").click(function() {
		$(this).parents(".screenCn").find(".screenList").slideUp('speed');
	});

	//隔行叉色
	$(".dataTable tr:odd").addClass("dataTbodyTr_odd");
	//盘旋焦点
	var thisIndex;
	$(".dataTable td").hover(function() {
		$(this).parent("tr").addClass("dataTbodyTr_focus");
		thisIndex = $(this).index();
		$(".dataTable tr").each(function(i) {
			$(this).find("td").eq(thisIndex).addClass("dataTbodyTr_focus");
		});
	}, function() {
		$(this).parent("tr").removeClass("dataTbodyTr_focus");
		thisIndex = $(this).index();
		$(".dataTable tr").each(function(i) {
			$(this).find("td").eq(thisIndex).removeClass("dataTbodyTr_focus");
		});
	});
	
	//全选反选
	$(".dataTable thead :checkbox").click(function() {
		if ($(this).is(":checked")) {
			$(".dataTable tbody tr td :checkbox").attr("checked", "checked");
		} else {
			$(".dataTable tbody tr td :checkbox").removeAttr("checked");
		}
	});
	$(".dataCn").on({
		click: function() {
			$(".dataTable tbody :checkbox").each(function(i) {
				if ($(this).is(":checked")) {
					$(".dataTable thead :checkbox").attr("checked", "checked");
				} else {
					$(".dataTable thead :checkbox").removeAttr("checked");
					return false;
				}
			});
		}
	}, ".dataTable tbody :checkbox");

	//删除数据
	$(".dataTable").on({
		click: function() {
			$(this).parents("tr").remove()
		}
	}, ".J_deleteData");
	
	//日志
	$(".J_log").parent("td").on({
		mouseover: function() {
			$(this).find(".logCn").css({
				"left":($(this).offset().left-$(this).find(".logCn").width())-210+"px",
			})
			$(this).find(".logCn").show()
		},
		mouseout: function(){
			$(this).find(".logCn").hide()
		}
	});
	
	
});