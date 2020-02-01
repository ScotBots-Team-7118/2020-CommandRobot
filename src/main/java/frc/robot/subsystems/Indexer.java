package frc.robot.subsystems;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Constants;

public class Indexer extends SubsystemBase
{
    TalonSRX TalID;
    public Indexer()
    {
        TalID = new TalonSRX(Constants.TAL_ID);
    }

    public void update(double speed)
    {
        TalID.set(ControlMode.PercentOutput, speed);
    }

}