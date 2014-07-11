/**
 * 
 */
package com.system;

/**
 * @author asus
 *
 */
public class Floor implements Runnable {

	private final int floorNum;
	private final Elevator elevator;
	public Floor(int floorNum,Elevator elevator) 
	{
		this.floorNum =  floorNum;
		this.elevator = elevator;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() 
	{
		 elevator.nextFloor(floorNum);

	}

}
