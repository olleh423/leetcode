package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DestinationCity {

    public static void main(String[] args) {

        DestinationCity obj = new DestinationCity();

        String[][] paths = {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
        System.out.println(obj.destCity(paths));
    }

    public String destCity(String[][] paths) {

        if(paths == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for(String[] route : paths) {
            map.put(route[0], route[1]);
        }

        String start = paths[0][0];
        while(map.containsKey(start)) {
            start = map.get(start);
        }
        return start;
    }
}
