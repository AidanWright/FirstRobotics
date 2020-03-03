/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCannon;

public class CannonRotateSub extends SubsystemBase {

  SpeedController cannonDrive, dummyDrive;
  DifferentialDrive cannonMotor;
  AnalogInput Voltage;

  public CannonRotateSub() {
    cannonDrive = new PWMVictorSPX(RobotContainer.cannonDrivePWM);
    dummyDrive = new PWMVictorSPX(RobotContainer.dummyDriveCannon);
	cannonMotor = new DifferentialDrive(cannonDrive, dummyDrive);
	Voltage = new AnalogInput(RobotContainer.potentiometer);
  }


	public void cannonDrive(double yInput) {
		// Calls the triggers and uses values to drive motors if their input surpasses deadzone floor
		if (yInput >= RobotContainer.controllerDeadZone) {
			cannonDriveUp();
		} else if (yInput <= -RobotContainer.controllerDeadZone) {
			cannonDriveDown();
		} else
			cannonStop();
}

	public void cannonDriveDown() {
		// Drives cannon down
		cannonMotor.tankDrive(RobotContainer.cannonDriveSpeed * 1, RobotContainer.cannonDriveSpeed * -1);
	}

	public void cannonDriveUp() {
        // Drives cannon up
		cannonMotor.tankDrive(RobotContainer.cannonDriveSpeed * -1, RobotContainer.cannonDriveSpeed * 1);
	}



	public void cannonStop() {
		// Values to stop the cannon
		cannonMotor.tankDrive(0, 0);
	}

	public boolean armAtAngle(double angle) {
		if(getVoltage() >= (angle - 0.05) && (getVoltage() <= (angle + 0.05)))
		return true;
		else 
		return false;
	}

	public double getVoltage() {
		return Voltage.getAverageVoltage();
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCannon());
  }
}