package eleven;

import java.awt.datatransfer.FlavorEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < 10; ++i) {
			queue.offer(i);
		}
		System.out.println(queue);
		System.out.println(queue.poll());
			
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		pq1.addAll(Arrays.asList(0,1,-9,12,343,-67));
		System.out.println(pq1);
		for (int i = 0; i < 6; ++i) {
			System.out.println(pq1.poll());
		}
		pq1.offer(78);
		pq1.offer(-78);
		pq1.offer(100);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		pq2.addAll(pq1);
		for (int i = 0, size = pq2.size(); i < size ; ++i) {
			System.out.print(pq2.poll() + " ");
		}
	}

}
