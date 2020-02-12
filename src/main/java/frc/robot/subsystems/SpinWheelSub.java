/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;
import frc.robot.commands.FindColor;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;

public class SpinWheelSub extends SubsystemBase {


   Color kBlueTarget, kRedTarget, kYellowTarget, kGreenTarget;

  SpeedController spinWheelDrive, dummyDrive;
  DifferentialDrive spinWheelMotor;
  ColorSensorV3 colorSensor;
  ColorMatch colorMatcher;

  public SpinWheelSub() {

   
    spinWheelDrive = new Victor(RobotContainer.spinWheelPWM);
    dummyDrive = new Victor(RobotContainer.dummyColorWheel);
    spinWheelMotor = new DifferentialDrive(spinWheelDrive, dummyDrive);
    I2C.Port i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
    colorMatcher = new ColorMatch();
  
    kBlueTarget = ColorMatch.makeColor(0.0,0.0,0.4);
    kGreenTarget = ColorMatch.makeColor(0.0,0.5,0.0);
    kRedTarget = ColorMatch.makeColor(0.5,0.3,0.0);
    kYellowTarget = ColorMatch.makeColor(0.3,0.4,0.0);
   

    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kYellowTarget);

  }


	public void findColor(Button bDrive ) {


    Color detectedColor = colorSensor.getColor();

    //System.out.println(detectedColor);
		String colorString;
		ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
  // double IR = colorSensor.getIR();


		if (match.color == kBlueTarget){
			colorString = "Blue";
		}
		else if (match.color == kGreenTarget){
			colorString = "Green";
		}
		else if (match.color == kRedTarget){
			colorString = "Red";
		}
		else if (match.color == kYellowTarget){
			colorString = "Yellow";
		} 
		else {
			colorString =  "Unknown";
		}


    SmartDashboard.putNumber("Red",detectedColor.red);
    SmartDashboard.putNumber("Green",detectedColor.green);
    SmartDashboard.putNumber("Blue",detectedColor.blue);
    //SmartDashboard.putNumber("IR", IR);
    SmartDashboard.putNumber("Confidence",match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

		if (match.color != kRedTarget && bDrive.get() == true){
		spinWheelDrive();
		}
		
		// Calls the triggers and uses values to drive motors if their input is greater
		// than or equal to 5%
	/*	if (yInput > .05) {
			spinWheelDriveDown(yInput);
		} else if (yInput < -.05) {
			spinWheelDriveUp(yInput);
		} else
			spinWheelStop();*/
	}

	public void spinWheelDrive() {
		// Drives the spinWheel down

		// if (Timer.getMatchTime() > 25) {
		spinWheelMotor.tankDrive(RobotContainer.spinWheelSpeed * 1, RobotContainer.spinWheelSpeed * -1);// Polarities are opposite because of accident in wiring,change
														// for future robots!!!
		// }
		// else if (Timer.getMatchTime() <= 25)
		// spinWheelMotor.tankDrive(trigger * -1, 0);
	}

	public void spinWheelDriveUp() {
//drives spinWheel upward
		spinWheelMotor.tankDrive(RobotContainer.spinWheelSpeed * -1, RobotContainer.spinWheelSpeed * 1);
	}



	public void spinWheelStop() {
		//values to stop the spinWheel
		spinWheelMotor.tankDrive(0, 0);
	}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new FindColor());
  }
}