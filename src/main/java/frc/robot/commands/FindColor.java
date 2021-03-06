/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
// Import our needed classes
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class FindColor extends CommandBase {
  /**
   * Creates a new FindColor.
   */
  public FindColor() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.findColorSub);
  }

  // Called when the command is initially scheduled.
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    Robot.findColorSub.findColor(RobotContainer.colorWheelDrive, DriverStation.getInstance().getGameSpecificMessage());
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
