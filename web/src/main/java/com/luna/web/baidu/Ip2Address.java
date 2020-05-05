package com.luna.web.baidu;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author Luna@win10
 * @date 2020/4/26 13:02
 */
public class Ip2Address {

	/**
	 * 读取
	 *
	 * @param rd
	 * @return
	 * @throws IOException
	 */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * 创建链接
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = JSONObject.parseObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	/**
	 * 百度获取城市信息
	 *
	 * @param ip
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JSONException, IOException {
		String ip = "125.62.6.79";
		// 百度地图申请的ak
		String ak = "DezNcsGYMqUvMpB3d1DKlvejwHTtwIDo";
		// 这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
		JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ip="+ip+"&ak="+ak);
		System.out.println(json);
		//这里只取出了两个参数，根据自己需求去获取
		JSONObject obj = (JSONObject) ((JSONObject) json.get("content")).get("address_detail");
		String province = obj.getString("province");
		System.out.println(province);

		JSONObject obj2 = (JSONObject) json.get("content");
		String address = obj2.getString("address");
		System.out.println(address);
	}


}
