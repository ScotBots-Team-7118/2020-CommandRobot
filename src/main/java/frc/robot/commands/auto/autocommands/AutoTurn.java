package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.gyro.*;
import frc.robot.subsystems.*;

/**
 * Command to turn the robot a given number of degrees autonomously.
 * 
 * Requires the DriveTrain subsystem.
 */
public class AutoTurn extends CommandBase
{
    /* Instance Variable Declaration */
    DriveTrain _drive;
    Gyroscope _gyro;
    double _angle;

    /**
     * Constructs a new AutoTurn command for a given angle of interval (-180, 180] with a DriveTrain requirement.
     * If the given angle is not of this interval, the program will convert it to that interval.
     */
    public AutoTurn(double angle)
    {
        _drive = RobotContainer.s_DriveTrain;
        _gyro = Robot.oi.gyro;
        _gyro.reset();

        // Scales the given angle to the interval (-180, 180]
        _angle = _gyro.normalizedHeadingVal(angle);
        
        addRequirements(_drive);
    }

    @Override
    public void execute()
    {
        /* TODO: Implement me! */
        // TODO: Need to figure out input number, how far we want the robot to go
        
        if (_gyro.getNormalizedHeading() < _angle)
        {
            
        }

        else if (_gyro.getNormalizedHeading() > _angle)
        {

        }

        else
        {

        }                                                                                                                                                                                
    }
}