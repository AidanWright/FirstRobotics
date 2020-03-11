/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

// Import our needed classes
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
* This class creates and maps the controllers.
 */
public class OI {

    // 
    //public static final ADIS16448_IMU imu = new ADIS16448_IMU();


    // Joysticks
    public Joystick driverController = new Joystick(RobotContainer.OI_DRIVER_CONTROLLER);
    public Joystick Xbox = new Joystick(RobotContainer.OI_XBOX_CONTROLLER);
    public XboxController XboxController = new XboxController(RobotContainer.OI_XBOX_CONTROLLER);

    // Buttons 
    public JoystickButton AButton = new JoystickButton(Xbox, 1); // Green A button
    public JoystickButton YButton = new JoystickButton(Xbox, 4); // Yellow Y button
    public JoystickButton XButton = new JoystickButton(Xbox, 3); // Blue X button
    public JoystickButton BButton = new JoystickButton(Xbox, 2); // Red B button
    public POVButton UpButton = new POVButton(Xbox, 0); // Up button on D-pad
    public POVButton DownButton = new POVButton(Xbox, 180); // Down button on D-pad
    public POVButton LeftButton = new POVButton(Xbox, 270); // Left button on D-pad
    public POVButton RightButton = new POVButton (Xbox, 90); // Right button on D-pad
    public JoystickButton leftBumper = new JoystickButton(Xbox, 5); // Left bumper
    public JoystickButton rightBumper = new JoystickButton(Xbox, 6); // Right bumper 
    public JoystickButton leftPress = new JoystickButton(Xbox, 9); // Button on left stick
    public JoystickButton rightPress = new JoystickButton(Xbox, 10); // Button on right stick
    public final int rightTrigger = 3; // On xbox controllers the right trigger is on port 3
    public final int leftTrigger = 2; // The left is on port 2

    public Button D1 = new JoystickButton(driverController, 1); // 1st button on flightstick
    public Button D2 = new JoystickButton(driverController, 2); // 2nd button on flightstick
    public Button D3 = new JoystickButton(driverController, 3); // 3rd button on flightstick
    public Button D4 = new JoystickButton(driverController, 4); // 4th button on flightstick
    public Button D5 = new JoystickButton(driverController, 5); // 5th button on flightstick
    public Button D6 = new JoystickButton(driverController, 6); // 6th button on flightstick
    
    // Axis
    public final int slider = 3; // Slider on flightstick. 
                                 // NOTE: neg is labeled as positive and vice-versa.

    public Command getAutonomousCommand() {
        return null; // fix
    }
                                
    
}



