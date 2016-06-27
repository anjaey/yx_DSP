package com.hy.util.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;


public class FileUpload {
	
	
	
  /**
	* 
	* 创 建 人：  Dp
	* 日     期：  2015年7月30日下午2:27:19
	* 描     述： UUid 做文件名  上传文件
	* -----------------------------
	* 修 改 人： 
	* 日     期： 
	* 描     述： TODO(注明修改原因) 
	* -----------------------------
	* @param file          //文件对象
    * @param filePath      //上传路径
    * @return  文件名
	*/
	 public static String fileUp(MultipartFile file, String filePath) throws IOException{
		 
		 return fileUp(file, filePath, UuidUtil.generateUUID());
	 }
	
	
    /**
     * @param file          //文件对象
     * @param filePath      //上传路径
     * @param fileName      //文件名
     * @return  文件名
     * @throws IOException IO异常
     */
    public static String fileUp(MultipartFile file, String filePath, String fileName) throws IOException{
        String extName = ""; // 扩展名格式：
            if (file.getOriginalFilename().lastIndexOf(".") >= 0){
                extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            }
            copyFile(file.getInputStream(), filePath, fileName+extName).replaceAll("-", "");
            
        return fileName+extName;
    }
     
    /**
     * 写文件到当前目录的upload目录中
     * 
     * @param in
     * @param fileName
     * @throws IOException
     */
    private static String copyFile(InputStream in, String dir, String realName)
            throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }
}