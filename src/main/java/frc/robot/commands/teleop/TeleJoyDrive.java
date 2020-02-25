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
    /* TODO: Fix implementation for parabolic control */

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
        //Testing.pingMe("CalcSpeeds");
        // TODO: Clean this up a bit if possible
        double[] toReturn = new double[2];
        double axisL = _oi.getController("JoyL").getRawAxis(1);
        double axisR = _oi.getController("JoyR").getRawAxis(1);

        // double vL = Constants.JOYDRIVE_A*Math.pow(axisL, 2) + Constants.JOYDRIVE_B*axisL;
        // double vR = Constants.JOYDRIVE_A*Math.pow(axisR, 2) + Constants.JOYDRIVE_B*axisR;
        
        double vL = (_oi.getController("JoyR").getRawButton(2)) ? axisL : axisL/3;
        double vR = (_oi.getController("JoyR").getRawButton(2)) ? axisR : axisR/3;

        toReturn[0] = (Math.abs(axisL) > Constants.DEADZONE) ? vL : 0.0;
        toReturn[1] = (Math.abs(axisR) > Constants.DEADZONE) ? vR : 0.0;

        return toReturn;
    }

    @Override
    public void end(boolean interrupted) {
    }
}