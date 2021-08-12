package com.hcl.javaakka.javamultithreadingbigint;

import java.math.BigInteger;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PrimeGenerator implements Runnable {
	private Result result;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		val bi = new BigInteger(2000, new Random());
		result.getResult().add(bi.nextProbablePrime());
	}

}
