package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        
        //W contains the required velocity of the shooter wheel as calculated by vision data
        double w =  Trajectory.calcVelocity(Networktable.getDistance())/Constants.DIST_PER_ROTATION;
        
       // Testing.pingMe("w is ",w+"");
        
       
        //v contains the needed motor input to approach the given W value
        double v = pid.getShooterSpeed(_shooter.getRotVelocity(), w)/Constants.MAX_DIST;
        //Testing.pingMe("v is ",v+"");
        //System.out.println(v+" to motor");
       
        //set shooter to calculated input
        _shooter.set(v);
        
        //cancel this command if during auto, you reach the need speed.
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