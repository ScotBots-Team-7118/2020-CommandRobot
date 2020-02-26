package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.Constants;
import frc.robot.Testing;

public class MacroFire extends CommandBase{

    static Timer time = new Timer();
    Indexer _index;

    boolean isNum;;

    boolean done;

    int numCount;
    int intnumber;

    public MacroFire(int number){
        _index = new Indexer();
        addRequirements(_index);
        isNum = true;
        intnumber = number;
    }

    public MacroFire(){
        _index = new Indexer();
        addRequirements(_index);
        isNum = false;
    }

    public void initialize(){
        System.out.println("init");
        time.start();
        numCount = intnumber;
    }

    public void end(boolean interupt){
        System.out.println("ending");
        time.stop();
    }

    @Override
    public void execute() {
        if(isNum){
            shootFor(numCount);
        }else{
            shootFor();
        }
    }

    private void shootFor(int num){
        System.out.println(time.get());
        if(time.get() < Constants.SHOOT_TIME){
            System.out.println("setting");
            _index.set(Constants.SHOOT_SPEED);
        }else{
            _index.set(0);
        }
        
        if(time.get() > Constants.WAIT_TIME){
            System.out.println("resetting");
            numCount--;
            System.out.println("canceling\n\n\n\n\n\n");
            time.reset();
        }
        if(numCount == 0){
            _index.set(0);
            time.reset();
            cancel();
        }
    }

    private void shootFor(){
        
        if(time.get() < Constants.SHOOT_TIME){
            _index.set(Constants.SHOOT_SPEED);
        }else{
            _index.set(0);
        }
        
        if(time.get() > Constants.WAIT_TIME){
            time.reset();
            cancel();
        }
    }
}