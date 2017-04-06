package com.wang.xml;

import java.io.File;
import java.net.URL;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 使用SAX操作xml（可扩展标记语言）。
 * @author wangmin
 * @since 2017年4月6日-下午1:48:49
 * @version V1.0
 */
public class SAXReaderXml extends DefaultHandler{

	@SuppressWarnings("rawtypes")
	Stack tags = new Stack();
	
	public SAXReaderXml() 
	{
		super();
	}
	
	public static void main(String[] args) {
		try 
		{
			URL url = DOMReaderXml.class.getResource("/base.xml");
			File file = new File(url.getFile());
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser sp = factory.newSAXParser();
			SAXReaderXml readerXml = new SAXReaderXml();
			sp.parse(file, readerXml);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void charactor(char[] ch, int start, int length)
	{
		String tag = (String)tags.peek();
		if ("no".equals(tag))
		{
			System.out.println("号码牌：" + new String(ch, start, length));
		}
		if ("address".equals(tag))
		{
			System.out.println("地址：" + new String(ch, start, length));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void startElement(String uri,String localName,String qName,Attributes attrs)
	{
		tags.push(qName);
	}
}
