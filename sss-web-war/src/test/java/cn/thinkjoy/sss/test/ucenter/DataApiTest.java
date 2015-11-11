package cn.thinkjoy.sss.test.ucenter;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by jimkan on 15-11-4.
 */
public class DataApiTest {
    private  static  final  String URL="http://uww-dev.thinkjoy.com.cn/v2";

    public String getSign() throws Exception {
        String secretKey= "b08762a33ff011e5be87fa163e33daaa";
        String uri="/baseData/subjects";
        String MD5="MD5";
        String UTF8="UTF-8";
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        messageDigest.update(URLEncoder.encode(uri + secretKey, UTF8).getBytes(UTF8));
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }


    public static void main(String args[]) throws Exception {
        DataApiTest dataApiTest = new DataApiTest();
        System.out.println(dataApiTest.getSign());
    }
}
