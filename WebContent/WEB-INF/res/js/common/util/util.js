/**
 *	--------数据操作类 
 * 	主要包括对页面数据的获取
 * 	以及其他公共方法
 * 
 */
$.util = {
		//根据class name 获取选中的checkedbox, 返回选中的list
		getCheckedBox : function (checkboxClassName) {  
			var checkboxArray = [];
			var checkboxs = $("." + checkboxClassName + ":checked");
			for (var i = 0; i < checkboxs.length; i ++ ) {
				checkboxArray[i] = checkboxs[i].value;
			}
			return checkboxArray;
		}
}
