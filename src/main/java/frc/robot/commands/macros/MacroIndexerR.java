package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Indexer;

/**
 * Command to run the indexer backwards.
 * 
 * Requires the indexer subsystem.
 */
public class MacroIndexerR extends CommandBase
{
    /* TODO: Untested Code */

    /* Instance Variable Declaration */
    Indexer _indexer;

    /**
     * Constructs a new MacroIndexerR command with Indexer requirement.
     */
    public MacroIndexerR()
    {
       _indexer =  RobotContainer.s_Indexer;
       addRequirements(_indexer);
    }

    @Override
    public void execute()
    {
        _indexer.set(Constants.INDEX_VELOCITY_R);
    }
}