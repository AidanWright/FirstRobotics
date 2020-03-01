/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.RobotContainer;
import frc.robot.commands.FindColor;

public class SpinWheelSub extends SubsystemBase {

	Color kBlueTarget, kRedTarget, kYellowTarget, kGreenTarget;
	TalonSRX spinWheelDrive,dummyDrive;
	DifferentialDrive spinWheelMotor;
	ColorSensorV3 colorSensor;
	ColorMatch colorMatcher;
	I2C.Port i2cPort;
	DigitalInput digIn0;
	Boolean running = false;

	public SpinWheelSub() {

	spinWheelDrive = new TalonSRX(RobotContainer.spinWheelCAN);
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
	colorMatcher = new ColorMatch();
	digIn0 = new DigitalInput(0);
  
	/*if (digIn0.get() == true) { // Values for testing color wheel in shop.
		kBlueTarget = ColorMatch.makeColor(0.0,0.0,0.4);
		kGreenTarget = ColorMatch.makeColor(0.0,0.5,0.0);
		kRedTarget = ColorMatch.makeColor(0.5,0.3,0.0);
		kYellowTarget = ColorMatch.makeColor(0.3,0.4,0.0);
	} else { // Values for color wheel. defualts to this.*/
		kBlueTarget = ColorMatch.makeColor(0.0,0.0,0.4);
		kGreenTarget = ColorMatch.makeColor(0.0,0.5,0.0);
		kRedTarget = ColorMatch.makeColor(0.5,0.3,0.0);
		kYellowTarget = ColorMatch.makeColor(0.3,0.4,0.0);
	//}

    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kYellowTarget);

  }


	public void findColor(Button bDrive ) {
		//System.out.println(digIn0.get());
		SmartDashboard.putBoolean("Dig in 0", digIn0.get());
		

		if (digIn0.get() == false) { // check if in testing
			if (bDrive.get() == true){
				SmartDashboard.putBoolean("Wheel Drive", true);
				spinWheelDrive();
			} else {
				spinWheelStop();
				SmartDashboard.putBoolean("Wheel Drive", false);
			}
		} else { // defualt to regular mode
		SmartDashboard.putBoolean("Wheel Drive", false);

		Color detectedColor = colorSensor.getColor();

			String colorString;
			ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);


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
		SmartDashboard.putNumber("Confidence",match.confidence);
		SmartDashboard.putString("Detected Color", colorString);

			if (match.color != kRedTarget && bDrive.get() == true){
			spinWheelDrive();
			} else if (match.color == kRedTarget) {
			spinWheelStop();
			} else if (!(bDrive.get() == true)) {
			spinWheelStop();
			}

			if (RobotContainer.spin4.get() == true && running == false) {
				running = true;
				spinWheelDrive();
				try {
					TimeUnit.SECONDS.sleep(18);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				spinWheelStop();	
				running = false;		
			} 
		}
	}

	public void spinWheelDrive() {
		spinWheelDrive.set(ControlMode.PercentOutput, 1);
	}

	public void spinWheelStop() {
		spinWheelDrive.set(ControlMode.PercentOutput, 0);
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new FindColor());
  }
}