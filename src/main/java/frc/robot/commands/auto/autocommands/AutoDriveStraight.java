package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

/**
 * Command to move the robot in a straight line a given distance autonomously. A
 * positive distance indicates that the robot should move forwards, whereas a
 * negative distance indicates that the robot should move backwards.
 * 
 * Requires the DriveTrain subsystem.
 */
public class AutoDriveStraight extends CommandBase
{

    /* Instance Variable Declaration */
    DriveTrain _drive;
    double _dist;
    double _remainder;
    int _sign;

    /**
     * Constructs a new AutoForward command for a given distance with a DriveTrain
     * requirement.
     */
    public AutoDriveStraight(double distance)
    {
        _drive = RobotContainer.s_DriveTrain;
        _dist = distance;
        _sign = (_dist == 0) ? 0 : (int) (_dist / Math.abs(_dist));

        addRequirements(_drive);
    }

    @Override
    public void execute()
    {
       // Calculate the distance that the robot still has to travel 
        _remainder = _dist - Constants.DIST_PER_ROTATION * ((_drive.getRightDist() + _drive.getLeftDist()) / 2);
        
        
        // If either side of the robot hasn't started moving, move both sides of the robot at the same speed
        if (_drive.getLeftDist() == 0 || _drive.getRightDist() == 0)
        {
            _drive.set(_sign * Constants.BASIC_SPEED, _sign * Constants.BASIC_SPEED);
        }

        // If the robot has a long way to go before reaching the distance,
        // drive the robot straight forward at an adjusted base speed
        else if (Math.abs(_remainder) > 2 /* TODO: wtf does this 2 represent */)
        {
            // This program uses a ratio between the two sides of the robot
            // to balance the speeds of each side of the robot in order to keep it driving straight

            double vR = (Math.abs(_drive.getLeftDist() / _drive.getRightDist() * Constants.BASIC_SPEED) > 1) ?
            1 : (_sign * _drive.getLeftDist() / _drive.getRightDist() * Constants.BASIC_SPEED);

            double vL = (Math.abs(_drive.getRightDist() / _drive.getLeftDist() * Constants.BASIC_SPEED) > 1) ?
            1 : (_sign * _drive.getRightDist() / _drive.getLeftDist() * Constants.BASIC_SPEED);

            _drive.set(vL, vR);                        
        }

        // If the robot is close to reaching the distance,
        // drive the robot forward at an adjusted brake speed
        else if (Math.abs(_remainder) < 2 && Math.abs(_remainder) > Constants.DIST_DEADZONE)
        {
            // Makes the robot slow down progressively before reaching the desired distance
            _drive.set(_sign * Constants.BRAKE_SPEED * _remainder, _sign * Constants.BRAKE_SPEED * _remainder);
        }

        // End the command and stop the robot when it gets close enough to the desired distance
        else
        {
           _drive.set(0, 0);
           cancel();
        }
    }
} 