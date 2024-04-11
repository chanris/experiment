package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 21/3/2024
 * @description
 */
public class lc56 {
    public static void main(String[] args) {
        lc56 lc56 = new lc56();
        int[][] mtx = new int[][]{{1,4},{2,3}};
        int[][] merge = lc56.merge(mtx);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        List<List<Integer>> list = new ArrayList<>();
        // 排序
        int[] tmp;
        for(int i = 0; i < intervals.length - 1; i++) {
            for(int j = i + 1; j < intervals.length; j++) {
                if(intervals[i][0] > intervals[j][0]) {
                    tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(intervals[0][0]);
        lst.add(intervals[0][1]);
        list.add(lst);
        for(int i = 1; i < intervals.length; i++) {
            List<Integer> last =  list.get(list.size() - 1);
            if(last.get(1) >= intervals[i][0]) {
                if (last.get(1) < intervals[i][1]) {
                    last.remove(last.size() - 1);
                    last.add(intervals[i][1]);
                }
            }else {
                List<Integer> l = new ArrayList();
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}
