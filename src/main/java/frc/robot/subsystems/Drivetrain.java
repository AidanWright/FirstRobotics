/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveArcade;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.hal.PWMJNI;


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */

PWMVictorSPX leftSidePWMVictorSPX = null;
PWMVictorSPX rightSidePWMVictorSPX = null;

DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    leftSidePWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_LEFT_SIDE_PWMVictorSPX);
    rightSidePWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_RIGHT_SIDE_PWMVictorSPX);

    
    differentialDrive = new DifferentialDrive(leftSidePWMVictorSPX, rightSidePWMVictorSPX);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void initDefaultCommandBase() {
setDefaultCommand(new DriveArcade());

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
