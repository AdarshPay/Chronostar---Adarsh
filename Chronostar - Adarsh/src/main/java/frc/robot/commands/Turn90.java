/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.Tools.controlLoops.PID;

public class Turn90 extends CommandBase {
  /**
   * Creates a new Turn90.
   */

  private PID pid;

  private final double kP = 0.01;
  private final double kI = 0;
  private final double kD = 0;

  
  private double originalAngle;

  public Turn90(double firstAngle) {
    // Use addRequirements() here to declare subsystem dependencies.
    originalAngle = firstAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid = new PID(kP, kI, kD);
    pid.setSetPoint(90);
    pid.setMinOutput(-0.25);
    pid.setMaxOutput(0.25);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pid.updatePID(RobotMap.ahrs.getAngle());
    System.out.println("Get result" + pid.getResult());
    RobotMap.rightMaster.set(ControlMode.PercentOutput, pid.getResult());
    RobotMap.leftMaster.set(ControlMode.PercentOutput, -pid.getResult());
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
    if(Math.abs(RobotMap.ahrs.getAngle() - 90) <= 0.5) {
      return true;
    }
    return false;
  }
}
