package com.rickwebstudy.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil {
	private static final String PASSWORD_CRYPT_KEY = "cloudesign"; 
    private static final String DES = "DES"; 
     
    /** 
     * DES加密 
     * @param src 要加密的数据 
     * @param key 加密取用的key。八位字符串 
     * @return 
     * @throws Exception 
     */ 
    public static String encrypt(String src, String key){  
        if(key==null||key.length()==0) { 
            key = PASSWORD_CRYPT_KEY; 
        } 
        byte bb[] = null; 
        String result = null; 
        try { 
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE,key);   
        // 正式执行加密操作 
            bb = cipher.doFinal(src.getBytes()); 
            result = Byte2Hex(bb); 
        } catch(Exception e) { 
        	e.printStackTrace();
            result = null; 
        } 
        return result; 
         
    } 
     
    /** 
     * DES解密 
     * @param src 要解密的数据源 
     * @param key 加密时取用的key，八位字符串 
     * @return 
     * @throws Exception 
     */ 
    public static String decrypt(String src, String key) {  
        if(key==null||key.length()==0) { 
            key = PASSWORD_CRYPT_KEY; 
        } 
        byte[] result = null; 
        Cipher cipher = null; 
        try { 
            result = String2Byte(src); 
            cipher = getCipher(Cipher.DECRYPT_MODE,key); 
            // 现在，获取数据并解密  
            // 正式执行解密操作  
            return new String(cipher.doFinal(result)); 
        } catch(Exception e) { 
            return null; 
        } 
    }  
     
    /** 
     * 根据 mode 和 key 初始化Cipher对象 
     * @param mode 加密还是解密 
     * @param key 密匙 
     * @return Cipher对象 
     * @throws Exception 
     */ 
    public static Cipher getCipher(int mode,String key) throws Exception { 
        // DES算法要求有一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();  
        // 从原始密匙数据创建一个DESKeySpec对象  
        DESKeySpec dks = new DESKeySpec(key.getBytes());  
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成  
        // 一个SecretKey对象  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);  
        SecretKey securekey = keyFactory.generateSecret(dks);  
        // Cipher对象实际完成解密操作  
        Cipher cipher = Cipher.getInstance(DES);  
        // 用密匙初始化Cipher对象  
        cipher.init(mode, securekey, sr);  
        return cipher; 
    } 
     
    /** 
     * 将byte[] 转成 hex 字符串 
     * @param bb byte数组 
     * @return 
     */ 
    public static String Byte2Hex(byte[] bb) { 
        StringBuilder buff = new StringBuilder(bb.length); 
        String sTemp; 
        for(int i=0;i<bb.length;i++){ 
            sTemp = Integer.toHexString(0xFF &bb[i]); 
            if(sTemp.length()<2){ 
                buff.append(0); 
            } 
            buff.append(sTemp.toUpperCase()); 
        } 
        return buff.toString(); 
    } 
     
    /** 
     * 字符串转换成byte[] 
     * @param src 要转换的字符串 
     * @return 
     */ 
    public static byte[] String2Byte(String src) { 
        int len = (src.length()/2); 
        byte [] result = new byte[len]; 
        char[] achar = src.toString().toCharArray(); 
        for(int j=0;j<len;j++){ 
            int pos = j*2; 
            result[j]= ((byte)(Char2Byte(achar[pos])<<4|Char2Byte(achar[pos+1]))); 
        } 
        return result; 
    } 
     
    /** 
     * 字符转成byte 
     * @param c  
     * @return 
     */ 
    private static byte Char2Byte(char c){ 
        byte  b = (byte)"0123456789ABCDEF".indexOf(c); 
        return b; 
    } 
     
}
