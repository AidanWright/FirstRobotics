/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CannonRotateSub;
import edu.wpi.first.wpilibj.Timer;


public class CannonLevels extends CommandBase {
    private final CannonRotateSub m_drive;
    private final int m_time;
    private final double m_angle;
    public Timer timeL;


    /**
     * Creates a new DriveTime.
     *
     * @param seconds The ehhhjhj
     * @param drive   The drive subsystem on which this command will run
     * @param angle   The angle to go to
     */
    public CannonLevels(int time, CannonRotateSub drive, double angle) {
    m_time = time;
    m_drive = drive;
    m_angle = angle;
    SmartDashboard.putBoolean("Auto", false);
  }

  @Override
  public void initialize() {
      timeL = new Timer();
      timeL.reset();
      timeL.start();
  }

  @Override
  public void execute() {
    if  (m_drive.getVoltage() > m_angle){
      m_drive.cannonStop();
    } else if(m_drive.getVoltage() < m_angle){
        m_drive.cannonDriveDown();
    } else if ((m_angle < m_drive.getVoltage())
      && (m_drive.getVoltage() < m_angle)){
        m_drive.cannonStop();
    } else {
        m_drive.cannonStop();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    if (timeL.get() > m_time) {
      return true;
    } else return false;
  }
}