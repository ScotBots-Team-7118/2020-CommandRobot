package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Climber extends SubsystemBase
{

    TalonSRX talCR;
    TalonSRX talCL;

    public Climber()
    {
        talCL = new TalonSRX(Constants.TAL_CL);
        talCR = new TalonSRX(Constants.TAL_CR);
    }

    public void update(double speed)
    {
        talCR.set(ControlMode.PercentOutput, speed);
        talCL.set(ControlMode.Follower, Constants.TAL_CR);
    }
}