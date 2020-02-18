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
        //System.out.println("Running Shooter");
        this.isAuto = isAuto;
        _shooter = RobotContainer.s_Shooter;
        pid = new PID(Constants.SHOOTER_P);
        addRequirements(_shooter);
    }

    @Override
    public void execute()
    {
        //System.out.println("executing Shooter");
        double w =  Trajectory.calcVelocity(Networktable.getDistance())/Constants.DIST_PER_ROTATION;
        //System.out.println(w);
        double v = pid.getShooterSpeed(_shooter.getRotVelocity(), w)/Constants.MAX_DIST;
        //System.out.println(v+" to motor");
        _shooter.set(v);
        if(isAuto && Math.abs(_shooter.getRotVelocity() - w) < 0.25){
            cancel();
        }
    }

    @Override
    public void end(boolean interrupted) {
        //System.out.println("ending");
        _shooter.set(0);
    }
}