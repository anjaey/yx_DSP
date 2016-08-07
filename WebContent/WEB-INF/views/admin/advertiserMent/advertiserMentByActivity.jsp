<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="rightCa pa">
	<div class="tabCa pa">
		<form id="di_find_form1">
			<!--面包屑导航-->
			<div class="crumbsNavCn fl w">
				<a href="javascript:toActivity()" class="crumbsNav fl h">推广</a> <a
					class="crumbsNav fl h">广告</a>
			</div>
			<div class="popularizeSubtotal fl w">
				<table>
					<caption>
						<span class="name">活动名称</span> <span class="state">推广中</span> <span
							class="time">2016/06/02~2016/06/30</span>
					</caption>
					<tr>
						<th>曝光量：</th>
						<td>10,000次</td>
						<th>点击量：</th>
						<td>7200次</td>
						<th>消费：</th>
						<td>2700元</td>
						<th>CPM：</th>
						<td>0.37元</td>
						<th>CPC：</th>
						<td>0.37元</td>
					</tr>
				</table>
			</div>
			<div class="operateCn fl w">
				<a class="fl" href="">新建广告</a> <input onclick="updateAdvertiserMentStates(1)" class="fl" type="button"
					value="启用" /> <input onclick="updateAdvertiserMentStates(0)" class="fl" type="button" value="停用" /> <input
					class="fr" type="submit" value="搜索" /> <select class="fr"><option>广告名称</option></select>
				<select class="fr"><option>广告状态</option></select>
			</div>
			<div class="dataTableCn fl">
				<table class="dataTable">
					<thead>
						<tr>
							<th width="40"><input type="checkbox" /></th>
							<th>广告名称</th>
							<th>推广活动</th>
							<th>状态</th>
							<th>创建时间</th>
							<th>曝光量</th>
							<th>点击量</th>
							<th>消费（元）</th>
							<th>CPM（元）</th>
							<th>CPC（元）</th>
							<th>最高出价</th>
							<th width="200">操作</th>
						</tr>
					</thead>
					<tbody id="di_tbody2"></tbody>
				</table>
			</div>
			<!--分页-->
			<div id="di_queryPage2" class="dataPage_cn fl w tc"></div>
		</form>
	</div>
</div>