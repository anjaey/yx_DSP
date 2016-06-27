package com.hy.util.common;

/**
 * 创 建 人：  schoff
 * 日     期： 2015年8月1日上午10:26:33
 * 描     述：排序 对象
 */
public class Order {

	private String param; 	// 排序参数
	private String rank;	// 倒序[desc]还是正序[null]
	
	/**
	 * 
	 * 创 建 人： schoff
	 * 日     期：  2015年8月1日上午10:31:55
	 * 描     述：构造方法[自定义排序方式 [倒序(desc)还是正序(null)]]
	 * @param rank					排序方式 [倒序(desc)还是正序(null)],倒序[desc]还是正序[null]
	 * @param param					排序的参数
	 */
	public Order(String rank, String param) {
		this.rank = rank;
		this.param = param;
	}
	
	/**
	 * 
	 * 创 建 人： schoff
	 * 日     期：  2015年8月1日上午10:31:24
	 * 描     述：构造方法[默认正序]
	 * @param param					排序的参数
	 */
	public Order(String param) {
		this.rank = null;
		this.param = param;
	}
	
	/**
	 * 
	 * 创 建 人： schoff
	 * 日     期：2015年8月1日上午10:35:09
	 * 描     述：返回[参数+排序方式 [倒序(desc)还是正序(null)]]
	 */
	public String toString() {
		String str = "";
		if (rank == null || rank.trim() == "") {
			rank = null;
		}
		if (param == null || param.trim() == "") {
			param = null;
		}
		
		if (rank != null && param != null) {
			str = " " + this.param.toString() + " " + this.rank.toString() + " ";
		}else if (param != null) {
			str = " " + this.param.toString();
		}else {
			str = null;
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(new Order("desc", "id").toString());
	}

	
}
