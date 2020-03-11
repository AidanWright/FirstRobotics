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
import frc.robot.Robot;
import frc.robot.subsystems.CannonRotateSub;
import frc.robot.subsystems.DoubleSolenoidSub;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FanSubsystem;
import frc.robot.subsystems.JugsMachineSub;

public class AutoBlueCenter extends CommandBase {
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
  public AutoBlueCenter(Drivetrain drive, JugsMachineSub jugs, FanSubsystem fans, CannonRotateSub cannon, DoubleSolenoidSub doub) {
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

    if (Robot.button1 == true && Robot.button2 == true && Robot.button3 == true && Robot.button4 == true) {
      // Ten foot and backwards: 13 secs
      TenShootBack tenShootBack = new TenShootBack(m_drive, m_jugs, m_fans, m_cannon, m_double);
      tenShootBack.schedule();
    } else if (Robot.button1 == false && Robot.button2 == true && Robot.button3 == true && Robot.button4 == true) {
      // Ten Foot no backwards: 8 secs
      TenShootNoBack tenShootNoBack = new TenShootNoBack(m_drive, m_jugs, m_fans, m_cannon, m_double);
      tenShootNoBack.schedule();
    } else {
      TenShootNoBack tenShootNoBack = new TenShootNoBack(m_drive, m_jugs, m_fans, m_cannon, m_double);
      tenShootNoBack.schedule();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(Robot.button1);
    SmartDashboard.putNumber("Time", timeL.get());
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
