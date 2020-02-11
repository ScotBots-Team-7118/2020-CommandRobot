package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase
{

    TalonSRX talSH;

    public Shooter()
    {
        talSH = new TalonSRX(Constants.TAL_SH);
    }

    public void update(double speed) {
        talSH.set(ControlMode.PercentOutput, speed);
    }
}