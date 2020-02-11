package frc.robot.commands.auto.AutoCommands;

//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.gyro.*;
import frc.robot.subsystems.*;
import frc.robot.Robot;

public class AutoLeft extends CommandBase{

    DriveTrain drive;
    Gyroscope gyro;
    double angle;
    public AutoLeft(double angle){
        drive = RobotContainer.s_DriveTrain;
        gyro = Robot.oi.gyro;
        this.angle = angle;
        addRequirements(drive);
    }

    public void execute(){
        if(gyro.getNormalizedHeading() > angle){

        }else if(gyro.getNormalizedHeading() < angle){

        }else{

        }                                                                                                                                                                                
    }
    //Need to figure out input number, how far we want the robot to go
}