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

    NetworkTableEntry valid;
    NetworkTableEntry entryX;
  
    NetworkTableEntry distance;
    NetworkTableEntry heading;
    /**
     * Constructs the Shooter subsystem.
     */

    double currentDeg;
    double velocity;
    public Shooter()
    {
        talSH = new TalonSRX(Constants.p_TAL_SH);
        talSH.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        NetworkTable table = NetworkTableInstance.getDefault().getTable("GripVisionData");
        NetworkTable rectangleTable = table.getSubTable("Grip is valid");
        valid = rectangleTable.getEntry("Valid"); //boolean
        entryX = table.getEntry("X"); //double
        distance = table.getEntry("Distance"); //double
        //heading = table.getEntry("Heading"); //double
    }

    /**
     * Shoots power cells out of the robot at a given speed.
     * @param speed
     */
    public void set(double speed) {
        // TODO: This implementation is currently being used for bugfixing with the ctre mag encoders
        //System.out.println("Enc val = " + currentDeg);
        //System.out.println(velocity);
        // TODO: If the talon is inverted for the shooter, we should really just be inverting the talon
        talSH.set(ControlMode.PercentOutput, speed);
    }

    public double getDeg(){
        return currentDeg;
    }

    public double getRotVelocity(){
        return velocity;
    }

    public double getCMD(){
        return talSH.getMotorOutputPercent();
    }

    @Override
    public void periodic() {
        // currentDeg = talSH.getSelectedSensorPosition()*360/Constants.ENCODER_REVP;
        // velocity = talSH.getSelectedSensorVelocity()/Constants.ENCODER_REVP;
    }

      //is x valid
      public boolean getValid(){
        return valid.getBoolean(false);
    }

    //pixel value from vision
    public double getX(){
        if(getValid()){
            return entryX.getDouble(0);
        }else{
            System.out.println("Error: Invalid X val in Network Table");
            return 0;
        }
    }
    
    //distance from target
    public double getDistance(){
        //Testing.toTable("Vis dist", distance.getDouble(0)+"");
        return 30;//distance.getDouble(0);
    }

    //gyroscope heading
    public double getHeading(){
        //Testing.toTable("Vis dist", heading.getDouble(0)+"");
       return 0;//heading.getDouble(0);
    
    }

        
        

    public double getError(){
        //derived from trig (ask kayla)
        return 0.43 * (getX() - 80 /* center 0 */) - 1.46;
    }

}