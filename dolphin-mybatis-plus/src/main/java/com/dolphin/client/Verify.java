package com.dolphin.client;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import java.util.LinkedHashMap;

public class Verify {
    public static void main(String[] args) throws AlipayApiException {
        //回调的待验签字符串
        String resultInfo = "notify_time=2024-05-05+14%3A41%3A35&notify_type=trade_status_sync&notify_id=2024050501222111427023281450981703&charset=UTF-8&version=1.0&sign_type=RSA2&sign=wmwMKx6PRFuqSFpZNhIjHckog7r7bneVjbCaHMddTKIDhfZwwnfk7JIC9NOWDjgfRLiw5dEJT5XNuyUnboieW5sLerRh1p4%2BxYVlJXuX5LTuySN3qc1Xhvr7I%2FLgU875%2BwQQEJ5RHQiggRRUXfZMgvdPMUy5T45Xp66DrdfdsIFsDWC1h8TQqjaZqMPkp7UEFSDcovqzCRWnC2tvArxqGNFw13qaUH8PurYxJol3TLDCwv%2FpgZWB3y4rnsmwPTNiDfCXbROjEPP0weeI3dg4i7c8EMj9SEM%2B5Q5VF4fCCA%2BfX9yEBBm6PPpAaQVTNZPAm2lJQmSdtiu0rXpVjyGb3w%3D%3D&auth_app_id=2021004119642155&trade_no=2024050522001423281419923118&app_id=2021004119642155&out_trade_no=629516539825098752&buyer_id=2088402558023287&seller_id=2088541899098320&trade_status=TRADE_SUCCESS&total_amount=0.01&receipt_amount=0.01&invoice_amount=0.01&buyer_pay_amount=0.01&point_amount=0.0&subject=TeXHub%E4%BC%9A%E5%91%981%E5%A4%A9&gmt_create=2024-05-05+11%3A14%3A19&gmt_payment=2024-05-05+11%3A14%3A26&fund_bill_list=%5B%7B%22amount%22%3A%220.01%22%2C%22fundChannel%22%3A%22ALIPAYACCOUNT%22%7D%5D";
        //编码格式



        String charset="utf-8";
        //支付宝公钥
        String alipaypublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5K2M8ffEfzc1NtWXUd+R1xkh8tCQlGMGM/jax1vLoD08GqKmBiJ4R7A5VqapO9iNd7QB1jpcPdKVa1TcIhaJrm+YJgLKV/RMC396Mt36LwtJae+glhFtv1gCQPfapZPzRr9fLReJK2PjuPDvN6VWqjP7f82gKmpaqqKZiZGrdy8A6k7gmI+3ZPHCRnQjCUg6h5thiV1n1CF9d9ZczoBtHt/S2eeZy9YpXTU7GQJMgNG6QP9m+TvQ9E6HXDjce/hn3kJNcY3TX/N3R0KU3aikzAg9fDI/aq9LZ2ojt59YZWSzb7gmmYIeHsalEO8nDdcFObUxQUzCm0ZeD9RC3TSidwIDAQAB";
        //签名方式
        String sign_type="RSA2";
        //对待签名字符串数据通过&进行拆分
        String [] temp = resultInfo.split("&");
        LinkedHashMap<String, String> map =  new LinkedHashMap<String, String>();
        //把拆分数据放在map集合内
        for (int i = 0; i < temp.length; i++) {
            String[] arr = temp[i].split("=", 2); //通过"="号分割成2个数据
            String[] tempAagin = new String[arr.length]; //再开辟一个数组用来接收分割后的数据
            for (int j = 0; j < arr.length; j++) {
                tempAagin[j] = arr[j];
            }
            map.put(tempAagin[0], tempAagin[1]);
        }



        System.out.println(map);
        //验签方法
        boolean signVerified = AlipaySignature.rsaCheckV1(map,alipaypublicKey,charset,sign_type);
        if(signVerified){
            // TODO 验签成功后
            System.out.println("success");
            return;

        }else{
            System.out.println("fail");
        }
    }
}
