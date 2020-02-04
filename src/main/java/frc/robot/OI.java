/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Import our needed classes
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
* Add your docs here.
 */
public class OI {
    // Joysticks
    public Joystick driverController = new Joystick(RobotContainer.OI_DRIVER_CONTROLLER);
    public XboxController xbox = new XboxController(RobotContainer.OI_XBOX_CONTROLLER);
    public Joystick Xbox = new Joystick(RobotContainer.OI_XBOX_CONTROLLER);

    // Buttons
    public Button AButton = new JoystickButton(Xbox, 1); //Green A button
    public Button BButton = new JoystickButton(Xbox, 2); //Red B button
    public Button XButton = new JoystickButton(Xbox, 3); //Blue X button
    public Button YButton = new JoystickButton(Xbox, 4); //Yellow Y button
    public Button leftBumper = new JoystickButton(Xbox, 5); //Left bumper
    public Button rightBumper = new JoystickButton(Xbox, 6); //Right bumper
    public Button backButton = new JoystickButton(Xbox, 7); //Back Button
    public Button startButton = new JoystickButton(Xbox, 8); //Start Button
    public Button leftAnalogButton = new JoystickButton(Xbox, 9); //Left Analog Press Button
    public Button rightAnalogButton = new JoystickButton(Xbox, 10); //Right Analog Press Button
    public int rightTrigger = 5;
    public int leftTrigger = 4;
}


