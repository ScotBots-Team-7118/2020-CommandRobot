package frc.robot.commands.macros;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants;

public class MacroWarmShooter extends CommandBase{

    Shooter shooter;

    public MacroWarmShooter(){
        shooter = RobotContainer.s_Shooter;
        addRequirements(RobotContainer.s_Shooter);
    }

    public void execute(){
        shooter.update(Constants.SHOOTER_SPEED);
    }
}