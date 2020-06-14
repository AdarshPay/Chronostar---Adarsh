/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ButtonMap;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
	/**
	 * Creates a new DriveTrain.
	 */
	public DriveTrain() {

	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}

	public void telopPeriodic(){
		arcadeDrive();
	}

	public void tankDrive() {
		if (Math.abs(ButtonMap.getRightSide()) > 0.1) {
			RobotMap.rightMaster.set(ControlMode.PercentOutput, ButtonMap.getRightSide());
		}

		else {
			RobotMap.rightMaster.set(ControlMode.PercentOutput, 0);
		}

		if (Math.abs(ButtonMap.getLeftSide()) > 0.1) {
			RobotMap.leftMaster.set(ControlMode.PercentOutput, ButtonMap.getLeftSide());
		}

		else {
			RobotMap.leftMaster.set(ControlMode.PercentOutput, 0);
		}
	}

	public void arcadeDrive() {
		if (Math.abs(ButtonMap.getForwardMovement()) > 0.1 || Math.abs(ButtonMap.getTurningMovement()) > 0.1) {
			if (ButtonMap.getForwardMovement() + ButtonMap.getTurningMovement() > 1){
				RobotMap.rightMaster.set(ControlMode.PercentOutput, 1);
				RobotMap.leftMaster.set(ControlMode.PercentOutput, ButtonMap.getForwardMovement() - ButtonMap.getTurningMovement()/ButtonMap.getForwardMovement() + ButtonMap.getTurningMovement());
			}

			else if (ButtonMap.getForwardMovement() + ButtonMap.getTurningMovement() < 1){
				RobotMap.rightMaster.set(ControlMode.PercentOutput, -1);
				RobotMap.leftMaster.set(ControlMode.PercentOutput, ButtonMap.getForwardMovement() - ButtonMap.getTurningMovement()/ButtonMap.getForwardMovement() + ButtonMap.getTurningMovement());
			}

			if (ButtonMap.getForwardMovement() - ButtonMap.getTurningMovement() > 1){

			}

			RobotMap.rightMaster.set(ControlMode.PercentOutput, ButtonMap.getForwardMovement() + ButtonMap.getTurningMovement());
			RobotMap.leftMaster.set(ControlMode.PercentOutput, ButtonMap.getForwardMovement() - ButtonMap.getTurningMovement());
		}

		else {
			RobotMap.leftMaster.set(ControlMode.PercentOutput, 0);
			RobotMap.rightMaster.set(ControlMode.PercentOutput, 0);
		}

	}

}
