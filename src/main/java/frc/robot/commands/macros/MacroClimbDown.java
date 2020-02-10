package frc.robot.commands.macros;

//Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;
import frc.robot.Constants;

public class MacroClimbDown extends CommandBase{
   
    Climber climbDown;

    public MacroClimbDown()
    {
        climbDown = RobotContainer.s_Climber;
        addRequirements(climbDown);

    }
    public void execute()
    {
        climbDown.update(Constants.CLIMBER_SPEEDD);
    }
}