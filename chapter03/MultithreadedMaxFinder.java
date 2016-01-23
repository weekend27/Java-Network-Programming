package network.chapter03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMaxFinder {
	public static int max(int[] data) throws InterruptedException, ExecutionException {
		if (data.length == 1) {
			return data[0];
		} else if (data.length == 0) {
			throw new IllegalArgumentException();
		}
		
		FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
		FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		
		return Math.max(future1.get(), future2.get());
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] data = {1,32,54,64,-9,36,5,0,23,44,23,1,32,54,64,-9,36,5,0,1,32,54,64,-9,36,5,4,8,7,6,7,9,8,32,54,64,-9,36,5,0,23,44,23,1,32,54,64,32,54,64,-9,36,5,0,23,44,23,1,32,54,64};
		long st = System.currentTimeMillis();
		System.out.println(MultithreadedMaxFinder.max(data));
		long et = System.currentTimeMillis();
		System.out.println("interval time =" + (et - st));
		
		long st1 = System.currentTimeMillis();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < data.length; ++i) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		System.out.println("max =" +max);
		long et1 = System.currentTimeMillis();
		System.out.println("interval time1 =" + (et1 - st1));
	}
	
}
