package frc.robot.subsystems;

/* Imports */
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;


/**
 * Subsystem for the intake mechanism on the robot.
 */
public class Intake extends SubsystemBase
{
    /* TODO: Untested Code */

    /* Class Variable Declaration */
    TalonSRX talIN;

    /**
     * Constructs the Intake subsystem.
     */
    public Intake()
    {
        talIN = new TalonSRX(Constants.p_TAL_IN);
        talIN.setInverted(true);
    }

    /**
     * Runs the intake at a given velocity,
     * where a positive input represents
     * running the intake into the robot.
     * @param velocity
     */
    public void set(double velocity)
    {
        talIN.set(ControlMode.PercentOutput, velocity);
    }

}