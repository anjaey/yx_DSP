package com.hy.business.funds.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.funds.IPayRecordBusiness;
import com.hy.dao.mybatis.mapper.PayRecordMapper;
import com.hy.dao.mybatis.model.PayRecordCriteria;
import com.hy.dao.mybatis.model.PayRecordCriteria.Criteria;
import com.hy.dao.mybatis.model.PayRecord;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

@Service
public class PayRecordBusinessImpl implements IPayRecordBusiness{

	@Autowired
	PayRecordMapper payRecordMapper;
	
	@Override
	public List<Map<String, Object>> selectPayRecordAndPage(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		//查询所有非内置角色
		try {
			PayRecordCriteria prc = new PayRecordCriteria();
			
			Criteria criteria = prc.createCriteria(); 
			
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			prc.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			prc.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));
			
			//支付时间段条件
			Object startTimeObj = parammap.get("startTime");  //开始时间
			if (!CommonUtil.isEmpty(startTimeObj)) {
				Long startTimelong = Long.parseLong(startTimeObj.toString());
				criteria.andPayTimeGreaterThan(startTimelong);
			}
			Object endTimeObj = parammap.get("endTime"); //结束时间
			if (!CommonUtil.isEmpty(endTimeObj)) {
				Long endTimelong = Long.parseLong(endTimeObj.toString());
				criteria.andPayTimeLessThan(endTimelong);
			}
			
			//确认状态
			Object checkStateObj = parammap.get("checkState");
			if (!CommonUtil.isEmpty(checkStateObj)) {
				Integer checkStateint = Integer.parseInt(checkStateObj.toString());
				criteria.andCheckStateEqualTo(checkStateint);
			}
			
			//查询
			List<PayRecord> rolelist = payRecordMapper.selectByExample(prc);
			listmap = ListMapUtil.convertListEntityToListMap(rolelist);

			//统计数量
			int pagecount = payRecordMapper.countByExample(prc);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listmap;
	}

	@Override
	public Map<String, Object> insertDict(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		try {
			PayRecord pr = (PayRecord)ListMapUtil.setEntityValue(map, PayRecord.class);
			payRecordMapper.insert(pr);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

}
