package assignment4;

public class DeviceThread  implements Runnable{
    private String Name;
    private int Timer;
    private Device Device;

    public DeviceThread(Device Device, String name, int time ){
        this.Name = name;
        this.Timer = time;
        this.Device = Device;
    }

    public void setTimer(int timer) {
        this.Timer = timer;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Timer);
            System.out.println(Name + " is over");
            Device.setIsRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


