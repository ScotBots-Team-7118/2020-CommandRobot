package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.Proportional;
import frc.robot.Constants;

/**
 * Subsystem representing the turret attached to the shooter mechanism on the robot.
 */
public class Turret extends SubsystemBase
{
    /* Class Variable Declaration */
    public TalonSRX talTUR;
    public Proportional p;
    //AnalogInput Sleft, Sright;


    double rAngle;
    double tAngle;
    double cAngle;
    /**
     * Constructs the Turret subsystem.
     */
    public Turret()
    {
        //set up turret speed calc
        p = new Proportional(Constants.TURRET_P); 
        //initialize turret talon
        talTUR = new TalonSRX(Constants.p_TAL_TUR);

        //configure bounding limit switches
        talTUR.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        talTUR.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    }
  

    /**
     * Updates the turret by rotating it at a given velocity.
     * @param velocity
     */
    public void set(double velocity)
    {
     
       talTUR.set(ControlMode.PercentOutput, velocity);
    }

    @Override
    public void periodic() {
    }
}