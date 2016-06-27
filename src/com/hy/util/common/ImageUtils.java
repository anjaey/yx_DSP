package com.hy.util.common;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;


/**
 * 图片工具类， 图片水印，文字水印，缩放
 * @author 
 */
public  class ImageUtils {
    
    /**
     * 添加图片水印
     * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
     * @param waterImg  水印图片路径，如：C://myPictrue//logo.png
     * @param x 水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间
     * @param y 水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
     */
    public final static void pressImage(String sourceImg, String waterImg, int x, int y, float alpha,String target) {
    	 try {
             File file = new File(sourceImg);
             BufferedImage image = ImageIO.read(file);
             int width = image.getWidth(null);
             int height = image.getHeight(null);
             BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
             Graphics2D g = bufferedImage.createGraphics();
             g.drawImage(image, 0, 0, width, height, null);
         
             BufferedImage waterImage = ImageIO.read(new File(waterImg));    // 水印文件
             int width_1 = waterImage.getWidth(null);
             int height_1 = waterImage.getHeight(null);
             g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
             
             int widthDiff = width - width_1;
             int heightDiff = height - height_1;
             if(x < 0){
                 x = widthDiff / 2;
             }else if(x > widthDiff){
                 x = widthDiff;
             }
             if(y < 0){
                 y = heightDiff / 2;
             }else if(y > heightDiff){
                 y = heightDiff;
             }
             g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束
             g.dispose();
             if(!StringUtil.isNull(target)){
    			 ImageIO.write(bufferedImage, ConstantUtil.PICTRUE_FORMATE_JPG, new File(sourceImg));
    		 }else{
    			 ImageIO.write(bufferedImage, ConstantUtil.PICTRUE_FORMATE_JPG, file);
    		 }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
  
    public final static void pressImage(String sourceImg, String waterImg, int x, int y, float alpha) {
    	pressImage(sourceImg, waterImg, x, y, alpha, null);
    }

    /**
     * 添加文字水印
     * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
     * @param pressText 水印文字， 如：中国证券网
     * @param fontName 字体名称，    如：宋体
     * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)
     * @param fontSize 字体大小，单位为像素
     * @param color 字体颜色
     * @param x 水印文字距离目标图片左侧的偏移量，如果x<0, 则在正中间
     * @param y 水印文字距离目标图片上侧的偏移量，如果y<0, 则在正中间
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
*/
    public static BufferedImage pressText(String sourceImg, String pressText, String fontName, int fontStyle, int fontSize, Color color, int x, int y, float alpha) {
        try {
            File file = new File(sourceImg);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setColor(color);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            int width_1 = fontSize * getLength(pressText);
            int height_1 = fontSize;
            int widthDiff = width - width_1;
            int heightDiff = height - height_1;
            if(x < 0){
                x = widthDiff / 2;
            }else if(x > widthDiff){
                x = widthDiff;
            }
            if(y < 0){
                y = heightDiff / 2;
            }else if(y > heightDiff){
                y = heightDiff;
            }
            g.drawString(pressText, x, y + height_1);
            g.dispose();
            ImageIO.write(bufferedImage, ConstantUtil.PICTRUE_FORMATE_JPG, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取字符长度，一个汉字作为 1 个字符, 一个英文字母作为 0.5 个字符
     * @param text
     * @return 字符长度，如：text="中国",返回 2；text="test",返回 2；text="中国ABC",返回 4.
*/
    public static int getLength(String text) {
        int textLength = text.length();
        int length = textLength;
        for (int i = 0; i < textLength; i++) {
            if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
                length++;
            }
        }
        return (length % 2 == 0) ? length / 2 : length / 2 + 1;
    }

    
    public static void modifyImagetogeter(String sourceImg,String targetImg,String newImg) {  
        try {  
        	File file = new File(sourceImg);
        	File targetFile = new File(targetImg);
        	File newFile = new File(newImg);
        	 BufferedImage image = ImageIO.read(file);
        	 BufferedImage targetImage = ImageIO.read(targetFile);
             BufferedImage b = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
             BufferedImage d = new BufferedImage(targetImage.getWidth(null), targetImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
            int w = b.getWidth();  
            int h = b.getHeight();  
            Graphics2D g  = d.createGraphics();  
            g.setColor(Color.WHITE);
            g.drawImage(b, 100, 10, w, h, null);  
            g.dispose();  
            ImageIO.write(d, "jpg", newFile);
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
  
    }  
    
    public static BufferedImage Merge(BufferedImage image1,BufferedImage image2, int posw, int posh) throws IOException {
    	  //合并两个图像
         // BufferedImage image2 = ImageIO.read(new File(targetImg));
          int w1 = image1.getWidth();
    	  int h1 = image1.getHeight();
    	  int w2 = image2.getWidth();
    	  int h2 = image2.getHeight();
    	  BufferedImage imageSaved = new BufferedImage(w1, h1, BufferedImage.TYPE_3BYTE_BGR);
    	  Graphics2D g2d = imageSaved.createGraphics();
    	  g2d.drawImage(image1, null, 0, 0);
    	  for (int i = 0; i < w2; i++) {
    	   for (int j = 0; j < h2; j++) {
    	    int _rgb1 = image1.getRGB(i + posw, j + posh);
    	    int _rgb2 = image2.getRGB(i, j);
    	    if (_rgb1 != _rgb2) {
    	     _rgb2 = _rgb1 & _rgb2;
    	    }
    	    imageSaved.setRGB(i + posw, j + posh, _rgb2);
    	   }
    	  }
    	 // ImageIO.write(imageSaved, "jpg", new File("D:\\baseTwoImg2.png"));
    	  return imageSaved;
   }
    /**
     * 获取空白图片 
    * 创 建 人：  Dp
    * 日     期：  2015年7月30日下午3:22:12
    * 描     述：
    * -----------------------------
    * 修 改 人： 
    * 日     期： 
    * 描     述： TODO(注明修改原因) 
    * -----------------------------
     */
    public static BufferedImage getBaseImg( int width, int height) throws IOException {
    	 BufferedImage whiteImage = new BufferedImage(300, 400, BufferedImage.TYPE_3BYTE_BGR);
	 	 Graphics2D g=whiteImage.createGraphics();
	 	 g.setColor(new Color(255, 255, 255));
		 g.fillRect(0,0,300,400);
		 g.drawImage(whiteImage, 0, 0, null);
		// ImageIO.write(whiteImage, "jpg", new File("D:\\baseTwoImg.png"));
    	 return whiteImage;
    }
    
    /**
     *  按具体值 缩放
    * 创 建 人：  Dp
    * 日     期：  2015年7月30日下午3:15:32
    * 描     述：
    * -----------------------------
    * 修 改 人： 
    * 日     期： 
    * 描     述：  
    * -----------------------------
     */
    public static void compressSize(int width, int height, String srcImgPath, String dstImgPath) {
		try {
			File source = new File(srcImgPath);
			BufferedImage sourceImage = ImageIO.read(source);
			BufferedImage dstImage = null;
			float wrate = (float) width / (float) sourceImage.getWidth();
			float hrate = (float) height/ (float) sourceImage.getHeight();
			float rate =  wrate < hrate ? wrate : hrate ;
			if (rate > 1) {
				rate = 1;
			}
			AffineTransform transform = AffineTransform.getScaleInstance(rate, rate);
			AffineTransformOp op = new AffineTransformOp(transform, null);
			dstImage = op.filter(sourceImage, null);
			ImageIO.write(dstImage, "jpg", new File(dstImgPath));
		} catch (Exception e) {
			
		}
	}
	
    /**
     * 按 比例缩放
    * 创 建 人：  Dp
    * 日     期：  2015年7月30日下午3:15:11
    * 描     述：
    * -----------------------------
    * 修 改 人： 
    * 日     期： 
    * 描     述：  
    * -----------------------------
     */
	public static void compressRateSize(float wrate, float hrate, String input, String output,String extension) {
		try {
			File source = new File(input);
			BufferedImage sourceImage = ImageIO.read(source);
			BufferedImage dstImage = null;
			AffineTransform transform = AffineTransform.getScaleInstance(wrate, hrate);
			AffineTransformOp op = new AffineTransformOp(transform, null);
			dstImage = op.filter(sourceImage, null);
			ImageIO.write(dstImage, extension, new File(output+"."+extension));
		} catch (Exception e) {
			
		}
	}
	
	public static boolean isImage(InputStream is){
		BufferedImage img = null;
		 try {
	            img = ImageIO.read(is);
	            if (img == null || img.getWidth(null) <= 0
	                    || img.getHeight(null) <= 0) {
	                return false;
	            }
	            return true;
	        } catch (Exception e) {
	            return false;
	        } finally {
	            if (is != null) {
	                try {
	                    is.close();
	                } catch (IOException e) {
	                }
	            }
	        }
	}
	
	public static boolean isImage(String filename){
		filename = filename.toLowerCase();
		if(filename.endsWith("jpg")){
			return true;
		}else if(filename.endsWith("jpeg")){
			return true;
		}else if(filename.endsWith("png")){
			return true;
		}else if(filename.endsWith("gif")){
			return true;
		}else if(filename.endsWith("bmp")){
			return true;
		}else if(filename.endsWith("tiff")){
			return true;
		}
		return false;
	}
	
	/**
	 * 创 建 人：  zhangyu
	 * 日     期：  2015年8月13日下午4:57:21
	 * 描     述：  设置数据中的url
	 * @param listobj
	 * @param key 保存url的key
	 * <br>-----------------------------<br>
	 * 修 改 人： 
	 * 日     期： 
	 * 描     述： (注明修改原因) 
	 * <br>-----------------------------<br>
	 */
	public static void setlistmapImaUrl(List<Map<String, Object>> listobj, String key){
		for (Map<String, Object> map : listobj) {
			Object urlobj = map.get(key);
			if (!CommonUtil.isEmpty(urlobj)) {
				String url = ImageUtils.getImageUrl(urlobj.toString());
				map.put("url",url);
			}
		}
	}
	
	 /**
     * 创 建 人：  zhangyu
     * 日     期：  2015年8月10日上午9:37:55
     * 描     述：  重新设置图片访问路径
     * @param imgRoot
     * @return
     * <br>-----------------------------<br>
     * 修 改 人： 
     * 日     期： 
     * 描     述： (注明修改原因) 
     * <br>-----------------------------<br>
     */
    public static String getImageUrl(Object imgRoot){
    	String url = null;
    	if (!CommonUtil.isEmpty(imgRoot)) {
    		//得到配置文件的图片图片服务器的地址
    		Object obj = CacheMapUtil.getConfigPropMap().get("imghost");
    		if (!CommonUtil.isEmpty(obj)) {
    			url = obj.toString();
    			url = url + "/" + imgRoot;
    		}
    	}
    	return url;
    }
    
    public static void main(String[] args) throws IOException, WriterException {
    	
    	//compressSize(200, 230, "d:/28737-105.jpg", "D:/123322.png");
		//compressRateSize(0.5f, 0.5f, "d:/28737-105.jpg", "D:/455555","png");
		
       // pressImage("d://28737-105.jpg", "d://baseTwoImg.png", 15, 10, 0.5f);
        //pressText("d://28737-105.jpg", "张三", "宋体", Font.BOLD|Font.ITALIC, 20, Color.BLACK, 30, 160, 0.8f);
    	
    	//BufferedImage whiteImage=getBaseImg(255,255);//生成一张白底图片

    	
    //	BufferedImage twoCodeImage = getBaseImg(100,100);//生成一张白底图片
		
		//BufferedImage twoCodeImageWhitBack= Merge(whiteImage,twoCodeImage,25,30);//二维码 带白底
		
    	
        
      //  resize("C://pic//4.jpg", 1000, 500, true);
    }
}
