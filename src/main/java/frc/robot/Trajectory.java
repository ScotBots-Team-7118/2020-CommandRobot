package frc.robot;

public class Trajectory{

    static double targH = 2.49555;
    static double deg = 35;
    static double toRad = 2*Math.PI/360;
    static double mtoft = 3.281;

    public static double calcVelocity(double d){
        if(d > 3.6 ){    
            double v = 4.9/(-(2.49555-1.056386)*Math.tan(35*toRad));
            v = Math.sqrt(v)*d;
            v = v/Math.cos(35*toRad);
            return v * mtoft;
        }else{
            System.out.println("Out of Range");
            return 0;
        }
    }   
}