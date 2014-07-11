/**
 * 
 */
package com.system;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author asus
 *
 */
public class ElevatorOperation extends Thread {
	
	private final Scanner in;
	private final Queue<Integer> pressedFloors;
	
	
	public ElevatorOperation(Queue<Integer> pressedFloors, Scanner in){
		this.pressedFloors=pressedFloors;
		this.in = in;
	}
	@Override
	public void run() 
	{
		System.out.println("Begin using elevator.........");
		while (!in.next().equalsIgnoreCase("stop"))
		{
			try{
				pressedFloors.add(Integer.parseInt(in.next()));
			}
			catch(NumberFormatException nfe){
				System.out.println("Invalid floor");
			}
		}
	}

}
