/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FanSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class FanTime extends CommandBase {
  private final FanSubsystem m_drive;
  private final int m_time;
  public Timer timeL;


  /**
   * Creates a new DriveTime.
   *
   * @param seconds The ehhhjhj
   * @param drive The drive subsystem on which this command will run
   */
  public FanTime(int time, FanSubsystem drive) {
    m_time = time;
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
    SmartDashboard.putBoolean("Fans auto", true);
    //m_drive.autoDrive(m_speed, 0);
    m_drive.fanDriveCCW();
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.autoDrive(0, 0);
    SmartDashboard.putBoolean("Fans auto", false);
  }

  @Override
  public boolean isFinished() {
    if (timeL.get() > m_time) {
      return true;
    } else return false;
  }
}