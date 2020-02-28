package frc.robot.commands.auto.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.macros.*;

public class AutoRevFire extends SequentialCommandGroup{
    
    public AutoRevFire(Indexer id,Shooter s,int number){
        for(int i = 0; i < number; i++){
            addCommands(new MacroRunShooter(s,true));
            addCommands(new MacroFire(id, 1));
        }
    }
}