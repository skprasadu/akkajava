package com.hcl.javaakka.akkabigint;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import lombok.val;

public class ManagerBehavior extends AbstractBehavior<String> {

	private ManagerBehavior(ActorContext<String> context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static Behavior<String> create() {
		return Behaviors.setup(ManagerBehavior::new);
	}

	@Override
	public Receive<String> createReceive() {
		// TODO Auto-generated method stub
		 return newReceiveBuilder()
	                .onMessageEquals("start" , () -> {
	                    for (int i = 0; i < 20; i++) {
	                        val worker = getContext().spawn(WorkerBehavior.create(), "worker"+i);
	                        worker.tell("start");
	                    }
	                    return this;
	                })
	                .build();
	}

}
