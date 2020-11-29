package com.solution.simple.lengthoflastword58;

/**
 * @className: LengthOfLastWord
 * @description:
 * @author: j
 * @date: 2020/4/2 17:01
 */
public class LengthOfLastWord {

    public static void main(String[] args) {

        String s="b  a   ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        //去掉头尾空格
        s=s.trim();

        if(s.length()==0){
            return 0;
        }

        int index=0;

        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)!=' '){
                index++;
            }else {
                break;
            }

        }

        return index;



    }
}
