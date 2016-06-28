package com.hy.business.advertiser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.advertiser.IAdvertiserBusiness;
import com.hy.dao.mybatis.mapper.AdvertiserMapper;
import com.hy.dao.mybatis.model.Advertiser;
import com.hy.dao.mybatis.model.AdvertiserCriteria;
import com.hy.dao.mybatis.model.AdvertiserCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

@Service
public class AdvertiserBusinessImpl implements IAdvertiserBusiness {

	@Autowired
	AdvertiserMapper advertiserMapper;

	@Override
	public List<Map<String, Object>> selectAllAdvertiserAndPage(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		try {
			AdvertiserCriteria ac = new AdvertiserCriteria();
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			ac.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			ac.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));

			Criteria criteria = ac.createCriteria();
			
			//多个广告主id
			Object idsobj = parammap.get("ids");
			if (!CommonUtil.isEmpty(idsobj)) {
				List<Integer> idslist = new ArrayList<Integer>();
				Integer[] ids = (Integer[])idsobj;
				for (int id : ids) {
					idslist.add(id);
				}
				criteria.andIdIn(idslist);
			}
			
			//多个商务人员
			Object marketUseridsobj = parammap.get("marketUserids");
			if (!CommonUtil.isEmpty(marketUseridsobj)) {
				List<Integer> marketUseridlist = new ArrayList<Integer>();
				Integer[] ids = (Integer[])marketUseridsobj;
				for (int id : ids) {
					marketUseridlist.add(id);
				}
				criteria.andMarketBusniessUserIn(marketUseridlist);
			}
			
			//审核状态
			Object checkStateobj = parammap.get("checkState");
			if (!CommonUtil.isEmpty(checkStateobj)) {
				int checkState = Integer.parseInt(checkStateobj.toString());
				criteria.andCheckStateEqualTo(checkState);
			}
			
			//用户类型
			Object typeobj = parammap.get("type");
			if (!CommonUtil.isEmpty(typeobj)) {
				int type = Integer.parseInt(typeobj.toString());
				criteria.andTypeEqualTo(type);
			}
			
			List<Advertiser> rolelist = advertiserMapper.selectByExample(ac);
			listmap = ListMapUtil.convertListEntityToListMap(rolelist);
			for (Map<String, Object> map : listmap) {
				//推广中的活动查询

				//带推广活动查询

				//查询商务用户。

				//查询消费总额
			}

			//统计数量
			int pagecount = advertiserMapper.countByExample(ac);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listmap;
	}

	@Override
	public Map<String, Object> selectAdvertiserDetilByid(Integer id) {
		Map<String, Object> map = null;
		
		AdvertiserCriteria ac = new AdvertiserCriteria();
		ac.createCriteria().andUserIdEqualTo(id);

		try {
			Advertiser advertiser = advertiserMapper.selectByExampleForOne(ac);
			map = ListMapUtil.convertEntityToMap(advertiser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public List<Map<String, Object>> selectAllAdvertiser(Map<String, Object> parammap) {
		AdvertiserCriteria ac = new AdvertiserCriteria();
		List<Map<String, Object>>  listmap = null;
		try {
			//暂时不加条件
			
			List<Advertiser> listadv = advertiserMapper.selectByExample(ac);
			
			listmap = ListMapUtil.convertListEntityToListMap(listadv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listmap;
	}



}
