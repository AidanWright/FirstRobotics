/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where all the constants for the robot is kept.
 * 
 * All vars can be accessed from anywhere since every var has the `public static` modifiers
 * and cannot be changed modified from elsewhere with the `final` modifier.
 * 
 * Vars with field int define a port for things like controllers, pwm, triggers, etc.
 * Vars with field Button are clickable buttons.
 * Vars with field double are used mainly for deadzones.
 */
public class RobotContainer {

  /* Controller Config */
  // Joysticks
  public static final int OI_DRIVER_CONTROLLER = 0; // FLightstick on port 0
  public static final int OI_XBOX_CONTROLLER = 1; // Xbox controller on port 1
  public static final double controllerDeadZone = 0.15; // Xbox Controller's deadzone (def 0.05)
  public static final double triggerDeadzone = 0.05; // Xbox trigger's deadzone. Realistically this is not needed unless the controller is REALLY bad.
  public static final double flightstickDeadZone = 0.15; // Flightstick's deadzone (def 0.05)
  /* Buttons */
  // Roller Buttons
  public static final Button rollerButtonUp = Robot.oi.leftBumper; // Button to run the roller intake.
  public static final Button rollerButtonDown = Robot.oi.leftPress; // Button to run the roller in the opposite direction. Used if a ball gets stuck.
  // Fan Buttons
  public static final Button fanButtonCCW = Robot.oi.rightBumper; // Button to run the fans for shooting.
  public static final int fanButtonCW = Robot.oi.leftTrigger; // Button to run the fans for intake.
  // Jugs Machine Buttons
  public static final int jugsMachineForward = Robot.oi.rightTrigger; // Button to shoot the jugs. Press this and wait for jugs to come to speed before using the fans.
  public static final int jugsMachineReverse = Robot.oi.leftTrigger; // Button to load balls into the cannon.
  // Cannon Angle Buttons
  public static final Button TrenchRunButton = Robot.oi.UpButton; // Button to level the robot.
  public static final Button closeShotButton = Robot.oi.RightButton;
  public static final Button IntakeAngleButton = Robot.oi.DownButton;
  public static final Button ThirtyTreeButton = Robot.oi.LeftButton;
  public static final Button LoadingIntake = Robot.oi.rightPress;
  public static final Button sevenTyroneFeetButton = Robot.oi.LeftButton;


  // Solenoid Buttons
  public static final Button climbButtonExtend = Robot.oi.D1; // Button to extend the arm.
  public static final Button climbButtonRetract = Robot.oi.D2; // Button to retract the arm.
  public static final Button rollerButtonExtend = Robot.oi.XButton; // Button to extend the arm.
  public static final Button rollerButtonRetract = Robot.oi.YButton; // Button to retract the arm.
  public static final Button singleSolenoidButtonExtend = Robot.oi.D4; // Button to extend the single solenoid. 
  public static final Button singleSolenoidButtonRetract = Robot.oi.D3; // Button to retract the single solenoid. No clue what these last two do.
  public static final Button colorSolenoidButtonExtend = Robot.oi.AButton; // Button to extend the color wheel solenoid.
  public static final Button colorSolenoidButtonRetract = Robot.oi.BButton; // Button to retact the color wheel solenoid.
  public static final Button spin4 = Robot.oi.D5;
  public static final Button cruiseControllButton = Robot.oi.D1;
   // Color Wheel Button
  public static final Button  colorWheelDrive = Robot.oi.D6; // Button to drive the color wheel.

  /* Port Configs */
  /* PWM */
  // Wheel Ports
  public static final int DRIVETRAIN_LEFT_FRONT_PWMVictorSPX = 1;
  public static final int DRIVETRAIN_RIGHT_FRONT_PWMVictorSPX = 0;
  public static final int DRIVETRAIN_LEFT_BACK_PWMVictorSPX = 3;
  public static final int DRIVETRAIN_RIGHT_BACK_PWMVictorSPX = 2;
  // Motor Ports
  public static final int rollerPWM = 4;
  public static final int jugsPWM = 5;
  public static final int cannonDrivePWM = 6;
  public static final int fanController1PWM = 7;
  public static final int fanController2PWM = 8;
  public static final int fanController3PWM = 9;
  public static final int spinWheelCAN = 3;
  // Dummy ports
  public static final int dummyDriveCannon = 11;
  public static final int dummyDriveRoller = 12;
  public static final int dummyColorWheel = 13;
  public static final int dummyDrivejugsMachine = 14;
  /* misc. */
  // Potentiometer Port
  public static final int potentiometer = 3; 

  /* Speed Configs */
  // Speeds
  public static final double cannonDriveSpeed = 0.75;
  public static final double fanCWSpeed = 1;
  public static final double fanCCWSpeed = 1;
  public static final double rollerSpeed = 0.85;
  public static final double jugsMachineSpeed = 0.95;
  public static final double spinWheelSpeed = 1.0;
  public static final double driveSpeed = 1.0;
  public static final double strafeSpeed = 1.0;

  /* Other */
  // Saftey
  public static final int patSupidSaftey = Robot.oi.slider; // Saftey for solenoids.
  // Cannon Positions
  public static final double Level = 1.856689263; // 1.436767
  public static final double limitUp = Level - 1.136767; // 0.3
  public static final double limitDown = Level + 0.753174; // 2.189941

  public static final double IntakeAngle = Level + 0.52002; // 1.956787
  public static final double sevenTyroneFeetShot = Level - 0.477767; // 0.959
  public static final double thirtyTreeFeetShot = 0.496826121; // 0.496826121
  public static final double tenFootShot = Level - 0.581167; // 0.9326
  public static final double closeShot = Level - 0.899617; // 0.58715
  public static final double loadingAngle = Level - 0.181884; // 1.254883


  /**
   * The container for the robot.  This SHOULD Contain subsystems, OI devices, 
   * and commands  but pat mixed up Constants, OI and RobotContainer.
   * Thank him for this mess
   */
  public RobotContainer() {
  }
}
