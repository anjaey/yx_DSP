package com.hy.business;
//package com.hy.business;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//import org.json.JSONObject;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.ui.Model;
//import com.hy.business.article.IArticleBusiness;
//import com.hy.business.user.IRoleBusiness;
//import com.hy.business.user.IUserBusiness;
//import com.hy.business.user.IUserMessageBusiness;
//import com.hy.controller.admin.article.ArticleManageController;
//import com.hy.dao.mybatis.model.ArticleEntity;
//import com.hy.dao.mybatis.model.SurveyItemEntity;
//import com.hy.dao.mybatis.model.SysDictEntity;
//import com.hy.dao.mybatis.model.UserEntity;
//import com.hy.dao.mybatis.model.UserMessageEntity;
//import com.hy.util.common.BusinessData;
//import com.hy.util.common.ListMapUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath*:/config/spring/applicationContext.xml"})
//@SuppressWarnings("unused")
//public class JunitBusiness {
//	@Autowired
//	private IRoleBusiness roleBusiness;
//	@Autowired
//	private IUserBusiness userBusiness;
//	@Autowired
//	private IArticleBusiness articleBusiness;
//	@Autowired
//	private ArticleManageController articleManageController;
//	@Autowired
//	private IUserMessageBusiness userMessageBusiness;
//
//	private MockHttpServletRequest request;
//	private MockHttpServletResponse response;
//	
//	private Integer pageIndex = 1;
//	private Integer pageSize = 10;
//
//	/**
//	 * @Description			执行测试方法之前初始化模拟request,response  
//	 * @return				无
//	 */
//	@Before
//	public void setUp() {
//		request = new MockHttpServletRequest();
//		request.setCharacterEncoding("UTF-8");
//		response = new MockHttpServletResponse();
//	}
//	
//	@Test
//	public void select() {
//		BusinessData<UserMessageEntity> data = userMessageBusiness.selectUserMessageById(5111);
//		 System.out.println(data.getT());
//		for (UserMessageEntity e : data.getList()) {
//			System.out.println(e.getContent()+"  "+e.getId());
//		}
//	}
//	
//	public static void main(String[] args) {
//		String string = "{data={total_results=3, task=[{origin=IM1506260003, pack_operations=[{product_id=[43, [028000133177] Nestle NIDO Kinder 1+ Powdered Milk Beverage, 3.52 lb. Canister], result_package_id=null, picking_id=[12, 盛汇延展仓\\INT\\00004], package_id=null, location_dest_id=[12, 盛汇延展仓/Stock], product_qty=100.0, scan_ids=null, location_id=[17, Physical Locations/Your Company: Transit Location], id=92}], name=盛汇延展仓\\INT\\00004, partner_id=[3, Administrator], min_date=2015-06-26 03:08:50, location_dest_id=[12, 盛汇延展仓/Stock], pack_operation_ids=[92], location_id=[17, Physical Locations/Your Company: Transit Location], id=12}, {origin=IM1508110009, pack_operations=[{product_id=[61, [PR/00062] Optimum Nutrition Platinum Pre-Workout Fruit Punch 30/Sr (红, 300ml)], result_package_id=null, picking_id=[35, 盛汇延展仓\\INT\\00011], package_id=null, location_dest_id=[12, 盛汇延展仓/Stock], product_qty=20.0, scan_ids=null, location_id=[17, Physical Locations/Your Company: Transit Location], id=23}], name=盛汇延展仓\\INT\\00011, partner_id=[24, 保税库管], min_date=2015-08-11 06:42:09, location_dest_id=[12, 盛汇延展仓/Stock], pack_operation_ids=[23], location_id=[17, Physical Locations/Your Company: Transit Location], id=35}, {origin=IM1508110010, pack_operations=[{product_id=[61, [PR/00062] Optimum Nutrition Platinum Pre-Workout Fruit Punch 30/Sr (红, 300ml)], result_package_id=null, picking_id=[37, 盛汇货架/INT/00004], package_id=null, location_dest_id=[37, 盛汇货架/库存], product_qty=10.0, scan_ids=null, location_id=[17, Physical Locations/Your Company: Transit Location], id=90}], name=盛汇货架/INT/00004, partner_id=null, min_date=2015-08-11 07:14:43, location_dest_id=[37, 盛汇货架/库存], pack_operation_ids=[90], location_id=[17, Physical Locations/Your Company: Transit Location], id=37}]}, rsp=succ, res=0}";
//		
//		JSONObject jsonObject = new JSONObject(string);
//		
//		System.out.println(jsonObject.toString());
//		
//		
//	}
//}
