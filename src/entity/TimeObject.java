package entity;

public class TimeObject {
	
	String time;
	float x;
	float y;
	float z;
	String limb;
	Wrist rw;
	Wrist lw;
	
	public TimeObject(String timeIn, Wrist rwIn, Wrist lwIn){
		this.time = timeIn;
		this.rw = rwIn;
		this.lw = lwIn;
	}
	
	
	public String getTime(){
		return this.time;
	}
	
	public Wrist getLeft(){
		return this.lw;
	}
	
	public Wrist getRight(){
		return this.rw;
	}
	
	public double avX(int type){
		double lVar = 0;
		double rVar = 0;
		double difference = 0;
		
		if(type == 0){
			lVar = (this.lw.getAccel().getX() * -1);
			rVar = this.rw.getAccel().getX();
		}
		else if(type == 1){
			lVar = (this.lw.getGyro().getX() * -1);
			rVar = this.rw.getGyro().getX();
		}
		else if(type == 2){
			lVar = (this.lw.getMagno().getX() * -1);
			rVar = this.rw.getMagno().getX();
		}
		
		if(lVar <= rVar){
			difference = rVar - lVar;
		}
		if(rVar <= lVar){
			difference = lVar - rVar;
		}
		
		return difference;
	}
	
	public double avY(int type){
		double lVar = 0;
		double rVar = 0;
		double difference = 0;
		
		if(type == 0){
			lVar = this.lw.getAccel().getY();
			rVar = this.rw.getAccel().getY();
		}
		else if(type == 1){
			lVar = this.lw.getGyro().getY();
			rVar = this.rw.getGyro().getY();
		}
		else if(type == 2){
			lVar = this.lw.getMagno().getY();
			rVar = this.rw.getMagno().getY();
		}
		
		if(lVar <= rVar){
			difference = rVar - lVar;
		}
		if(rVar <= lVar){
			difference = lVar - rVar;
		}
		
		return difference;
	}
	
	public double avZ(int type){
		double lVar = 0;
		double rVar = 0;
		double difference = 0;
		
		if(type == 0){
			lVar = this.lw.getAccel().getZ();
			rVar = this.rw.getAccel().getZ();
		}
		else if(type == 1){
			lVar = this.lw.getGyro().getZ();
			rVar = this.rw.getGyro().getZ();
		}
		else if(type == 2){
			lVar = this.lw.getMagno().getZ();
			rVar = this.rw.getMagno().getZ();
		}
		
		if(lVar <= rVar){
			difference = rVar - lVar;
		}
		if(rVar <= lVar){
			difference = lVar - rVar;
		}
		
		return difference;
	}
}
