package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj.Timer;
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
public class AutoDriveStraight extends CommandBase {
    /* Instance Variable Declaration */
    DriveTrain _drive;
    double _dist;
    double _remainder;
    /**
     * Constructs a new AutoForward command for a given distance with a DriveTrain
     * requirement.
     */
    public AutoDriveStraight(double distance) {
        _drive = RobotContainer.s_DriveTrain;
        _dist = distance;
        addRequirements(_drive);
    }

    @Override
    public void execute() {
       //distance that the robot still has to travel 
        _remainder = _dist - Constants.D_PER_ROTATION * ((_drive.getRightDist() + _drive.getLeftDist()) / 2);

        //adjusts speed based on error and keeps robot driving straight
        if (_drive.getRightDist() <_drive.getLeftDist()) 
        {
            _drive.update(Constants.BASIC_SPEED, Constants.ADJUSTED_SPEED);
        }
        else if (_drive.getLeftDist() < _drive.getRightDist()) 
        {
            _drive.update(Constants.ADJUSTED_SPEED, Constants.BASIC_SPEED);
        }
        else 
        {
            _drive.update(Constants.BASIC_SPEED,Constants.BASIC_SPEED);
        }
        


        if (_drive.getLeftDist() == 0 ||_drive.getRightDist() == 0)
        {
            _drive.update(Constants.BASIC_SPEED, Constants.BASIC_SPEED);
        }
        else if (_remainder > 1)
        {
            double vR = (Math.abs(_drive.getRightDist() / _drive.getLeftDist() * Constants.BASIC_SPEED) > 1) ?
            1 : (_drive.getRightDist() / _drive.getLeftDist() * Constants.BASIC_SPEED);

            double vL = (Math.abs(_drive.getLeftDist() / _drive.getRightDist() * Constants.BASIC_SPEED) > 1) ?
            1 : (_drive.getLeftDist() / _drive.getRightDist() * Constants.BASIC_SPEED);

            _drive.update(vL, vR);                        
        }
        else if (_remainder < 1 && _remainder > 0)
        {
            _drive.update(Constants.BRAKE_SPEED * _remainder, Constants.BRAKE_SPEED * _remainder);
        }
        else
        {
            _drive.update(0, 0);
        }
    }
    
    
            /* TODO: Implement me! */
            // TODO: Need to figure out input number, how far we want the robot to go     


} 

