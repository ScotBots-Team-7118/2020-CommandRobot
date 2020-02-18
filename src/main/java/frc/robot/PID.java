package frc.robot;

public class PID{

    //Sum turret corrections
    double turTotal;

    double _error;
    double _p;
    // double _i;
    // double _d;

    // boolean useP;
    // boolean useI;
    // boolean useD;

    public PID(double p/*, double i, double d, boolean up, boolean ui, boolean ud*/){
        _p = p;
        // _i = i;
        // _d = d;

        // useP = up;
        // useI = ui;
        // useD = ud;

        turTotal = 1;
    }

    public void updateVis(double error){
        _error = error;
       
    }

    public double adjustTurretSpeed(){
        if(Math.abs(_error) > Constants.TURRET_PZONE){
            return Math.abs(_error)/_error;
        } else if (Math.abs(_error) <= Constants.TURRET_PZONE){
            return _error*_p;
        }else{
            System.out.println("Error: Out of bounds turret");
            return 0;
        }
    }

    public double getTurretSpeed(){
        return adjustTurretSpeed()/35;
    }

    public double getShooterSpeed(double cv, double ov){
        double diff = ov-cv;
        return diff*_p;
    }
}