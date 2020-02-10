package frc.robot.commands.auto;


//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;;

public class AutoForward extends CommandBase{

    DriveTrain drive;

    public AutoForward(){
        drive = RobotContainer.s_DriveTrain;

        addRequirements(drive);
    }

    public void execute(){
       //Need to figure out input number, how far we want the robot to go
       
        // drive.update(,)                                                                                                                                                                                            
    }
}


