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
    public MacroIntakeF(Intake in)
    {
        _intake = in;
        addRequirements(_intake);
    }

    @Override
    public void execute()
    {
        System.out.println("intakeing");
        _intake.set(Constants.IN_VELOCITY_F);
    }

    @Override
    public void end(boolean interrupted) {
        _intake.set(0);
    }
}