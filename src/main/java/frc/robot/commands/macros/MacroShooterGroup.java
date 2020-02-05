package frc.robot.commands.macros;

//import
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class MacroShooterGroup extends ParallelCommandGroup{

    public MacroShooterGroup(){
        addCommands(new MacroWarmShooter());
        addCommands(new MacroFindTarget());
    }

}