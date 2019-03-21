package com.wxiip.util;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月15日  11：28
 * @Description: SHA3加密算法工具类
 */
public class Sha3Utils {
    private static Size DEFAULT = Size.S224;
    /**
     * SHA3加密处理.
     *
     * @param string
     *            加密对象字符串
     * @return 加密后字符串
     */
    public static String digest(String string) {
        return digest(string, DEFAULT, true);
    }
    /**
     * 指定大小进行SHA3加密处理.
     *
     * @param string
     *            加密对象字符串
     * @param s
     *            大小
     * @return SHA3加密后字符串
     */
    public static String digest(String string, Size s) {
        return digest(string, s, true);
    }

    /**
     * 指定大小,并且指定是否转换成16进制进行SHA3加密处理.
     *
     * @param string
     *            加密对象字符串
     * @param s
     *            大小
     * @param bouncyencoder
     *            是否转换成16进制
     * @return SHA3加密后字符串
     */
    public static String digest(String string, Size s, boolean bouncyencoder) {
        Size size = s == null ? DEFAULT : s;
        SHA3.DigestSHA3 md = new SHA3.DigestSHA3(size.getValue());
        String text = string != null ? string : "null";
        try {
            md.update(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            // most unlikely
            md.update(text.getBytes());
        }
        byte[] digest = md.digest();
        return encode(digest, bouncyencoder);
    }
    /**
     * 根据字节数组是否转换成16进制进行SHA3加密处理.
     *
     * @param bytes
     *            字节数组
     * @param bouncyencoder
     *            是否转换成16进制
     * @return SHA3加密后字符串
     */
    public static String encode(byte[] bytes, boolean bouncyencoder) {
        if (bouncyencoder)
            return Hex.toHexString(bytes);
        else {
            BigInteger bigInt = new BigInteger(1, bytes);
            return bigInt.toString(16);
        }
    }
    /**
     * 大小枚举.
     */
    public enum Size {
        S224(224), S256(256), S384(384), S512(512);
        int bits = 0;
        Size(int bits) {
            this.bits = bits;
        }
        public int getValue() {
            return this.bits;
        }
    }
    //SHA3-224 算法
    public static String sha3224(String source){
        byte[] bytes = source.getBytes(Charset.forName("UTF-8"));
        Digest digest = new SHA3Digest(224); //通过bouncycastle获得消息摘要SHA3-224对象
        digest.update(bytes,0,bytes.length); //
        //执行摘要
        byte[] rsData=new byte[digest.getDigestSize()];
        digest.doFinal(rsData,0);
        return Hex.toHexString(rsData); //将byte[]数组转换成十六进制
    }

    public static void main(String[] args) {
        String source = "java小工匠";
        String sha3224 = sha3224(source);
        System.out.println("sha3-224:"+sha3224+",length="+sha3224.length());
        String d256=digest(source, Size.S256);
        System.out.println("d256:"+d256+",length="+d256.length());
    }





}
