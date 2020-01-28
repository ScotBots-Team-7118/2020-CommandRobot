package frc.robot.commands.teleop;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.Robot;

public class TeleJoyDrive extends CommandBase{

    DriveTrain drive;

    public TeleJoyDrive(){
        //retrieve drivetrain subsystem.
        drive = RobotContainer.s_DriveTrain;
        addRequirements(drive);
    }

    //update drive subsystem to calculated speeds.
    public void execute(){
        drive.update(calculateSpeeds()[0], calculateSpeeds()[1]);
    }

    /**
     * Calculate talon inputs depending on controller inputs.
     * @return
     */
    public double[] calculateSpeeds(){
        double[] toReturn;
        double left = Robot.oi.JoyL.getRawAxis(1)/3;
        double right = Robot.oi.JoyR.getRawAxis(1)/3;

        if(left > Constants.DEADZONE || right > Constants.DEADZONE){
            toReturn = new double[]{left, right};
        }else{
            toReturn = new double[]{0.0,0.0};
        }
        return toReturn;
    }
}