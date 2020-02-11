package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{

    // Declare drive talons.
    TalonSRX talLM, talLF, talRM, talRF;

    public DriveTrain()
    {
        // Initialize talons
        talLM = new TalonSRX(Constants.TAL_LM);
        talLF = new TalonSRX(Constants.TAL_LF);
        talRM = new TalonSRX(Constants.TAL_RM);
        talRF = new TalonSRX(Constants.TAL_RF);

        invertController(talRM);
        invertController(talRF);
    }

    /**
     * Set talons to pre-caculated input speeds.
     * @param speedL
     * @param speedR
     */
    public void update(double speedL, double speedR)
    {
        talLM.set(ControlMode.PercentOutput, speedL);
        talLF.set(ControlMode.Follower, Constants.TAL_LM);

        talRM.set(ControlMode.PercentOutput, speedR);
        talRF.set(ControlMode.Follower, Constants.TAL_RM);
    }

    /**
     * Reversing forwards and backwards directions.
     * @param tal is the motor controller you want to invert.
     */
    private void invertController(TalonSRX tal)
    {
        tal.setInverted(!tal.getInverted());
    }
}