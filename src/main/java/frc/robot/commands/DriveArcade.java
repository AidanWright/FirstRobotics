/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;



public class DriveArcade extends CommandBase {
  /**
   * Creates a new DriveArcade.
   * 
   */
  private void requires(Drivetrain m_drivetrain) {
  }
  public DriveArcade() {
   
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.m_drivetrain);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = -Robot.m_oi.driverController.getY();
    double rotateSpeed = Robot.m_oi.driverController.getX();

    Robot.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_drivetrain.arcadeDrive(0, 0);
    //end(interrupted);
  }

  // Returns true when the command should end.
  @Override
 public boolean isFinished() {
    return false;
 }

  //public void interrupted() {
   // end(false);
    
 // }

}
