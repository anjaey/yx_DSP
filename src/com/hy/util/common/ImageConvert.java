package com.hy.util.common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩工具类 提供的方法中可以设定生成的 缩略图片的大小尺寸等
 */
public class ImageConvert {
	private static Log log = LogFactory.getLog(ImageConvert.class);

	private static BufferedImage InputImage(String srcImgPath) {
		BufferedImage srcImage = null;
		try {
			FileInputStream in = new FileInputStream(srcImgPath);
			srcImage = ImageIO.read(in);
		} catch (IOException e) {
			log.error("读取图片文件出错！" + e.getMessage());
			e.printStackTrace();
		}
		return srcImage;
	}

	/**
	 * 按宽度进行等比压缩。方法可设置flag来判断在实际宽度小于所传宽度时是否时进行图片处理
	 * 
	 * @param srcImgPath
	 * @param outImgPath
	 * @param maxLength
	 * @param flag
	 *            boolean类型，true:如果图片宽度大于传来的压缩宽度，则压缩，否则不压缩；false：不作比较，全部按传来的尺寸压缩
	 * @return
	 */
	public static boolean compressImage(String srcImgPath, String outImgPath,
			int maxLength, boolean flag) {
		boolean status = false;
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		if (null != src) {
			int old_w = src.getWidth();
			// 得到源图宽
			int old_h = src.getHeight();
			// 得到源图长
			int new_w = 0;
			// 新图的宽
			int new_h = 0;

			/* 原宽大于新宽时一定压缩，小于新宽时按flag判断是否需要压缩 */
			if ((!flag) || (flag && old_w > maxLength)) {
				// 根据图片尺寸压缩比得到新图的尺寸
				if (old_w > old_h) {
					// 图片要缩放的比例
					new_w = maxLength;
					new_h = (int) Math.round(old_h
							* ((float) maxLength / old_w));
				} else {
					new_w = (int) Math.round(old_w
							* ((float) maxLength / old_h));
					new_h = maxLength;
				}
				status = disposeImage(src, outImgPath, new_w, new_h);
			} else {
				status = true;
			}
		}
		return status;
	}

	private static boolean disposeImage(BufferedImage src, String outImgPath,
			int new_w, int new_h) {
		boolean flag = false;
		int old_w = src.getWidth();
		int old_h = src.getHeight();
		BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		// 判断输入图片的类型
		
		//以下注释与2015-8-27
//		switch (src.getType()) {
//		case 13:
//			// png,gifnewImg = new BufferedImage(new_w, new_h,
//			// BufferedImage.TYPE_4BYTE_ABGR);
//			break;
//		default:
//			tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
//			break;
//		}
		//结束
		
		
		
		Graphics2D g = tag.createGraphics();
		// 从原图上取颜色绘制新图
		g.drawImage(src, 0, 0, old_w, old_h, null);
		g.dispose();
		// 根据图片尺寸压缩比得到新图的尺寸
		tag.getGraphics().drawImage(
				src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0,
				null);
		try {
			FileOutputStream newimage = new FileOutputStream(outImgPath); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			jep.setQuality(1f, true);
			encoder.encode(tag, jep);
			newimage.close();
			flag = true;
		} catch (IOException e) {
			log.error("ImageConvert处理图片失败！", e);
		}
		return flag;
	}

}
