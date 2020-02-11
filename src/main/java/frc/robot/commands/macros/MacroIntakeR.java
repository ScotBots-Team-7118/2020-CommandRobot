package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

public class MacroIntakeR extends CommandBase
{
    Intake intake;
    public MacroIntakeR()
    {
        // Assigns the intake to RobotContainer.s_Intake
        intake = RobotContainer.s_Intake;
        addRequirements(intake);
    }

    public void execute()
    {
        // Updates intake constantly
        intake.update(Constants.INDEX_SPEEDR);
    }
}