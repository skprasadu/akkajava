package com.hcl.javaakka.akkabigint;

import akka.actor.typed.ActorSystem;
import lombok.val;

public class AkkaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		val bigPrimes = ActorSystem.create(ManagerBehavior.create(), "BigPrimes");
        bigPrimes.tell("start");
	}

}
