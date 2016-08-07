
var basepath = document.getElementById('basepath').getAttribute('data');

$(function() {
	//查询最新广告
	findNewestAdvertiserMent();

	//欢迎
	$(".welcomeCa").show();//资料未完善就显示
	$(".J_welcome").click(function(){
		$(".welcomeCa").hide();
		if($(this).hasClass("perfect")){
			window.location.href="index.html";
		}
	});
});

/**
 * 显示详情
 * 
 */
function showAdvertiserMentInfo(_this) {
	$(".home_adOverview,.home_adSingle").removeClass("focus");
	$(".home_adSituation,.home_adDetails").hide();
	if($(_this).hasClass("home_adOverview")){
		$(_this).addClass("focus");
		$(".home_adSituation").show()
	}else if($(_this).hasClass("home_adSingle")){
		$(_this).addClass("focus");
		$(".home_adDetails").show()
	}
}

/**
 * 查询广告主详情
 * 
 */
function findAdvertiserMentByid(id) {
	$.ajax({
		type: "POST",
		url: basepath + "/admin/generalizeManager/findAdvertiserMentByid?advertiserid=" + id,
		dataType: "json",
		success: function(data){
			$("td[name='name']").html(data.name);
			$("td[name='activityId']").html(data.id);
			
			if (data.checkState == 1) {
				$("td[name='checkState']").html("审核");
			} else {
				$("td[name='checkState']").html("待审核");
			}
			
			if (data.activity) {
				$("td[name='startTime']").html(data.activity.startformat);
				$("td[name='endTime']").html(data.activity.endtimeformat);
				if (data.activity.chargeway == 1) {  
					$("td[name='chargeWay']").html("CPC");
				} else {
					$("td[name='chargeWay']").html("CPM");
				}
				$("td[name='activityname']").html(data.activity.name);
				$("td[name='checkbestbidprice']").html(data.pricing.checkbestbidprice);
			}
			
			
		}
	});
}

/**
 * 查询最新的广告
 */
function findNewestAdvertiserMent() {
	$("#js-NewestAdvertiserMent div").remove();
	$.ajax({
		type: "POST",
		url: basepath + "/admin/generalizeManager/findNewestAdvertiserMent?queryPage.pageSize=15&queryPage.targetPage=1",
		dataType: "json",
		success: function(data){
			if (data) {
				for (var i = 0; i < data.length; i ++) {
					$("#js-NewestAdvertiserMent").append('<div onclick="showAdvertiserMentInfo(this),findAdvertiserMentByid(' + data[i].id + ')" class="home_adSingle fl w J_adTab">' + data[i].name + '</div>');
				}
			}
		}
	});
}
