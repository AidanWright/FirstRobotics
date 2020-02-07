/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DoubleSolenoidDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class DoubleSolenoidSub extends SubsystemBase {

  static DoubleSolenoid pitchSolenoid = new DoubleSolenoid(4, 5);
  static DoubleSolenoid pitchSolenoid2 = new DoubleSolenoid(6, 7);


  
  static Value val = DoubleSolenoid.Value.kReverse;



  public void extend() {
    pitchSolenoid.set(DoubleSolenoid.Value.kForward);
    pitchSolenoid2.set(DoubleSolenoid.Value.kForward);
    val = DoubleSolenoid.Value.kForward;
  }
  public void retract() {
    pitchSolenoid.set(DoubleSolenoid.Value.kReverse);
    pitchSolenoid2.set(DoubleSolenoid.Value.kReverse);
    val = DoubleSolenoid.Value.kReverse;
  }
  public void keep() {
      pitchSolenoid.set(val);
      pitchSolenoid2.set(val);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DoubleSolenoidDrive());
  }
}
