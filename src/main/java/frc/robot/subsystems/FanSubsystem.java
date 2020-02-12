/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.FanControl;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class FanSubsystem extends SubsystemBase {

  public static SpeedController fanController1, fanController2, fanController3;
  DifferentialDrive fanDrive;


  public FanSubsystem() {
    fanController1 = new PWMVictorSPX(RobotContainer.fanController1PWM);
    fanController2 = new PWMVictorSPX(RobotContainer.fanController2PWM);
    fanController3 = new PWMVictorSPX(RobotContainer.fanController3PWM);
   
    SpeedControllerGroup fan1Fan2 = new SpeedControllerGroup(fanController1, fanController2);

    fanDrive = new DifferentialDrive(fan1Fan2, fanController3);

  }

  public void fanDrive(double bCCW, double bCW) {
    if (bCW > RobotContainer.triggerDeadzone) {
	  	fanDriveCW();
    } else if (bCCW > RobotContainer.triggerDeadzone) {
      fanDriveCCW();
    } else
            fanDriveStop();
  }

  public void fanDriveCW() {
		// Drives the fan down
		fanDrive.tankDrive(RobotContainer.fanCWSpeed * 1, RobotContainer.fanCWSpeed * -1);
  }

  public void fanDriveCCW() {
		// Drives the fan down
		fanDrive.tankDrive(RobotContainer.fanCWSpeed * -1, RobotContainer.fanCWSpeed * 1);
  }
  
  public void fanDriveStop() {
		// Values to stop the fan
		fanDrive.tankDrive(0, 0);
	}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new FanControl());
  }
}