package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Climber extends SubsystemBase
{

    TalonSRX TAL_CR;
    TalonSRX TAL_CL;

    public Climber()
    {
        TAL_CL = new TalonSRX(Constants.TAL_CL);
        TAL_CR = new TalonSRX(Constants.TAL_CR);
    }

    public void update(double speed) {
        TAL_CR.set(ControlMode.PercentOutput, speed);
        TAL_CL.set(ControlMode.Follower, Constants.TAL_CR);
    }
}