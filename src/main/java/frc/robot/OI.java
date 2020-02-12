/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Import our needed classes
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
/**
* Add your docs here.
 */
public class OI {
    // Joysticks
    public Joystick driverController = new Joystick(RobotContainer.OI_DRIVER_CONTROLLER);
    public Joystick Xbox = new Joystick(RobotContainer.OI_XBOX_CONTROLLER);
    public XboxController xboxController = new XboxController(RobotContainer.OI_XBOX_CONTROLLER);

    // Buttons
    public Button AButton = new JoystickButton(Xbox, 1); //Green A button
    public Button YButton = new JoystickButton(Xbox, 4); //Yellow Y button
    public Button XButton = new JoystickButton(Xbox, 3); //Blue X button
    public Button BButton = new JoystickButton(Xbox, 2); //Red B button
    public Button leftBumper = new JoystickButton(Xbox, 5);//Left bumper
    public Button rightBumper = new JoystickButton(Xbox, 6);//Right bumper 
    public final int rightTrigger = 2;
    public final int leftTrigger = 3;

    Button D1 = new JoystickButton(driverController, 1);
    Button D2 = new JoystickButton(driverController, 2);
    Button D3 = new JoystickButton(driverController, 3);
    Button D4 = new JoystickButton(driverController, 4);
    Button D5 = new JoystickButton(driverController, 5);
    Button D6 = new JoystickButton(driverController, 6);
    
    // Axis
    public final int slider = 3;

}


