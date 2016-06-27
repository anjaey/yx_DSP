package com.hy.business.user;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.hy.dao.mybatis.model.Userbasic;


/**
 * 用户相关业务逻辑
 * @author hy
 *
 */
@Service
public interface IUserBusiness {
	
	/**
	 * 比较session中的user 和数据库的user 是否有改变
	 * 如果有改变 强制返回登录页面
	 * @author hy
	 * @date 2016年5月26日下午3:09:14
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectUnalterableUserInfoSessionAndUserInfodata(Map<String, Object> ubsession,
			Map<String, Object> ubdata);
	
	/**
	 * 根据用户名修改密码
	 * @author hy
	 * @date 2016年5月11日下午3:07:54
	 * @param map  key: username 表示用户名   pwd : 表示要修改的密码
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateUserPwdByUsername(Map<String, Object> map);
	
	/**
	 * 用户通过邮箱找回密码。
	 * @author hy
	 * @date 2016年5月23日上午11:57:28
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> getPwdAndToPage(Map<String, Object> map);
	
	/**
	 * 修改密码 发邮件， 并生成邮件地址。
	 * @author hy
	 * @date 2016年5月23日上午10:24:22
	 * @param obj
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updatePwdAndtoEmail(Map<String, Object> map, HttpServletRequest reqeust);
	
	/**
	 * 修改用户密码
	 * 根据原密码和旧密码修改
	 * @author hy
	 * @date 2016年5月10日下午7:12:45
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateUserPwd(Map<String, Object> map, Userbasic userbasic);

	/**
	 * 登录
	 * @author hy
	 * @date 2016年5月3日下午2:20:00
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> login(Map<String, Object> map, HttpServletRequest reqeust);
	
	/**
	 * 添加用户/注册
	 *  
	 * @author hy
	 * @date 2016年5月3日下午2:25:41
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertUser(Map<String, Object> map);
	
	/**
	 * 查询用户信息，包括详细信息
	 * 
	 * @author hy
	 * @date 2016年5月3日下午2:29:31
	 * @param map 可以是任意条件 其中key为 userBasic表字段名称
	 * @return map
	 * map中格式为：
	 * 
	 *  key 为 userBasic   value 为个人基本信息，如果不存在，为空
	 *  key 为 userDetil   value 为个人详细信息，如果不存在，为空
	 *  
	 *  
	 * @update
	 * @date
	 */
	public Map<String, Object> selectUserInfoByid(Map<String, Object> map);
	
}
 
