package Collection;

import java.util.*;


	public class PC {
		
		LinkedList<Integer> l1 = new LinkedList<>();
		int capacity = 5;
		
		public void produce() throws InterruptedException {
			
			int value = 0;
			while(true) {
				synchronized(this) {
					while(l1.size() == capacity)
						wait();
					System.out.println("producing : " + value);
					l1.add(value++);
					notifyAll();
					Thread.sleep(100);
				}
			}
		}
		
		public void consume() throws InterruptedException {
			while(true) {
				synchronized(this) {
					while(l1.size() == 0)
						wait();
					int val = l1.removeFirst();
					System.out.println("consuming : " + val);
					notifyAll();
					Thread.sleep(100);
				}
			}
		}
	}

