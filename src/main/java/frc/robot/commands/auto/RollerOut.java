/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DoubleSolenoidSub;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RollerOut extends CommandBase {
    private final DoubleSolenoidSub m_drive;
    private final int m_time;
    public Timer timeL;


    /**
     * Creates a new DriveTime.
     *
     * @param seconds The ehhhjhj
     * @param drive   The drive subsystem on which this command will run
     */
    public RollerOut(int time, DoubleSolenoidSub drive) {
    m_time = time;
    m_drive = drive;

    addRequirements(drive);
  }

  @Override
  public void initialize() {
      timeL = new Timer();
      timeL.reset();
      timeL.start();
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Roller Out", true);
    m_drive.extendRoller();
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Roller Out", false);
    m_drive.off();
  }

  @Override
  public boolean isFinished() {
    if (timeL.get() > m_time) {
      return true;
    } else return false;
  }
}