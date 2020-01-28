package frc.robot.commands.teleop;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import frc.robot.Robot;

public class TeleXboxDrive extends CommandBase{

    DriveTrain drive;
    public TeleXboxDrive(){

        //retrieve drive subsytem.
        drive = RobotContainer.s_DriveTrain;
        addRequirements(drive);
    }

    public void execute(){
        //set drive subsystem to calculated speeds.
        drive.update(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate speeds according to controller inputs.
     * @return
     */
    public double[] calculateSpeeds(){
        double[] toReturn;
        double left = Robot.oi.XBOX.getRawAxis(1)/3;
        double right = Robot.oi.XBOX.getRawAxis(5)/3;
        toReturn = new double[]{left, right};
        return toReturn;
    }
}