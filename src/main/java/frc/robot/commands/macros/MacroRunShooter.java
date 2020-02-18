package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Shooter;

/**
 * Command to run the shooter to shoot power cells out of the robot.
 * 
 * Requires the Shooter subsystem.
 */
public class MacroRunShooter extends CommandBase
{
    /* Instance Variable Declaration */
    Shooter _shooter;
    PID pid;
    boolean isAuto;
    /**
     * Constructs a new MacroRunShooter command with a Shooter requirement.
     */
    public MacroRunShooter(boolean isAuto)
    {
        this.isAuto = isAuto;
        _shooter = RobotContainer.s_Shooter;
        pid = new PID(Constants.SHOOTER_P);
        addRequirements(_shooter);
    }

    @Override
    public void execute()
    {
        
        double w =  Trajectory.calcVelocity(Networktable.getDistance())/Constants.DIST_PER_ROTATION;
        double v = pid.getShooterSpeed(_shooter.getRotVelocity(), w)/Constants.MAX_DIST;
        _shooter.set(v);
        if(isAuto && Math.abs(_shooter.getRotVelocity() - w) < 0.25){
            cancel();
        }
    }
}