package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Turret extends SubsystemBase
{

    TalonSRX talTUR;

    public Turret()
    {
        talTUR = new TalonSRX(Constants.TAL_TUR);
    }
    public void update(double angle)
    {
        talTUR.set(ControlMode.PercentOutput, findAngle(angle));
    }

    public double findAngle(double angle){
        return 0.1;
    }
}