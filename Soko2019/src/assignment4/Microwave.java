package assignment4;

import java.util.ArrayList;

public class Microwave extends Device implements Switchable, Heatable, Timeable, Bootable, Interrupitble {
	private String name = "Microwave";
	private boolean IsOn = false;
	private int timer;
	private int temperature;
	private boolean IsRunning = false;
	private Thread MicrowaveTimerThread;
	private long startTimer;
	
	public void setRunning(boolean running) {
		this.IsRunning = running;
	}

	@Override
	public String getName() {
		return name;
	}

	// Switchable
	@Override
	public void switchOff() {
		System.out.println(name + ": Switched OFF!");
		IsOn = false;

	}

	// Switchable
	@Override
	public void switchOn() {
		System.out.println(name + ": Switched ON!");
		IsOn = true;
	}

	// Heatable
	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		System.out.println(name + ": Temperatur is set to " + temperature + "!");
	}

	// Timeable
	@Override
	public void setTimer(int timer) {
		this.timer = timer;
		System.out.println(name + ": Timer is set to " + timer);
		this.startTimer = System.currentTimeMillis(); 
		
	}
	public void getTimer() {
			if (IsRunning == true) {
				long currentTime = System.currentTimeMillis();
				long remainingTime = (currentTime - startTimer) / 1000;
				System.out.println("Remaining time: " + remainingTime +"s" );
			} else {
				System.out.println("Last set timer: " + timer +"s" );
			}
			
		}
	

	// Bootable
	@Override
	public void start() {
		if (IsOn && this.timer != 0 && this.temperature != 0 && IsRunning == false){
			this.IsRunning = true;
			System.out.println(name + ": Start Baking!");
			System.out.println("Temperatur:" + temperature);
			System.out.println("Timer:" + timer);
			MicrowaveTimerThread = new Thread(new DeviceThread(this,"MicrowaveTimer", this.timer));
			MicrowaveTimerThread.start();
		} else {
			System.out.println("Setup for microwave incomplete!");
			if (!IsOn) {
				System.out.println("Not switched On!");
			}
			if (!(temperature > 0)) {
				System.out.println("Temperatur not set!");
			}
			if (!(timer > 0)) {
				System.out.println("Timer must be set!");
			}
			if(IsRunning == true){
				System.out.println("Device still running!");
			}
		}
	}

	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		if(IsOn == true) {
			result.add(new SwitchOnCommand(this));
			result.add(new SetTimerCommand(this));
			result.add(new SetTemperaturCommand(this));
			result.add(new StartCommand(this));
			result.add(new GetTimerCommand(this));
			result.add(new InterruptCommand(this));
			result.add(new SwitchOffCommand(this));
		}
		else{
			result.add(new SwitchOnCommand(this));
		}
		return result;
	}

	@Override
	public void interrupt() {
		if(IsRunning == true){
			this.MicrowaveTimerThread.interrupt();
			this.IsRunning = false;
			this.startTimer = 0;
		}
		else{
			System.out.println("Microwave is not running");
		}
	}
}
