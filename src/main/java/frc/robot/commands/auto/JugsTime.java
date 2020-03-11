/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.JugsMachineSub;


public class JugsTime extends CommandBase {
  private final JugsMachineSub m_drive;
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
  public JugsTime(int time, double speed, JugsMachineSub drive) {
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
    SmartDashboard.putBoolean("Jugs auto", true);
    m_drive.autoDrive(m_speed, 0);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.autoDrive(0, 0);
    SmartDashboard.putBoolean("Jugs auto", false);
  }

  @Override
  public boolean isFinished() {
    if (timeL.get() > m_time) {
      return true;
    } else return false;
  }
}