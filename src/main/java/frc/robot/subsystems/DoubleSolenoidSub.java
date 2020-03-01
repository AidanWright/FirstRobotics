/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DoubleSolenoidDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class DoubleSolenoidSub extends SubsystemBase {

 // static DoubleSolenoid pitchSolenoid = new DoubleSolenoid(5, 6);
  static DoubleSolenoid pitchSolenoid2 = new DoubleSolenoid(1, 2);


  
  static Value valRoller = DoubleSolenoid.Value.kOff;
 // static Value valClimb = DoubleSolenoid.Value.kOff;

/*
  public void extendClimb() {
    pitchSolenoid.set(DoubleSolenoid.Value.kForward);
    valClimb = DoubleSolenoid.Value.kForward;
  }
  public void retractClimb() {
    pitchSolenoid.set(DoubleSolenoid.Value.kReverse);
    valClimb = DoubleSolenoid.Value.kReverse;
  }
  public void keepClimb() {
      pitchSolenoid.set(valClimb);
      System.out.println("Climb " + valClimb);
  }
*/

  public void extendRoller() {
    pitchSolenoid2.set(DoubleSolenoid.Value.kForward);
    valRoller = DoubleSolenoid.Value.kForward;
  }
  public void retractRoller() {
    pitchSolenoid2.set(DoubleSolenoid.Value.kReverse);
    valRoller = DoubleSolenoid.Value.kReverse;
  }
  public void keepRoller() {
      pitchSolenoid2.set(valRoller);
      System.out.println("Roller " + valRoller);
  }
  public void off() {
     // pitchSolenoid.set(DoubleSolenoid.Value.kOff);
      pitchSolenoid2.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DoubleSolenoidDrive());
  }
}