package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Intake;

/**
 * Command to run the intake forwards (into the robot).
 * 
 * Requires the intake subsystem.
 */
public class MacroIntakeF extends CommandBase
{
    /* Instance Variable Declaration */
    Intake _intake;
    
    /**
     * Constructs a new MacroIntakeF command with an Intake requirement.
     */
    public MacroIntakeF()
    {
        _intake = RobotContainer.s_Intake;
        addRequirements(_intake);
    }

    @Override
    public void execute()
    {
        // TODO: Finish implementation
        // Intake should not run if the indexer is full (this should be considered here).
        _intake.update(Constants.INDEX_VELOCITY_F);
    }
}