package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Subsystem used to manage the climber on the robot.
 */
public class Climber extends SubsystemBase
{
    /* TODO: Untested Code */

    /* Class Variable Declaration */
    TalonSRX talC;

    /**
     * Constructs the Climber subsystem.
     */
    public Climber()
    {
        talC = new TalonSRX(Constants.p_TAL_C);
    }

    /**
     * Update the climber to run at a given velocity.
     * @param velocity of the climber.
     */
    public void update(double velocity) {
        talC.set(ControlMode.PercentOutput, velocity);
    }
}