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
public class MacroAim extends CommandBase
{
    /* Instance Variable Declaration */
    Turret _turret;
    boolean auto;

    /**
     * Constructs a new MacroRotateTurret command with a Turret requirement.
     * @param direction of rotation.
     * direction = 1 for rightward rotation, direction = -1 for leftward rotation.
     */
    public MacroAim(Turret t, boolean isAuto)
    {
        auto = isAuto;   
        _turret = t;
        addRequirements(_turret);    
    }

    @Override
    public void execute()
    {
        double error = Robot.rC.s_Shooter.getError();
        // Should stop the turret upon terminating the command
        // Tests needed to confirm the correct direction of the shooter
       if(auto && Math.abs(error) < Constants.VIS_DEADZONE){
           cancel();
       }
       
        _turret.pid.updateVis(error);
        _turret.set(_turret.pid.getTurretSpeed());
    }
}