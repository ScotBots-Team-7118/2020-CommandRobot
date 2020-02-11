package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Subsystem representing the turret attached to the shooter mechanism on the robot.
 */
public class Turret extends SubsystemBase
{
    /* Class Variable Declaration */
    TalonSRX talTUR;

    /**
     * Constructs the Turret subsystem.
     */
    public Turret()
    {
        talTUR = new TalonSRX(Constants.p_TAL_TUR);
    }

    /**
     * Updates the turret by rotating it at a given velocity.
     * @param velocity
     */
    public void update(double velocity)
    {
        talTUR.set(ControlMode.PercentOutput, velocity);
    }
}