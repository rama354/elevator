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
public class FloorInputThread extends Thread {
	
	private final Scanner in;
	private final Queue<String> pressedFloors;
	
	
	public FloorInputThread(Queue<String> pressedFloors, Scanner in){
		this.pressedFloors=pressedFloors;
		this.in = in;
	}
	@Override
	public void run() 
	{
		while(true){
			pressedFloors.add(in.next());
		}
	}

}
