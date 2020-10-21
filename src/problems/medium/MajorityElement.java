package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class MajorityElement {

    public static void main(String[] args) {

        MajorityElement obj = new MajorityElement();

        int[] arr = {2,9,6,4,2,2,2,3,6,5,2,2,2,2,2};
        System.out.println(obj.majorityElement(arr));
    }

    public int majorityElement(int[] arr) {

        int count = 1;
        int element = arr[0];

        for(int i=1 ; i<arr.length ; i++) {

            count += arr[i] != element ? -1 : 1;
            if(count == 0) {
                element = arr[i];
                count = 1;
            }
        }

        return element;
    }
}
