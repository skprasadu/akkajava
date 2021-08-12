package com.hcl.javaakka.akkabigint;

import java.math.BigInteger;
import java.util.Random;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class WorkerBehavior extends AbstractBehavior<String> {

	private WorkerBehavior(ActorContext<String> context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static Behavior<String> create() {
		return Behaviors.setup(WorkerBehavior::new);
	}

	@Override
	public Receive<String> createReceive() {
		// TODO Auto-generated method stub
		return newReceiveBuilder()
				.onMessageEquals("start", () -> {
					BigInteger b = new BigInteger(4000, new Random());
					System.out.println(b.nextProbablePrime());
					return this;
				})
				.build();
	}

}
