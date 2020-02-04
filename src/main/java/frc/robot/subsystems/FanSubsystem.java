/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.FanControl;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Robot;

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

  public void fanDrive() {
		// Calls the triggers and uses values to drive motors if their input is greater
		// than or equal to 5%
		if (Robot.m_oi.YButton.get() == true) {
			fanDriveCW();
    } else if (Robot.m_oi.AButton.get() == true) {
      fanDriveCCW();
    } else
            fanDriveStop();
  }
  public void fanDriveCW() {
		// Drives the fan down

		// if (Timer.getMatchTime() > 25) {
		fanDrive.tankDrive(RobotContainer.fanCWSpeed * 1, RobotContainer.fanCWSpeed * -1);// Polarities are opposite because
                                                                                      // of accident in wiring,change
														// for future robots!!!
		// }
		// else if (Timer.getMatchTime() <= 25)
		// fanDrive.tankDrive(trigger * -1, 0);
  }

  public void fanDriveCCW() {
		// Drives the fan down

		// if (Timer.getMatchTime() > 25) {
		fanDrive.tankDrive(RobotContainer.fanCWSpeed * -1, RobotContainer.fanCWSpeed * 1);// Polarities are opposite because
                                                                                      // of accident in wiring,change
														// for future robots!!!
		// }
		// else if (Timer.getMatchTime() <= 25)
		// fanDrive.tankDrive(trigger * -1, 0);
  }
  
  public void fanDriveStop() {
		//values to stop the fan
		fanDrive.tankDrive(0, 0);
	}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new FanControl());
  }
}