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
    int runUpper;
    
    /**
     * Constructs a new MacroIndexerR command with Indexer requirement.
     * @param id
     * @param second
     */
    public MacroIndexerR(Indexer id, int second)
    {
       _indexer =  id;
       addRequirements(_indexer);
       runUpper = second;
    }

    @Override
    public void execute()
    {
        _indexer.set(Constants.INDEX_VELOCITY_R,runUpper);
    }
    
    @Override
    public void end(boolean interrupted) {
        _indexer.set(0,3);
    }
}