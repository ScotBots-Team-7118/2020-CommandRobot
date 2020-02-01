/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
        public static enum ControlsConfig {JOYSTICKS, XBOX};
        public static ControlsConfig controls = ControlsConfig.XBOX;

        //Drive talon imports
        public static int TAL_RM = 5;
        public static int TAL_RF = 4;
        public static int TAL_LM = 3;
        public static int TAL_LF = 2;

        //Joystick Deadzone
        public static double DEADZONE = 0.1;
    
        //Intake talon
        public static int TAL_IN = 0;

        //indexer talon
        public static int TAL_ID = 0;
    
        //Climber motor(s)
        public static int TAL_CL = 0;  
        public static int TAL_CR = 0; 
        
        //Shooter talon
        public static int TAL_SH =0;

        //Turret talon
        public static int TAL_TUR = 0;
        
        //Controllers
        public static int XBOX = 0;
        public static int JOYL = 0;
        public static int JOYR = 1;
}
