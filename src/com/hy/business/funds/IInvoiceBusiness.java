package com.hy.business.funds;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.hy.util.common.QueryPage;

/**
 * 发票接口
 * 
 * @author hy
 *
 */
@Service
public interface IInvoiceBusiness {
	
	/**
	 * 	统计用户的充值总额、已开票金额、
	 *  并计算可开票金额。
	 * 
	 * @author hy
	 * @date 2016年6月28日上午10:06:03
	 * @param userid
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectStatisticsInvoiceMoney(Integer userid);
	
	/**
	 * 
	 * 根据发票id 查询发票信息
	 * @author hy
	 * @date 2016年5月6日上午11:58:21
	 * @param Invoiceid
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectInvoiceByid(Integer id);

	/**
	 * 查询发票，并分页。
	 * 根据广告主、用户账号、状态、申请发票时间段
	 * 
	 * @author hy
	 * @date 2016年5月6日上午11:19:50
	 * @param parammap
	 * 	advertisers		个广告组（list）
	 *  useraccounts	/邮箱  广告主账号/邮箱.
	 *  state			状态
	 *  startTime		开始时间
	 *  endTime			结束时间
	 * @param queryPage	分页参数
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAllInvoice(Map<String, Object> parammap, QueryPage queryPage);
	
	/**
	 * 
	 * 修改发票信息
	 * @author hy
	 * @date 2016年5月3日下午3:29:00
	 * @param map
	 * 
	 * map的key表示字段名称，必须传入主键。
	 * 
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateInvoiceInfo(Map<String, Object> map);
	
	/**
	 * 添加发票信息
	 * @author hy
	 * @date 2016年5月3日下午3:28:08
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertInvoiceInfo(Map<String, Object> map);
}
