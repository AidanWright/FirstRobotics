
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.RollerDrive;

public class RollerSubsystem extends SubsystemBase{

  SpeedController rollerDrive, dummyDrive;
  DifferentialDrive rollerMotor;

  public RollerSubsystem() {

    rollerDrive = new PWMVictorSPX(RobotContainer.rollerPWM);
    dummyDrive = new PWMVictorSPX(RobotContainer.dummyDriveRoller);
    rollerMotor = new DifferentialDrive(rollerDrive, dummyDrive);

  }


	public void rollerDrive() {
		// Calls the triggers and uses values to drive motors if their input is greater
		// than or equal to 5%
		if (Robot.m_oi.XButton.get() == true) {
			rollerDriveDown();
    	} else if (Robot.m_oi.BButton.get() == true) {
			rollerDriveUp();
    	} else
			rollerStop();
	}

	public void rollerDriveDown() {
		rollerMotor.tankDrive(RobotContainer.rollerSpeed * 1, RobotContainer.rollerSpeed * -1);// Polarities are opposite because of accident in wiring,change
	}

	public void rollerDriveUp() {
		rollerMotor.tankDrive(RobotContainer.rollerSpeed * -1, RobotContainer.rollerSpeed * 1);
	}



	public void rollerStop() {
		//values to stop the rollerIntake
		rollerMotor.tankDrive(0, 0);
	}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new RollerDrive());
  }
}