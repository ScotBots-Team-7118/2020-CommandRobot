package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
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
    AnalogInput us1, us2;
    
    public int numPowerCells;
    boolean us1Active = false,
    us2Active = false;
    
    
    /**
     * Constructs the Indexer subsystem.
     */
    public Indexer()
    {
        talID1 = new TalonSRX(Constants.p_TAL_ID_1);
        talID2 = new TalonSRX(Constants.p_TAL_ID_2);
        us1 = new AnalogInput(Constants.p_US1);
        us2 = new AnalogInput(Constants.p_US2);
    }

    /**
     * Sets the indexer to run at a given velocity
     * and track if a power cell enters or leaves the indexer.
     * @param velocity1
     * @param velocity2
     */
    public void set(double velocity1, double velocity2)
    {
        talID1.set(ControlMode.PercentOutput, velocity1);
        talID2.set(ControlMode.PercentOutput, velocity2);

        if (us1Active && us1.getVoltage() < Constants.PC_DETECTION_VOLTAGE /* Voltage Threshold */)
        {
            us1Active = false;
        }

        else if (!us1Active && us1.getVoltage() > Constants.PC_DETECTION_VOLTAGE /* Voltage Threshold */)
        {
            us1Active = true;
            numPowerCells++;
        }

        if (us2Active && us2.getVoltage() < Constants.PC_DETECTION_VOLTAGE /* Voltage Threshold */)
        {
            us2Active = false;
            numPowerCells--;
        }

        else if (!us2Active && us2.getVoltage() > Constants.PC_DETECTION_VOLTAGE /* Voltage Threshold */)
        {
            us2Active = true;
            numPowerCells++;
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