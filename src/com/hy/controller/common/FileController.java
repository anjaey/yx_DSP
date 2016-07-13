package com.hy.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import com.hy.util.common.DirUtil;
import com.hy.util.upload.UploadBean;
import com.hy.util.upload.UploadException;
import com.hy.util.upload.UploadUtils;

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
	 * 
	 * 公共上传
	 * @author hy
	 * @date 2016年7月1日上午11:55:54
	 * @param path1  相对路径
	 * @param suffixType  文件后缀名限制
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> uploadProFile(String path1, String suffixType){
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
			uploadUtils.setSuffixStr(suffixType);
			
			// 上传路径
			String uploadCredentialsUrlPath = path1;
			
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
		return map;
	}
}
