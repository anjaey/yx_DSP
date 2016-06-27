	package com.hy.util.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;

/**
 * code 工具
 * @author linw
 *
 */
public class CodeUtil {
	
	private static Map<String, List<CodeInfo>> codeMap = new HashMap<String, List<CodeInfo>>();
	
	static {
		
		// PSD 生效状态 list
		List<CodeInfo> psdInfoStatusList = new ArrayList<CodeInfo>();
		
		CodeInfo psdInfoStatus0 = new CodeInfo();
		psdInfoStatus0.setCodeKey(ConstantStaticUtil.DSP_INFO_STATUS_0);
		psdInfoStatus0.setCodeValue("失效");
		
		CodeInfo psdInfoStatus1 = new CodeInfo();
		psdInfoStatus1.setCodeKey(ConstantStaticUtil.DSP_INFO_STATUS_1);
		psdInfoStatus1.setCodeValue("生效");
		
		psdInfoStatusList.add(psdInfoStatus0);
		psdInfoStatusList.add(psdInfoStatus1);
		
		codeMap.put(ConstantStaticUtil.DSP_INFO_STATUS_LIST, psdInfoStatusList);
		
		// PSD 生效状态 list
		List<CodeInfo> psdInfoIsCreativeCheckList = new ArrayList<CodeInfo>();
		
		CodeInfo psdInfoIsCreativeCheck0 = new CodeInfo();
		psdInfoIsCreativeCheck0.setCodeKey(ConstantStaticUtil.DSP_INFO_IS_CREATIVE_CHECK_0);
		psdInfoIsCreativeCheck0.setCodeValue("不需要");
		
		CodeInfo psdInfoIsCreativeCheck1 = new CodeInfo();
		psdInfoIsCreativeCheck1.setCodeKey(ConstantStaticUtil.DSP_INFO_IS_CREATIVE_CHECK_1);
		psdInfoIsCreativeCheck1.setCodeValue("需要");
		
		psdInfoIsCreativeCheckList.add(psdInfoIsCreativeCheck0);
		psdInfoIsCreativeCheckList.add(psdInfoIsCreativeCheck1);
		
		codeMap.put(ConstantStaticUtil.DSP_INFO_IS_CREATIVE_CHECK_LIST, psdInfoIsCreativeCheckList);
		
		
		// 用户状态 list
		List<CodeInfo> userbasicStateList = new ArrayList<CodeInfo>();
		
		CodeInfo userbasicState1 = new CodeInfo();
		userbasicState1.setCodeKey(ConstantStaticUtil.USERBASIC_STATE_1);
		userbasicState1.setCodeValue("激活");
		
		CodeInfo userbasicState2 = new CodeInfo();
		userbasicState2.setCodeKey(ConstantStaticUtil.USERBASIC_STATE_2);
		userbasicState2.setCodeValue("锁定");
		
		CodeInfo userbasicState3 = new CodeInfo();
		userbasicState3.setCodeKey(ConstantStaticUtil.USERBASIC_STATE_3);
		userbasicState3.setCodeValue("未激活");
		
		userbasicStateList.add(userbasicState1);
		userbasicStateList.add(userbasicState2);
		userbasicStateList.add(userbasicState3);
		
		codeMap.put(ConstantStaticUtil.USERBASIC_STATE_LIST, userbasicStateList);
		
		
		// 广告主 资质状态 list
		List<CodeInfo> advertiserCredentialsStatusList = new ArrayList<CodeInfo>();
		
		CodeInfo advertiserCredentialsStatus0 = new CodeInfo();
		advertiserCredentialsStatus0.setCodeKey(ConstantStaticUtil.ADVERTISER_CREDENTIALS_STATUS_0);
		advertiserCredentialsStatus0.setCodeValue("已提交");
		
		CodeInfo advertiserCredentialsStatus1 = new CodeInfo();
		advertiserCredentialsStatus1.setCodeKey(ConstantStaticUtil.ADVERTISER_CREDENTIALS_STATUS_1);
		advertiserCredentialsStatus1.setCodeValue("未提交");
		
		advertiserCredentialsStatusList.add(advertiserCredentialsStatus0);
		advertiserCredentialsStatusList.add(advertiserCredentialsStatus1);
		
		codeMap.put(ConstantStaticUtil.ADVERTISER_CREDENTIALS_STATUS_LIST, advertiserCredentialsStatusList);
		
		
		// 广告主 资质审核状态 list
		List<CodeInfo> advertiserCredentialsCheckStatusList = new ArrayList<CodeInfo>();
		
		CodeInfo advertiserCredentialsCheckStatus0 = new CodeInfo();
		advertiserCredentialsCheckStatus0.setCodeKey(ConstantStaticUtil.ADVERTISER_CREDENTIALS_CHECK_STATUS_0);
		advertiserCredentialsCheckStatus0.setCodeValue("待审核");
		
		CodeInfo advertiserCredentialsCheckStatus1 = new CodeInfo();
		advertiserCredentialsCheckStatus1.setCodeKey(ConstantStaticUtil.ADVERTISER_CREDENTIALS_CHECK_STATUS_1);
		advertiserCredentialsCheckStatus1.setCodeValue("审核成功");
		
		CodeInfo advertiserCredentialsCheckStatus2 = new CodeInfo();
		advertiserCredentialsCheckStatus2.setCodeKey(ConstantStaticUtil.ADVERTISER_CREDENTIALS_CHECK_STATUS_2);
		advertiserCredentialsCheckStatus2.setCodeValue("审核失败");
		
		advertiserCredentialsCheckStatusList.add(advertiserCredentialsCheckStatus0);
		advertiserCredentialsCheckStatusList.add(advertiserCredentialsCheckStatus1);
		advertiserCredentialsCheckStatusList.add(advertiserCredentialsCheckStatus2);
		
		codeMap.put(ConstantStaticUtil.ADVERTISER_CREDENTIALS_CHECK_STATUS_LIST, advertiserCredentialsCheckStatusList);
		
		
		// 创意 审核状态 list
		List<CodeInfo> creativeStatusList = new ArrayList<CodeInfo>();
		
		CodeInfo creativeStatus0 = new CodeInfo();
		creativeStatus0.setCodeKey(ConstantStaticUtil.CREATIVE_STATUS_0);
		creativeStatus0.setCodeValue("审核中");
		
		CodeInfo creativeStatus1 = new CodeInfo();
		creativeStatus1.setCodeKey(ConstantStaticUtil.CREATIVE_STATUS_1);
		creativeStatus1.setCodeValue("审核成功");
		
		CodeInfo creativeStatus2 = new CodeInfo();
		creativeStatus2.setCodeKey(ConstantStaticUtil.CREATIVE_STATUS_2);
		creativeStatus2.setCodeValue("审核失败");
		
		creativeStatusList.add(creativeStatus0);
		creativeStatusList.add(creativeStatus1);
		creativeStatusList.add(creativeStatus2);
		
		codeMap.put(ConstantStaticUtil.CREATIVE_STATUS_LIST, creativeStatusList);
		
		
		// 创意 流量类型 list
		List<CodeInfo> trafficTypeList = new ArrayList<CodeInfo>();
		// 创意 流量类型 list 一期 只有PC端流量和移动端流量
		List<CodeInfo> trafficTypeList1 = new ArrayList<CodeInfo>();
		
		CodeInfo trafficType1 = new CodeInfo();
		trafficType1.setCodeKey(ConstantStaticUtil.CREATIVE_TRAFFIC_TYPE_1);
		trafficType1.setCodeValue("PC端流量");
		
		CodeInfo trafficType2 = new CodeInfo();
		trafficType2.setCodeKey(ConstantStaticUtil.CREATIVE_TRAFFIC_TYPE_2);
		trafficType2.setCodeValue("移动端流量");
		
		CodeInfo trafficType3 = new CodeInfo();
		trafficType3.setCodeKey(ConstantStaticUtil.CREATIVE_TRAFFIC_TYPE_3);
		trafficType3.setCodeValue("视频端流量");
		
		trafficTypeList.add(trafficType1);
		trafficTypeList.add(trafficType2);
		trafficTypeList.add(trafficType3);
		
		codeMap.put(ConstantStaticUtil.CREATIVE_TRAFFIC_TYPE_LIST, trafficTypeList);
		
		trafficTypeList1.add(trafficType1);
		trafficTypeList1.add(trafficType2);
		codeMap.put(ConstantStaticUtil.CREATIVE_TRAFFIC_TYPE_LIST1, trafficTypeList1);
		
		
		
		// 创意 创意类型 list
		List<CodeInfo> creativeTypeList = new ArrayList<CodeInfo>();
		
		CodeInfo creativeType1 = new CodeInfo();
		creativeType1.setCodeKey(ConstantStaticUtil.CREATIVE_CREATIVE_TYPE_1);
		creativeType1.setCodeValue("图片");
		
		CodeInfo creativeType2 = new CodeInfo();
		creativeType2.setCodeKey(ConstantStaticUtil.CREATIVE_CREATIVE_TYPE_2);
		creativeType2.setCodeValue("flash");
		
		CodeInfo creativeType3 = new CodeInfo();
		creativeType3.setCodeKey(ConstantStaticUtil.CREATIVE_CREATIVE_TYPE_3);
		creativeType3.setCodeValue("视频");
		
		creativeTypeList.add(creativeType1);
		creativeTypeList.add(creativeType2);
		creativeTypeList.add(creativeType3);
		
		codeMap.put(ConstantStaticUtil.CREATIVE_CREATIVE_TYPE_LIST, creativeTypeList);
		
		
		// 日志 类型 list
		List<CodeInfo> logTypeList = new ArrayList<CodeInfo>();
		
		CodeInfo logType1 = new CodeInfo();
		logType1.setCodeKey(ConstantStaticUtil.LOG_TYPE_1);
		logType1.setCodeValue("增加");
		
		CodeInfo logType2 = new CodeInfo();
		logType2.setCodeKey(ConstantStaticUtil.LOG_TYPE_2);
		logType2.setCodeValue("修改");
		
		CodeInfo logType3 = new CodeInfo();
		logType3.setCodeKey(ConstantStaticUtil.LOG_TYPE_3);
		logType3.setCodeValue("查询");
		
		CodeInfo logType4 = new CodeInfo();
		logType4.setCodeKey(ConstantStaticUtil.LOG_TYPE_4);
		logType4.setCodeValue("删除");
		
		logTypeList.add(logType1);
		logTypeList.add(logType2);
		logTypeList.add(logType3);
		logTypeList.add(logType4);
		
		codeMap.put(ConstantStaticUtil.LOG_TYPE_LIST, logTypeList);
		
		
		// 日志 表 list
		List<CodeInfo> logTableList = new ArrayList<CodeInfo>();
		
		CodeInfo logTable1 = new CodeInfo();
		logTable1.setCodeKey(ConstantStaticUtil.LOG_TABLE_DSP_INFO);
		logTable1.setCodeValue("DSP");
		
		CodeInfo logTable2 = new CodeInfo();
		logTable2.setCodeKey(ConstantStaticUtil.LOG_TABLE_ADVERTISER);
		logTable2.setCodeValue("广告主");
		
		logTableList.add(logTable1);
		logTableList.add(logTable2);
		
		codeMap.put(ConstantStaticUtil.LOG_TABLE_LIST, logTableList);
		
		
		
		// 日志 字段 list
		List<CodeInfo> logColumnList = new ArrayList<CodeInfo>();
		
		// dsp start =========================================================================================
		
		CodeInfo logColumn1 = new CodeInfo();
		logColumn1.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_INFO_LIMIT_IP);
		logColumn1.setCodeValue("IP设置");
		
