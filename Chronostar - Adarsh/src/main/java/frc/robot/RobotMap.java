package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

import frc.robot.subsystems.DriveTrain;

public class RobotMap{
    public RobotMap(){

    }
    
    public static int leftMasterID = 4;
    public static int leftFollower1ID = 3;
    //public static int leftFollower2ID = 4;
    public static int rightFollower2ID = 2;
    //public static int rightFollower1ID = 2;
    public static int rightMasterID = 1;

    //public static TalonSRX leftFollower2 = new TalonSRX(leftFollower2ID);
    public static TalonFX leftFollower1 = new TalonFX(leftFollower1ID);
    public static TalonFX rightFollower2 = new TalonFX(rightFollower2ID);
    //public static TalonSRX rightFollower1 = new TalonSRX(rightFollower1ID);
    public static TalonFX leftMaster = new TalonFX(leftMasterID);
    public static TalonFX rightMaster = new TalonFX(rightMasterID);

    public static AHRS ahrs = new AHRS(SerialPort.Port.kMXP);

    //private static DriveEncoder leftMainDrive = new DriveEncoder(RobotMap.leftDriveLead,RobotMap.leftDriveLead.getSelectedSensorPosition(0));
	//private static DriveEncoder rightMainDrive = new DriveEncoder(RobotMap.rightDriveLead,RobotMap.rightDriveLead.getSelectedSensorPosition(0));

    public static DriveTrain driveTrain = new DriveTrain();


}