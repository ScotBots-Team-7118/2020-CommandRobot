package frc.robot.commands.teleop;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.*;

public class TeleJoyDrive extends CommandBase
{
    DriveTrain drive;
    OI oi;

    public TeleJoyDrive()
    {
        // Retrieve drivetrain subsystem.
        drive = RobotContainer.s_DriveTrain;
        oi = Robot.oi;

        // Allocate to DriveTrain subsystem.
        addRequirements(drive);
    }

    //update drive subsystem to calculated speeds.
    public void execute()
    {
        drive.update(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate talon inputs depending on controller inputs.
     * @return
     */
    public double[] calculateSpeeds()
    {
        double[] toReturn = new double[2];
        double left = oi.getController("JoyL").getRawAxis(1)/3;
        double right = oi.getController("JoyR").getRawAxis(1)/3;

        toReturn[0] = (Math.abs(left) > Constants.DEADZONE / 3) ? left : 0.0;
        toReturn[1] = (Math.abs(right) > Constants.DEADZONE / 3) ? right : 0.0;

        return toReturn;
    }
}