/**
 * bitms.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.bitms.api.client.tool;

import com.bitms.api.client.bean.sign.BitmsMap;
import com.bitms.api.client.bean.sign.RequestHolder;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.exception.ApiException;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * Signing tool
 */
public class Signature {
    /**
     * Get the private key
     *
     * @param algorithm
     * @param ins
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, String ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }
        byte[] encodedKey = Base64.decode(ins);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /**
     * Get the public key
     *
     * @param algorithm
     * @param ins
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromX509(String algorithm, String ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }
        byte[] encodedKey = Base64.decode(ins);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    /**
     * Collection deduplication and sorting
     *
     * @param requestHolder
     * @return
     */
    public static Map<String, String> getSortedMap(RequestHolder requestHolder) {
        Map<String, String> sortedParams = new TreeMap<String, String>();
        BitmsMap appParams = requestHolder.getApplicationParams();
        if (appParams != null && appParams.size() > 0) {
            sortedParams.putAll(appParams);
        }
        BitmsMap protocalMustParams = requestHolder.getProtocalMustParams();
        if (protocalMustParams != null && protocalMustParams.size() > 0) {
            sortedParams.putAll(protocalMustParams);
        }
        BitmsMap protocalOptParams = requestHolder.getProtocalOptParams();
        if (protocalOptParams != null && protocalOptParams.size() > 0) {
            sortedParams.putAll(protocalOptParams);
        }
        return sortedParams;
    }

    /**
     * Convert the request object to text
     *
     * @param requestHolder
     * @return
     */
    public static String getSignatureContent(RequestHolder requestHolder) {
        return getSignContent(getSortedMap(requestHolder));
    }

    /**
     * Convert a Map parameter object to text
     *
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (StringUtils.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    /**
     * Parameter signature
     *
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsaSign(String content, String privateKey, String charset, String signType) throws ApiException {
        if (BitmsConstants.SIGN_TYPE_RSA.equals(signType)) {
            return rsa128Sign(content, privateKey, charset);
        } else if (BitmsConstants.SIGN_TYPE_RSA2.equals(signType)) {
            return rsa256Sign(content, privateKey, charset);
        } else {
            throw new ApiException("Sign Type is Not Support : signType=" + signType);
        }
    }

    /**
     * sha1WithRsa signature
     *
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsa128Sign(String content, String privateKey, String charset) throws ApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(BitmsConstants.SIGN_TYPE_RSA, privateKey);
            java.security.Signature signature = java.security.Signature.getInstance(BitmsConstants.SIGN_ALGORITHMS);
            signature.initSign(priKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            return Base64.encodeStr(signature.sign());
        } catch (InvalidKeySpecException ie) {
            throw new ApiException("The RSA private key format is incorrect. Check whether the private key of the PKCS8 format is correctly configured.", ie);
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }
    }

    /**
     * sha256WithRsa signature
     *
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsa256Sign(String content, String privateKey, String charset) throws ApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(BitmsConstants.SIGN_TYPE_RSA, privateKey);
            java.security.Signature signature = java.security.Signature.getInstance(BitmsConstants.SIGN_SHA256RSA_ALGORITHMS);
            signature.initSign(priKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            return Base64.encodeStr(signature.sign());
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }
    }

}
