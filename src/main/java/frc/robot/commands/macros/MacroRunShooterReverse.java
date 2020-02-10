package frc.robot.commands.macros;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

//imports

public class MacroRunShooterReverse extends CommandBase{

    Shooter shoot;

    public MacroRunShooterReverse(){
        shoot = RobotContainer.s_Shooter;
        addRequirements(shoot);    
    }

    @Override
    public void execute() {
        shoot.update(-Constants.SHOOTER_SPEED);
    }
}