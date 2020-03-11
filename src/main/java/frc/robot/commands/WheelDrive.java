/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.commands.auto.DriveTime;

public class WheelDrive extends CommandBase {

  Boolean lock = false;
  DriveTime cruiseControll;

  /**
   * Creates a new WheelDrive.
   * 
   */
  public WheelDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if (cruiseControll.isFinished() == true) { // unlock controlls
    //  lock = false;
    //}
    //if (lock != true) {
      // arcade drive
      Robot.drivetrain.drive(-Robot.oi.driverController.getY(), Robot.oi.driverController.getX(), Robot.oi.driverController.getZ());
      
      // cruise controll
      /*if (RobotContainer.cruiseControllButton.get() == true) {
        lock = true;
        cruiseControll = new DriveTime(3, -Robot.oi.driverController.getY(), Robot.drivetrain);
        cruiseControll.schedule();
      }
    }*/
  }

  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
