package com.hcl.javaakka.javamultithreadingbigint;

import java.util.ArrayList;

import lombok.val;

public class JavaMultithreading {

	public static void main(String[] args) throws InterruptedException {
		val start = System.currentTimeMillis();

		val result = new Result();
		val r = new PrimeGenerator(result);

		val threads = new ArrayList<Thread>();

		for (int i = 0; i < 20; i++) {
			val t = new Thread(r);
			threads.add(t);
			t.start();
		}

		for (val t : threads) {
			t.join();
		}
		
		System.out.println(result.getResult());

		val end = System.currentTimeMillis();

		System.out.println("Total time " + (end - start) + " ms.");
	}

}
