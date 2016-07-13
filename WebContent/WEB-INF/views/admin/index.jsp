<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<!--  此处以及后面使用相对路径  -->
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="${base}/res/css/admin/base.css" type="text/css" rel="stylesheet" />
		<link href="${base}/res/css/admin/common.css" type="text/css" rel="stylesheet" />
		<link href="${base}/res/css/admin/page.css" type="text/css" rel="stylesheet" />
	</head>
	
	<body>
		<div class="manCa">
			<!-- 顶部 -->
			<%@include file="/WEB-INF/views/admin/common/top.jsp"%>
			
			<!-- 左边  -->
			<%@include file="/WEB-INF/views/admin/common/left.jsp"%>
			
			<div class="rightCa pa">
				<!--广告列表-->
				<div class="home_adCn pa">
					<a href="#" class="home_adInsert pa tc">新建广告</a>
					<div onclick="showAdvertiserMentInfo(this)" class="home_adOverview pa w J_adTab focus">整体情况</div>
					<div class="home_adRecently pa w">最近新创建的广告</div>
					<div id="js-NewestAdvertiserMent" class="home_adList pa w">
					</div>
				</div>
				
				<!--概况-->
				<div class="home_adSituation pa" style="display: block;">
					<div class="statistics fl w">
						<div class="statisticsSingle fl">
							<div class="statisticsSingle_left fl tc">余额</div>
							<div class="statisticsSingle_right fl">
								<div class="statisticsSingle_right_top" style="color: #42a4ff;">10000<sub class="unit">元</sub></div>
								<div class="statisticsSingle_right_bottom">
									我要<a href="#">充值</a>&nbsp;|
									查看<a href="#">记录</a>
								</div>
							</div>
						</div>
						<div class="statisticsSingle fl">
							<div class="statisticsSingle_left fl tc" style="background-color: #f5b13b;">消费</div>
							<div class="statisticsSingle_right fl">
								<div class="statisticsSingle_right_top" style="color: #f5b13b;">10000<sub class="unit">元</sub></div>
								<div class="statisticsSingle_right_bottom">
									查看<a href="#">消费记录</a>
								</div>
							</div>
						</div>
						<div class="statisticsSingle fl">
							<div class="statisticsSingle_left fl tc" style="background-color: #7cbc2a;">广告</div>
							<div class="statisticsSingle_right fl">
								<div class="statisticsSingle_right_top" style="color: #7cbc2a;">10000</div>
								<div class="statisticsSingle_right_bottom">
									 有效广告：<span style="color: #7cbc2a;">1</span>&nbsp;|&nbsp;待审核：<span style="color: #7cbc2a;">2</span>
								</div>
							</div>
						</div>
					</div>
					<div class="wholeCn fl w">
						<div class="wholeTitle fl">
							<div class="wholeTitle_text fl">
								<p>整体情况</p>
								<span>以下数据有近三十分钟的统计延迟</span>
							</div>
							<div class="wholeTitle_screen fr">
								<input type="text" placeholder="请选择日期" />
								<select><option>下拉</option></select>
							</div>
						</div>
						<div class="wholeSubtotal fl">
							<div class="wholeSubtotal_single fl">
								<p>100000</p>
								<span>曝光量（次）</span>
							</div>
							<div class="wholeSubtotal_single fl">
								<p>100000</p>
								<span>点击（次）</span>
							</div>
							<div class="wholeSubtotal_single fl">
								<p>100000</p>
								<span>花费（元）</span>
							</div>
						</div>
						<div class="wholeStatistics fl"><img src="${base}/res/images/admin/statisticsImg.jpg" style="width: 100%; height: 100%;" /></div>
					</div>
				</div>
				
				<!--广告详情-->
				<div class="home_adDetails pa">
					<div class="adDetails_title fl">
						<div class="adDetails_titleText fl">
							<p>广告1</p>
							<span>以下数据有近三十分钟的统计延迟</span>
						</div>
						<div class="adDetails_titleScreen fr">
							<input type="text" placeholder="请选择日期" />
							<select><option>下拉</option></select>
						</div>					
					</div>					
					<div class="adDetailsSubtotal fl">
						<div class="left fl h">
							<div class="adDetailsSubtotal_single fl">
								<p>100000</p>
								<span>曝光量（次）</span>
							</div>
						</div>
						<div class="right fr h">
							<div class="adDetailsSubtotal_single fl">
								<p>100000</p>
								<span>点击（次）</span>
							</div>
							<div class="adDetailsSubtotal_single fl">
								<p>100000</p>
								<span>花费（元）</span>
							</div>
						</div>
					</div>
					<div class="adWholeStatistics fl">
						<div class="adDetailsTable fl">
							<table>
								<caption>广告详情</caption>
								<tr>
									<th>名称：</th>
									<td name="name"></td>
								</tr>
								<tr>
									<th>ID：</th>
									<td name="activityId"></td>
								</tr>
								<tr>
									<th>状态:</th>
									<td name="checkState" style="color: #e07900;"></td>
								</tr>
								<tr>
									<th>推广活动：</th>
									<td name="activityname"></td>
								</tr>
								<tr>
									<th>计费模式：</th>
									<td name="chargeWay"></td>
								</tr>
								<tr>
									<th>开始日期：</th>
									<td name="startTime"></td>
								</tr>
								<tr>
									<th>结束日期：</th>
									<td name="endTime"></td>
								</tr>
								<tr>
									<th>出价：</th>
									<td name="checkbestbidprice"></td>
								</tr>
							</table>
						</div>
						<div class="adDetailsStatistics fr"><img src="${base}/res/images/admin/statisticsImg.jpg" style="width: 100%; height: 100%;" /></div>
					</div>					
				</div>
			</div>
		</div>
		<!--——————————————————————————————————————————————————————————————————————-->
		<!--联系客服-->
		<%@include file="/WEB-INF/views/admin/common/contactWay.jsp"%>
		
		<!--欢迎-->
		<%@include file="/WEB-INF/views/admin/common/welcome.jsp"%>
		
	</body>
</html>
<script src="${base}/res/js/common/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="${base}/res/js/common/style.js" type="text/javascript"></script>
<script src="${base}/res/js/admin/index/index.js"  data="${base}" id="basepath"
	 type="text/javascript"></script>
