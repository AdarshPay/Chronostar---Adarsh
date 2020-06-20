/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.Sensors.NAVX;
import frc.robot.Tools.controlLoops.PID;

public class Turn90 extends CommandBase {
  /**
   * Creates a new Turn90.
   */

  private PID pid;

  private final double kP = 0.014;
  private final double kI = 0.00035;
  private final double kD = 0.01;

  private NAVX navx;

  private double originalAngle;

  public Turn90() {
    // Use addRequirements() here to declare subsystem dependencies.
    //originalAngle = firstAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    navx = new NAVX(RobotMap.ahrs);
    navx.softResetAngle();
    pid = new PID(kP, kI, kD);
    pid.setSetPoint(180);
    pid.setMinOutput(-0.75);
    pid.setMaxOutput(0.75);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pid.updatePID(navx.currentAngle());
    SmartDashboard.putNumber("OriginalAngle", originalAngle);
    SmartDashboard.putNumber("Navx Angle", navx.currentAngle());
    SmartDashboard.putNumber("Get result", pid.getResult());
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
    if(Math.abs(navx.currentAngle() - 180) <= 0.25) {
      SmartDashboard.putBoolean("Finished", true);
      return true;
    }
    return false;
  }
}
