package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.subsystems.DriveTrain;
/**
 * 
 */
public class AutoBasicGroup extends SequentialCommandGroup
{
    public AutoBasicGroup(DriveTrain d){
        addCommands(new AutoDriveStraight(d, 4));
    }    
}