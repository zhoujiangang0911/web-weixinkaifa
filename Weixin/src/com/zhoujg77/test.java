package com.zhoujg77;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.thoughtworks.xstream.XStream;
import com.zhoujg77.model.AccessToken;

public class test {
	public static void main(String[] args) {
		AccessToken accessToken = new AccessToken();
		
		accessToken = WeixinUtil.getAccessToken();
		System.out.println("票据："+accessToken.getToken());
		System.out.println("有效时间："+accessToken.getExpiresIn());
		try {
			String path ="D:/a.png";
			//String mediaId = WeixinUtil.upload(path, accessToken.getToken(), "image");
			JSONObject mediaId = WeixinUtil.send("image", path, accessToken.getToken());
			
			System.out.println(mediaId);
			
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
