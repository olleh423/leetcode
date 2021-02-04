package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 02-02-2021
 */
public class ReconstructItinerary {

    public static void main(String[] args) {

        ReconstructItinerary obj = new ReconstructItinerary();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        System.out.println(obj.findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> result = new ArrayList<>();
        if(tickets == null)
            return result;

        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for(List<String> edge : tickets) {

            if(!adjList.containsKey(edge.get(0)))
                adjList.put(edge.get(0), new PriorityQueue<>());
            if(!adjList.containsKey(edge.get(1)))
                adjList.put(edge.get(1), new PriorityQueue<>());

            adjList.get(edge.get(0)).add(edge.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while(!stack.isEmpty()) {

            String top = stack.peek();
            if(adjList.get(top).isEmpty()) {
                result.add(stack.pop());
            }
            else {
                stack.push(adjList.get(top).poll());
            }
        }

        Collections.reverse(result);
        return result;
    }
}
