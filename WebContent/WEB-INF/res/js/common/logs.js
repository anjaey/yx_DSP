var logs_targetPage = 1;
var logs_is_page = true;

// 初始化 日志
function base_init_logs() {
	
	var width = 210;
	
	var siteType_obj = $("#siteType");
	if (siteType_obj.length > 0) {
		var siteType = siteType_obj.val();
		if (siteType == "DSP") {
			width = 180;
		} else if (siteType == "ADX") {
			width = 210;
		}
	}
	
	// 日志
	$(".dataTable").on({
		mouseenter: function() {
			
			var logCn = $(this).find(".logCn");
			
			var id = logCn.attr("data-id");
			
			logs_targetPage = 1;
			logs_is_page = true;
			
			var html = base_find_logs_page(id, logs_targetPage);
			html = html == "" ? "暂无日志" : html;
			$(logCn.children()[0]).html(html);
			
			logCn.css({
				"left":($(this).offset().left-logCn.width())-width+"px",
			});
			logCn.show();
		},
		mouseleave: function(){
			$(this).find(".logCn").hide();
		}
	},".J_log");
	
	// 滚动条到最后进行分页查询
	$.each($(".logCn"), function() {
		
		var id = $(this).attr("data-id");
		var nDivHight = $(this).height();
		
		$(this).scroll(function() {
			
			if (!logs_is_page) {
				return;
			}
			
			var nScrollHight = $(this)[0].scrollHeight;
			var nScrollTop = $(this)[0].scrollTop;
			if (nScrollTop + nDivHight >= nScrollHight - 100) {
				
				logs_targetPage = logs_targetPage + 1;
				var html = base_find_logs_page(id, logs_targetPage);
				if (html == null || $.trim(html) == "") {
					logs_is_page = false;
				} else {
					var ul = $($(this)[0]).children()[0];
					$(ul).append(html);
				}
			}
		});
	});
}