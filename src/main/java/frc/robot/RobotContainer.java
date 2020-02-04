/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Import our needed classes
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /* Controller Config */
  // Joysticks
  public static final int OI_DRIVER_CONTROLLER = 0; // FLightstick on port 0
  public static final int OI_XBOX_CONTROLLER = 1; // Xbox controller on port 1
  public static final double controllerDeadZone = 0.15; // Controller's deadzone (def 0.05)
  public static final double flightstickDeadZone = 0.15; // Controller's deadzone (def 0.05)
  // Roller Buttons
  public static final Button rollerButtonDown = Robot.oi.XButton;
  public static final Button rollerButtonUp = Robot.oi.XButton;
  // Fan Buttons
  public static final Button fanButtonCW = Robot.oi.XButton;
  public static final Button fanButtonCCW = Robot.oi.XButton;

  /* PWM Port Configs */
  // Wheel Ports
  public static final int DRIVETRAIN_LEFT_FRONT_PWMVictorSPX = 0;
  public static final int DRIVETRAIN_RIGHT_FRONT_PWMVictorSPX = 1;
  public static final int DRIVETRAIN_LEFT_BACK_PWMVictorSPX = 2;
  public static final int DRIVETRAIN_RIGHT_BACK_PWMVictorSPX = 3;
  // Motor Ports
  public static final int rollerPWM = 4;
  public static final int cannonDrivePWM = 6;
  public static final int fanController1PWM = 7;
  public static final int fanController2PWM = 8;
  public static final int fanController3PWM = 9;
  // Dummy ports
  public static final int dummyDriveCannon = 11;
  public static final int dummyDriveRoller = 12;

  /* Speed Configs */
  // Speeds
  public static final double cannonDriveSpeed = 0.5;
  public static final double fanCWSpeed = 0.5;
  public static final double fanCCWSpeed = 0.5;
  public static final double rollerSpeed = 0.5;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
 // }
}
