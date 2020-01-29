package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase {
 PWMTalonSRX bottomPWMTalonSRX = null;
 PWMTalonSRX topPWMTalonSRX = null;

 public Shooter() {
    bottomPWMTalonSRX = new PWMTalonSRX(RobotContainer.JUGMACHINE_BOTTOM_PWMTalonSRX);
    topPWMTalonSRX = new PWMTalonSRX(RobotContainer.JUGMACHINE_TOP_PWMTalonSRX);

    SpeedControllerGroup jugMachine = new SpeedControllerGroup(bottomPWMTalonSRX, topPWMTalonSRX);
 }
}