package com.liuzhenhui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

public class MessageUtils {
	
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	
	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	
	/**
	 * 事件类型：SCAN(扫码)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单事件-点击菜单拉取消息时的事件推送)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(自定义菜单事件-点击菜单跳转链接时的事件推送)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

	/**
	 * 事件推送
	 */
	public static final String TEMPLATE_SEND_JOB_FINISH = "TEMPLATESENDJOBFINISH";

	/**
	 * 多客服
	 */
	public static final String TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";

	/**
	 * 多客服接入
	 */
	public static final String KF_CREATE_SESSION = "kf_create_session";

	/**
	 * 多客服关闭
	 */
	public static final String KF_CLOSE_SESSION = "kf_close_session";

	/**
	 * 多客服手动关闭
	 */
	public static final String KF_CLOSE_TYPE = "KF";

	/**
	 * 多客服退出关闭
	 */
	public static final String LOGOUT_CLOSE_TYPE = "LOGOUT";

	/**
	 * 超时退出关闭
	 */
	public static final String TIMEOUT_CLOSE_TYPE = "TIMEOUT";

	/**
	 * 将xml转换为map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String>  xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<>();
		SAXReader saxReader = new SAXReader();
		InputStream inputStream = request.getInputStream();
		Document document = saxReader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elements = root.elements();
		for (Element element : elements) {
			map.put(element.getName(), element.getText());
		}
		inputStream.close();
		return map;
	}
	
	public static String objectToXml(BaseMessage message){
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		return xStream.toXML(message);
	}
	
}
