<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${base}/res/css/admin/base.css" type="text/css"
	rel="stylesheet" />
<link href="${base}/res/css/admin/common.css" type="text/css"
	rel="stylesheet" />
<link href="${base}/res/css/admin/page.css" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${base}/res/js/common/jquery-ui-1.9.2.custom/css/smoothness/jquery-ui-1.9.2.custom.min.css" />
<link rel="stylesheet" href="${base}/res/css/admin/jqueryUI_reset.css" />
</head>

<body>
	<div class="manCa">
		<!-- 顶部 -->
		<%@include file="/WEB-INF/views/admin/common/top.jsp"%>

		<!-- 左边  -->
		<%@include file="/WEB-INF/views/admin/common/left.jsp"%>

		<div style="display: none" id="js-advertiser-add" class="rightCa pa">
			<%@include
				file="/WEB-INF/views/admin/advertiserMent/advertiserMentAdd.jsp"%>
		</div>

		<div id="js-advertiser-find" class="rightCa pa">
			<div class="tabCa pa">
				<div class="tab_menuWrapper pa">
					<ul id="js-change" class="tab_menuList fl">
						<li onclick="toActivity()" class="tab_menu fl h focus">推广活动</li>
						<li onclick="toAdvertiserMent()" class="tab_menu fl h">广告</li>
					</ul>
					<div class="tab_buttons fr h">
						<a href="javascript:addAdvertiser()" class="J_addData">新建广告</a>
					</div>
				</div>
				<div class="tab_contentWrapper pa">
					<div id="js-activity-info">
						<!--推广活动-->
						<form id="di_find_form">
							<div class="popularizeSubtotal fl w">
								<div class="popularizeSubtotal_single fl">
									<p>100000</p>
									<span>曝光量（次）</span>
								</div>
								<div class="popularizeSubtotal_single fl">
									<p>100000</p>
									<span>点击量（次）</span>
								</div>
								<div class="popularizeSubtotal_single fl">
									<p>100000</p>
									<span>花费（元）</span>
								</div>
							</div>
							<div class="operateCn fl w">
								<input class="fl" onclick="updateActivityStates(1)" type="button" value="启用" /> <input class="fl"
									type="button" onclick="updateActivityStates(0)" value="停用" /> <input class="fr" type="submit"
									value="搜索" /> <select class="fr"><option>活动状态</option></select>
								<select class="fr"><option>活动名称</option></select>
							</div>
							<div class="dataTableCn fl">
								<table class="dataTable">
									<thead>
										<tr>
											<th width="40"><input type="checkbox" /></th>
											<th>活动名称</th>
											<th>推广日期</th>
											<th>状态</th>
											<th>创建时间</th>
											<th>曝光量</th>
											<th>点击量</th>
											<th>消费（元）</th>
											<th>每日限额</th>
											<th width="200">操作</th>
										</tr>
										<thead>
											<tbody id="di_tbody"></tbody>
								</table>
							</div>
							<!--分页-->
							<div id="di_queryPage" class="dataPage_cn fl w tc"></div>
						</form>
					</div>

					<!-- 广告选项卡 -->
					<div style="display: none" id="js-advertiserMent-info"
						style="display: none">
						<%@include
							file="/WEB-INF/views/admin/advertiserMent/advertiserMentInfo.jsp"%>
					</div>

				</div>
			</div>
		</div>

		<!--根据活动查询的广告-->
		<div style="display: none" id="js-advertiserMentByActivity-info"
			style="display: none">
			<%@include
				file="/WEB-INF/views/admin/advertiserMent/advertiserMentByActivity.jsp"%>
		</div>

		<!-- 根据广告查询创意 -->
		<div style="display: none" id="js-creativeInfoByAdvertiserMent-info">
			<%@include file="/WEB-INF/views/admin/advertiserMent/creativeInfoByAdvertiserMent.jsp"%>
		</div>

	</div>
	<!--——————————————————————————————————————————————————————————————————————-->

	<!--弹出框（修改限额） -->
	<div class="updateQuota_Dialog" title="修改限额">
		<table class="dialogTable_form w ha">
			<tr>
				<th>每日限额<span class="must">*</span>:
				</th>
				<td><input type="text" id="js-activity-everyday-uota" /><span
					class="prompt">保存成功后该上限值次日生效.</span></td>
			</tr>
		</table>
	</div>

	<!--弹出框（修改出价） -->
	<div class="updateBid_Dialog" title="修改出价">
		<table class="dialogTable_form w ha">
			<tr>
				<th>最高出价<span class="must">*</span>:
				</th>
				<td><input name="js-advertiserMent-check-best-bid-price" type="text" /><span class="prompt">修改最高出价后将重新审核广告!</span></td>
			</tr>
		</table>
	</div>

	<!--弹出框（修改期限） -->
	<div class="updateDeadline_Dialog" title="修改期限">
		<table class="dialogTable_form w ha">
			<tr>
				<th>推广期限<span class="must">*</span>:
				</th>
				<td><input class="J_deadline" type="checkbox" name="checkbox"
					id="js-activity-ischecked" /> <label for="checkbox1">无期限</label> <span
					class="prompt">勾选无期限后，只需选择开始时间即可</span></td>
			</tr>
			<tr>
				<th>开始时间<span class="must">*</span>:
				</th>
				<td><input type="text" id="js-activity-startTime" /><span
					class="prompt"> <!--说明-->
				</span></td>
			</tr>
			<tr class="J_endTime">
				<th>结束时间<span class="must">*</span>:
				</th>
				<td><input type="text" id="js-activity-endTime" /><span
					class="prompt"> <!--说明-->
				</span></td>
			</tr>
		</table>
	</div>

	<!--联系客服-->
	<%@include file="/WEB-INF/views/admin/common/contactWay.jsp"%>
</body>
</html>

<script src="${base}/res/js/common/jquery-1.8.2.min.js"
	type="text/javascript"></script>
<script type="text/javascript" data="${base}" id="basepath"
	src="${base}/res/js/common/util/util.js"></script>
<script src="${base}/res/js/common/style.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${base}/res/js/common/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" data="${base}" id="basepath"
	src="${base}/res/js/admin/generalize/activity.js"></script>
<script type="text/javascript" data="${base}" id="basepath"
	src="${base}/res/js/admin/generalize/advertiserMent.js"></script>
	
<script type="text/javascript" data="${base}" id="basepath"
	src="${base}/res/js/admin/generalize/creative.js"></script>
		
<script type="text/javascript"
	src="${base}/res/js/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript"
	src="${base}/res/js/ztree/jquery.ztree.excheck.min.js"></script>

