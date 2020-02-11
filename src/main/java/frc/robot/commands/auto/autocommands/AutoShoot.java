package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

/**
 * Command to run the shooter autonomously.
 * 
 * Requires the Shooter subsystem.
 */
public class AutoShoot extends CommandBase{
    /* Instance Variable Declaration */
    Shooter _shooter;

    /**
     * Constructs a new AutoShooter command with a Shooter requirement.
     */
    public AutoShoot()
    {
        _shooter = RobotContainer.s_Shooter;
        addRequirements(_shooter);
    }

    @Override
    public void execute()
    {
        /* TODO: Implement me! */
        // TODO: Need to figure out input number, how far we want the robot to turn and shoot
    }
}