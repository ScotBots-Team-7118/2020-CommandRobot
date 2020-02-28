package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Intake;

/**
 * Command to run the intake in reverse (away from the robot).
 * 
 * Requires the intake subsystem.
 */
public class MacroIntakeR extends CommandBase
{
    /* Instance Variable Declaration */
    Intake _intake;

    /**
     * Constructs a new MacroIntakeR command with an Intake requirement.
     */
    public MacroIntakeR(Intake in)
    {
        // Assigns the intake to RobotContainer.s_Intake
        _intake = in;
        addRequirements(_intake);
    }

    @Override
    public void execute()
    {
        //System.out.println("intakeing but r");
        _intake.set(Constants.IN_VELOCITY_R);
    }

    @Override
    public void end(boolean interrupted) {
        _intake.set(0);
    }
}