package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.PID;
import frc.robot.vision.VisionHandler;
import frc.robot.Constants;

/**
 * Subsystem representing the turret attached to the shooter mechanism on the robot.
 */
public class Turret extends SubsystemBase
{
    /* Class Variable Declaration */
    TalonSRX talTUR;
    public PID pid;
    public VisionHandler vis;
    //AnalogInput Sleft, Sright;


    double rAngle;
    double tAngle;
    double cAngle;
    /**
     * Constructs the Turret subsystem.
     */
    public Turret()
    {
        pid = new PID(0/*,0,0, true, false, false*/); //gimme some constatnts
        vis = new VisionHandler();
        talTUR = new TalonSRX(Constants.p_TAL_TUR);

        //TODO check for forward
        talTUR.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        talTUR.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        //talTUR.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        //Sleft = new AnalogInput(Constants.p_SWITCH_LEFT);
        //Sright = new AnalogInput(Constants.p_SWITCH_RIGHT);
        

    }
  

    /**
     * Updates the turret by rotating it at a given velocity.
     * @param velocity
     */
    public void set(double velocity)
    {
      //TODO use limit switches to stop and SET THIUNGS
    //double _sign = velocity/Math.abs(velocity);
        //System.out.println(talTUR.getSelectedSensorPosition());
        //if(((Sleft.getVoltage() > Constants.TRIPPED) && _sign == -1) || ((Sright.getVoltage() > Constants.TRIPPED) && _sign == 1)){
        //    talTUR.set(ControlMode.PercentOutput, velocity);
        //}else if((Sleft.getVoltage() < Constants.TRIPPED) && (Sright.getVoltage() < Constants.TRIPPED)){
            talTUR.set(ControlMode.PercentOutput, velocity);
        //}
    }

    @Override
    public void periodic() {
        vis.update();
    }
}