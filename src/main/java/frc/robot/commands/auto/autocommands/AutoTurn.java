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
        // Stop the robot and the command if the angle is 0 (since the robot is already in the correct position).
        if (_angle == 0)
        {
            _drive.update(0, 0);
            cancel();
        }

        // If the robot is too far left, turn to the right at a decreasing speed
        if (_gyro.getNormalizedHeading() < _angle - Constants.TURN_DEADZONE)
        {
            _drive.update(-(_gyro.getNormalizedHeading() / _angle) * Constants.FULL_TURN_SPEED,
                            (_gyro.getNormalizedHeading() / _angle) * Constants.FULL_TURN_SPEED);
        }

        // If the robot is too far right, turn to the left at a decreasing speed
        else if (_gyro.getNormalizedHeading() > _angle + Constants.TURN_DEADZONE)
        {
            _drive.update((_gyro.getNormalizedHeading() / _angle) * Constants.FULL_TURN_SPEED,
                            (_gyro.getNormalizedHeading() / _angle) * Constants.FULL_TURN_SPEED);
        }

        // If the robot isn't too far to the right or too far to the left, stop the robot and end the command.
        else
        {
            _drive.update(0, 0);
            cancel();
        }                                                                                                                                                                                
    }
}