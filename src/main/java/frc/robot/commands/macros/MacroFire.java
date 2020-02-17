package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MacroFire extends CommandBase{

    Timer time;
    Indexer _index;

    boolean isNum;
    double num;

    public MacroFire(double number){
        num = number;
        time = new Timer();
        _index = new Indexer();
        addRequirements(_index);
        isNum = true;
    }

    public MacroFire(){
        time = new Timer();
        _index = new Indexer();
        addRequirements(_index);
        isNum = false;
    }

    @Override
    public void execute() {
        if(isNum){
            shootFor(num);
        }else{
            shootFor();
        }
    }

    private void shootFor(double num){
        for(int i = 0; i < num; i++){
            if(time.hasPeriodPassed(0.5)){
                if(!time.hasPeriodPassed(0.5)){
                    _index.set(0.3);
                }
            }
        }
    }

    private void shootFor(){
        if(time.hasPeriodPassed(0.5)){
            _index.set(0.3);
        }
    }
}