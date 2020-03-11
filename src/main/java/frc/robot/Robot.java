/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
// Import our needed classes
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.CannonRotateSub;
import frc.robot.subsystems.ColorSolenoidSub;
import frc.robot.subsystems.DoubleSolenoidSub;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FanSubsystem;
import frc.robot.subsystems.JugsMachineSub;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.SingleSolenoidSub;
import frc.robot.subsystems.SpinWheelSub;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

// import org.opencv.core.Mat;
// import org.opencv.core.Point;
// import org.opencv.core.Scalar;
// import org.opencv.imgproc.Imgproc;

// import edu.wpi.cscore.CvSink;
// import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {

  // Declare our variables
  private Command m_autonomousCommand;
  public static OI oi;
  public static Drivetrain drivetrain;
  public static CannonRotateSub cannonRotateSub;
  public static FanSubsystem fanSubsystem;
  public static RollerSubsystem rollerSubsystem;
  public static DoubleSolenoidSub doubleSolenoidSub;
  public static SpinWheelSub findColorSub;
  public static SingleSolenoidSub singleSolenoidSub;
  public static JugsMachineSub jugsMachineSub;
  public static ColorSolenoidSub colorSolenoidSub;

  // Digital Inputs
  public static DigitalInput digIn9;
  public static DigitalInput digIn8;
  public static DigitalInput digIn7;
  public static DigitalInput digIn6;
  public static boolean button9;
  public static boolean button8;
  public static boolean button7;
  public static boolean button6;
  public static int station;
  public static double ballX;
  public static double ballY;

  CvSink cvSink;
  CvSource outputStream;
  Mat source;

  // Initialize Subsystem
  Thread m_visionThread;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    oi = new OI();
    drivetrain = new Drivetrain();
    cannonRotateSub = new CannonRotateSub();
    fanSubsystem = new FanSubsystem();
    rollerSubsystem = new RollerSubsystem();
    doubleSolenoidSub = new DoubleSolenoidSub();
    findColorSub = new SpinWheelSub();
    singleSolenoidSub = new SingleSolenoidSub();
    jugsMachineSub = new JugsMachineSub();
    colorSolenoidSub = new ColorSolenoidSub();

    digIn9 = new DigitalInput(9);
    digIn8 = new DigitalInput(8);
    digIn7 = new DigitalInput(7);
    digIn6 = new DigitalInput(6);

    m_visionThread = new Thread(() -> {
      // Get the UsbCamera from CameraServer
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setVideoMode(PixelFormat.kMJPEG, 160, 120, 30);
      new Thread(() -> {
        cvSink = CameraServer.getInstance().getVideo();
        outputStream = CameraServer.getInstance().putVideo("camera stream", 160, 120);
        source = new Mat();
        while (!Thread.interrupted()) {
          // Tell the CvSink to grab a frame from the camera and put it
          // in the source mat.  If there is an error notify the output.
          if (cvSink.grabFrame(source) == 0) {
            // Send the output the error.
            outputStream.notifyError(cvSink.getError());
            // skip the rest of the current iteration
            continue;
          }
          SmartDashboard.putNumber("Ball x", ballX);
          SmartDashboard.putNumber("Ball y", ballY);
          if (ballX != 42069 && ballY != 42069) Imgproc.putText(source, "Ball", new Point(ballX - 100, ballY - 25), 2, 0.5, new Scalar(255, 255, 255));
          Imgproc.rectangle(source, new Point(5, 5), new Point(155, 115),
            new Scalar(255, 255, 255), 2);
          outputStream.putFrame(source);
        }
        }).start();


      // Pixy2
      PixyVision.initialize();
    });
    m_visionThread.setDaemon(true);
    m_visionThread.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    button9 = !digIn9.get();
		button8 = !digIn8.get();
		button7 = !digIn7.get();
		button6 = !digIn6.get();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if ((button9 == true) && (button8 == false))
			station = 1;
		else if ((button9 == false) && (button8 == true))
			station = 3;
		else if ((button9 == true) && (button8 == true))
			station = 2;
		
		if (station == 1) {
			if ((button7 == true) && (gameData.charAt(0) == 'L')) {
				System.out.println("Switch1L");
			}
			else if ((gameData.charAt(1) == 'L') && (button6 == true)) {
				System.out.println("Scale1L");
			}
			else if (gameData.charAt(0) == 'L') {
				System.out.println("Switch1L2");
			}
			else {
				System.out.println("autoRun1");
			}
		}
		else if (station == 3) {
			if ((button7 == true) && (gameData.charAt(0) == 'R')) {
				System.out.println("Switch3R");
			}
			else if ((gameData.charAt(1) == 'R') && (button6 == true)) {
				System.out.println("Scale3R2");
			}
			else if (gameData.charAt(0) == 'R') {
				System.out.println("Switch3R2");
			}
			else {
				System.out.println("AutoRun3");
			}
		}
		else if (station == 2) {
			if (gameData.charAt(0) == 'R') {
				System.out.println("AutoRun2R switch score");
			}
			else {
				System.out.println("AutoRun2L");
			}		
		}

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    singleSolenoidSub.keep();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Block largest = PixyVision.getBiggestBlock();
    if (!(largest == null)) {
      SmartDashboard.putNumber("Largest X", largest.getX());
      ballX = (double) largest.getX();
      ballY = (double) largest.getY();
      } else {
        ballX = 42069;
        ballY = 42069;
      }
    }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
