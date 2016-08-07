package com.hy.business.address.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.business.address.IAddressBusiness;
import com.hy.dao.mybatis.mapper.AddressCitiesMapper;
import com.hy.dao.mybatis.mapper.AddressProvincesMapper;
import com.hy.dao.mybatis.model.AddressCities;
import com.hy.dao.mybatis.model.AddressCitiesCriteria;
import com.hy.dao.mybatis.model.AddressProvinces;
import com.hy.dao.mybatis.model.AddressProvincesCriteria;
import com.hy.util.common.ListMapUtil;

@Service
public class AddressBusinessImpl implements IAddressBusiness{

	@Autowired
	AddressCitiesMapper addressCitiesMapper;
	@Autowired
	AddressProvincesMapper addressProvincesMapper;

	@Override
	public List<Map<String, Object>> selectAddressProvinces() {
		List<Map<String, Object>> listmap = null;
		try {
			List<AddressProvinces> listaddPro = addressProvincesMapper.selectByExample(new AddressProvincesCriteria());
			listmap = ListMapUtil.convertListEntityToListMap(listaddPro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listmap;
	}

	@Override
	public List<Map<String, Object>> selectAddressCitiesByProvincesId(String provincesId) {
		List<Map<String, Object>> listmap = null;
		try {
			AddressCitiesCriteria acc = new AddressCitiesCriteria();
			acc.createCriteria().andProvinceidEqualTo(provincesId);
			List<AddressCities> listaddPro = addressCitiesMapper.selectByExample(acc);
			listmap = ListMapUtil.convertListEntityToListMap(listaddPro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listmap;
	}

	@Override
	public List<Map<String, Object>> selectAddressProvincesAndCreateTree() {
		List<Map<String, Object>> returnlistmap = new ArrayList<Map<String, Object>>(); 
		//查询所有省
		List<Map<String, Object>> listmap = selectAddressProvinces();
		for (Map<String, Object> map : listmap) {
			//赋值
			map.put("name", map.get("province"));
			map.put("parentid", 0);

			String id = map.get("id").toString();
			String provincesid = map.get("provinceid").toString();
			List<Map<String, Object>> provinceslistmap = selectAddressCitiesByProvincesId(provincesid);

			for (Map<String, Object> map2 : provinceslistmap) {
				map2.put("pId", id);
				map2.put("name", map2.get("city"));
			}	
			returnlistmap.addAll(provinceslistmap);
		}
		
		//全部加上
		returnlistmap.addAll(listmap);
		
		return returnlistmap;
	}

}
