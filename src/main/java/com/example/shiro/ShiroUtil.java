package com.example.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @Project: management_system
 * @Package: com.example.shiro
 * @Author: 周博义
 * @Date: Created in 2020/5/30 10:25
 */
public class ShiroUtil {

    /**
     * 传入一个明文，返回一个加密后的密文
     */
    public static String getCiphertext(String plaintext) {
        String ciphertext = DigestUtils.md5DigestAsHex(plaintext.getBytes());
        return ciphertext;
    }

    /**
     * 加盐加密
     * @param salt
     * @param message
     * @return
     */
    public static String  encryptionBySalt(String salt, String message){
        /**
         * shiro加密：
         * String algorithmName 加密算法
         * Object source 明文
         * Object salt 盐值
         * int hashIterations 加密次数
         */
        String algorithmName = com.example.util.MyConstants.algorithmName;
        int hashIterations = com.example.util.MyConstants.hashIterations;
        SimpleHash simpleHash = new SimpleHash(algorithmName, message, salt, hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptionBySalt("root", "root"));
        System.out.println(encryptionBySalt("admin", "admin"));
    }
}
