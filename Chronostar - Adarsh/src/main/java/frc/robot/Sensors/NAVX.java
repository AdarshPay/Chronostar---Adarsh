package frc.robot.Sensors;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.RobotMap;

public class NAVX {
	private double originalAngle;
	private double originalYaw;
	private double originalRoll;
	private double originalPitch;
	private AHRS imu;

	public NAVX(AHRS navx) {
		imu = navx;
		originalAngle = imu.getAngle();
		originalYaw = imu.getYaw();
		originalPitch = imu.getPitch();
		originalRoll = imu.getRoll();
	}
	public NAVX(AHRS navx, Double startAngle) {
		imu = navx;
		originalAngle = startAngle;
		originalYaw = imu.getYaw();
		originalPitch = imu.getPitch();
		originalRoll = imu.getRoll();
	}
	public double currentAngle() {
		return imu.getAngle()-originalAngle;	
	}
	public double currentPitch(){
		return imu.getPitch();
	}
	public double currentRoll(){
		return imu.getRoll();
	}
	public double currentYaw(){
		return ((imu.getYaw())-originalYaw);
	}
	public boolean isMoving() {
		return imu.isMoving();
	}
	public double currentAccelerometerX(){
		return imu.getWorldLinearAccelX();
	}
	public double currentAccelerometerY(){
		return imu.getWorldLinearAccelY();
	}
	public double currentAccelerometerZ(){
		return imu.getWorldLinearAccelZ();
	}
	public boolean isOn(){
		return imu.isConnected();
	}
	public boolean isMagCalibrated(){
		return imu.isMagnetometerCalibrated();
	}
	public boolean isAutoCalibrating(){
		return imu.isCalibrating();
	}
	public boolean isMagInerference(){
		return imu.isMagneticDisturbance();
	}
	public void softResetAngle(){
		originalAngle = RobotMap.ahrs.getAngle();

	}
	public void softResetYaw(){
		originalYaw = RobotMap.ahrs.getYaw();
	}
}