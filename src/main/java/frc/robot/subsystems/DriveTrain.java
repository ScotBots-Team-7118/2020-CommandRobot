package frc.robot.subsystems;

/**
 * Imports
 */
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{

    //declare drive talons.
    TalonSRX TAL_LM;
    TalonSRX TAL_LF;
    TalonSRX TAL_RM;
    TalonSRX TAL_RF;

    public DriveTrain() {

        //initialize talons
        TAL_LM = new TalonSRX(Constants.TAL_FL);
        TAL_LF = new TalonSRX(Constants.TAL_BL);
        TAL_RM = new TalonSRX(Constants.TAL_FR);
        TAL_RF = new TalonSRX(Constants.TAL_BR);
    }

    /**
     * Set talons to pre-caculated input speeds.
     * @param speedL
     * @param speedR
     */
    public void update(double speedL, double speedR) {
        TAL_LM.set(ControlMode.PercentOutput, speedL);
        TAL_LF.set(ControlMode.Follower, Constants.TAL_FL);

        TAL_RM.set(ControlMode.PercentOutput, -speedR);
        TAL_RF.set(ControlMode.Follower, Constants.TAL_FR);
    }

    public void periodic() {
    }

}