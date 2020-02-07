/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class SingleSolenoidDrive extends CommandBase {
  /**
   * Creates a new RollerDrive.
   */
  static boolean isToggled = false;
  static boolean patIsAllowed = false;

  public SingleSolenoidDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.singleSolenoidSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.oi.driverController.getRawAxis(RobotContainer.patSupidSaftey) <= -0.9) {
      patIsAllowed = true;
    } else {
      patIsAllowed = false;
    }
    if (patIsAllowed == true) {
      if (RobotContainer.singleSolenoidButtonExtend.get() == true) {
        Robot.singleSolenoidSub.extend();
    
    } else if (RobotContainer.singleSolenoidButtonRetract.get() == true) {
        Robot.singleSolenoidSub.retract();
    } else
        Robot.singleSolenoidSub.keep();
    }
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