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
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Drivetrain extends SubsystemBase {
  
   

PWMVictorSPX leftFrontPWMVictorSPX = null;
PWMVictorSPX leftBackPWMVictorSPX = null;
PWMVictorSPX rightFrontPWMVictorSPX = null;
PWMVictorSPX rightBackPWMVictorSPX = null; 

DifferentialDrive differentialDrive = null;

  public Drivetrain() {

    leftFrontPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_LEFT_FRONT_PWMVictorSPX);
    leftBackPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_LEFT_BACK_PWMVictorSPX);
    rightFrontPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_RIGHT_FRONT_PWMVictorSPX);
    rightBackPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_RIGHT_BACK_PWMVictorSPX);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontPWMVictorSPX, leftBackPWMVictorSPX);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontPWMVictorSPX, rightBackPWMVictorSPX);



    
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
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

