package com.hy.business.funds.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.business.advertiser.IAdvertiserBusiness;
import com.hy.business.funds.IInvoiceBusiness;
import com.hy.business.user.IUserBusiness;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.AdvertiserMapper;
import com.hy.dao.mybatis.mapper.InvoiceMapper;
import com.hy.dao.mybatis.model.Invoice;
import com.hy.dao.mybatis.model.InvoiceCriteria;
import com.hy.dao.mybatis.model.InvoiceCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.DateUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

/**
 * 发票实现接口
 * @author hy
 *
 */
@Service
public class InvoiceBusinessImpl extends BaseDaoImpl implements IInvoiceBusiness{

	@Autowired
	InvoiceMapper invoiceMapper;
	@Autowired
	AdvertiserMapper advertiserMapper;
	@Autowired
	IAdvertiserBusiness advertiserBusiness;
	@Autowired
	IUserBusiness userBusiness;
	

	@Override
	public Map<String, Object> selectInvoiceByid(Integer id) {
		Map<String, Object> map = null;
		try {
			Invoice invoice = invoiceMapper.selectByPrimaryKey(id);
			map = ListMapUtil.convertEntityToMap(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> selectAllInvoice(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		try {
			InvoiceCriteria ic = new InvoiceCriteria();
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			ic.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			ic.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));
			
			Criteria criteria = ic.createCriteria();
			
			//多个广告主id
			Object obj = parammap.get("ProposerUsers");
			if (!CommonUtil.isEmpty(obj)) {
				List<Integer> proposerUserlist = new ArrayList<Integer>();
				Integer[] ProposerUserss = (Integer[])obj;
				for (int proposerint : ProposerUserss) {
					proposerUserlist.add(proposerint);
				}
				criteria.andProposerUserIn(proposerUserlist);
			}
			
			//状态
			Object stateObj = parammap.get("state");
			if (!CommonUtil.isEmpty(stateObj)) {
				int state = Integer.parseInt(stateObj.toString());
				criteria.andStateEqualTo(state);
			}
			
			//时间段
			Object startTimeobj = parammap.get("startTime");
			if (!CommonUtil.isEmpty(startTimeobj)) {
				String startTimestr = startTimeobj.toString();
				Date strtTimedate = DateUtil.str2Date(startTimestr, DateUtil.YYYY_MM_DD);
				
				criteria.andProposerTimeLessThanOrEqualTo(strtTimedate.getTime());
			}
			
			Object endTimeobj = parammap.get("endTime");
			if (!CommonUtil.isEmpty(endTimeobj)) {
				String endTimestr = endTimeobj.toString();
				Date endTimedate = DateUtil.str2Date(endTimestr, DateUtil.YYYY_MM_DD);
				criteria.andProposerTimeGreaterThanOrEqualTo(endTimedate.getTime());
			}

			List<Invoice> invoiceList = invoiceMapper.selectByExample(ic);
			listmap = ListMapUtil.convertListEntityToListMap(invoiceList);
			
			for (Map<String, Object> map : listmap) {
				//申请人
				Object proposerUserobj = map.get("proposerUser");
				if (!CommonUtil.isEmpty(proposerUserobj)) {
					int proposerUser = Integer.parseInt(proposerUserobj.toString());
					Map<String, Object> proposerUsermap = advertiserBusiness.selectAdvertiserDetilByid(proposerUser);
					map.put("proposerUsername", proposerUsermap.get("company"));
				}
				
				//开票人
				Object onInvoiceUserObj = map.get("onInvoiceUser");
				if (!CommonUtil.isEmpty(onInvoiceUserObj)) {
					int onInvoiceUser = Integer.parseInt(onInvoiceUserObj.toString());
					Map<String, Object> onInvoiceUsermap =  userBusiness.selectUserDetilByid(onInvoiceUser);
					map.put("onInvoiceUsername", onInvoiceUsermap.get("compellation"));
				}
			}

			//统计数量
			int pagecount = invoiceMapper.countByExample(ic);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listmap;
	}

	@Override
	public Map<String, Object> updateInvoiceInfo(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			if (!CommonUtil.isEmpty(map)) {
				Invoice invoice = (Invoice)ListMapUtil.setEntityValue(map, Invoice.class);
				
				invoiceMapper.updateByPrimaryKeySelective(invoice);
				returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
			} else {
				returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> insertInvoiceInfo(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			if (!CommonUtil.isEmpty(map)) {
				Invoice invoice = (Invoice)ListMapUtil.setEntityValue(map, Invoice.class);
				
				invoiceMapper.insertSelective(invoice);
				returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
			} else {
				returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectStatisticsInvoiceMoney(Integer userid) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		double onInvoiceMoney = 0;  		//总开票金额
		double alreadyOnInvoiceMoney = 0;  	//已开票金额
		double noOnInvoiceMoney = 0;  		//未开票金额
		
		//统计总开票金额
		String sql = "select sum(on_invoice_money) as onInvoiceMoney from yx_invoice where proposer_user = ?";
		Object[] params = {userid};
		List<Map<String, Object>> listmap = super.jdbcBaseDao.findList(sql, params);
		if (!CommonUtil.isEmpty(listmap) && listmap.size() == 1) {
			Map<String, Object> map = listmap.get(0);
			if (!CommonUtil.isEmpty(map)) {
				Object onInvoiceMoneyobj = map.get("onInvoiceMoney");
				if (!CommonUtil.isEmpty(onInvoiceMoneyobj)) {
					onInvoiceMoney = Double.parseDouble(onInvoiceMoneyobj.toString());
				}
			}
		}
		
		//统计已开票金额
		sql = "select sum(on_invoice_money) as alreadyOnInvoiceMoney from yx_invoice where proposer_user = ? and state = 1";
		listmap = super.jdbcBaseDao.findList(sql, params);
		if (!CommonUtil.isEmpty(listmap) && listmap.size() == 1) {
			Map<String, Object> map = listmap.get(0);
			if (!CommonUtil.isEmpty(map)) {
				Object alreadyOnInvoiceMoneyobj = map.get("alreadyOnInvoiceMoney");
				if (!CommonUtil.isEmpty(alreadyOnInvoiceMoneyobj)) {
					alreadyOnInvoiceMoney = Double.parseDouble(alreadyOnInvoiceMoneyobj.toString());
				}
			}
		}
		
		returnmap.put("onInvoiceMoney", onInvoiceMoney);
		returnmap.put("alreadyOnInvoiceMoney", alreadyOnInvoiceMoney);
		
		//统计还可以开票的金额
		noOnInvoiceMoney = onInvoiceMoney - alreadyOnInvoiceMoney;
		returnmap.put("noOnInvoiceMoney", noOnInvoiceMoney);
		
		return returnmap;
	}

}
