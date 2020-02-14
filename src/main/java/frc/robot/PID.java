package frc.robot;

public class PID{

    double total;

    double _error;
    double _p;
    double _i;
    double _d;

    boolean useP;
    boolean useI;
    boolean useD;

    public PID(double p, double i, double d, boolean up, boolean ui, boolean ud){
        _p = p;
        _i = i;
        _d = d;

        useP = up;
        useI = ui;
        useD = ud;

        total = 1;
    }

    public void updateVis(double error){
        _error = error;

        total = sumChange();
       
    }

    public double getKp(){
        if(_error > 20){
            return 0; //gimme a constant
        } else if (_error < -20){
            return -0; //gimme a constant
        } else {
            return -_error*_p;
        }
    }

    public double getTur(){
        return total/35; 
    }

    public double sumChange(){
        return getKp();
    }
}