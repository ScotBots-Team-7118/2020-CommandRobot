package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Subsystem used to managed the drive train of the robot.
 */
public class DriveTrain extends SubsystemBase
{
    /* TODO: MagEncoders Untested */

    /* Class Variable Declaration */
    TalonSRX talLM, talLF, talRM, talRF;

    // Pulses Per Revolution of the MagEncoders on the drive train
    final double encoderPPR = 0; // TODO: check if val = 4096

    /**
     * Constructs the DriveTrain subsystem.
     */
    public DriveTrain()
    {
        /* Talon Initialization */
        talLM = new TalonSRX(Constants.p_TAL_LM);
        talLF = new TalonSRX(Constants.p_TAL_LF);
        talRM = new TalonSRX(Constants.p_TAL_RM);
        talRF = new TalonSRX(Constants.p_TAL_RF);

        // Configures each of the mag enconders on the master Drive Train talons
        // The "relative" configuration indicates that they will work identically
        // to quadrature encoders (as opposed to PWM Sensors). 
        talLM.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        talRM.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        // Invert the right side || TODO: This may need to change once we test on the competition drive train
        invertController(talRM);
        invertController(talRF);
    }

    /**
     * Set talons to given input speeds.
     * 
     * @param velocityL
     * @param velocityR
     */
    public void update(double velocityL, double velocityR)
    {
        talLM.set(ControlMode.PercentOutput, velocityL);
        talLF.set(ControlMode.Follower, Constants.p_TAL_LM);

        talRM.set(ControlMode.PercentOutput, velocityR);
        talRF.set(ControlMode.Follower, Constants.p_TAL_RM);
    }

    /**
     * Invert a given TalonSRX motor controller.
     * @param tal to be inverted.
     */
    private void invertController(TalonSRX tal)
    {
        tal.setInverted(!tal.getInverted());
    }

    /**
     * @return The distance traveled by the left side of the drive train
     * (currently in revolutions).
     */
    public double getLeftDist()
    {
        return talLM.getSelectedSensorPosition() / encoderPPR;
    }

    /**
     * @return The distance traveled by the right side of the drive train
     * (currently in revolutions).
     */
    public double getRightDist()
    {
        return talRM.getSelectedSensorPosition() / encoderPPR;
    }

    /**
     * Reset the distance traveled by both sides of the drive train.
     */
    public void resetEncoders()
    {
        talLM.setSelectedSensorPosition(0);
        talRM.setSelectedSensorPosition(0);
    }
}