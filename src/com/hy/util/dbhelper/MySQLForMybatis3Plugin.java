package com.hy.util.dbhelper;
import java.util.List;  

import org.mybatis.generator.api.CommentGenerator;  
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;  
import org.mybatis.generator.api.PluginAdapter;  
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;  
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;  
import org.mybatis.generator.api.dom.java.Method;  
import org.mybatis.generator.api.dom.java.Parameter;  
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;  
import org.mybatis.generator.api.dom.java.TopLevelClass;  
import org.mybatis.generator.api.dom.xml.Attribute;  
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;  
import org.mybatis.generator.api.dom.xml.XmlElement;  
  
/**
 * 功能</br />
 * <ul>
 * <li>1.生成分页语句,查询时可以分页,用Criteria进行设置</li>
 * <li>2.插入实体时返回生成的主键值,生成的主键值,在你插入的那个实体自动注入,如:insert(TextEntity), TextEntity.getId(),即可拿到</li>
 * <li>3.增加selectByExampleForOne方法,通用任何条件查询单个实体数据</li>
 * </ul>
 * 
 * @version 1.0
 */
public class MySQLForMybatis3Plugin extends PluginAdapter {  
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,  
            IntrospectedTable introspectedTable) {  
        // add field, getter, setter for limit clause  
        addLimit(topLevelClass, introspectedTable, "limitStart");  
        addLimit(topLevelClass, introspectedTable, "limitEnd");  
        return super.modelExampleClassGenerated(topLevelClass,  
                introspectedTable);  
    }  
    @Override  
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(  
            XmlElement element, IntrospectedTable introspectedTable) {  
//      XmlElement isParameterPresenteElemen = (XmlElement) element  
//              .getElements().get(element.getElements().size() - 1);  
        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$  
        isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitStart>=0")); //$NON-NLS-1$ //$NON-NLS-2$  
//      isNotNullElement.addAttribute(new Attribute("compareValue", "0")); //$NON-NLS-1$ //$NON-NLS-2$  
        isNotNullElement.addElement(new TextElement(  
                "limit #{limitStart} , #{limitEnd}"));  
//      isParameterPresenteElemen.addElement(isNotNullElement);  
        element.addElement(isNotNullElement);  
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,  
                introspectedTable);  
    }
    
    // change to return the primaryKey to the Enity for insert element
    @Override
	public boolean sqlMapInsertElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
    	String primaryKeyType = getPrimaryKeyType(introspectedTable);
    	System.err.println(primaryKeyType);
    	if (!"java.lang.String".equals(primaryKeyType)) {
    		XmlElement isNotNullElement = new XmlElement("selectKey"); //$NON-NLS-1$  
    		isNotNullElement.addAttribute(new Attribute("resultType", primaryKeyType)); //$NON-NLS-1$ //$NON-NLS-2$  
    		isNotNullElement.addAttribute(new Attribute("order", "AFTER")); //$NON-NLS-1$ //$NON-NLS-2$  
    		isNotNullElement.addAttribute(new Attribute("keyProperty", "id")); //$NON-NLS-1$ //$NON-NLS-2$  
    		isNotNullElement.addElement(new TextElement("SELECT LAST_INSERT_ID()"));  
    		element.addElement(isNotNullElement);
		}
		return super.sqlMapInsertElementGenerated(element, introspectedTable);
	}
    
    
 // change to return the primaryKey to the Enity for insert selective element
	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		String primaryKeyType = getPrimaryKeyType(introspectedTable);
		if (!"java.lang.String".equals(primaryKeyType)) {
			XmlElement isNotNullElement = new XmlElement("selectKey"); //$NON-NLS-1$  
			isNotNullElement.addAttribute(new Attribute("resultType", primaryKeyType)); //$NON-NLS-1$ //$NON-NLS-2$  
			isNotNullElement.addAttribute(new Attribute("order", "AFTER")); //$NON-NLS-1$ //$NON-NLS-2$  
			isNotNullElement.addAttribute(new Attribute("keyProperty", "id")); //$NON-NLS-1$ //$NON-NLS-2$  
			isNotNullElement.addElement(new TextElement("SELECT LAST_INSERT_ID()"));  
			element.addElement(isNotNullElement);
		}
		return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
	}
	
	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String name = "example";
		Method method = new Method("selectByExampleForOne");
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getExampleType()), name));
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
		interfaze.addMethod(method);
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	
	// add the new Element for mapper.xml, use to add a new Function
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement rootElement = document.getRootElement();
		
		XmlElement selectOne = new XmlElement("select");
		selectOne.addAttribute(new Attribute("id", "selectByExampleForOne"));
		selectOne.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		selectOne.addAttribute(new Attribute("parameterType", "java.lang.Integer"));
		selectOne.addElement(new TextElement("select"));
		
		// distinct
		XmlElement ifOne = new XmlElement("if");
		ifOne.addAttribute(new Attribute("test", "distinct"));
		ifOne.addElement(new TextElement("distinct"));
		selectOne.addElement(ifOne);
		
		// include Base_Column_List
		XmlElement includeXml = new XmlElement("include");
		includeXml.addAttribute(new Attribute("refid", "Base_Column_List"));
		selectOne.addElement(includeXml);
		
		// text table
		selectOne.addElement(new TextElement("from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));

		// _parameter
		XmlElement ifTwo = new XmlElement("if");
		ifTwo.addAttribute(new Attribute("test", "_parameter != null"));
		
		XmlElement includeRefXml = new XmlElement("include");
		includeRefXml.addAttribute(new Attribute("refid", "Example_Where_Clause"));
		ifTwo.addElement(includeRefXml);
		
		selectOne.addElement(ifTwo);
		
		// orderByClause
		XmlElement ifThree = new XmlElement("if");
		ifThree.addAttribute(new Attribute("test", "orderByClause != null"));
		ifThree.addElement(new TextElement("order by ${orderByClause}"));
		selectOne.addElement(ifThree);
		
		rootElement.addElement(selectOne);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
	private void addLimit(TopLevelClass topLevelClass,  
            IntrospectedTable introspectedTable, String name) {  
        CommentGenerator commentGenerator = context.getCommentGenerator();  
        Field field = new Field();  
        field.setVisibility(JavaVisibility.PROTECTED);  
//      field.setType(FullyQualifiedJavaType.getIntInstance());  
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());  
        field.setName(name);  
//      field.setInitializationString("-1");  
        commentGenerator.addFieldComment(field, introspectedTable);  
        topLevelClass.addField(field);  
        char c = name.charAt(0);  
        String camel = Character.toUpperCase(c) + name.substring(1);  
        Method method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setName("set" + camel);  
        method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));  
        method.addBodyLine("this." + name + "=" + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
        method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());  
        method.setName("get" + camel);  
        method.addBodyLine("return " + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
    }  
    /** 
     * This plugin is always valid - no properties are required 
     */  
    public boolean validate(List<String> warnings) {  
        return true;  
    }  
    
    public static void generate() {  
        String config = ClassLoader.getSystemResource(
                "config/db/mybatis/MyBatisCodeGenerator.xml").getFile();  
        String[] arg = { "-configfile", config, "-overwrite" };  
        ShellRunner.main(arg);
    }  
    
    public static void main(String[] args) {  
        generate();
    }
    
    public String getPrimaryKeyType(IntrospectedTable introspectedTable) {
    	String reType = "java.lang.Integer";
    	List<IntrospectedColumn> primaryKeyColumnList = introspectedTable.getPrimaryKeyColumns();
    	if (primaryKeyColumnList != null && primaryKeyColumnList.size() > 0) {
    		IntrospectedColumn introspectedColumn = primaryKeyColumnList.get(0);
    		reType = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();
    	}
    	
    	return reType;
    }
  
}  