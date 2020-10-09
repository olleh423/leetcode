package problems;

import java.util.LinkedList;
import java.util.Queue;

public class PrimeGenerator {

	private Queue<Integer> queue;
	
	public PrimeGenerator() {
		this.queue = new LinkedList<>();
	}
	
	private boolean isPrime(int n) {
		for(int i=2 ; i<=Math.sqrt(n) ; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	private void generateAndAddPrimesToQueue(int n) {
		
		int counter = 2;
		while(queue.size() < n) {
			if(isPrime(counter)) 
				queue.add(counter);
			counter++;
		}
	}
	
	public int generate(int n) {
		
		if(queue.isEmpty()) {
			generateAndAddPrimesToQueue(n);
			queue.add(0);
		}
		return queue.remove();
	}
	
	public static void main(String[] args) {

		PrimeGenerator pg = new PrimeGenerator();
		System.out.println(pg.generate(4));
	}
}
