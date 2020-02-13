package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Turret;

/**
 * Command to rotate the turret a given direction.
 * If the given int is positive, the turret will rotate right.
 * Otherwise, the turret will rotate left.
 * 
 * Requries the Turret subsystem.
 */
public class MacroRotateTurret extends CommandBase
{
    /* Instance Variable Declaration */
    Turret _turret;
    int _sign = 0;

    /**
     * Constructs a new MacroRotateTurret command with a Turret requirement.
     * @param direction of rotation.
     * direction = 1 for rightward rotation, direction = -1 for leftward rotation.
     */
    public MacroRotateTurret(int direction)
    {
        _turret = RobotContainer.s_Turret;
        _sign = direction / Math.abs(direction);
        addRequirements(_turret);    
    }

    @Override
    public void execute()
    {
        // Should stop the turret upon terminating the command
        // Tests needed to confirm the correct direction of the shooter
        _turret.update(_sign);
    }
}