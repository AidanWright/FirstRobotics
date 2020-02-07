/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.SingleSolenoidDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoidSub extends SubsystemBase {


  static Solenoid pitchSolenoid3 = new Solenoid(0);
  static Solenoid pitchSolenoid4 = new Solenoid(1);

  
  static boolean val2 = false;


  public void extend() {
    pitchSolenoid3.set(true);
    pitchSolenoid4.set(true);
    val2 = true;
  }
  public void retract() {
    pitchSolenoid3.set(false);
    pitchSolenoid4.set(false);
    val2 = false;
  }
  public void keep() {
      pitchSolenoid3.set(val2);
      pitchSolenoid4.set(val2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new SingleSolenoidDrive());
  }
}
