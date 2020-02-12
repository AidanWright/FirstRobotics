/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


public class JugsMachineDrive extends CommandBase {
  /**
   * Creates a new rollerIntakeDrive.
   */
  public JugsMachineDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.jugsMachineSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.jugsMachineSub.JugsMachineDrive(Robot.oi.xboxController.getRawAxis(RobotContainer.jugsMachineReverse), Robot.oi.xboxController.getRawAxis(RobotContainer.jugsMachineForward));
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