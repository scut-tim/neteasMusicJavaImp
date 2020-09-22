
import java.security.NoSuchAlgorithmException;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


import java.util.Base64;
import java.util.Base64.*;

import java.math.*;


public class EncodeOfNeteas {

    public String a(int a) {
        double d, e;
        String b = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String c = "";
        for (d = 0; a > d; d++) {
            e = Math.random() * b.length();
            e = Math.floor(e);
            c = c + b.charAt((int) e);
        }
        return c;
    }

    public String b(String a, String b){

        byte[] result = null;
        
        try{
            SecretKeySpec sKeySpec = new SecretKeySpec(b.getBytes("utf-8"), "AES");// c
            IvParameterSpec iSpec = new IvParameterSpec("0102030405060708".getBytes("utf-8"));// d

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iSpec);
            result = cipher.doFinal(a.getBytes("utf-8"));
        }catch(Exception e){

        }
            
        Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(result);
        return encode;
    }

    //fake fun c
    public String c(String a, String b, String c) throws NoSuchAlgorithmException {

        StringBuffer sb = new StringBuffer(a);
        a = sb.reverse().toString();
        
        // get hex encoding for a
        int[] asc_code = new int[a.length()];
        int[] hex_code = new int[a.length()*2];
        String hexString = "";
        for(int i = 0;i<asc_code.length;i++){
            asc_code[i] = (int)a.charAt(i);
        }
        for(int i = 0, j = 0;i<asc_code.length;i++,j+=2){

            String bString = Integer.toBinaryString(asc_code[i]);
            while(bString.length() < 8){
                bString = "0" + bString;
            }
            hex_code[j] = Integer.parseInt(bString.substring(0,4),2);
            hex_code[j+1] = Integer.parseInt(bString.substring(4),2);
            hexString = hexString + Integer.toHexString(hex_code[j]) + Integer.toHexString(hex_code[j+1]);
        }

        BigInteger hexStringDecValue = new BigInteger(hexString,16);
        BigInteger bDecValue         = new BigInteger(b,16);
        BigInteger cDecValue         = new BigInteger(c,16);
        String result                = hexStringDecValue.modPow(bDecValue , cDecValue).toString(16);

        return result;
    }


    public String getParams(String d, String g, String i){

        String params = b(d,g);
        params = b(params,i);
        return params;

    }

    public String getEncSecKey(String i, String e, String f){
        try{
            return c(i,e,f);
        }catch(NoSuchAlgorithmException ee){

        }
        return null;
        
    }








    public static void main(String[] args) {
        // System.out.println("你好");

        // //test fun a
        EncodeOfNeteas encodeOfNeteas = new EncodeOfNeteas();
        // String ar = encodeOfNeteas.a(16);
        // System.out.println("ar: " + ar);
        // System.out.println();


        // //test fun b
        // String d = "{\"logs\":\"[{\\\"action\\\":\\\"sysaction\\\",\\\"json\\\":{\\\"dataType\\\":\\\"cdnCompare\\\",\\\"cdnType\\\":\\\"xy\\\",\\\"resourceType\\\":\\\"audio-m4a\\\",\\\"resourceId\\\":29481242,\\\"resourceUrl\\\":\\\"https://m801.music.126.net/20200905152138/94469c038e7ca8e285dc1da9df4dcd71/jdyyaac/025e/535a/5252/5400f8fc45d04fca2b28e8da4a497179.m4a\",\\\"cdnBytes\\\":131072,\\\"p2pBytes\\\":0}}]\",\\\"csrf_token\\\":\"edbbf45f393edbcf34aa3ca6ef4c631f\"}";
        // String g = "0CoJUm6Qyw8W8jud";
        
       
        // String br = encodeOfNeteas.b("{\"ids\": \"[167691]\", \"level\": \"higher\", \"encodeType\": \"aac\", \"csrf_token\": \"\"}", g);
        // // System.out.println(d);
        // // System.out.println(br);
        
        // String params = encodeOfNeteas.getParams(d, g);
        // // System.out.println("params:" + params);
        // // System.out.println();
        // System.out.println("br: "+br);
        // //vertify fun b
        // // System.out.println("params:"+ encodeOfNeteas.getParams("{\"ids\": \"[167691]\", \"level\": \"higher\", \"encodeType\": \"aac\", \"csrf_token\": \"\"}", g));


        // //test fake c
        // String e = "010001";
        // String f = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
        // String encSecKey = encodeOfNeteas.getEncSecKey(ar, e, f);
        // System.out.println("encSecKey: " + encSecKey);

        // //vertify fake c
        // System.out.println("encSecKey: " + encodeOfNeteas.getEncSecKey("hr3DzOPIjeLAqypi", "010001", "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7"));


        


        //hex encoding
        // String a = "zzz";
        // int[] asc_code = new int[a.length()];
        // int[] hex_code = new int[a.length()*2];
        // String hexString = "";
        // for(int i = 0;i<asc_code.length;i++){
        //     asc_code[i] = (int)a.charAt(i);
        // }
        // for(int i = 0, j = 0;i<asc_code.length;i++,j+=2){

        //     String bString = Integer.toBinaryString(asc_code[i]);
        //     while(bString.length() < 8){
        //         bString = "0" + bString;
        //     }
        //     hex_code[j] = Integer.parseInt(bString.substring(0,4),2);
        //     hex_code[j+1] = Integer.parseInt(bString.substring(4),2);
        //     hexString = hexString + Integer.toHexString(hex_code[j]) + Integer.toHexString(hex_code[j+1]);
        // }
        // System.out.println(hexString);
        // System.out.println(Integer.parseInt(hexString,16));
        // System.out.println(0.5 % 2);


        //test post   https://music.163.com/weapi/song/enhance/player/url/v1?csrf_token=    "{\"ids\": \"[167691]\", \"level\": \"higher\", \"encodeType\": \"aac\", \"csrf_token\": \"\"}",
        //String fuckingD = "{\"id\":\"29481242\",\"c\":\"[{\"id\":\"29481242\"}]\",\"csrf_token\":\"\"}";
        //String fuckingD = "{\"ids\": \"[506092956]\", \"level\": \"higher\", \"encodeType\": \"aac\", \"csrf_token\": \"\"}";
        //String fuckingD = "{\"id\":\"506092956\",\"c\":\"[{\\\"id\\\":\\\"506092956\\\"}]\",\"csrf_token\":\"\"}";
        //{"hlpretag":"<span class=\"s-fc7\">","hlposttag":"</span>","s":"chaos chaos ","type":"1","offset":"0","total":"true","limit":"30","csrf_token":""}
        String fuckingD =  "{\"hlpretag\":\"<span class=\\\"s-fc7\\\">\",\"hlposttag\":\"</span>\",\"s\":\"chaos chaos \",\"type\":\"1\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"30\",\"csrf_token\":\"\"}";
        String fuckingG = "0CoJUm6Qyw8W8jud";
        String fuckingE = "010001";
        String fuckingF = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
        String fuckingI = encodeOfNeteas.a(16);
        //String fuckingI = "n0uFX7NuovjIFX03";
        
        String para = encodeOfNeteas.getParams(fuckingD,fuckingG,fuckingI);
        String encSec = encodeOfNeteas.getEncSecKey(fuckingI, fuckingE ,fuckingF);

        System.out.println(fuckingD);
        //String url = "https://music.163.com/weapi/song/enhance/player/url/v1?csrf_token=";
        String url = "https://music.163.com/weapi/cloudsearch/get/web?csrf_token=";
        System.out.println("hello?");
        System.out.println(para);
        System.out.println();
        System.out.println(encSec);
        Req.Post(url, para,encSec);
        





        //test again  i = "4Jkl6oieaDuP4thd"    "eHhjXckqrtZkqcwCalCMx0QuU6Lj9L7Wxouw1iMCnB4="
        // String b = "{\"csrf_token\":\"\"}";
        // String g = "0CoJUm6Qyw8W8jud";
        // String i = "4Jkl6oieaDuP4thd";
        // String e = "010001";
        // String f = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";

        // String temp = encodeOfNeteas.b(b,g);
        // String para = encodeOfNeteas.b(temp,i);
        // System.out.println(para);
        // System.out.println();
        // String key = encodeOfNeteas.getEncSecKey(i, e, f);
        // System.out.println(key);

        // String realencSecKey = "d7af41175f5722420aa9662840ffa5ba4a01eae871d5c92cbe6def6f72903ebf37ff0a3035a5377d5378ce6b459a2f021e7b076bb98730a798a6548d74539906bfa0ae3a8c8a46d2c1646109b323a0bd6346149d71b9df295bc0445e674e9b20fe840ea11ee3d66c9945c421e1caae3c00bc857ec16adc88ae17e93884e7ffd9";
        //                       //d7af41175f5722420aa9662840ffa5ba4a01eae871d5c92cbe6def6f72903ebf37ff0a3035a5377d5378ce6b459a2f021e7b076bb98730a798a6548d74539906bfa0ae3a8c8a46d2c1646109b323a0bd6346149d71b9df295bc0445e674e9b20fe840ea11ee3d66c9945c421e1caae3c00bc857ec16adc88ae17e93884e7ffd9
        // String encText = "O/DDjpz8NzxvDRDP8CWJfFl0TFc9yQVdi357HZObZlg3GBpQysjVaq23rt1rdR0H";
        //                 //O/DDjpz8NzxvDRDP8CWJfFl0TFc9yQVdi357HZObZlg3GBpQysjVaq23rt1rdR0H
        // if(realencSecKey.equals(key))
        // {
        //     System.out.println("equals ???");
        // }

        // if(encText.equals(para)){
        //     System.out.println("fxxxk");
        // }




    }

}




