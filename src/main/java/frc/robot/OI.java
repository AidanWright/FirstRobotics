/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.commands.ClimbUp;
//import frc.robot.commands.ShooterCommand;
//import frc.robot.commands.ClimbDown;
/**
* Add your docs here.
 */
public class OI {
    public Joystick driverController = new Joystick(RobotContainer.OI_DRIVER_CONTROLLER);
    

    Button D1 = new JoystickButton(driverController, 1);
    Button D2 = new JoystickButton(driverController, 2);
    Button D3 = new JoystickButton(driverController, 3);
    //Button D4 = new JoystickButton(driverController, 4);
    //Button D5 = new JoystickButton(driverController, 5);
    //Button D6 = new JoystickButton(driverController, 6);
    //Button D7 = new JoystickButton(driverController, 7);
    //Button D8 = new JoystickButton(driverController, 8);
    //Button D9 = new JoystickButton(driverController, 9);
    //Button D10 = new JoystickButton(driverController, 10);

    public OI() {
        while(true) {
       //D1.whenPressed(new ClimbUp());
       //D2.whenPressed(new ClimbDown());
        //D3.whenPressed(new ShooterCommand());
        }
    }
}


