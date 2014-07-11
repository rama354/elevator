/**
 * 
 */
package com.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author asus
 *
 */
public class ElevatorMain {

	private static List<Thread> floorThreadPool = new ArrayList<Thread>();
	private static Queue<String> pressedFloors = new LinkedBlockingQueue<String>();
	
	public void init(int numOfFloors)
	{	
		Elevator elevator = new Elevator();
		for (int i=1;i<=numOfFloors; i++){
			floorThreadPool.add(new Thread(new Floor(i,elevator)));
		}
	}
	
	public static void main(String[] args) 
	{
		ElevatorMain system = new ElevatorMain();
		Scanner in = new Scanner(System.in);
		system.init(in.nextInt());
		
		FloorInputThread input = new FloorInputThread(pressedFloors,in);
		input.start();
		system.getFloorThreadFromPool().start();

	}

	private Thread getFloorThreadFromPool()
	{
		
		
	}
}
