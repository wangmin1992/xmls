package com.wang.xml;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * 使用JDOM操作XML（可扩展标记语言）。
 * @author wangmin
 * @since 2017年4月6日-下午1:51:07
 * @version V1.0
 */
public class JDOMReaderXml {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) 
	{
		try 
		{
			URL url = DOMReaderXml.class.getResource("/base.xml");
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File(url.getFile()));
			//获取根节点
			Element ele = doc.getRootElement();
			List list = ele.getChildren();
			for (int i = 0 ; i < list.size() ; i++)
			{
				System.out.println("号码牌：" + ((Element)list.get(i)).getChild("no").getText());
				System.out.println("地址：" + ((Element)list.get(i)).getChild("address").getText());
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
