package problems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class JobSequencing {

	static class Job {
		
		String id;
		int value;
		int deadLine;
		
		Job(String id, int value, int deadLine) {
			this.id = id;
			this.value = value;
			this.deadLine = deadLine;
		}
		
		@Override
		public String toString() {
			return id;
		}
	}
	
	private Job[] sequence(List<Job> jobs) {
		
		//sort all jobs in non increasing order of profit
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return new Integer(b.value).compareTo(new Integer(b.value));
			}
		});
		
		//get maximum time slot
		int maxTime = Collections.max(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return new Integer(a.deadLine).compareTo(new Integer(b.deadLine));
			}
		}).deadLine;
		
		Job [] sequence = new Job[maxTime];
		
		for(Job job : jobs) {
			
			if(sequence[job.deadLine-1] == null) {
				sequence[job.deadLine-1] = job;
			}
			else {
				int avlTimeSlot = getAvailableTimeSlot(sequence, job.deadLine-1);
				if(avlTimeSlot != -1) {
					sequence[avlTimeSlot] = job;
				}
			}
		}
		
		return sequence;
	}
	
	//returns -1 if no time slot is available else returns time slot index
	private int getAvailableTimeSlot(Job[] sequence, int currentTimeSlot){
		
		for(int i = currentTimeSlot-1 ; i >=0 ; i--)
			if(sequence[i] == null) return i;
		
		return -1;
	}
	
	private void showSequence(Job[] seq) {
		
		int maxProfit = 0;
		for(Job s : seq) {
			System.out.println(s + " ");
			maxProfit += s.value;
		}
		System.out.println("Max Profit : " + maxProfit);
	}
	
	public static void main(String[] args) {
		
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("A", 20, 2));
		jobs.add(new Job("B", 15, 2));
		jobs.add(new Job("C", 10, 1));
		jobs.add(new Job("D", 5, 3));
		jobs.add(new Job("E", 1, 3));
		
		JobSequencing seq = new JobSequencing();
		seq.showSequence(seq.sequence(jobs));
	}
}
