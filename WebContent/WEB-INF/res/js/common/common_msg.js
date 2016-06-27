
/**
 * 根据正则表达式验证，不合法的提示不合法。
 * 只针对于当前页面格式。
 * @param value 值
 * @param valueobj 值得JSON对象。传入 id  calss 名词
 * expression 表达式
 * @param title 当前字段名词
 * @returns {Boolean}
 */
function expression(value, valueobj , expression) {
	var bool = true;
	for (var i = 0; i < value.length; i ++) {
		var showMsgSpan = $(valueobj[i]).parent().find("span");
		if (expression[i]) {
			var patt1 = expression[i];
			var isTset = patt1.test(value[i]);
			if (!isTset) {
				showMsgSpan.html("输入不合法");
				bool = false;
			} else {
				showMsgSpan.html("输入正确");
			}
		} else {
			if (value[i] == "" || value[i] == undefined || value[i] == "undefined") {
				showMsgSpan.html("不能输入空值");
				bool = false;
			} else {
				showMsgSpan.html("输入正确");
			}
		}
	}
	return bool;
}

/**
 * 公共 验证 base
 * @param val 值
 * @param msgId 消息ID
 * @param required 是否必填（true、false），null不必填
 * @param showName 显示名称
 * @param minLength 最小长度，null不验证
 * @param maxLength 最大长度，null不验证
 * @param isNum 是否为数字（true、false），null为位符串
 * @returns {Boolean}
 */
function common_check_base1(val, msgId, required, showName, minLength, maxLength, isNum) {
	
	var result = true;
	var msg = "";
	
	try {
		
		if (val == undefined) {
			val = "";
		} else {
			val = $.trim(val);
		}
		
		// 为null，默认不必填
		if (required == null) {
			required = false;
		}
		
		// 为null，默认位符串
		if (isNum == null) {
			isNum = false;
		}
		
		if (val.length > 0) {
			if (minLength != null) {
				if (val.length < minLength) {
					throw showName + "小于" + minLength + "位";	
				}
			}
			if (maxLength != null) {
				if (val.length > maxLength) {
					throw showName + "大于" + maxLength + "位";
				}
			}
			if (isNum) {
				if (isNaN(val)) {
					throw showName + "不是数字";
				}
			}
		} else {
			if (required) {
				throw showName + "为空";
			}
		}
	} catch (e) {
		result = false;
		msg = e;
	} finally {}
	
	if (result) {
		$("#" + msgId).html("");
	} else {
		$("#" + msgId).html(msg);
	}
	return result;
}

/**
 * 公共 验证
 * @param valId 值ID
 * @param msgId 消息ID
 * @param required 是否必填（true、false），null不必填
 * @param showName 显示名称
 * @param minLength 最小长度，null不验证
 * @param maxLength 最大长度，null不验证
 * @param isNum 是否为数字（true、false），null为位符串
 * @returns {Boolean}
 */
function common_check_1(valId, msgId, required, showName, minLength, maxLength, isNum) {
	var val = $("#" + valId).val();
	var result = common_check_base(val, msgId, required, showName, minLength, maxLength, isNum);
	return result;
}

/**
 * 公共 验证
 * @param valName 值NAME
 * @param msgId 消息ID
 * @param required 是否必填（true、false），null不必填
 * @param showName 显示名称
 * @param minLength 最小长度，null不验证
 * @param maxLength 最大长度，null不验证
 * @param isNum 是否为数字（true、false），null为位符串
 * @returns {Boolean}
 */
function common_check_2(valName, msgId, required, showName, minLength, maxLength, isNum) {
	var val = $("input[name='" + valName + "']:checked").val();
	var result = common_check_base(val, msgId, required, showName, minLength, maxLength, isNum);
	return result;
}

/**
 * 公共 验证 base
 * @param val 值
 * @param msgId 消息ID
 * @param required 是否必填（true、false），null不必填
 * @param showName 显示名称
 * @param minLength 最小长度，null不验证
 * @param maxLength 最大长度，null不验证
 * @param isNum 是否为数字（true、false），null为位符串
 * @returns {Boolean}
 */
function common_check_base(val, msgId, required, showName, minLength, maxLength, isNum) {
	
	var result = true;
	var msg = "";
	
	try {
		
		if (val == undefined) {
			val = "";
		} else {
			val = $.trim(val);
		}
		
		// 为null，默认不必填
		if (required == null) {
			required = false;
		}
		
		// 为null，默认位符串
		if (isNum == null) {
			isNum = false;
		}
		
		if (val.length > 0) {
			if (minLength != null) {
				if (val.length < minLength) {
					throw showName + "小于" + minLength + "位";	
				}
			}
			if (maxLength != null) {
				if (val.length > maxLength) {
					throw showName + "大于" + maxLength + "位";
				}
			}
			if (isNum) {
				if (isNaN(val)) {
					throw showName + "不是数字";
				}
			}
		} else {
			if (required) {
				throw showName + "为空";
			}
		}
	} catch (e) {
		result = false;
		msg = e;
	} finally {}
	
	if (result) {
		$("#" + msgId).html("");
	} else {
		$("#" + msgId).html(msg);
	}
	return result;
}


/**
 * 公共 展示
 */
function common_show_msg(msgMap, msgKey, msgId) {
	var msg = msgMap[msgKey];
	var msg_obj = $("#" + msgId);
	if (msg != undefined) {
		msg_obj.html(msg);
	} else {
		msg_obj.html("");
	}
}

