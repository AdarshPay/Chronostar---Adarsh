/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.Tools.controlLoops.PID;

public class DriveForward extends CommandBase {
  /**
   * Creates a new DriveForward.
   */

  private PID pid;

  private final double kP = 0.01;
  private final double kI = 0;
  private final double kD = 0;
  
  private double desiredSpeed;
  private double desiredTime;
  private double initTime;
  public DriveForward(double speed, double time) {
    desiredSpeed = speed;
    desiredTime = time;
    
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotMap.rightMaster.set(ControlMode.PercentOutput, desiredSpeed);
    RobotMap.leftMaster.set(ControlMode.PercentOutput, desiredSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotMap.rightMaster.set(ControlMode.PercentOutput, 0);
    RobotMap.leftMaster.set(ControlMode.PercentOutput, 0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Timer.getFPGATimestamp()-initTime >= desiredTime){
      return true;
    }
    return false;
  }
}
