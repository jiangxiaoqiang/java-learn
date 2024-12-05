package com.dolphin.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class IpConstant {
    private static String HOST_ADDRESS_IP;


    public static String getHostAddressIp() {
        return HOST_ADDRESS_IP;
    }


    static {
        try {
            InetAddress address = InetAddress.getLocalHost();
            HOST_ADDRESS_IP = address.getHostAddress();
        } catch (UnknownHostException e) {
        }
    }

    /**
     *
     * @return
     * @throws UnknownHostException
     */
    public static long makeWorkerId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ips = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int ip : ips) {
                sums += ip;
            }
            long workId = (sums % 32);
            return workId;
        } catch (UnknownHostException e) {
            // 如果获取失败，则使用随机数备用
            return RandomUtils.nextLong(0, 31);
        }
    }

    public static Long getDataCenterId() {
        String hostName;
        try {
            hostName =InetAddress.getLocalHost().getHostName();
        } catch (Exception e){
            hostName = "127.0.0.1";
        }
        int[] ints = StringUtils.toCodePoints(hostName);
        int sums = 0;
        for (int i : ints) {
            sums += i;
        }
        return (long) (sums % 32);
    }
}
