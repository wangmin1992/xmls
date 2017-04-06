package com.wang.xml;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * 使用DOM操作XML（可扩展标记语言）。
 * @author wangmin
 * @since 2017年4月6日-下午1:49:59
 * @version V1.0
 */
public class DOMReaderXml {

	public static void main(String[] args) {
		try 
		{
			URL url = DOMReaderXml.class.getResource("/base.xml");
			File file = new File(url.getFile());
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList list = doc.getElementsByTagName("value");
			for (int i = 0 ; i < list.getLength() ; i++)
			{
				System.out.println("号码牌：" + doc.getElementsByTagName("no").item(i).getFirstChild().getNodeValue());
				System.out.println("地址：" + doc.getElementsByTagName("address").item(i).getFirstChild().getNodeValue());
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
