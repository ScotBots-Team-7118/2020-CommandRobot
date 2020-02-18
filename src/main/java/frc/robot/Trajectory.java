package frc.robot;

public class Trajectory{

    static double targH = 2.49555;
    static double deg = 35;
    static double toRad = 2*Math.PI/360;
    static double mtoft = 3.281;

    public static double calcVelocity(double d){
        if(d > 3.6 ){
            //System.out.println(d + " Trajectoryifing");    
            double v = 4.9/(-(2.49555-1.056386-d*Math.tan(35*toRad)));
            //System.out.println(v+"this is v step 2");
            v = Math.sqrt(v)*d;
            //System.out.println(v+"this is v step 3");
            v = v/Math.cos(35*toRad);
            //System.out.println(v+" this is v");
            return v * mtoft;
        }else{
            System.out.println("Out of Range");
            return 0;
        }
    }   
}