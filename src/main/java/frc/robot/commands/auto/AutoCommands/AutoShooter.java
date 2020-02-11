package frc.robot.commands.auto.AutoCommands;

//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class AutoShooter extends CommandBase{

    Shooter shooter;

    public AutoShooter(){
        shooter = RobotContainer.s_Shooter;

        addRequirements(shooter);
    }

    public void execute(){
                                                                                                                                                                                                    
    }
}
//Need to figure out input number, how far we want the robot to turn and shoot   