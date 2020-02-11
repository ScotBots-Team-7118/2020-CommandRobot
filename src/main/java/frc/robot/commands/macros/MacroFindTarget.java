package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Vision;

/**
 * Command for the robot to locate the power cell hopper.
 * 
 * Requires the vision subsystem.
 */
public class MacroFindTarget extends CommandBase
{
    /* TODO: Implement me! */
    Vision _vision;

    /* Instance Variable Declaration */

    /**
     * Constructs a new MacroFindTarget command with a Vision requirement.
     */
    public MacroFindTarget()
    {
        _vision = RobotContainer.s_Vision;
        addRequirements(_vision);
    }

    @Override
    public void execute()
    {
        
    }
}