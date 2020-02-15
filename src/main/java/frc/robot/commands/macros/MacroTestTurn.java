package frc.robot.commands.macros;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;

//imports

public class MacroTestTurn extends CommandBase{

    Turret turret;

    public MacroTestTurn(){
        turret = RobotContainer.s_Turret;
        addRequirements(turret);    
    }

    @Override
    public void execute() {
        turret.set(-Constants.SHOOTER_SPEED);
    }
}