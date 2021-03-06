/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ColorSolenoidDrive extends CommandBase {
  /*
   * Creates a new RollerDrive.
   */
  static boolean isToggled = false;
  static boolean patIsAllowed = false;

  public ColorSolenoidDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.colorSolenoidSub);
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
    SmartDashboard.putBoolean("Saftey Color", patIsAllowed);
    if (patIsAllowed == true) {
      if (RobotContainer.colorSolenoidButtonExtend.get() == true) {
        Robot.colorSolenoidSub.extend();
    
    } else if (RobotContainer.colorSolenoidButtonRetract.get() == true) {
        Robot.colorSolenoidSub.retract();
    } else
        Robot.colorSolenoidSub.keep();
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