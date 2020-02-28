package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.Constants;

public class MacroFire extends CommandBase{

    //timer object
    static Timer time = new Timer();
    
    Indexer _index;

    //do i use a number of balls or run indefinite
    boolean isNum;;

    //am I finished
    boolean done;
    
    //number of balls
    int numCount;

    public MacroFire(Indexer id, int number){
        _index = id;
        addRequirements(_index);
        isNum = true;
        numCount = number;
    }

    public MacroFire(Indexer id){
        _index = id;
        addRequirements(_index);
        isNum = false;
    }

    public void initialize(){
        time.start();
    }

    public void end(boolean interupt){
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

    /**
     * shoot for a number of shots
     * @param num
     */
    private void shootFor(int num){
        System.out.println(time.get());
        if(time.get() < Constants.SHOOT_TIME){
            System.out.println("setting");
            _index.set(Constants.SHOOT_SPEED,1);
        }else{
            _index.set(0,1);
        }
        
        if(time.get() > Constants.WAIT_TIME){
            System.out.println("resetting");
            numCount--;
            System.out.println("canceling");
            time.reset();
        }
        if(numCount == 0){
            _index.set(0,1);
            time.reset();
            cancel();
        }
    }

    /**
     * shoot until cancelled
     */
    private void shootFor(){
        
        if(time.get() < Constants.SHOOT_TIME){
            _index.set(Constants.SHOOT_SPEED, 1);
        }else{
            _index.set(0, 1);
        }
        
        if(time.get() > Constants.WAIT_TIME){
            time.reset();
            cancel();
        }
    }
}