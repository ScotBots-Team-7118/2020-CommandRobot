package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Indexer;
import frc.robot.Constants;

public class MacroIndexerR extends CommandBase
{
    Indexer index;
    public MacroIndexerR()
    {
       index =  RobotContainer.s_Indexer;
       addRequirements(index);
    }

    @Override
    public void execute() {
        index.update(Constants.INDEX_SPEEDR);
    }
}