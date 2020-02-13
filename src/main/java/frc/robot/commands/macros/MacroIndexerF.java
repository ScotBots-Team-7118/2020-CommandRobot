package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Indexer;

/**
 * Command to run the indexer forwards.
 * 
 * Requires the indexer subsystem.
 */
public class MacroIndexerF extends CommandBase
{
    /* TODO: Untested Code */

    /* Instance Variable Declaration */
    Indexer _indexer;
    

    /**
     * Constructs a new MacroIndexerF command with Indexer requirement.
     */
    public MacroIndexerF()
    {
       _indexer =  RobotContainer.s_Indexer;
       addRequirements(_indexer);
    }

    @Override
    public void execute() {
        _indexer.update(Constants.INDEX_VELOCITY_F);
    }
}