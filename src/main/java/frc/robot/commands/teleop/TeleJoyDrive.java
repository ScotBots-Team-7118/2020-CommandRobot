package frc.robot.commands.teleop;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
import frc.robot.subsystems.DriveTrain;;

/**
 * Command to Drive the robot according to two joysticks.
 * 
 * Requires the DriveTrain subsystem.
 */
public class TeleJoyDrive extends CommandBase
{
    /* TODO: Untested Code */

    /* Instance Variable Declaration */
    DriveTrain _drive;
    OI _oi;

    /**
     * Constructs a new TeleJoyDrive command with a DriveTrain requirement.
     */
    public TeleJoyDrive()
    {
        // Retrieve drivetrain subsystem.
        _drive = RobotContainer.s_DriveTrain;
        _oi = Robot.oi;

        // Allocate to DriveTrain subsystem.
        addRequirements(_drive);
    }

    /**
     * Update drive subsystem to calculated speeds.
     */
    @Override
    public void execute()
    {
        _drive.set(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate talon inputs depending on controller inputs.
     * @return
     */
    public double[] calculateSpeeds()
    {
        // TODO: Clean this up a bit if possible
        double[] toReturn = new double[2];
        double left = _oi.getController("JoyL").getRawAxis(1)/3;
        double right = _oi.getController("JoyR").getRawAxis(1)/3;

        toReturn[0] = (Math.abs(left) > Constants.DEADZONE / 3) ? left : 0.0;
        toReturn[1] = (Math.abs(right) > Constants.DEADZONE / 3) ? right : 0.0;

        return toReturn;
    }
}