<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form id="di_find_form1">
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
			<input class="fl" type="button"  value="启用" /> <input class="fl"
				type="button" value="停用" /> <input class="fr" type="submit"
				value="搜索" /> <select class="fr"><option>广告状态</option></select> <select
				class="fr"><option>广告名称</option></select>
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
				<tbody id="di_tbody1"></tbody>
			</table>
		</div>
		<!--分页-->
		<div id="di_queryPage1" class="dataPage_cn fl w tc"></div>
</form>