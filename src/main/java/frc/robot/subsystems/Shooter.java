package frc.robot.subsystems;

/* Imports */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Subsystem representing the shooter mechanism on the robot.
 */
public class Shooter extends SubsystemBase
{
    /* Class Variable Declaration */
    TalonSRX talSH;
    Encoder enc;

    /**
     * Constructs the Shooter subsystem.
     */

    double currentDeg;
    double velocity;
    public Shooter()
    {
        talSH = new TalonSRX(Constants.p_TAL_SH);
        enc = new Encoder(1,2,3);
        talSH.setInverted(true);
    }

    /**
     * Shoots power cells out of the robot at a given speed.
     * @param speed
     */
    public void set(double speed) {
        // TODO: This implementation is currently being used for bugfixing with the ctre mag encoders
        System.out.println("Enc val = " + currentDeg);
        System.out.println(velocity);

        
        // TODO: If the talon is inverted for the shooter, we should really just be inverting the talon
        talSH.set(ControlMode.PercentOutput, speed);
    }

    public double getDeg(){
        return currentDeg;
    }

    public double getRotVelocity(){
        return velocity;
    }

    public double getCMD(){
        return talSH.getMotorOutputPercent();
    }

    @Override
    public void periodic() {
        currentDeg = enc.get()*360/2000;
        velocity = enc.getRate()/2000;
    }

}