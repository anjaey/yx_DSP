package com.hy.util.common;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
 
/**
 * @className:PinyingUtil.java
 * @classDescription:拼音操作工具类
 * @author:邓鹏
 */
 
public class PingYinUtil {
 
    /**
     * 将字符串转换成拼音数组
     * 默认全小写
     * 
     * @param src
     * @return 返回String
     */
    public static String[] getPinyin(String src) {
        return getPinyin(src, false);
    }
 
    /**
     * 将字符串转换成拼音数组
     * 
     * @param src
     * @param isCapital 是否大写
     * @return 返回String
     */
    public static String[] getPinyin(String src, boolean isCapital) {
        // 判断字符串是否为空
        if ("".equals(src) || null == src) {
            return null;
        }
        char[] srcChar = src.toCharArray();
        int srcCount = srcChar.length;
        String[] srcStr = new String[srcCount];
 
        for (int i = 0; i < srcCount; i++) {
            srcStr[i] = charToPinyin(srcChar[i], isCapital);
        }
        return srcStr;
    }
    
    /**
     * 转换成拼音 字符串  默认小写
     * @param src
     * @return 返回String
     */
    public static String getPinyinStr(String src) {
    	return getPinyinStr(src,false);
    }
 
    /**
     *  转换成拼音 字符串 
     * @param src
     * @param isCapital 是否大写
     * @return 返回String
     */
    public static String getPinyinStr(String src, boolean isCapital) {
    	// 判断字符串是否为空
    	if ("".equals(src) || null == src) {
    		return null;
    	}
    	char[] srcChar = src.toCharArray();
    	int srcCount = srcChar.length;
    	StringBuilder srcStr = new StringBuilder();
    	for (int i = 0; i < srcCount; i++) {
    		srcStr.append(charToPinyin(srcChar[i], isCapital));
    	}
    	return srcStr.toString();
    }
    
    
    /**
     * 将单个字符转换成拼音
     * 
     * @param src
     * @param  默认小写
     * @return 返回String
     */
    public static String charToPinyin(char src){
    	return charToPinyin(src,false);
    }
    
    
    /**
     * 将单个字符转换成拼音
     * 
     * @param src
     * @param isCapital 是否大小写
     * @return 返回String
     */
    public static String charToPinyin(char src, boolean isCapital) {
        // 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuffer tempPinying = new StringBuffer();
        // 如果是中文
        if (src > 128) {
            try {
                // 转换得出结果
                String[] strs = PinyinHelper.toHanyuPinyinStringArray(src,defaultFormat);
                if(isCapital){
                	tempPinying.append(strs[0].toUpperCase());
                }else{
                	tempPinying.append(strs[0]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            tempPinying.append(src);
        }
        return tempPinying.toString();
 
    }
 
 
    /**
     * 取汉字的首字母(默认是小写)
     * @param src
     * @return 返回char 数组
     */
    public static char[]  getFirstSpellByChar(char src){
        return getFirstSpellByChar(src,false);
    }
  
    
    /**
     * 取汉字的首字母
     * @param src
     * @param isCapital 是否是大写
     * @return 返回char 数组
     */
    public static char[]  getFirstSpellByChar(char src,boolean isCapital){
        //如果不是汉字直接返回
        if (src <= 128) {
            return new char[]{src};
        }
    	HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		 char [] headChars=null;
	        //获取所有的拼音
	        String[] pinyingStr=null;
	        try {
				pinyingStr = PinyinHelper.toHanyuPinyinStringArray(src,defaultFormat);
				headChars =new char[pinyingStr.length];
	        } catch (BadHanyuPinyinOutputFormatCombination e) {
	        	e.printStackTrace();
	        }
	        //创建返回对象
	        int i=0;
	        //截取首字符
	        for(String s:pinyingStr){
	            char headChar=s.charAt(0);
	            //首字母是否大写，默认是小写
	            if(isCapital){
	                headChars[i]=Character.toUpperCase(headChar);
	             }else{
	                headChars[i]=headChar;
	             }
	            i++;
	        }
        return headChars;
    }
  
    
    /**
     * 查找字符串首字母
     * @param src 
     * @return 返回String 数组
     */
    public  static String[] getFirstSpellByString(String src){
        return getFirstSpellByString( src, true);
    }
  
    
    /**
     * 获取首字母 
     * @param src 
     * @param isCapital 是否大写
     * @param separator 分隔符
     * @return 返回String 数组
     */
    public  static String[] getFirstSpellByString(String src,boolean isCapital){
    	if ("".equals(src) || null == src) {
    		return null;
    	}
        char[]chars=src.toCharArray();
        String[] headString=new String[chars.length];
        int i=0;
        for(char ch:chars){
            char[]chs=getFirstSpellByChar(ch,isCapital);
            StringBuffer sb=new StringBuffer();
            sb.append(chs[0]);
            headString[i]=sb.toString();
            i++;
        }
        return headString;
    }
    
    
    /**
     * 获取首字母 默认返回小写
     * @param src
     * @return  返回String
     */
    public  static String getFirstSpellStr(String src){
    	return getFirstSpellStr(src,false);
    }
   
    
    /**
     *  获取首字母 并返回大写
     * @param src 
     * @param isCapital 是否返回大写
     * @return  返回String
     */
    public  static String getFirstSpellStr(String src,boolean isCapital){
    	if ("".equals(src) || null == src) {
    		return null;
    	}
    	char[]chars=src.toCharArray();
    	StringBuffer sbf=new StringBuffer();
    	for(char ch:chars){
    		char[]chs=getFirstSpellByChar(ch,isCapital);
    		sbf.append(chs[0]);
    	}
    	return sbf.toString();
    }
     
    public static void main(String[] args) {
        //将字符串转换成拼音数组
    	System.out.println("我是重庆人");
        System.out.println(getPinyinStr("曹顺写爪哇===="));
         
        //将字符串转换成拼音数组,以逗号分隔
        String test2[]=getPinyin("我是重庆人");
        String test2st="";
        for(int i=0;i<test2.length;i++){
            test2st+=test2[i];
        }
        System.out.println(test2st);
        String kk[] =getFirstSpellByString("我是重庆人", true);
        System.out.println(kk.length);
        System.out.println(getFirstSpellStr("我是重庆人"));
    }
 
}