		CodeInfo logColumn3 = new CodeInfo();
		logColumn3.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_INFO_WEB_TRAFFIC_CONTROL);
		logColumn3.setCodeValue("Web端流量控制数");
		
		CodeInfo logColumn4 = new CodeInfo();
		logColumn4.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_INFO_MOBILE_TRAFFIC_CONTROL);
		logColumn4.setCodeValue("移动端流量控制数");
		
		CodeInfo logColumn5 = new CodeInfo();
		logColumn5.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_INFO_VIDEO_TRAFFIC_CONTROL);
		logColumn5.setCodeValue("视频流量控制数");
		
		CodeInfo logColumn6 = new CodeInfo();
		logColumn6.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_INFO_STATUS);
		logColumn6.setCodeValue("状态");
		
		// dsp end =========================================================================================
		
		// user start =========================================================================================
		
		CodeInfo logColumn12 = new CodeInfo();
		logColumn12.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_CONNECTION_EMIAL);
		logColumn12.setCodeValue("联系邮箱");
		
		CodeInfo logColumn13 = new CodeInfo();
		logColumn13.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_EPITHET);
		logColumn13.setCodeValue("三国花名");
		
		CodeInfo logColumn7 = new CodeInfo();
		logColumn7.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_STATE);
		logColumn7.setCodeValue("状态");
		
		CodeInfo logColumn8 = new CodeInfo();
		logColumn8.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_COMPELLATION);
		logColumn8.setCodeValue("姓名");
		
		CodeInfo logColumn9 = new CodeInfo();
		logColumn9.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_QQ);
		logColumn9.setCodeValue("QQ");
		
		CodeInfo logColumn10 = new CodeInfo();
		logColumn10.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_WECHAT);
		logColumn10.setCodeValue("微信");
		
		CodeInfo logColumn11 = new CodeInfo();
		logColumn11.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_MOBILEPHONE);
		logColumn11.setCodeValue("手机号");
		
		CodeInfo logColumn30 = new CodeInfo();
		logColumn30.setCodeKey(ConstantStaticUtil.LOG_COLUMN_USER_ROLE);
		logColumn30.setCodeValue("角色");

		logColumnList.add(logColumn12);
		logColumnList.add(logColumn13);
		logColumnList.add(logColumn7);
		logColumnList.add(logColumn8);
		logColumnList.add(logColumn9);
		logColumnList.add(logColumn10);
		logColumnList.add(logColumn11);
		logColumnList.add(logColumn30);
		
		// user end =========================================================================================
		
		//行业映射 start
		CodeInfo logColumn16 = new CodeInfo();
		logColumn16.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_SORTMAPPING_MAPPING_NAME);
		logColumn16.setCodeValue("映射名称");
		CodeInfo logColumn17 = new CodeInfo();
		logColumn11.setCodeKey(ConstantStaticUtil.LOG_COLUMN_DSP_SORTMAPPING_MAPPING_ID);
		logColumn11.setCodeValue("映射ID");
		logColumnList.add(logColumn16);
		logColumnList.add(logColumn17);
		
		//行业映射 end
		
		//汇款记录 start
		CodeInfo logColumn18 = new CodeInfo();
		logColumn18.setCodeKey(ConstantStaticUtil.LOG_COLUMN_REMITTANCE_TIME);
		logColumn18.setCodeValue("汇款时间");
		CodeInfo logColumn19 = new CodeInfo();
		logColumn19.setCodeKey(ConstantStaticUtil.LOG_COLUMN_REMITTANCE_MONEY);
		logColumn19.setCodeValue("汇款金额");
		CodeInfo logColumn20 = new CodeInfo();
		logColumn20.setCodeKey(ConstantStaticUtil.LOG_COLUMN_REMITTANCE_STATE);
		logColumn20.setCodeValue("汇款状态");
		logColumnList.add(logColumn20);
		logColumnList.add(logColumn19);
		logColumnList.add(logColumn18);
		//汇款记录 end
		
		//月账单 start
		CodeInfo logColumn21 = new CodeInfo();
		logColumn21.setCodeKey(ConstantStaticUtil.LOG_COLUMN_FINANCIAL_RESULTS_REALSPENDING_MONEY);
		logColumn21.setCodeValue("实际消费金额");
		CodeInfo logColumn22 = new CodeInfo();
		logColumn22.setCodeKey(ConstantStaticUtil.LOG_COLUMN_FINANCIAL_RESULTS_INVOICE_STATE);
		logColumn22.setCodeValue("发票状态");
		CodeInfo logColumn23 = new CodeInfo();
		logColumn23.setCodeKey(ConstantStaticUtil.LOG_COLUMN_FINANCIAL_RESULTS_BILLEXPIRE_TIME);
		logColumn23.setCodeValue("到期时间");
		CodeInfo logColumn24 = new CodeInfo();
		logColumn24.setCodeKey(ConstantStaticUtil.LOG_COLUMN_FINANCIAL_RESULTS_BILLEXPIRE_ISSUEDSTATE);
		logColumn24.setCodeValue("发布状态");
		CodeInfo logColumn25 = new CodeInfo();
		logColumn25.setCodeKey(ConstantStaticUtil.LOG_COLUMN_FINANCIAL_RESULTS_STATE);
		logColumn25.setCodeValue("账单状态");
		
		logColumnList.add(logColumn23);
		logColumnList.add(logColumn22);
		logColumnList.add(logColumn21);
		logColumnList.add(logColumn24);
		logColumnList.add(logColumn25);
		//月账单 end
		
		//角色 start
		CodeInfo logColumn40 = new CodeInfo();
		logColumn40.setCodeKey(ConstantStaticUtil.LOG_COLUMN_ROLE_INFO_NAME);
		logColumn40.setCodeValue("角色名称");
		CodeInfo logColumn41 = new CodeInfo();
		logColumn41.setCodeKey(ConstantStaticUtil.LOG_COLUMN_ROLE_INFO_PERMISSIONS);
		logColumn41.setCodeValue("权限");
		logColumnList.add(logColumn41);
		logColumnList.add(logColumn40);
		//角色 end
				
		
		// 广告主 start =========================================================================================
		
		CodeInfo logColumn2 = new CodeInfo();
		logColumn2.setCodeKey(ConstantStaticUtil.LOG_COLUMN_ADVERTISER_CREDENTIALS_CHECK_STATUS);
		logColumn2.setCodeValue("客户资质审核状态");
		
		// 广告主 end =========================================================================================
		
		logColumnList.add(logColumn1);
		logColumnList.add(logColumn2);
		logColumnList.add(logColumn3);
		logColumnList.add(logColumn4);
		logColumnList.add(logColumn5);
		logColumnList.add(logColumn6);
		
		codeMap.put(ConstantStaticUtil.LOG_COLUMN_LIST, logColumnList);
	}
	/*
	private CodeService codeService;
	
	private void init(ServletContext servletContext) {
		WebApplicationContext webApp = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		codeService = (CodeService) webApp.getBean("codeService");
	}
	*/
	/**
	 * 加载 code
	 */
	public void load(ServletContext servletContext) {
		
		/*this.init(servletContext);
		
		List<CodeInfo> codeInfoList = codeService.findCodeList(null, null, null);
		if (codeInfoList != null && !codeInfoList.isEmpty()) {
			for (CodeInfo codeInfo : codeInfoList) {
				if (codeInfo == null) {
					continue;
				}
				
				String codeName = codeInfo.getCodeName();
				if (StringUtils.isEmpty(codeName)) {
					continue;
				}
				
				List<CodeInfo> codeInfoListTemp = codeMap.get(codeName);
				if (codeInfoListTemp == null) {
					codeInfoListTemp = new ArrayList<CodeInfo>();
					codeInfoListTemp.add(codeInfo);
					codeMap.put(codeName, codeInfoListTemp);
				} else {
					codeInfoListTemp.add(codeInfo);
				}
			}
		}*/
	}
	
	/**
	 * 查询 code value
	 * @param codeName
	 * @param codeKey
	 * @return
	 */
	public static String getCodeValue(String codeName, String codeKey) {
		CodeInfo codeInfo = getCodeInfo(codeName, codeKey);
		if (codeInfo != null) {
			return codeInfo.getCodeValue();
		}
		return null;
	}
	
	/**
	 * 查询 code po
	 * @param codeName
	 * @param codeKey
	 * @return
	 */
	public static CodeInfo getCodeInfo(String codeName, String codeKey) {
		if (!StringUtils.isEmpty(codeName) 
				&& !StringUtils.isEmpty(codeKey)) {
			
			List<CodeInfo> codeInfoList = getCodeInfoList(codeName);
			if (codeInfoList != null && !codeInfoList.isEmpty()) {
				for (CodeInfo codeInfo : codeInfoList) {
					if (codeInfo == null) {
						continue;
					}
					
					String codeKeyTemp = codeInfo.getCodeKey();
					if (codeKey.equals(codeKeyTemp)) {
						return codeInfo;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 查询 code po list
	 * @param codeName
	 * @return
	 */
	public static List<CodeInfo> getCodeInfoList(String codeName) {
		if (!StringUtils.isEmpty(codeName)) {
			return codeMap.get(codeName);
		}
		return null;
	}
	
	/**
	 * 查询 code map
	 * @param codeNameList
	 * @return
	 */
	public static Map<String, List<CodeInfo>> getCodeInfoList(List<String> codeNameList) {
		
		Map<String, List<CodeInfo>> codeMap = new HashMap<String, List<CodeInfo>>();
		
		if (codeNameList != null && !codeNameList.isEmpty()) {
			for (String codeName : codeNameList) {
				if (StringUtils.isEmpty(codeName)) {
					continue;
				}
				
				List<CodeInfo> codeInfoList = getCodeInfoList(codeName);
				
				codeMap.put(codeName, codeInfoList);
			}
		}
		
		if (codeMap != null && !codeMap.isEmpty()) {
			return codeMap;
		}
		return null;
	}
	
	public static class CodeInfo implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -8098970273806878465L;
		
		private String codeKey;
		private String codeName;
		private String codeValue;
		
		public String getCodeKey() {
			return codeKey;
		}
		public void setCodeKey(String codeKey) {
			this.codeKey = codeKey;
		}
		public String getCodeName() {
			return codeName;
		}
		public void setCodeName(String codeName) {
			this.codeName = codeName;
		}
		public String getCodeValue() {
			return codeValue;
		}
		public void setCodeValue(String codeValue) {
			this.codeValue = codeValue;
		}
	}
}
