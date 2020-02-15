package frc.robot;

public class PID{

    double turTotal;

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

        turTotal = 1;
    }

    public void updateVis(double error){
        _error = error;

        turTotal = sumTurChange();
       
    }

    public double getTurKp(){
        if(_error > 20){
            return Constants.TUR_LEFT; //gimme a constant
        } else if (_error < -20){
            return Constants.TUR_RIGHT; //gimme a constant
        } else {
            return -_error*_p;
        }
    }

    public double getTur(){
        return turTotal/35; 
    }

    public double sumTurChange(){
        return getTurKp();
    }
}