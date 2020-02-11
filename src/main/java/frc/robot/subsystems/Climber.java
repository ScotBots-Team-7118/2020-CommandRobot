package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Climber extends SubsystemBase
{

    TalonSRX talC;

    public Climber()
    {
        talC = new TalonSRX(Constants.TAL_C);
    }

    public void update(double speed) {
        talC.set(ControlMode.PercentOutput, speed);
    }
}