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
    Proportional p;
    boolean isAuto;
    boolean done;
    /**
     * Constructs a new MacroRunShooter command with a Shooter requirement.
     */
    public MacroRunShooter(Shooter s,boolean isAuto)
    {
        //System.out.println("Running Shooter");
        this.isAuto = isAuto;
        _shooter = s;
        p = new Proportional(Constants.SHOOTER_P);
        addRequirements(_shooter);
        done = false;
    }

    @Override
    public void execute()
    {

        //W contains the required velocity of the shooter wheel as calculated by vision data
        double w =  Trajectory.calcVelocity(_shooter.getDistance())/Constants.DIST_PER_ROTATION;
       
        //v contains the needed motor input to approach the given W value
        double v = p.getShooterSpeed(_shooter.getRotVelocity(), w)/Constants.MAX_DIST;
       
        //set shooter to calculated input
        _shooter.set(v);
        
        //cancel this command if during auto, you reach the needed speed.
        if(isAuto && Math.abs(_shooter.getRotVelocity() - w) < 0.25){
            done = true;
        }
    }

    //end command without interrupt
    @Override
    public boolean isFinished() {
     
        return done;
    }

    //test for interupt to stop motor
    @Override
    public void end(boolean interrupted) {
        if(interrupted){
            _shooter.set(0);
        }
    }
}