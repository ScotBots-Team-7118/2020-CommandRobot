package frc.robot.subsystems;

// Imports
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{

    // Declare drive talons.
    TalonSRX TAL_LM, TAL_LF, TAL_RM, TAL_RF;

    public DriveTrain()
    {
        // Initialize talons
        TAL_LM = new TalonSRX(Constants.TAL_LM);
        TAL_LF = new TalonSRX(Constants.TAL_LF);
        TAL_RM = new TalonSRX(Constants.TAL_RM);
        TAL_RF = new TalonSRX(Constants.TAL_RF);

        invertController(TAL_RM);
        invertController(TAL_RF);
    }

    /**
     * Set talons to pre-caculated input speeds.
     * @param speedL
     * @param speedR
     */
    public void update(double speedL, double speedR)
    {
        TAL_LM.set(ControlMode.PercentOutput, speedL);
        TAL_LF.set(ControlMode.Follower, Constants.TAL_LM);

        TAL_RM.set(ControlMode.PercentOutput, speedR);
        TAL_RF.set(ControlMode.Follower, Constants.TAL_RM);
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