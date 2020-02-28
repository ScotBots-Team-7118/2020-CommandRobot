package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;

// TODO: Test Code
/**
 * Command to test turning the Turret.
 * 
 * Requires the turret subsystem.
 */
public class MacroTestTurn extends CommandBase
{
    /* Instance Variable Declaration */
    Turret _turret;

    /**
     * Constructs a new MacroTestTurn command with a Turret requirement.
     */
    public MacroTestTurn(Turret t)
    {
        _turret = t;
        addRequirements(_turret);    
    }

    @Override
    public void execute()
    {
        _turret.set(-Constants.SHOOTER_SPEED);
    }
}