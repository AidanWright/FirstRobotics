/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.WheelDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */


DifferentialDrive differentialDrive;
SpeedController leftFrontPWMVictorSPX, rightFrontPWMVictorSPX, leftBackPWMVictorSPX, rightBackPWMVictorSPX;
SpeedControllerGroup leftMotors, rightMotors;
Boolean locked;

  public Drivetrain() {
    // Creates new PWM Speed controllers
    leftFrontPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_LEFT_FRONT_PWMVictorSPX);
    rightFrontPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_RIGHT_FRONT_PWMVictorSPX);
    leftBackPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_LEFT_BACK_PWMVictorSPX);
    rightBackPWMVictorSPX = new PWMVictorSPX(RobotContainer.DRIVETRAIN_RIGHT_BACK_PWMVictorSPX);
    
    // Creates new Speed control groups
    leftMotors = new SpeedControllerGroup(leftFrontPWMVictorSPX, leftBackPWMVictorSPX);
    rightMotors = new SpeedControllerGroup(rightFrontPWMVictorSPX, rightBackPWMVictorSPX);

    differentialDrive = new DifferentialDrive(rightMotors, leftMotors);
  }

  public void drive(double moveSpeed, double rotateSpeed, double spinSpeed){
      if (moveSpeed < -RobotContainer.flightstickDeadZone || // check if past deadzone
        moveSpeed > RobotContainer.flightstickDeadZone ||
        rotateSpeed > RobotContainer.flightstickDeadZone ||
        rotateSpeed < -RobotContainer.flightstickDeadZone) {
        differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
      }
      if (spinSpeed > RobotContainer.flightstickDeadZone ||
        spinSpeed < -RobotContainer.flightstickDeadZone) {
        differentialDrive.arcadeDrive(moveSpeed, spinSpeed);
      }
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void autoDrive(double fwd, double rot) {
    //SmartDashboard.putNumber("Auto Fwrd", fwd);
    differentialDrive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new WheelDrive());
  }
}
