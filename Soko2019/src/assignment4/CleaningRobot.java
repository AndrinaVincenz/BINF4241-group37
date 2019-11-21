package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class CleaningRobot extends Device implements Timeable, Bootable, Chargeable, Interrupitble {
	
	private String name = "CleaningRobot";
	private boolean atChargingBase = true;
	private int timer;
	private boolean IsRunning;
	private Thread CleaningRobotTimerThread;
	private long startTimer;
	private long currentTime = System.currentTimeMillis();
	private int diffTime = (int) (currentTime - startTimer); 
	private int rechargeTime = 25;
	private boolean isRunning;
	private double batteryStatus; 
	private double cleaningCompletion = 0.00;
	private double startChargingTimer;
	private int CurrentbatteryChargingStatus; 
	private int CurrentbatteryStatus;
	private double CurrentCleaningCompletion;
	
	@Override
	public void setIsRunning(boolean running) {
		this.IsRunning = running;
	
	}
	@Override
	public String getName() {
		return name;
	}

	public void getCleaningCompletion() {
		CurrentCleaningCompletion = ((diffTime / timer) * 100) /1000;
		if (CurrentCleaningCompletion + cleaningCompletion>= 100) {
			System.out.println("Robo is finished and returns to base");
			interrupt();
		}
		System.out.println("Percentage of Cleaning Completion: " + cleaningCompletion + CurrentCleaningCompletion);
	}
	// Timeable
	@Override
	public void setTimer(int timer) {
		this.timer = timer;
		
		System.out.println(name + ": Timer is set to " + timer);
	}
	public void getTimer() {
		
	}
	public void getBatteryChargingStatus() {
		CurrentbatteryChargingStatus = (int) ((int) 100 - ((((currentTime - startChargingTimer) / rechargeTime) *100)) / 1000);
		if (batteryStatus + CurrentbatteryChargingStatus >= 100) {
			System.out.println("BatteryChargingStatus: " + 100.00);
		} else {
			int total = (int) (batteryStatus + CurrentbatteryChargingStatus);
			System.out.println("BatteryChargingStatus: " + total + "%");
		}
	}

	public void getBatteryStatus() {
		currentTime = System.currentTimeMillis();
		diffTime = (int) (currentTime - startTimer);
		CurrentbatteryStatus = (int) ((int) 100 -  ((100.00 - (diffTime / timer) * 100)) / 1000) -100;
		if (CurrentbatteryStatus <= 0) {
			interrupt();
		} 
		System.out.println("Batterystatus: " + CurrentbatteryStatus + "%");
	}
	public void completeCleaning() {
		if (cleaningCompletion >= 0) {
			System.out.println("Robo will start again at: " + cleaningCompletion);
			start();
		} else {
			System.out.println("Robo is finished cleaning, start from beginning.");
		}
		
		
	}
	// Bootable
		@Override
		public void start() {
			if (timer <= 0) {
				System.out.println("Set Timer first");
			} else if (atChargingBase && batteryStatus == 100) {
				
				this.IsRunning = true;
				CleaningRobotTimerThread = new Thread(new DeviceThread(this, "CleaningRobotTimer", this.timer));
				CleaningRobotTimerThread.start();
				this.startTimer = System.currentTimeMillis();
				this.startChargingTimer = 0;
				this.atChargingBase = false;
			} else {
				System.out.println("Battery isn't full yet");
				this.getBatteryStatus();

				
			
			}
		}
	@Override
	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		if (IsRunning == false) {
			result.add(new StartCommand(this));
			
			result.add(new GetTimerCommand(this));
			result.add(new SetTimerCommand(this));
			
			result.add(new CompleteCleaning(this));
			result.add(new CheckBatteryChargingCommand(this));
		}
		else{
			result.add(new InterruptCommand(this));
			result.add(new CheckBatteryCommand(this));
			result.add(new CheckCleaningCompletionCommand(this));
		}
		return result;
	}
	@Override
	public void interrupt() {
		if(IsRunning == true){
			this.CleaningRobotTimerThread.interrupt();
			this.IsRunning = false;
			this.atChargingBase = true;
			CurrentCleaningCompletion = ((diffTime / timer) * 100) /1000;
			this.cleaningCompletion += CurrentCleaningCompletion;
			if (cleaningCompletion >= 100) {
				cleaningCompletion = 0.00;
			}
			this.startTimer = 0;
			this.CurrentbatteryStatus = (int) ((100.00 - (diffTime / timer) * 100)) / 1000;
			this.batteryStatus = CurrentbatteryStatus;
			if (batteryStatus <= 0) {
				this.batteryStatus = 0;
			}
			this.startChargingTimer = System.currentTimeMillis();
		}
		else{
			System.out.println("Robo is not cleaning");
		}
	}

}
