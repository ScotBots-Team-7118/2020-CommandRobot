package frc.robot.commands.macros;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;
import frc.robot.Constants;

public class MacroClimbUp extends CommandBase{

    Climber climbUp;

    public MacroClimbUp()
    {
        climbUp = RobotContainer.s_Climber;
        addRequirements(climbUp);
    }

    public void execute()
    {
        climbUp.update(Constants.CLIMBER_SPEEDU);
    }
}