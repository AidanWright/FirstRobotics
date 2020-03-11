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
    if (Robot.button9 == true) {
      if (Robot.cannonRotateSub.getVoltage() < RobotContainer.limitUp) {
        if(Robot.oi.Xbox.getRawAxis(1) > 0) {
          Robot.cannonRotateSub.cannonDrive(-1 * Robot.oi.Xbox.getY());
        } 
      }
    }
    if (Robot.cannonRotateSub.getVoltage() > RobotContainer.limitDown) {
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
      if (RobotContainer.sevenTyroneFeetButton.get() == true){
      if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.sevenTyroneFeetShot){
        Robot.cannonRotateSub.cannonDriveUp();
      } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.sevenTyroneFeetShot){
          Robot.cannonRotateSub.cannonDriveDown();
      } else if ((RobotContainer.sevenTyroneFeetShot < Robot.cannonRotateSub.getVoltage())
        && (Robot.cannonRotateSub.getVoltage() < RobotContainer.sevenTyroneFeetShot)){
        Robot.cannonRotateSub.cannonStop();
      } else {
          Robot.cannonRotateSub.cannonStop();
      }
    }
/*
    //thirtyFeetShot
    if (RobotContainer.ThirtyTreeButton.get() == true){
      if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.thirtyTreeFeetShot){
        Robot.cannonRotateSub.cannonDriveUp();
      } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.thirtyTreeFeetShot){
          Robot.cannonRotateSub.cannonDriveDown();
      } else if ((RobotContainer.thirtyTreeFeetShot < Robot.cannonRotateSub.getVoltage())
        && (Robot.cannonRotateSub.getVoltage() < RobotContainer.thirtyTreeFeetShot)){
        Robot.cannonRotateSub.cannonStop();
      } else {
          Robot.cannonRotateSub.cannonStop();
      }
    }    */ 

    if (RobotContainer.closeShotButton.get() == true){
      if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.closeShot){
        Robot.cannonRotateSub.cannonDriveUp();
      } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.closeShot){
          Robot.cannonRotateSub.cannonDriveDown();
      } else if ((RobotContainer.closeShot < Robot.cannonRotateSub.getVoltage())
        && (Robot.cannonRotateSub.getVoltage() < RobotContainer.closeShot)){
        Robot.cannonRotateSub.cannonStop();
      } else {
          Robot.cannonRotateSub.cannonStop();
      }
    }

        //loading Angle
        if (RobotContainer.LoadingIntake.get() == true){
          if  (Robot.cannonRotateSub.getVoltage() > RobotContainer.loadingAngle){
            Robot.cannonRotateSub.cannonDriveUp();
          } else if(Robot.cannonRotateSub.getVoltage() < RobotContainer.loadingAngle){
              Robot.cannonRotateSub.cannonDriveDown();
          } else if ((RobotContainer.loadingAngle < Robot.cannonRotateSub.getVoltage())
            && (Robot.cannonRotateSub.getVoltage() < RobotContainer.loadingAngle)){
            Robot.cannonRotateSub.cannonStop();
          } else {
              Robot.cannonRotateSub.cannonStop();
          }
        }

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