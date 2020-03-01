/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Import our needed classes
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ColorSolenoidDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class ColorSolenoidSub extends SubsystemBase {


  static Solenoid pitchSolenoid6 = new Solenoid(0);
 

  
  static boolean val2 = false;


  public void extend() {
    pitchSolenoid6.set(true);
    val2 = true;
  }
  public void retract() {
    pitchSolenoid6.set(false);
    val2 = false;
  }
  public void keep() {
      pitchSolenoid6.set(val2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ColorSolenoidDrive());
  }
}
