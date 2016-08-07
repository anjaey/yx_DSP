<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="${base}/res/js/ztree/zTreeStyle.css"
		type="text/css">
<div class="tabCa pa">
	<div class="tab_menuWrapper pa">
		<ul class="tab_menuList fl">
			<li class="tab_menu fl h focus">新建广告</li>
		</ul>
		<div class="stepCn fl w">
			<div class="stepSingle stepSingle_focus">
				<div class="stepNumber">1</div>
				<div class="stepName">基本信息</div>
			</div>
			<div class="stepSingle">
				<div class="stepNumber">2</div>
				<div class="stepName">瞄准</div>
			</div>
			<div class="stepSingle">
				<div class="stepNumber">3</div>
				<div class="stepName">定价</div>
			</div>
			<div id="js-next-4" class="stepSingle">
				<div class="stepNumber">4</div>
				<div class="stepName">添加创意</div>
			</div>
			<div id="js-next-5" class="stepSingle">
				<div class="stepNumber">5</div>
				<div class="stepName">提交审核</div>
			</div>
		</div>
	</div>
	<div class="tab_contentWrapper pa"
		style="top: 130px; background-color: #FFFFFF; bottom: 60px; overflow-y: auto;">
		<!--步奏1-->
		<div id="js-addadvertiserMent-Info-div" class="tab_content pa " style="display: block;">
			<div class="stepForm fl">
				<table class="dataForm">
					<caption>推广活动</caption>
					<tr>
						<th style="text-align: left;"><input checked="checked" value="1" type="radio" name="tghd"
							id="tghd1" /><label for="tghd1">已定义推广活动</label></th>
						<td><select name="js-activity-id"></select></td>
					</tr>
					
					<tr id="js-activity">
						<th style="text-align: left; vertical-align: top;"><input
							type="radio" name="tghd" value="0" id="tghd2" /><label for="tghd2">新建	</label></th>
						<td>
							<table>
								<tr>
									<th style="color: #808080;">活动名称<span class="must">*</span>：
									</th>
									<td width="700"><input name="js-activity-name" type="text" style="width: 240px;" /></td>
								</tr>
								<tr>
									<th style="vertical-align: top; color: #808080;">推广日期<span
										class="must">*</span>：
									</th>
									<td><input type="checkbox" name="js-activity-type"/><label
										style="color: #808080;">无期限</label> <span class="prompt">勾选无期限后，只需选择开始时间即可</span><br />
										<span style="color: #808080;">开始时间：</span><input  name="js-activity-startTime" type="text"
										style="width: 170px;" /><br /> <span style="color: #808080;">结束时间：</span><input
										type="text" name="js-activity-endTime" style="width: 170px;" /></td>
								</tr>
								<tr>
									<th style="color: #808080;">每日限额：</th>
									<td><input name="js-activity-everydayQuota" type="text" style="width: 240px;" /><span
										class="prompt">每日支出将以您设置的活动预算为上线</span></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div class="partitionLine fl w"></div>
			<div class="stepForm fl">
				<table class="dataForm">
					<caption>广告</caption>
					<tr>
						<th>广告名称<span class="must">*</span>：
						</th>
						<td><input name="js-advertiserMent-name" type="text" /></td>
					</tr>
					<tr>
						<th>投放类型<span class="must">*</span>：
						</th>
						<td><select name="js-advertiseMent-popularize-type"></select></td>
					</tr>
					<tr>
						<th>链接地址<span class="must">*</span>：
						</th>
						<td><input type="text" name="js-advertiseMent-path"/></td>
					</tr>
					<tr>
						<th>PVP监测地址：</th>
						<td><input type="text" name="js-advertiseMent-PV-monitoring-address"/><span class="prompt">若有多个，请用“|”分隔</span></td>
					</tr>
					<tr>
						<th>行业标签：</th>
						<td><input name="js-advertiseMent-trade-tag1" type="text" style="width: 171px;" />-<input
							 name="js-advertiseMent-trade-tag2" type="text" style="width: 171px;" /></td>
					</tr>
				</table>
			</div>
		</div>
		<!--步奏2-->
		<div  class="tab_content pa ">
			<div class="leftDiv pa h">
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>目标定位</caption>
						<tr>
							<th>时间段：</th>
							<td><input type="text" name="js-advertisement-start-time" style="width: 150px;" />-<input
								type="text" name="js-advertisement-end-time" style="width: 150px;" /></td>
						</tr>
						<tr>
							<th style="vertical-align: top;">目标区域：</th>
							<td>
								<div style="width: 308px; max-height: 200px; border: solid 1px #C5C5C5; overflow: auto;">
									<!--结构树-->
									<ul id="addressTree" class="ztree"></ul>
								</div>
							</td>
						</tr>
						<tr>
							<th>操作系统：</th>
							<td>
								<table id="dd_010" class="checkedList">
									<tr>
									</tr>
								</table>

							</td>
						</tr>
						<tr>
							<th>网络环境：</th>
							<td>
								<table id="dd_011" class="checkedList">
									<tr>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th>运营商：</th>
							<td>
								<table id="dd_012" class="checkedList">
									<tr>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th>设备类型：</th>
							<td>
								<table id="dd_013" class="checkedList">
									<tr>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div class="partitionLine fl w"></div>
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>受众</caption>
						<tr>
							<th>性别：</th>
							<td>
								<table id="dd_014" class="checkedList">
									<tr>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th>年龄：</th>
							<td><select style="width: 120px;" class="dd_015"></select>-<select
								style="width: 120px;" class="dd_015"></select> <span
								class="prompt">岁</span></td>
						</tr>
						<tr>
							<th style="vertical-align: top;">兴趣爱好：</th>
							<td>
								<table id="dd_005" class="checkedList">
									<tr>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="rightDiv pa h">
				<div class="stepForm fl">
					<table class="dataForm">
						<caption style="margin-top: 0px;">推广活动</caption>
						<tr>
							<th>活动名称：</th>
							<td class="js-activity-name-td"></td>
						</tr>
						<tr>
							<th>开始日期：</th>
							<td class="js-activity-start-time-td"></td>
						</tr>
						<tr>
							<th>结束日期：</th>
							<td class="js-activity-end-time-td"></td>
						</tr>
						<tr>
							<th>每日限额：</th>
							<td class="js-activity-quota-td"></td>
						</tr>
					</table>
				</div>
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>广告</caption>
						<tr>
							<th>广告名称：</th>
							<td class="js-advertiser-ment-td"></td>
						</tr>
						<tr>
							<th>推广类型：</th>
							<td class="js-advertiser-generalize-td"></td>
						</tr>
						<tr>
							<th>链接地址：</th>
							<td class="js-advertiser-path-td"></td>
						</tr>
						<tr>
							<th>行业标签：</th>
							<td class="js-advertiser-tag-td"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--步奏3-->
		<div class="tab_content pa ">
			<form id="js-advertisement-pricing-from">
				<div class="leftDiv pa h">
					<div class="stepForm fl">
						<table class="dataForm">
							<caption>出价</caption>
							<tr>
								<th>创意类型<span class="must">*</span>：
								</th>
								<td><input type="radio" value="2" name=chargeway id="cylx1"
									disabled="disabled" /><label for="cylx1">CPM</label> <input
									type="radio" name="chargeway" value="1" id="cylx2" checked="checked" /><label
									for="cylx2">CPC</label></td>
							</tr>
							<tr>
								<th>每次点击最高出价<span class="must">*</span>：
								</th>
								<td><input type="text" name="checkbestbidprice"/><span class="prompt">元&nbsp;&nbsp;最低不低于0.50元</span></td>
							</tr>
							<tr>
								<th>设置每日支出限额：</th>
								<td><input type="text" name="dayexpenditurequota"/><span class="prompt">元&nbsp;&nbsp;为该广告设置每日支出上限，若您的活动只有一个广告，建议不要设置每日支出限额</span></td>
							</tr>
						</table>
					</div>
					<div class="partitionLine fl w"></div>
					<div class="stepForm fl">
						<table class="dataForm">
							<caption>频次控制</caption>
							<tr>
								<th>曝光频次<span class="must">*</span>：
								</th>
								<td>
								<select name="exposurefrequencyunit"><option value="1">每天</option><option value="0">投放周期</option></select>-<input
									type="text" name="exposurefrequencyno" style="width: 120px;" /><span class="prompt">次/人</span></td>
							</tr>
							<tr>
								<th>点击频次<span class="must">*</span>：
								</th>
								<td>
								<select name="checkfrequeunit"><option value="1">每天</option><option value="0">投放周期</option></select>-<input
									type="text" name='checkfrequeeveryoneno' style="width: 120px;" /> <span class="prompt">次/人</span></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
			<div class="rightDiv pa h">
				<div class="stepForm fl">
					<table class="dataForm">
						<caption style="margin-top: 0px;">推广活动</caption>
						<tr>
							<th>活动名称：</th>
							<td class="js-activity-name-td"></td>
						</tr>
						<tr>
							<th>开始日期：</th>
							<td class="js-activity-start-time-td"></td>
						</tr>
						<tr>
							<th>结束日期：</th>
							<td class="js-activity-end-time-td"></td>
						</tr>
						<tr>
							<th>每日限额：</th>
							<td class="js-activity-quota-td"></td>
						</tr>
					</table>
				</div>
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>广告</caption>
						<tr>
							<th>广告名称：</th>
							<td class="js-advertiser-ment-td"></td>
						</tr>
						<tr>
							<th>推广类型：</th>
							<td class="js-advertiser-generalize-td"></td>
						</tr>
						<tr>
							<th>链接地址：</th>
							<td class="js-advertiser-path-td"></td>
						</tr>
						<tr>
							<th>行业标签：</th>
							<td class="js-advertiser-tag-td"></td>
						</tr>
					</table>
				</div>
			</div>

		</div>
		<!--步奏4-->
		<div class="tab_content pa ">
			<form id="js-creative-from">
			<div class="leftDiv pa h">
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>创意</caption>
						<tr>
							<th>创意类型<span class="must">*</span>：
							</th>
							<td><select name="creativetype"></select></td>
						</tr>
						<tr>
							<th>创意形式<span class="must">*</span>：
							</th>
							<td><select name="advertisermodality"></select></td>
						</tr>
						<tr>
							<th>规格尺寸<span class="must">*</span>：
							</th>
							<td><select name="size"></select></td>
						</tr>
						<tr>
							<th>创意内容<span class="must">*</span>：
							</th>
							<td><input type="file" multiple="multiple" /><span
								class="prompt">可接受文件格式为：JPG、PNG和GIF，最大尺寸为：400K。最多可上传5个创意</span></td>
						</tr>
					</table>
				</div>
			</div>
			</form>
			<div class="rightDiv pa h">
				<div class="stepForm fl">
					<table class="dataForm">
						<caption style="margin-top: 0px;">推广活动</caption>
						<tr>
							<th>活动名称：</th>
							<td class="js-activity-name-td"></td>
						</tr>
						<tr>
							<th>开始日期：</th>
							<td class="js-activity-start-time-td"></td>
						</tr>
						<tr>
							<th>结束日期：</th>
							<td class="js-activity-end-time-td"></td>
						</tr>
						<tr>
							<th>每日限额：</th>
							<td class="js-activity-quota-td"></td>
						</tr>
					</table>
				</div>
				<div class="stepForm fl">
					<table class="dataForm">
						<caption>广告</caption>
						<tr>
							<th>广告名称：</th>
							<td class="js-advertiser-ment-td"></td>
						</tr>
						<tr>
							<th>推广类型：</th>
							<td class="js-advertiser-generalize-td"></td>
						</tr>
						<tr>
							<th>链接地址：</th>
							<td class="js-advertiser-path-td"></td>
						</tr>
						<tr>
							<th>行业标签：</th>
							<td class="js-advertiser-tag-td"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>

	</div>
	<div class="stepChange pa tc">
		<input type="button" value="取消" class="cancelBtn" /> 
		
		<input type="button" onclick="nextAdvertiserMentAdd()" value="上一步" class="lastBtn" style="display: none;" />
		<input id="js-next-button" type="button" onclick="nextAdvertiserMentAdd()" value="下一步" class="nextBtn" /> <input
		type="button" onclick="submitAdvertiserMent()" value="提交审核" class="submitBtn js-botton-next" style="display: none;" />
		
		<input type="button" onclick="submitAdvertiserMent()" value="保存" class="nextBtn js-botton-sub" /> 
	</div>
</div>
	