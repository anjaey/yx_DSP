package com.hy.business.funds;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hy.util.common.QueryPage;

/**
 * 
 * 支付/充值记录
 * 
 * @author hy
 *
 */
@Service
public interface IPayRecordBusiness {
	
	/**
	 * 分页查询支付/充值记录，
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectPayRecordAndPage(Map<String, Object> parammap,
			QueryPage queryPage);
 
	/**
	 * 添加支付记录信息,充值记录，充值
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertDict(Map<String, Object> map);

}
