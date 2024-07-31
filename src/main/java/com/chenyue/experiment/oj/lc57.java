package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/29
 * @description
 */
public class lc57 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = new int[]{4,8};
        lc57 lc = new lc57();
        int[][] insert = lc.insert(intervals, newIntervals);
        for (int[] num: insert) {
            System.out.print(Arrays.toString(num) + " ");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> range = new ArrayList<>();
        int len = intervals.length;
        for(int i = 0; i < len; i++) {
            range.add(new int[]{intervals[i][0], intervals[i][1]});
            if(intervals[i][1] >= newInterval[0]) {
                int p = i+1;
                while(p < len && (newInterval[1] >= intervals[p][0])){
                    range.get(range.size()-1)[1] =  intervals[p][1];
                    p++;
                }
                if(p == i+1 && range.get(range.size()-1)[1] < newInterval[1]) {
                    range.get(range.size()-1)[1] = newInterval[1];
                }
                i = p-1;
            }
        }
        return range.toArray(new int[range.size()][]);
    }
}
