package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MeetingRooms {

    public static void main(String[] args) {

        MeetingRooms obj = new MeetingRooms();
    }

    private static class Pair {
        int time;
        int type; // 0 to start and 1 to end
        Pair(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals == null)
            return false;

        int n = intervals.length;
        Pair[] pairs = new Pair[n*2];

        for(int i=0, k=0 ; i<n ; i++, k+=2) {

            Pair start = new Pair(intervals[i][0], 0);
            Pair end = new Pair(intervals[i][1], 1);

            pairs[k] = start; pairs[k+1] = end;
        }

        Arrays.sort(pairs, (a, b) -> a.time == b.time ? b.type - a.type : a.time - b.time);

        int total = 0, count = 0;
        for(Pair p : pairs) {

            if(p.type == 0) {
                count++; total = Math.max(total, count);
            }
            else {
                count--;
            }
        }

        return total <= 1;
    }
}
