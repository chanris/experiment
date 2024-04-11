package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 17/1/2024
 * @description
 */
public class lc2744 {
    public static void main(String[] args) {
        String[] words = new String[]{"cd", "ac", "dc", "ca", "zz"};
        int count = maximumNumberOfStringPairs(words);
        System.out.println(count);
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    count++;
                }
            }
        }
        return count;
    }
}
