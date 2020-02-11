package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

/**
 * The command group for running the shooter mechanism.
 */
public class MacroShooterGroup extends ParallelCommandGroup
{
    /* TODO: Implement me! */

    /* Instance Variable Declaration */


    /**
     * Constructs a new MacroShooterGroup command group.
     */
    public MacroShooterGroup()
    {
        addCommands(new MacroFindTarget());
    }
}