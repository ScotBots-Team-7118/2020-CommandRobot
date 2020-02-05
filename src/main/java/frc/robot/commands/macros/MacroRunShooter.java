package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class MacroRunShooter extends CommandBase
{
    Shooter shooter;

    public MacroRunShooter()
    {
        shooter = RobotContainer.s_Shooter;
        addRequirements(shooter);
    }
    public void execute()
    {

    }
}