/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// Import our needed classes
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CannonRotateSub;
import frc.robot.subsystems.DoubleSolenoidSub;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FanSubsystem;
import frc.robot.subsystems.JugsMachineSub;

public class TenShootBack extends CommandBase {
    private Drivetrain m_drive;
    private JugsMachineSub m_jugs;
    private FanSubsystem m_fans;
    private CannonRotateSub m_cannon;
    private DoubleSolenoidSub m_double;
    public boolean done = false;
    public boolean ranJugs = false;
    public boolean ranFans = false;
    public boolean ranDrive = false;
    public boolean ranCannonShoot = false;
    public Timer timeL;


  /**
   * Creates a new Auto command for center the robot.
   * 
   */
  public TenShootBack(Drivetrain drive, JugsMachineSub jugs, FanSubsystem fans, CannonRotateSub cannon, DoubleSolenoidSub doub) {
    m_drive = drive;
    m_jugs = jugs;
    m_fans = fans;
    m_cannon = cannon;
    m_double = doub;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, jugs, fans, cannon, doub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timeL = new Timer();
    timeL.reset();
    timeL.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("done", done);
    if (done == false) {
        // Ten foot and backwards: 10 secs
            if (ranCannonShoot == false) {
                new RollerOut(2, m_double);
                new CannonLevels(3, m_cannon, RobotContainer.tenFootShot).schedule();
                SmartDashboard.putBoolean("Jugs auto", true);
                JugsTime jugstime = new JugsTime(6, 1, m_jugs);
                jugstime.schedule();
                ranCannonShoot = true;
            }
            if (timeL.get() > 4 && ranFans == false) {
                SmartDashboard.putBoolean("Fans auto", true);
                FanTime fantime = new FanTime(2, m_fans);
                fantime.schedule();
                ranFans = true;
            }
            if (timeL.get() > 6 && ranDrive == false) {
                SmartDashboard.putBoolean("Drive auto", true);
                DriveTime drivetime = new DriveTime(2, -0.75, m_drive);
                drivetime.schedule();
                //new CannonLevels(5, m_cannon, RobotContainer.IntakeAngle).schedule();
                ranDrive = true;
                done = true;
            }
        }
    }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timeL.get() > 13) {
      return true;
    } else return false;
  }
}
