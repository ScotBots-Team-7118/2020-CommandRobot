package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.Timer;
/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

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
    Timer time;
    double Howlong;
    /**
     * Constructs a new MacroRotateTurret command with a Turret requirement.
     * @param direction of rotation.
     * direction = 1 for rightward rotation, direction = -1 for leftward rotation.
     */
    public MacroRotateTurret(Turret t,int direction)
    {
        _turret = t;
        _sign = direction / Math.abs(direction);

        addRequirements(_turret);    
    }

    public MacroRotateTurret(Turret t, int direction, double ti){
        _turret = t;
        _sign = direction / Math.abs(direction);

        addRequirements(_turret);  
        Howlong = ti;
        time = new Timer();
        time.start();
    }

    @Override
    public void execute()
    {
        // TODO: Should stop the turret upon terminating the command
        // TODO: Tests needed to confirm the correct direction of the shooter
        _turret.set(_sign);

        if(time.get() >= Howlong){
            time.reset();
            _turret.set(0);
            cancel();
        }
    }
}