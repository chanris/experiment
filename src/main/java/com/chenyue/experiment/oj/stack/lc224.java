package com.chenyue.experiment.oj.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/8
 * @description
 */
@SuppressWarnings("all"
)
public class lc224 {
    public static void main(String[] args) {
        String s = "(1-(     -2))";
        lc224 lc = new lc224();
        int calculate = lc.calculate(s);
        System.out.println(calculate);
    }

    public int calculate(String s) {
        // (10 + 15 - 20)
        // numsSt = 20 15 10
        // operSt = - + )
        // 20 15 10
        // - +
        Deque<Integer> numsSt = new LinkedList<>();
        Deque<Character> operSt = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStTmp = new LinkedList<>();
        Deque<Character> operStTmp = new LinkedList<>();
        boolean flag = false;
        int num = 0;
        boolean hasNum = false;
        for(char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (flag && (c == '+' || c == '-')) {
                numsSt.addLast(0);
                flag = false;
            }else {
                flag = false;
            }
            if (c == '(' || c == '+' || c == '-') {
                operSt.addLast(c);
                if(c == '(') flag = true;
                if(hasNum) {
                    numsSt.addLast(num);
                    hasNum = false;
                    num = 0;
                }
            }
            else if (c != ')'){
                num = num * 10 + (c - '0');
                hasNum = true;
            }else {
                if (hasNum) {
                    numsSt.addLast(num);
                    hasNum = false;
                    num = 0;
                }
                char oper = operSt.removeLast();
                while (oper != '(') {
                    numStTmp.addLast(numsSt.removeLast());
                    operStTmp.addLast(oper);
                    oper = operSt.removeLast();
                }
                numStTmp.addLast(numsSt.removeLast());
                while (!operStTmp.isEmpty()) {
                    oper = operStTmp.removeLast();
                    int a = numStTmp.removeLast();
                    int b = numStTmp.removeLast();
                    numStTmp.addLast(oper == '+' ? a + b : a - b);
                }
                numsSt.addLast(numStTmp.removeLast());
            }
        }
        return numsSt.remove();
    }

}
