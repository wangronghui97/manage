package com.demo.needmanage.comment;

public class StringUtils {

    public static boolean isEmpty(String str){

        if (str==null){
            return true;
        }else if (str.trim().equals("")){
            return true;
        }else {
            return false;
        }




    }

}
