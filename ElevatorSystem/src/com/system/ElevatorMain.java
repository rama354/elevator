/**
 * 
 */
package com.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

import com.system.Elevator.Direction;

/**
 * @author asus
 *
 */
public class ElevatorMain {

	private static List<Thread> floorThreadPool = new ArrayList<Thread>();
	private static Queue<Integer> pressedFloors = new LinkedBlockingQueue<Integer>();
	private Elevator elevator;
	
	public void init(int numOfFloors)
	{	
		elevator = new Elevator();
		for (int i=0;i<=numOfFloors; i++){
			floorThreadPool.add(new Thread(new Floor(i,elevator)));
		}
	}
	
	public static void main(String[] args) 
	{
		ElevatorMain system = new ElevatorMain();
		Scanner in = new Scanner(System.in);
		System.out.println("How many floors in the building?");
		system.init(in.nextInt());
		
		ElevatorOperation input = new ElevatorOperation(pressedFloors,in);
		input.start();
	
		while(!pressedFloors.isEmpty())
			system.getNextFloorFromPool().start();

	}


	/**
	 * algorithm for identifying next floor for elevator
	 * @return
	 */
	private Thread getNextFloorFromPool()
	{
		int diff=0;
		TreeMap<Integer,Integer> upDiffMap = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> downDiffMap = new TreeMap<Integer,Integer>();
		Iterator<Integer> iter = pressedFloors.iterator();
		
		while (iter.hasNext())
		{
			int pressedFloor = iter.next();
			diff = pressedFloor-elevator.getCurrentFloor();
			if (diff < 0)
			{
				downDiffMap.put(Math.abs(diff),pressedFloor);
			}
			if (diff > 0)
			{
				upDiffMap.put(diff,pressedFloor);
			}
				
		}
		
		if (elevator.getCurrentDirection() ==  Direction.UP)
		{
			pressedFloors.remove(upDiffMap.firstKey());
			return floorThreadPool.get(upDiffMap.firstKey());
		}
		else{
			pressedFloors.remove(downDiffMap.firstKey());
			return floorThreadPool.get(downDiffMap.firstKey());
		}
		
		
	}
}
