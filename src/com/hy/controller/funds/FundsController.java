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

import com.hy.business.advertiser.IAdvertiserBusiness;
import com.hy.business.funds.IInvoiceBusiness;
import com.hy.business.funds.IPayRecordBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.ConstantStaticUtil;
import com.hy.util.common.DirUtil;
import com.hy.util.common.QueryPage;
import com.hy.util.upload.UploadBean;
import com.hy.util.upload.UploadException;
import com.hy.util.upload.UploadUtils;

/**
 * 资金管理
 * @author hy
 *
 */
@Controller
public class FundsController extends BaseController{

	@Autowired
	IPayRecordBusiness payRecordBusinessImpl;
	@Autowired
	IInvoiceBusiness invoiceBusiness;
	@Autowired
	IAdvertiserBusiness advertiserBusiness;
	@Autowired
	IPayRecordBusiness payRecordBusiness;
	
	/**
	 * 分页查询充值/支付记录
	 * @author hy
	 * @date 2016年6月28日上午10:45:28
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/finance/funds/findPayListAndPage", method = RequestMethod.POST)
	public void findPayListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = payRecordBusiness.selectPayRecordAndPage(parammap, queryPage);

			String vmPath = File.separator + "vm" + File.separator + "popularizeActivity";

			map1 = initpage("advertiserPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
	/**
	 * 跳转到充值记录
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/finance/funds/toRechargeRecord")
	public ModelAndView toaddInvoiceIndex(Model model) {
		//查询充值总金额
		int userid = this.getSessionLoginUserid();
		Map<String, Object> map = invoiceBusiness.selectStatisticsInvoiceMoney(userid);
		
		//查询账户余额
		Map<String, Object> advertisermap = advertiserBusiness.selectAdvertiserDetilByid(userid);
		model.addAttribute("onInvoiceMoney", map.get("map"));
		model.addAttribute("userBalance", advertisermap.get("price"));
		return forwardPage("admin/invoice/RechargeRecord");
	}
	
	/**
	 * 支付，充值。
	 * @author hy
	 * @date 2016年6月27日下午5:57:08
	 * @param map
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/finance/funds/pay", method = RequestMethod.POST)
	public void pay(@RequestParam Map<String, Object> map) {
		payRecordBusinessImpl.insertDict(map);
	}
	
	/**
	 * 
	 * 上传支付凭证
	 * @author hy
	 * @date 2016年6月27日下午6:02:28
	 * @update
	 * @date
	 */
	public void uploadPayVoucher() {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> msgMap = new HashMap<String, Object>();
		
		response.setContentType("text/html; charset=utf-8");
		
		map.put("msgMap", msgMap);
		map.put("state", "1");
		try {
			
			UploadUtils uploadUtils = new UploadUtils();
			// 最大限制
			Long maxSize = Long.valueOf(50 * 1024 * 1024);
			uploadUtils.setMaxSize(maxSize);
			// 后缀名限制
			String suffixType = "BMP,JPG,JPEG,PNG,GIF";
			uploadUtils.setSuffixStr(suffixType);
			
			// 上传路径
			String uploadCredentialsUrlPath = ConstantStaticUtil.UPLOAD_USER_URL_IMG_PATH;
			
			String rootDir = DirUtil.getDirUpload();
			
			try {
				List<UploadBean> credentialsUrlFileList = uploadUtils.getUploadFiles(request, "credentialsUrlFile");
				UploadBean credentialsUrlFile = null;
				if (credentialsUrlFileList != null && !credentialsUrlFileList.isEmpty()) {
					credentialsUrlFile = credentialsUrlFileList.get(0);
				}
				if (credentialsUrlFile != null) {
					uploadUtils.saveUploadFiles(credentialsUrlFile, rootDir, uploadCredentialsUrlPath);
					String path = credentialsUrlFile.getPath();
					
					map.put("data", path);
					map.put("state", "1");
				} else {
					map.put("state", "0");
				}
			} catch (UploadException e) {
				map.put("state", "0");
			} catch (Exception e) {
				map.put("state", "0");
			}
			
		} catch (Exception e) {
			if (msgMap.isEmpty()) {
				map.put("state", "0");
			}
		}
		this.writeJson(map);
	}
	
}
