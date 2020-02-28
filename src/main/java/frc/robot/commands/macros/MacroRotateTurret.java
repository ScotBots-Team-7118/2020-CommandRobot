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
     * direction = 1 for rightward rotation, direction = -1 for leftward rotation.
     * @param t
     * @param direction
     */
    public MacroRotateTurret(Turret t,int direction)
    {
        //assign pointer and direction of rotation
        _turret = t;
        _sign = direction / Math.abs(direction);

        addRequirements(_turret);    
    }

    /**
     * Constructs a new MacroRotateTurret command with a Turret requirement.
     * direction = 1 for rightward rotation, direction = -1 for leftward rotation.
     * time in seconds for the turret to move
     * @param t
     * @param direction
     * @param ti
     */
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
        _turret.set(_sign);

        if(time.get() >= Howlong){
            time.reset();
            _turret.set(0);
            cancel();
        }
    }
}