package com.hcl.javaakka.javamultithreadingbigint;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

import lombok.Getter;

@Getter
public class Result {
	private SortedSet<BigInteger> result = new TreeSet<>();
}
