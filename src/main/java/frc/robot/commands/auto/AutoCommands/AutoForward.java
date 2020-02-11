package frc.robot.commands.auto.AutoCommands;


//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;;

public class AutoForward extends CommandBase{

    DriveTrain drive;
    double dist;
    public AutoForward(double dist){
        drive = RobotContainer.s_DriveTrain;
        this.dist = dist;
        addRequirements(drive);
    }

    public void execute(){
       //Need to figure out input number, how far we want the robot to go
       
        // drive.update(,)                                                                                                                                                                                            
    }
}


