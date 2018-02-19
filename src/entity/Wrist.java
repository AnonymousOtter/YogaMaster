package entity;

public class Wrist {

	String wrist;
	Sensor accelerometer;
	Sensor gyroscope;
	Sensor magnetometer;
	
	public Wrist(String wristIn, Sensor acc, Sensor gyr, Sensor mag) {
		this.wrist = wristIn;
		this.accelerometer = acc;
		this.gyroscope = gyr;
		this.magnetometer = mag;
	}
	
	public String getWrist(){
		return this.wrist;
	}
	
	public Sensor getAccel(){
		return this.accelerometer;
	}
	
	public Sensor getGyro(){
		return this.gyroscope;
	}
	
	public Sensor getMagno(){
		return this.magnetometer;
	}

}
