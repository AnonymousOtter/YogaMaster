package entity;


public class Sensor {

	String time;
	int type;
	double x;
	double y;
	double z;
	double epoch;
	String lr;
	
	public Sensor(String timeIn, int typeIn, double xIn, double yIn, double zIn, double epochIn, String lrIn) {
		this.time = timeIn;
		this.type = typeIn;
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
		this.epoch = epochIn;
		this.lr = lrIn;
	}
	
	public Sensor(){
		
	}
	
	public String getTime(){
		return this.time;
	}
	
	public int getType(){
		return this.type;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}
	
	public double getEpoch(){
		return this.epoch;
	}
	
	public String getLR(){
		return this.lr;
	}
	
	public void printAll(){
		System.out.println("----------------------------");
		System.out.println(this.time);
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println(this.z);
		System.out.println(this.lr);
		System.out.println("----------------------------");
	}

}
