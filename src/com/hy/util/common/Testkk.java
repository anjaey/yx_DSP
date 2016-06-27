package com.hy.util.common;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class Testkk implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env,
			@SuppressWarnings("rawtypes") 
			Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
	}

}
