package frc.robot.commands.teleop;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import frc.robot.*;

public class TeleXboxDrive extends CommandBase
{

    DriveTrain drive;

    public TeleXboxDrive()
    {
        // Retrieve drive subsytem.
        drive = RobotContainer.s_DriveTrain;

        // Allocate to DriveTrain subsystem.
        addRequirements(drive);
    }

    public void execute()
    {
        //set drive subsystem to calculated speeds.
        drive.update(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate speeds according to controller inputs.
     * @return
     */
    public double[] calculateSpeeds(){
        double[] toReturn = new double[2];
        double left = -Robot.oi.getController("Xbox").getRawAxis(1)/3;
        double right = -Robot.oi.getController("Xbox").getRawAxis(5)/3;

        toReturn[0] = (Math.abs(left) > Constants.DEADZONE / 3) ? left : 0.0;
        toReturn[1] = (Math.abs(right) > Constants.DEADZONE / 3) ? right : 0.0;

        return toReturn;
    }
}