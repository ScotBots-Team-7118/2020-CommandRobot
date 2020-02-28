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
    /* TODO: Untested Code */

    /* Class Variable Declaration */
    TalonSRX talID1;
    TalonSRX talID2;
    
    public int numPowerCells;
    
    
    /**
     * Constructs the Indexer subsystem.
     */
    public Indexer()
    {
        talID1 = new TalonSRX(Constants.p_TAL_ID_1);
        talID2 = new TalonSRX(Constants.p_TAL_ID_2);
    }

    /**
     * Sets the indexer to run at a given velocity
     * and track if a power cell enters or leaves the indexer.
     * @param velocity
     */
    public void set(double velocity, int sel)
    {
        if(sel == 0){
            talID1.set(ControlMode.PercentOutput, velocity);
        }else if(sel == 1){
            talID2.set(ControlMode.PercentOutput, velocity);
        }else{
            talID1.set(ControlMode.PercentOutput, velocity);
            talID2.set(ControlMode.PercentOutput, velocity);
        }
    }

    /**
     * @return Whether or not the indexer is full of power cells.
     */
    public boolean isFull()
    {
        return numPowerCells > Constants.PC_CAPACITY;
    }
}