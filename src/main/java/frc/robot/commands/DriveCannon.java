/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// Import our needed classes
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DriveCannon extends CommandBase {
  /**
   * Creates a new DriveCannon.
   */
  public DriveCannon() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.cannonRotateSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.cannonRotateSub.getVoltage() < RobotContainer.limitUp) {
      if(Robot.oi.Xbox.getRawAxis(1) > 0) {
        Robot.cannonRotateSub.cannonDrive(-1 * Robot.oi.Xbox.getY());
      } 
    } else if (Robot.cannonRotateSub.getVoltage() > RobotContainer.limitDown) {
      if(Robot.oi.Xbox.getRawAxis(1) < 0) {
        Robot.cannonRotateSub.cannonDrive(-1 * Robot.oi.Xbox.getY());
      }
      Robot.cannonRotateSub.cannonDrive(-1 * Robot.oi.Xbox.getY());
    } else {
      Robot.cannonRotateSub.cannonDrive(-1 * Robot.oi.Xbox.getY());
    }
    //Trench Run
    if (RobotContainer.TrenchRunButton.get() == true){
    if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.Level){
      Robot.cannonRotateSub.cannonDriveUp();
    } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.Level){
      Robot.cannonRotateSub.cannonDriveDown();
    } else if ((RobotContainer.Level < Robot.cannonRotateSub.getVoltage())
      && (Robot.cannonRotateSub.getVoltage() < RobotContainer.Level)){
      Robot.cannonRotateSub.cannonStop();
    } else {
      Robot.cannonRotateSub.cannonStop();
    }
  }
    //IntakeAngle
    if (RobotContainer.IntakeAngleButton.get() == true){
    if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.IntakeAngle){
      Robot.cannonRotateSub.cannonDriveUp();
    } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.IntakeAngle){
        Robot.cannonRotateSub.cannonDriveDown();
    } else if ((RobotContainer.IntakeAngle < Robot.cannonRotateSub.getVoltage())
      && (Robot.cannonRotateSub.getVoltage() < RobotContainer.IntakeAngle)){
      Robot.cannonRotateSub.cannonStop();
    } else {
        Robot.cannonRotateSub.cannonStop();
    }
  }

       //twentyFeetShot
       if (RobotContainer.TwentyFeetButton.get() == true){
        if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.twentyFeetShot){
          Robot.cannonRotateSub.cannonDriveUp();
        } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.twentyFeetShot){
            Robot.cannonRotateSub.cannonDriveDown();
        } else if ((RobotContainer.twentyFeetShot < Robot.cannonRotateSub.getVoltage())
          && (Robot.cannonRotateSub.getVoltage() < RobotContainer.twentyFeetShot)){
          Robot.cannonRotateSub.cannonStop();
        } else {
            Robot.cannonRotateSub.cannonStop();
        }
      }

        //thirtyFeetShot
        if (RobotContainer.ThirtyFeetButton.get() == true){
          if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.thirtyFeetShot){
            Robot.cannonRotateSub.cannonDriveUp();
          } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.thirtyFeetShot){
              Robot.cannonRotateSub.cannonDriveDown();
          } else if ((RobotContainer.thirtyFeetShot < Robot.cannonRotateSub.getVoltage())
            && (Robot.cannonRotateSub.getVoltage() < RobotContainer.thirtyFeetShot)){
            Robot.cannonRotateSub.cannonStop();
          } else {
              Robot.cannonRotateSub.cannonStop();
          }
        }     
        /*
        if (RobotContainer.ThirtyFeetButton.get() == true){
          if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.limitDown){
            Robot.cannonRotateSub.cannonDriveUp();
          } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.limitDown){
              Robot.cannonRotateSub.cannonDriveDown();
          } else if ((RobotContainer.thirtyFeetShot < Robot.cannonRotateSub.getVoltage())
            && (Robot.cannonRotateSub.getVoltage() < RobotContainer.thirtyFeetShot)){
            Robot.cannonRotateSub.cannonStop();
          } else {
              Robot.cannonRotateSub.cannonStop();
          }
        }
        */


  //System.out.println(Robot.cannonRotateSub.getVoltage());
  SmartDashboard.putNumber("Pot Value", Robot.cannonRotateSub.getVoltage());

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