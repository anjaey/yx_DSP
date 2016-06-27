package com.hy.controller.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.FtpUtil;
import com.hy.util.common.ImageUtils;

/**
 * 创 建 人： zhangyu
 * 日     期： 2015年8月14日下午3:25:55
 * 描     述：  图片上传
 * <br>--------------------------------------<br>
 * 修 改 人： 
 * 日     期： 
 * 描     述：  扼要说明修改原因，修改详细请注明到方法级
 * <br>--------------------------------------<br>
 */
@Controller
public class FileController extends BaseController {

	/**
	 * 创 建 人：  zhangyu
	 * 日     期：  2015年8月14日下午3:28:55
	 * 描     述： 文件上传公共方法
	 * @param file 文件流
	 * @param root 必须设置 上传根目录  内置的编号代替  
	 * artcle --》1  文章相关
	 * other --》2  其他
	 * product --》3 商品相关
	 * uedit --》4 文本编辑器相关
	 * user --》5 用户相关 如头像等
	 * 
	 * @param key 默认值为null  默认文件在根目录中
	 * @param type 默认为0 不保存到附件表,只会返回路径    1 保存到产品附件表      2 保持到系统附件表
	 * <br>-----------------------------<br>
	 * 修 改 人： 
	 * 日     期： 
	 * 描     述： (注明修改原因) 
	 * <br>-----------------------------<br>
	 */

	@RequestMapping("/admin/common/addfile.html")
	public void uploadProFile(MultipartFile file, Integer root, String key, Integer type){
		
		//取出FTP路径
		String dir = "";
		
		try {
			//获取文件名称
			String orginalName = file.getOriginalFilename();

			//得到生成的文件名称
			String filename = CommonUtil.getNewFilename(orginalName);

			if (CommonUtil.isEmpty(type)) {
				type = 0;
			}
			
//			switch (root) {
//			case 1:
//				dir = ConstantUtil.FTP_ARTICLEROOTDIR_NAME;
//				break;
//			case 2:
//				
//				dir = ConstantUtil.FTP_OTHERROOTDIR_NAME;
//				break;
//			case 3:
//				
//				dir = ConstantUtil.FTP_PRODUCTROOTDIR_NAME;
//				break;
//			case 4:
//				
//				dir = ConstantUtil.FTP_UEIDORROOTDIR_NAME;
//				break;
//			case 5:
//				
//				dir = ConstantUtil.FTP_USERROOTDIR_NAME;
//				break;
//			default:
//				
//				System.out.println("不存在当前根目录");
//				return;
//			}
			
			//拼接路径
			String url = null;
			if (!CommonUtil.isEmpty(key)) {
				url = dir + "/" +key +"/" + filename;
			} else {
				url = dir + "/" + filename;
			}
			

			//获取文件流
			InputStream is = file.getInputStream();
			if (!CommonUtil.isEmpty(is)) {
				//上传FTP
				Boolean bool = FtpUtil.uploadSingleImage(url, is);
				if (bool) {

					//设置返回数据
					Map<String, Object> map = new HashMap<String, Object>();
					
					if (type == 1) {
						//保存到附件表
//						ProductAttachmentEntity pae = new ProductAttachmentEntity();
//						String proattuuid = UuidUtil.generateUUID();
//						pae.setCreatetime(new Date());
//						pae.setKeyid(key);
//						pae.setName(orginalName);
//						pae.setUrl(url);
//						pae.setStatus(1);
//						pae.setAttachmenttype(0);
//						pae.setUuid(proattuuid);
//						pae.setFilemodule(type.toString());
					} else if (type == 2) {
						//保存到附件表
//						SysAttachmentEntity sae = new SysAttachmentEntity();
//						String proattuuid = UuidUtil.generateUUID();
//						sae.setCreatetime(new Date());
//						sae.setName(orginalName);
//						sae.setUrl(url);
//						sae.setUuid(proattuuid);
					}
					map.put("key",key);
					
					//拼接图片访问路径
					map.put("url", url);
					
					String urlAddress = ImageUtils.getImageUrl(url);
					map.put("urlAddress", urlAddress);
					
					this.writeJson(ConstantUtil.SYSTEM_DATA_RETURN,map);
				}else{
					this.writeJson(ConstantUtil.SYSTEM_DATA_RETURN,ConstantUtil.RETURN_FAIL);
				}
			} else {
				this.writeJson(ConstantUtil.SYSTEM_DATA_RETURN,ConstantUtil.RETURN_FAIL);
			} 

		} catch (IOException e) {
			this.writeJson(ConstantUtil.SYSTEM_DATA_RETURN,ConstantUtil.RETURN_FAIL);
			e.printStackTrace();
		}
	}
}
