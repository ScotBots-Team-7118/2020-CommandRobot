package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Intake;

/**
 * Command to run the intake in reverse (away from the robot). Requires the intake subsystem.
 */
public class MacroIntakeR extends CommandBase
{
    /* Instance Variable Declaration */
    Intake _intake;

    /**
     * Constructs a new MacroIntakeR command with an Intake requirement.
     */
    public MacroIntakeR()
    {
        // Assigns the intake to RobotContainer.s_Intake
        _intake = RobotContainer.s_Intake;
        addRequirements(_intake);
    }

    @Override
    public void execute()
    {
        // TODO: Finish implementation
        // Intake should not run if the indexer is full (this should be considered here).
        _intake.set(Constants.INDEX_VELOCITY_R);
    }
}