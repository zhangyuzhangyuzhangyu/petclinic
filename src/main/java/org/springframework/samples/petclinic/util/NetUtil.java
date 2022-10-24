package org.springframework.samples.petclinic.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author: zhangyu
 * @date: 2022/10/22 22:08
 **/
public class NetUtil {
	/**
	 * 获取本机ipv4地址
	 * catch所有异常，异常返回""
	 * @return
	 */
	public static String getLocalIp(){

		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			NetworkInterface networkInterface;
			Enumeration<InetAddress> inetAddresses;
			InetAddress inetAddress;
			while (networkInterfaces.hasMoreElements()) {
				networkInterface = networkInterfaces.nextElement();
				inetAddresses = networkInterface.getInetAddresses();
				while (inetAddresses.hasMoreElements()) {
					inetAddress = inetAddresses.nextElement();
					if (inetAddress != null && inetAddress instanceof Inet4Address) {
						String ip = inetAddress.getHostAddress();
						if(!"127.0.0.1".equals(ip)){
							return ip;
						}
					}
				}
			}
			return "";
		}catch (Exception e){
			e.printStackTrace();
			return "";
		}

	}
}
