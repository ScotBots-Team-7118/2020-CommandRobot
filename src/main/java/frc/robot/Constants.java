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
        /* Climber */
        // Talon Port Number
        public static int p_TAL_C = 0;

        // Velocities (% fraction of full speed)
        public static double CLIMBER_VELOCITY_U = 0.1;
        public static double CLIMBER_VELOCITY_D = -0.1;

        
        /* Controls/OI */
        // Enum for controls configurations and associated variable
        public static enum ControlsConfig {JOYSTICKS, XBOX, DUALDRIVERS};
        public static ControlsConfig controls = ControlsConfig.XBOX;

        // Controller Ports for various values of ControlsConfig
        public static int p_XBOX = 0;
        public static int p_JOYL = 0;
        public static int p_JOYR = 1;
        public static int[] p_DUALDRIVERS = {0, 1, 2};

        // // Turret controller || TODO: Confirm that reformatting is good with Nathaniel
        // public static int TURC = 1;

        // Joystick deadzone
        public static double DEADZONE = 0.1;


        /* DriveTrain */
        // Talon Port Numbers
        public static int p_TAL_RM = 5;
        public static int p_TAL_RF = 4;
        public static int p_TAL_LM = 3;
        public static int p_TAL_LF = 2;
        

        /* Indexer */
        // Talon Port Number
        public static int p_TAL_ID = 0;

        // Velocities (% fraction of full speed)
        public static double INDEX_VELOCITY_F = 0.1;
        public static double INDEX_VELOCITY_R = -0.1;
        

        /* Intake */
        // Talon Port Number
        public static int p_TAL_IN = 0;

        // Velocities (% fraction of full speed)
        public static double IN_VELOCITY_F = 0.1;
        public static double IN_VELOCITY_R = -0.1;
        

        /* Shooter */
        // Talon Port Number
        public static int TAL_SH = 5;

        // Target Speed (% fraction of full speed)
        public static double SHOOTER_SPEED = 1;


        /* Turret */
        // Talon Port Number
        public static int p_TAL_TUR = 3;

        // Turret Rotating Speed
        public static double TURRET_SPEED = 1;

        // Variables Representing Ideal Inputs for MacroRotateTurret
        public static int LEFT = -1;
        public static int RIGHT = 1;
}
