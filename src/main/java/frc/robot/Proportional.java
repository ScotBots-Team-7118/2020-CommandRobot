package frc.robot;

public class Proportional{

    double _error;
    double _p;

    /**
     * Set the proportional value
     * @param p
     */
    public Proportional(double p){
        _p = p;
    }

    /**
     * Update the current error via vision
     * @param error
     */
    public void updateVis(double error){
        _error = error;
    }

    /**
     * Calculate turret speed
     * @return
     */
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

    /**
     * return turret speed
     * @return
     */
    public double getTurretSpeed(){
        return adjustTurretSpeed()/35;
    }

    /**
     * Calculate shooter speed
     * @param cv
     * @param ov
     * @return
     */
    public double getShooterSpeed(double cv, double ov){
        double diff = ov-cv;
        diff = Math.abs(diff);
        return diff*_p;
    }
}