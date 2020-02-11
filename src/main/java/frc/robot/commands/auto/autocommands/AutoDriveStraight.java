package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

/**
 * Command to move the robot in a straight line a given distance autonomously.
 * A positive distance indicates that the robot should move forwards,
 * whereas a negative distance indicates that the robot should move backwards.
 * 
 * Requires the DriveTrain subsystem.
 */
public class AutoDriveStraight extends CommandBase
{
    /* Instance Variable Declaration */
    DriveTrain _drive;
    double _dist;

    /**
     * Constructs a new AutoForward command for a given distance
     * with a DriveTrain requirement.
     */
    public AutoDriveStraight(double distance)
    {
        _drive = RobotContainer.s_DriveTrain;
        _dist = distance;
        addRequirements(_drive);
    }

    @Override
    public void execute()
    {
        /* TODO: Implement me! */
        // TODO: Need to figure out input number, how far we want the robot to go                                                                                                                                                                            
    }
}


