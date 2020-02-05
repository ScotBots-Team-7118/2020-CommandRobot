package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;

public class MacroClimb extends CommandBase
{
    Climber climber;

    public MacroClimb()
    {
        climber = RobotContainer.s_Climber;
        addRequirements (climber);
    }
    public void execute()
    {
        
    }
}