package frc.robot;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class Testing{

    boolean run;

    public Testing(boolean run){
        this.run = run;    
    }

    public static void pingMe(String me){
        System.out.println("hit "+me);
    }

    public void PrintMe(){
        if(run){
            System.out.println("Gyro NHeading is "+Robot.rC.Rgyro.getNormalizedHeading());
            System.out.println("Shooter velocity is "+RobotContainer.s_Shooter.getRotVelocity());
            System.out.println("Left d is "+RobotContainer.s_DriveTrain.getLeftDist()+"Right d is "+RobotContainer.s_DriveTrain.getRightDist());
            System.out.println("Limit switches "+RobotContainer.s_Turret.talTUR.getSelectedSensorPosition());
        }
    }
}