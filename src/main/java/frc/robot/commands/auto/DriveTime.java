/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;


public class DriveTime extends CommandBase {
  private final Drivetrain m_drive;
  private final int m_time;
  private final double m_speed;
  public Timer timeL;


  /**
   * Creates a new DriveTime.
   *
   * @param seconds The ehhhjhj
   * @param speed The speed at which the robot will drive
   * @param drive The drive subsystem on which this command will run
   */
  public DriveTime(int time, double speed, Drivetrain drive) {
    m_time = time;
    m_speed = speed;
    m_drive = drive;
  }

  @Override
  public void initialize() {
      timeL = new Timer();
      timeL.reset();
      timeL.start();
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Drive auto", true);
    m_drive.autoDrive(m_speed, 0);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.autoDrive(0, 0);
    SmartDashboard.putBoolean("Drive auto", false);
  }

  @Override
  public boolean isFinished() {
    if (timeL.get() > m_time) {
      return true;
    } else return false;
  }

}