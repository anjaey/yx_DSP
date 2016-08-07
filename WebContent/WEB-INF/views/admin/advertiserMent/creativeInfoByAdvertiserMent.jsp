<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="rightCa pa">
	<div class="tabCa pa">
		<!--面包屑导航-->
		<div class="crumbsNavCn fl w">
			<a  href="javascript:toActivity()" class="crumbsNav fl h">推广</a> <a
				href="javascript:toAdvertiserMent1()" class="crumbsNav fl h">广告</a><a
				class="crumbsNav fl h">创意</a>
		</div>
		<div class="popularizeSubtotal fl w">
			<table>
				<caption>
					<span class="name">广告名称</span> <span class="state">推广中</span> <span
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
			<input class="fl" onclick="updateCreativeStates(1)" type="button" value="启用" /> <input class="fl"
				type="button" onclick="updateCreativeStates(0)" value="停用" /> <input onclick="deleteCreativeByid()" class="fl" type="button"
				value="删除" /> <a class="fl addOriginality"
				href="javascript:addCreativeInfo()">新增创意</a> <input class="fr"
				type="submit" value="搜索" /> <select class="fr"><option>广告名称</option></select>
			<select class="fr"><option>广告状态</option></select>
		</div>
		<form id="di_find_form2">
			<div class="dataTableCn fl">
				<table class="dataTable">
					<thead>
						<tr>
							<th width="40"><input type="checkbox" /></th>
							<th>创意ID</th>
							<th>状态</th>
							<th>审核状态</th>
							<th>创建时间</th>
							<th>曝光量</th>
							<th>点击量</th>
							<th>消费（元）</th>
							<th>CPM（元）</th>
							<th>CPC（元）</th>
						</tr>
					</thead>
					<tbody id="di_tbody3"></tbody>
				</table>
			</div>
			<!--分页-->
			<div id="di_queryPage3" class="dataPage_cn fl w tc"></div>

			<div class="wholeCn fl w">
				<div class="wholeTitle fl">
					<div class="wholeTitle_screen fl">
						<input type="text" placeholder="请选择日期" /> <select><option>曝光量</option></select>
						<select><option>广告创意</option></select>
					</div>
				</div>
				<div class="wholeStatistics fl">
					<img src="${base}/res/images/admin/statisticsImg.jpg"
						style="width: 100%; height: 100%;" />
				</div>
			</div>
	</div>
</div>
<!--弹出框（查看创意） -->
<div class="lookOriginality_Dialog tc" title="查看创意">
	<img id="js-creative-img" src="" />
</div>

<!--弹出框（新增创意） -->
<div class="addOriginality_Dialog" title="新增创意">
	<table class="dialogTable_form ha">
		<tr>
			<th>创意类型<span class="must">*</span>：</th>
			<td><select id="js-creativetype" name="creativetype"></select></td>
		</tr>
		<tr>
			<th>创意形式<span class="must">*</span>：</th>
			<td><select id="js-advertisermodality" name="advertisermodality"></select></td>
		</tr>
		<tr>
			<th>规格尺寸<span class="must">*</span>：</th>
			<td><select id="js-size" name="size"></select></td>
		</tr>
		<tr>
			<th style="vertical-align: top;">创意内容<span class="must">*</span>：</th>
			<td>
				<span class="prompt w">可接受文件格式为：JPG、PNG和GIF，最大尺寸为：400K。最多可上传5个创意</span><br />
				<input type="file" multiple="multiple" style="margin-left: 0px" />
			</td>
		</tr>
	</table>
</div>

<script src="${base}/res/js/common/jquery-1.8.2.min.js"
	type="text/javascript"></script>
<script type="text/javascript" data="${base}" id="basepath"
	src="${base}/res/js/admin/generalize/creative.js"></script>