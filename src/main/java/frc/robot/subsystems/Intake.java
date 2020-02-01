package frc.robot.subsystems;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class Intake extends SubsystemBase
{
    TalonSRX TAL_IN;

    public Intake()
    {
        TAL_IN = new TalonSRX(Constants.TAL_IN);
    }

    public void update(double speed)
    {
        TAL_IN.set(ControlMode.PercentOutput, speed);
    }

}