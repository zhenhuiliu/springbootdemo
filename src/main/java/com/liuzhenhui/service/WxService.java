package com.liuzhenhui.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liuzhenhui.utils.HttpClientUtil;
import com.liuzhenhui.utils.WeixinConstants;
import com.liuzhenhui.web.WeiXinController;

public class WxService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeiXinController.class);
	
	public static String createQRCode(String accessToken,String content){
		logger.info("geta服务createQrcode请求参数 accessToken:{},sence:{}", accessToken, content);
		StringBuilder sb = new StringBuilder(WeixinConstants.qrcodeUrl);
		sb.append(accessToken);
		String result = HttpClientUtil.sendPost(sb.toString(), content);
		logger.info("geta服务createQrcode 返回结果:{}", result);
		return result;
	}
	
	/**
	 * 获取accessToken
	 */
	public static String getAccessToken(String lfappid, String lfappsecret) {
		logger.info("geta服务getAccessToken请求参数 appid:{},appsecret:{}", lfappid, lfappsecret);
		StringBuilder sb = new StringBuilder();
		sb.append("grant_type=").append("client_credential").append("&appid=").append(lfappid).append("&secret=")
				.append(lfappsecret);
		String content = HttpClientUtil.sendGet(WeixinConstants.tokenUrl, sb.toString());
		logger.info("geta服务getAccessToken 返回结果:{}", content);
		return content;
	}

	public static void main(String[] args) {
//		String result = getAccessToken(WeixinConstants.appId, WeixinConstants.appsecret);
//		System.out.println(result);
		String content = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"sfgerjgreu\"}}}";
		System.out.println(content);
		String result = createQRCode("KtDv7gSNPWPl_Fur26mQt-UlcIyIAbsXQX7aRrZcq-8oRrwhWWgizinCPmV6DUfT2Azg2d52gD67kg8g4zK4Nlb3l_ugsklRsNIhOCItcWLqj0eevBOV7yVA3Ws1M8TJZGWeAAAHOE",content);
		System.out.println(result);
	}

}
