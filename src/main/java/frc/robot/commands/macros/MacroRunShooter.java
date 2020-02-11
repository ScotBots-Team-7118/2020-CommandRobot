package frc.robot.commands.macros;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

//imports

public class MacroRunShooter extends CommandBase{

    Shooter shoot;

    public MacroRunShooter(){
        shoot = RobotContainer.s_Shooter;
       addRequirements(shoot);    // Add the shooter subsystem as a requirement for this command
    }
// Constantly updating shoot
    @Override
    public void execute() {
        shoot.update(-Constants.SHOOTER_SPEED);
    }
}