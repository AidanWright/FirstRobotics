
package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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

	public void rollerDrive(Button bDwn, Button bUp) {
		if (bDwn.get() == true) {
			rollerDriveDown();
    	} else if (bUp.get() == true) {
			rollerDriveUp();
    	} else
			rollerStop();
	}

	public void rollerDriveUp() {
		// Drives the roller up
		rollerMotor.tankDrive(RobotContainer.rollerSpeed * -1, RobotContainer.rollerSpeed * 1);
	}

	public void rollerDriveDown() {
		// Drives the roller down
		rollerMotor.tankDrive(RobotContainer.rollerSpeed * 1, RobotContainer.rollerSpeed * -1);
	}

	public void rollerStop() {
		// values to stop the rollerIntake
		rollerMotor.tankDrive(0, 0);
	}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new RollerDrive());
  }
}