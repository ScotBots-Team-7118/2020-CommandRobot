package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Networktable{
    static NetworkTableEntry valid;
    static NetworkTableEntry entryX;
  
    static NetworkTableEntry distance;
    static NetworkTableEntry heading;

    public Networktable(){
        NetworkTable table = NetworkTableInstance.getDefault().getTable("GripVisionData");
        valid = table.getEntry("Valid"); //boolean
        entryX = table.getEntry("X"); //double
        distance = table.getEntry("Distance"); //double
        heading = table.getEntry("Heading"); //double
    }

      //is x valid
      public static boolean getValid(){
        return valid.getBoolean(false);
    }

    //pixel value from vision
    public static double getX(){
        if(getValid()){
            return entryX.getDouble(0);
        }else{
            System.out.println("Error: Invalid X val in Network Table");
            return 0;
        }
    }
    
    //distance from target
    public static double getDistance(){
        //Testing.pingMe("Vis dist", distance.getDouble(0)+"");
        return distance.getDouble(0);
    }

    //gyroscope heading
    public static double getHeading(){
        //Testing.pingMe("Vis dist", heading.getDouble(0)+"");
       return heading.getDouble(0);
    
    }
}