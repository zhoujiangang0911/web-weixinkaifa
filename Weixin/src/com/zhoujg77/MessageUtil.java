package com.zhoujg77;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.zhoujg77.model.News;
import com.zhoujg77.model.NewsMessage;
import com.zhoujg77.model.TextMessage;

public class MessageUtil {
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IAMGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	
	
	
	
	/**
	 * xml转化map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String, String>();
		
		SAXReader reader = new SAXReader();
		
			InputStream ins = request.getInputStream();
			Document doc = reader.read(ins);
			
			Element root = doc.getRootElement();
			
			List<Element> list = root.elements();
			
			
			for(Element e:list){
				map.put(e.getName(), e.getText());
				
			}	
			ins.close();
			return map;
	}
	
	
	/**
	 * 对象转xml
	 * @param text
	 * @return
	 */
	public static String textMessageToXml(TextMessage text){
		XStream xStream = new XStream();
		xStream.alias("xml", text.getClass());
		return xStream.toXML(text);
	}
	
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent(content);
		return  textMessageToXml(text);
	}
	
	
	/**主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎你的关注:\n\n");
		sb.append("1.关于我\n\n");
		sb.append("2.最新消息\n\n");
		sb.append("回复？调出此菜单！\n");
		return sb.toString();
	}
	
	/**主菜单1
	 * @return
	 */
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎你的关注asdasdadsasda:\n\n");
		return sb.toString();
	}
	
	/**主菜单2
	 * @return
	 */
	public static String SencondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎你的关asdf注:\n\n");
		return sb.toString();
	}
	
	
	/**
	 * 图文消息转xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item", new News().getClass());
		return xStream.toXML(newsMessage);
	}
	
	
	/**图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("我的介绍");
		news.setDescription("testststststst");
		news.setPicUrl("http://zhoujiangang0911.tunnel.mobi/Weixin/a.png");
		news.setUrl("https://github.com/zhoujiangang0911");
		
		newsList.add(news);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime()+"");
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage); 
		return message;
	}
	
	
	
}
