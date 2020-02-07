
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.JugsMachineDrive;

public class JugsMachineSub extends SubsystemBase{

  SpeedController jugsMachineDrive, dummyDrive;
  DifferentialDrive jugsMachineMotor;

  public JugsMachineSub() {

    jugsMachineDrive = new PWMVictorSPX(RobotContainer.jugsPWM);
    dummyDrive = new PWMVictorSPX(RobotContainer.dummyDrivejugsMachine);
    jugsMachineMotor = new DifferentialDrive(jugsMachineDrive, dummyDrive);

  }


	public void JugsMachineDrive(Button jugsmachineforward, Button jugsmachinereverse) {
		// Calls the triggers and uses values to drive motors if their input is greater
		// than or equal to 5%
		if (RobotContainer.jugsMachineForward.get() == true) {
			jugsMachineForward();
    	} else if (RobotContainer.jugsMachineReverse.get() == true) {
			jugsMachineReverse();
    	} else
			jugsMachineStop();
	}

	public void jugsMachineForward() {
		jugsMachineMotor.tankDrive(RobotContainer.jugsMachineSpeed * 1, RobotContainer.jugsMachineSpeed  * -1);// Polarities are opposite because of accident in wiring,change
	}

	public void jugsMachineReverse() {
		jugsMachineMotor.tankDrive(RobotContainer.jugsMachineSpeed * -1, RobotContainer.jugsMachineSpeed * 1);
	}



	public void jugsMachineStop() {
		//values to stop the rollerIntake
		jugsMachineMotor.tankDrive(0, 0);
	}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new JugsMachineDrive());
  }
}