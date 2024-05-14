package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 24/4/2024
 * @description
 */
import java.util.*;

public class Main {
    static final int MAXN = (int) 1e5 + 10;
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    static final int MAX_LENGTH = 5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long start = System.currentTimeMillis();
        if(n == 1){
            System.out.println(0);
            return;
        }
        findNumbers(0, 0);
        //System.out.println(Arrays.toString(nums.toArray())); // 61
        for(int i = 1; i <= nums.size(); i++){ // 枚举次数
            if(check(n, 0, i)){
                System.out.println(i);
                long end = System.currentTimeMillis();
                System.out.println(end - start);
                return;
            }
        }
        System.out.println(-1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    static void findNumbers (int start, int len) {
        if(start != 0 && len <= MAX_LENGTH && start != 1)
            nums.add(start);
        if(len == MAX_LENGTH)
            return;
        findNumbers(start * 10 + 1, len + 1);
        findNumbers(start * 10 + 2, len + 1);
    }

    static boolean check(int cur, int len, int maxLen){
        if(cur == 1){
            for (Integer an : ans) {
                System.out.print(an+" ");
            }
            System.out.println();
            return true;
        }
        if(len == maxLen)
            return false;
        boolean ck = false;
        for(int i = 0; i < nums.size(); i++){
            if(cur % nums.get(i) == 0){ // 能整除
                ans.add(nums.get(i));
                ck = check(cur / nums.get(i), len + 1, maxLen);
                ans.remove(ans.size() - 1);
                if(ck) break;
            }
        }
        return ck;
    }
}