package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.PID;
import frc.robot.Vision.VisionHandler;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.gyro.Gyroscope;;
/**
 * Subsystem representing the turret attached to the shooter mechanism on the robot.
 */
public class Turret extends SubsystemBase
{
    /* Class Variable Declaration */
    TalonSRX talTUR;
    public PID pid;
    public VisionHandler vis;
    NetworkTableEntry valid;
    NetworkTableEntry entryX;
  
    NetworkTableEntry distance;
    NetworkTableEntry heading;

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
        NetworkTable table = NetworkTableInstance.getDefault().getTable("GripVisionData");
        valid = table.getEntry("Valid"); //boolean
        entryX = table.getEntry("X"); //double
        distance = table.getEntry("Distance"); //double
        heading = table.getEntry("Heading"); //double

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
        return distance.getDouble(0);
    }

    //gyroscope heading
    public double getHeading(){
        return heading.getDouble(0);
    }

    /**
     * Updates the turret by rotating it at a given velocity.
     * @param velocity
     */
    public void set(double velocity)
    {
        rAngle = Robot.rC.Rgyro.getRawHeading();
        tAngle = Gyroscope.normalizedHeadingVal(getHeading());
        cAngle = rAngle - tAngle;
        if(cAngle <= 180 || cAngle >= -180){
            talTUR.set(ControlMode.PercentOutput, velocity);
        }else{
            System.out.println("Turret boundary hit");
            talTUR.set(ControlMode.PercentOutput, -velocity);
        }
    }

    @Override
    public void periodic() {
        vis.update();
    }
}