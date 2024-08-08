package com.my.java.base;

import com.alipay.api.internal.util.codec.Base64;
import com.my.java.base.file.FileUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/**
 * RSA 非对称加密算法工具类
 *
 * @ClassName: RSAUtil
 * @Version: 1.0
 */
public class RSAUtil {

    /**
     * 加密算法
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * RSA位数，采用2048，则加密密文和解密密文需要使用245和256
     */
    private static final Integer INITIALIZE_LENGTH = 2048;

    /**
     * 公钥
     */
    public static String publicKey = "";

    /**
     * 私钥
     */
    public static String privateKey = "";

    /**
     * 生成公钥和私钥
     */
    public static void generateKey() {
        // 1.初始化秘钥
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            // 随机数生成器
            SecureRandom sr = new SecureRandom();
            // 设置秘钥长度
            keyPairGenerator.initialize(INITIALIZE_LENGTH, sr);
            // 开始创建
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 进行转码
            publicKey = Base64.encodeBase64String(rsaPublicKey.getEncoded());
            // 进行转码
            privateKey = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 私钥匙加密或解密
     */
    public static String encryptByprivateKey(String content, String privateKeyStr, int opmode) {
        // 私钥要用PKCS8进行处理
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr.getBytes()));
        KeyFactory keyFactory;
        PrivateKey privateKey;
        Cipher cipher;
        byte[] result;
        String text = null;
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            // 还原Key对象
            privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(opmode, privateKey);
            //加密解密
            text = encryptTxt(opmode, cipher, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String encryptTxt(int opmode, Cipher cipher, String content) {
        byte[] result;
        String text = null;
        try {
            // 加密
            if (opmode == Cipher.ENCRYPT_MODE) {
                result = cipher.doFinal(content.getBytes());
                text = Base64.encodeBase64String(result);
            } else if (opmode == Cipher.DECRYPT_MODE) {
                // 解密
                result = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
                text = new String(result, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 公钥匙加密或解密
     */
    public static String encryptByPublicKey(String content, String publicKeyStr, int opmode) {
        // 公钥要用X509进行处理
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr.getBytes()));
        KeyFactory keyFactory;
        PublicKey publicKey;
        Cipher cipher;
        byte[] result;
        String text = null;
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            // 还原Key对象
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(opmode, publicKey);
            text = encryptTxt(opmode, cipher, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 读取文件中的公钥
     **/
    public static PublicKey getPublicKey(String pathPublicKeyName) {
        String publicKeyStr = FileUtils.getKey(pathPublicKeyName);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr.getBytes()));
        PublicKey publicKey = null;
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            publicKey = factory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            e.getMessage();
        }
        return publicKey;
    }

    /**
     * 读取文件中的私钥
     *
     * @param pathPrivateKeyName:
     **/
    public static PrivateKey getPrivateKey(String pathPrivateKeyName) {
        String privateKeyStr = FileUtils.getKey(pathPrivateKeyName);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr.getBytes()));
        PrivateKey privateKey = null;
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            e.getMessage();
        }
        return privateKey;
    }

    public static String sign(String message,PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes("UTF-8"));
        return java.util.Base64.getEncoder().encodeToString(sign.sign());
    }

    public static String buildMessage(String method, String url, long timestamp, String body) {
        return method + "\n"
            + url + "\n"
            + timestamp + "\n"
            + body + "\n";
    }

    public static void main(String[] args) {
        generateKey();
        System.out.println(publicKey);
        System.out.println("--" + privateKey);

        String encryptStr = encryptByPublicKey("美女在哪",publicKey,Cipher.ENCRYPT_MODE);
        String result = encryptByprivateKey(encryptStr,privateKey,Cipher.DECRYPT_MODE);

        System.out.println(result);
    }
}

