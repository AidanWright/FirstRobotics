/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.SingleSolenoidDrive;

public class SingleSolenoidSub extends SubsystemBase {


  static Solenoid pitchSolenoid4 = new Solenoid(3);
  static Solenoid pitchSolenoid5 = new Solenoid(4);

  static boolean val1 = false;
  static boolean val2 = true;


  public void extend() {
    pitchSolenoid4.set(true);
    pitchSolenoid5.set(true);
    val1 = true;
    val2 = true;
  }
  public void retract() {
    pitchSolenoid4.set(false);
    pitchSolenoid5.set(false);
    val1 = false;
    val2 = false;
  }
  public void keep() {
      pitchSolenoid4.set(val1);
      pitchSolenoid5.set(val2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new SingleSolenoidDrive());
  }
}
