package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Subsystem representing the shooter mechanism on the robot.
 */
public class Shooter extends SubsystemBase
{
    /* Class Variable Declaration */
    TalonSRX talSH;
    Encoder enc;

    //For network table to pi
    NetworkTableEntry valid;
    NetworkTableEntry entryX;
    NetworkTableEntry distance;
    /**
     * Constructs the Shooter subsystem.
     */

     //status variables to give current degree of the shooter and its velocity in rotations/sec
    double currentDeg;
    double velocity;

    public Shooter()
    {
        //configure talon with encoder
        talSH = new TalonSRX(Constants.p_TAL_SH);
        talSH.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        
        //declare network table and fields
        NetworkTable table = NetworkTableInstance.getDefault().getTable("GripVisionData");
        NetworkTable rectangleTable = table.getSubTable("Grip is valid");
        valid = rectangleTable.getEntry("Valid"); //boolean
        entryX = table.getEntry("X"); //double
        distance = table.getEntry("Distance"); //double
    }

    /**
     * Shoots power cells out of the robot at a given speed.
     * @param speed
     */
    public void set(double speed) {
        talSH.set(ControlMode.PercentOutput, speed);
    }

    /**
     * Return current angle of the motor
     * @return
     */
    public double getDeg(){
        return currentDeg;
    }

    /**
     * return current angular velocity of the wheel
     * @return
     */
    public double getRotVelocity(){
        return velocity;
    }

    /**
     * return current command to talon
     * @return
     */
    public double getCMD(){
        return talSH.getMotorOutputPercent();
    }

    // @Override
    // public void periodic() {
    //     // currentDeg = talSH.getSelectedSensorPosition()*360/Constants.ENCODER_REVP;
    //     // velocity = talSH.getSelectedSensorVelocity()/Constants.ENCODER_REVP;
    // }

      /**
       * test if entry x is a valid value
       * @return
       */
      public boolean getValid(){
        return valid.getBoolean(false);
    }

    /**
     * return pixel value from vision
     * @return
     */
    public double getX(){
        if(getValid()){
            return entryX.getDouble(0);
        }else{
            System.out.println("Error: Invalid X val in Network Table");
            return 0;
        }
    }
    
    /**
     * distance from target
     * @return
     */
    public double getDistance(){
        //Testing.toTable("Vis dist", distance.getDouble(0)+"");
        return 30;//distance.getDouble(0);
    }

    /**
     * Return error to target
     * @return
     */
    public double getError(){
        //derived from trig (ask kayla)
        return 0.43 * (getX() - 80 /* center 0 */) - 1.46;
    }

}