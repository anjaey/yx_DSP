package com.hy.business.profitCommand.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.profitCommand.IProfitCommandBusiness;
import com.hy.dao.mybatis.mapper.ProfitCommandMapper;
import com.hy.dao.mybatis.model.ProfitCommand;
import com.hy.dao.mybatis.model.ProfitCommandCriteria;
import com.hy.util.common.ListMapUtil;

/**
 * 利润控制接口
 * 
 * @author hy
 *
 */
@Service
public class ProfitCommandBusinessImpl implements IProfitCommandBusiness{

	@Autowired
	ProfitCommandMapper profitCommandMapper;

	@Override
	public Map<String, Object> selectProfitCommand() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProfitCommand rc = profitCommandMapper.selectByExampleForOne(new ProfitCommandCriteria());
			map = ListMapUtil.convertEntityToMap(rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
