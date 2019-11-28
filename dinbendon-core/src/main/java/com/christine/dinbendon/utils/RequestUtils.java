package com.christine.dinbendon.utils;

import com.christine.dinbendon.model.po.Member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
public class RequestUtils {

	public static final String SESSION_LOGIN_ATTR = "account";

	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getRemoteAddr();
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public static String getFisrtRemoteHost(HttpServletRequest request) {
		String ip = getRemoteHost(request);
		if (ip != null) {
			String[] array = ip.split(",");
			if (array.length > 0) {
				ip = array[0];
			}
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	public static Member getSessoinAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member acc = (Member) session.getAttribute(SESSION_LOGIN_ATTR);
		return acc;
	}
}
