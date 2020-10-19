package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 18-10-2020
 */
public class MeetingRooms {

    public static void main(String[] args) {

        MeetingRooms obj = new MeetingRooms();

        int[][] intervals = { {0, 30}, {5, 10}, {15, 20} };
        System.out.println(obj.canAttend(intervals));
    }

    public boolean canAttend(int[][] intervals) {

        if(intervals == null) return true;

        int n = intervals.length;
        int[][] times = new int[2*n][2];

        int i=0;
        for(int[] slot : intervals) {

            times[i][0] = slot[0];
            times[i][1] = 1;
            i++;
            times[i][0] = slot[1];
            times[i][1] = 0;
            i++;
        }

        Arrays.sort(times, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int meetingRooms = 0;
        int counter = 0;
        for(int k=0 ; k<times.length ; k++) {
            counter += (times[k][1] == 1 ? 1 : -1);
            meetingRooms = Math.max(meetingRooms, counter);
        }

        return meetingRooms <= 1;
    }
}
