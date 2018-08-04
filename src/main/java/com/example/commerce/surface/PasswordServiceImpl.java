package com.example.commerce.surface;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final static  String  KEY_SHA = "SHA";
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static String encryptSHA(String data) throws Exception{
        if(data==null || data.equals("")) return "";
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data.getBytes());
        byte[] bytes = sha.digest();
        return byteArrayToHexString(bytes);
    }

    private static String byteArrayToHexString(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<bytes.length;++i){
            stringBuffer.append(byteToHexString(bytes[i]));
        }
        return stringBuffer.toString();
    }

    private static String byteToHexString(byte b){
        int ret= b;
        if(ret<0) ret+=256;
        int m = ret/16;
        int n = ret%16;
        return hexDigits[m]+hexDigits[n];
    }

    @Override
    public String encrypt(Integer password) {
        String newString = null;
        try{
            newString = encryptSHA(password.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return newString;
    }



}
