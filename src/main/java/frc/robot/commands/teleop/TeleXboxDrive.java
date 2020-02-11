package frc.robot.commands.teleop;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.*;


/**
 * Command to drive the robot using an xbox controller.
 * 
 * Requries the DriveTrain subsystem.
 */
public class TeleXboxDrive extends CommandBase
{
    /* TODO: Fix implementation for parabolic/P/PI control */

    /* Instance Variable Declaration */
    DriveTrain _drive;
    OI _oi;

    /**
     * Constructs a new TeleXboxDrive command with a DriveTrain requirement.
     */
    public TeleXboxDrive()
    {
        // Retrieve drive subsytem.
        _drive = RobotContainer.s_DriveTrain;
        _oi = Robot.oi;

        // Allocate to DriveTrain subsystem.
        addRequirements(_drive);
    }

    @Override
    public void execute()
    {
        // Set drive subsystem to calculated speeds.
        _drive.update(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate speeds according to controller inputs.
     * @return
     */
    public double[] calculateSpeeds(){
        double[] toReturn = new double[2];

        // Calculate the output for each side of the robot
        double left = -_oi.getController("Xbox").getRawAxis(1) / 3;
        double right = -_oi.getController("Xbox").getRawAxis(5) / 3;

        // Return 0.0 for any joystick value within the deadzone, return the calculated output otherwise
        toReturn[0] = (Math.abs(left) > Constants.DEADZONE / 3) ? left : 0.0;
        toReturn[1] = (Math.abs(right) > Constants.DEADZONE / 3) ? right : 0.0;

        return toReturn;
    }
}