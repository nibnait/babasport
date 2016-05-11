package com.nibnait.babasport.common.encode;

import com.nibnait.common.page.Pagination;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5加密
 * Created by nibnait on 2016/5/9.
 */
public class Md5PwdImpl implements Md5Pwd {
    //加密
    public String  encode(String password){
        String algorithm = "MD5";
        //加盐所谓加盐就是在用户密码的基础上按照某一规则添加不规律的字符
        //并保存起来，保证下次加密的盐值相同

        MessageDigest instance = null;
        try {
            instance = MessageDigest.getInstance(algorithm);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //加密
        byte[] digest = instance.digest(password.getBytes());
        //十六进制加密
        char[] encodeHex = Hex.encodeHex(digest);

        return new String(encodeHex);
    }
}

