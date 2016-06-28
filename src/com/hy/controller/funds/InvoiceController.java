package com.hy.controller.funds;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hy.business.funds.IInvoiceBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.QueryPage;

/**
 * 发票控制器
 * 发票的开票、查询
 * @author hy
 *
 */
@Controller
public class InvoiceController extends BaseController{

	@Autowired
	IInvoiceBusiness invoiceBusiness;
	
	/**
	 * 跳转到开票记录页面
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/Invoice/toInvoiceIndex")
	public ModelAndView toInvoiceIndex(Model model) {
		//统计充值总额、已开票金额、计算可开票金额
		int userid = this.getSessionLoginUserid();
		Map<String, Object> map = invoiceBusiness.selectStatisticsInvoiceMoney(userid);
		model.addAllAttributes(map);
		return forwardPage("admin/invoice/invoice");
	}
	
	/**
	 * 跳转到开票页面
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/Invoice/toaddInvoiceIndex")
	public ModelAndView toaddInvoiceIndex(Model model) {
		//统计充值总额、已开票金额、计算可开票金额
		int userid = this.getSessionLoginUserid();
		Map<String, Object> map = invoiceBusiness.selectStatisticsInvoiceMoney(userid);
		model.addAllAttributes(map);
		return forwardPage("admin/invoice/addinvoice");
	}
	
	/**
	 * 发票开票
	 * @author hy
	 * @date 2016年6月28日上午9:56:39
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/Invoice/addInvoice", method = RequestMethod.POST)
	public void addInvoice(@RequestParam Map<String, Object> map) {
		Map<String, Object> returnmap = invoiceBusiness.insertInvoiceInfo(map);
		this.writeJson(returnmap);
	}
	
	/**
	 * 分页查询发票信息
	 * @author hy
	 * @date 2016年6月28日上午10:00:35
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/Invoice/findInvoiceListAndPage", method = RequestMethod.POST)
	public void findInvoiceListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = invoiceBusiness.selectAllInvoice(parammap, queryPage);

			String vmPath = File.separator + "vm" + File.separator + "popularizeActivity";

			map1 = initpage("advertiserPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
}
