package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Subsystem used to manage the power cell indexer on the robot.
 */
public class Indexer extends SubsystemBase
{
    /* TODO: Finish implementing me! */
    // Needs to be able to return whether or not the indexer is full of power cells

    /* Class Variable Declaration */
    TalonSRX talID;
    
    /**
     * Constructs the Indexer subsystem.
     */
    public Indexer()
    {
        talID = new TalonSRX(Constants.p_TAL_ID);
    }

    /**
     * Sets the indexer to run at a given velocity.
     * @param velocity
     */
    public void update(double velocity)
    {
        talID.set(ControlMode.PercentOutput, velocity);
    }

}