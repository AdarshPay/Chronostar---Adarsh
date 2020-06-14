package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;

public class RobotConfig {
    public RobotConfig() {

    }
    //adarsh has no thumbs

    public static void setStartingConfig() {
        //RobotMap.leftMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        //RobotMap.rightMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        RobotMap.leftMaster.setSelectedSensorPosition(0);
        RobotMap.rightMaster.setSelectedSensorPosition(0);


        RobotMap.leftFollower1.set(ControlMode.Follower, RobotMap.leftMasterID);
        //RobotMap.leftFollower2.set(ControlMode.Follower, RobotMap.leftMasterID);
        //RobotMap.rightFollower1.set(ControlMode.Follower, RobotMap.rightMasterID);
        RobotMap.rightFollower2.set(ControlMode.Follower, RobotMap.rightMasterID);
        RobotMap.leftMaster.setInverted(true);
        RobotMap.leftFollower1.setInverted(InvertType.FollowMaster);
        //RobotMap.leftFollower2.setInverted(InvertType.FollowMaster);
    }
}