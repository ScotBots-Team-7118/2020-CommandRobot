package frc.robot.commands.auto;

//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.*;

public class AutoRight extends CommandBase{

    DriveTrain drive;

    public AutoRight(){
        drive = RobotContainer.s_DriveTrain;

        addRequirements(drive);
    }

    public void execute(){
                                                                                                                                                                                                    
    }
}
//Need to figure out input number, how far we want the robot to go