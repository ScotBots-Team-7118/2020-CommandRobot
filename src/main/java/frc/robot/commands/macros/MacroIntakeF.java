package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

public class MacroIntakeF extends CommandBase
{
    Intake intake;
    public MacroIntakeF()
    {
        intake = RobotContainer.s_Intake;
        addRequirements(intake);
    }

    public void execute()
    {
        intake.update(Constants.INDEX_SPEEDF);
    }
}