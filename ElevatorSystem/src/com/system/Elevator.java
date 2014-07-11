package com.system;

public class Elevator {
	
	private int currentFloor;
	private Direction currentDirection;
	private enum Direction{ UP, DOWN, STATIONARY };
	
	public synchronized void nextFloor(int floornum)
	{		
		System.out.println("Moving to Floor no."+floornum);
		currentFloor=floornum;
		if (currentFloor - floornum < 0 ){
			currentDirection = Direction.UP;
		}
		else if( currentFloor - floornum > 0 )
		{
			currentDirection = Direction.DOWN;
		}
		else currentDirection = Direction.STATIONARY;
		
 	}

}
