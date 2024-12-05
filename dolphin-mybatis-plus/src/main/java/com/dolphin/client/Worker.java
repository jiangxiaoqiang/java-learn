package com.dolphin.client;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Worker {
    public static void main(String[] args) throws UnknownHostException {
        getDataCenterId();
    }

    public static Long getDataCenterId() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        int[] ints = StringUtils.toCodePoints(hostName);
        int sums = 0;
        for (int i : ints) {
            sums += i;
        }
        return (long) (sums % 32);
    }

}
