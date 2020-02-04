/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCannon;

public class CannonRotateSub extends SubsystemBase {

  SpeedController cannonDrive, dummyDrive;
  DifferentialDrive cannonMotor;

  public CannonRotateSub() {

    cannonDrive = new PWMVictorSPX(RobotContainer.cannonDrivePWM);
    dummyDrive = new PWMVictorSPX(RobotContainer.dummyDriveCannon);
    cannonMotor = new DifferentialDrive(cannonDrive, dummyDrive);

  }


	public void cannonDrive(double yInput) {
		// Calls the triggers and uses values to drive motors if their input is greater
		// than or equal to 5%
		if (yInput > .05) {
			cannonDriveDown(yInput);
		} else if (yInput < -.05) {
			cannonDriveUp(yInput);
		} else
			cannonStop();
	}

	public void cannonDriveDown(double yInput) {
		// Drives the cannon down

		// if (Timer.getMatchTime() > 25) {
		cannonMotor.tankDrive(RobotContainer.cannonDriveSpeed * 1, RobotContainer.cannonDriveSpeed * -1);// Polarities are opposite because of accident in wiring,change
														// for future robots!!!
		// }
		// else if (Timer.getMatchTime() <= 25)
		// cannonMotor.tankDrive(trigger * -1, 0);
	}

	public void cannonDriveUp(double yInput) {
        //drives cannon upward
		cannonMotor.tankDrive(RobotContainer.cannonDriveSpeed * -1, RobotContainer.cannonDriveSpeed * 1);
	}



	public void cannonStop() {
		//values to stop the cannon
		cannonMotor.tankDrive(0, 0);
	}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCannon());
  }
}