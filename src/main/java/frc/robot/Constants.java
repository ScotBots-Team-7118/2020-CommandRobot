/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants
{

        // PORTS

        /* Climber */
        // Talon Port Number
        public static int p_TAL_C = 0;


        /* Controls/OI */
        // Controller Ports for various values of ControlsConfig
        public static int p_XBOX = 0;
        public static int p_JOYL = 0;
        public static int p_JOYR = 0;
        public static int[] p_DUALDRIVERS = { 0, 1, 2 };


        /* DriveTrain */
        // Talon Port Numbers
        public static int p_TAL_RM = 0;
        public static int p_TAL_RF = 0;
        public static int p_TAL_LM = 0;
        public static int p_TAL_LF = 0;


        /* Indexer */
        // Talon Port Number
        public static int p_TAL_ID = 0;


        /* Intake */
        // Talon Port Number
        public static int p_TAL_IN = 0;


        /* Shooter */
        // Talon Port Number
        public static int p_TAL_SH = 0;


        /* Turret */
        // Talon Port Number
        public static int p_TAL_TUR = 0;



        // CONSTANTS

        /* Auto */


        /* AutoCommands */
        // AutoTurn Drive Full Speed
        public static double FULL_TURN_SPEED = 0.7;

        // AutoTurn allowed margin of error in degrees
        public static double TURN_DEADZONE = 0.5;

        // Auto drive speeds
        public static double BASIC_SPEED = 0.3;
        public static double BRAKE_SPEED = .5;

        // The allowed margin of error for AutoDriveStraight in feet.
        public static double DIST_DEADZONE = 0.08;

        // Auto line dist
        public static int AUTO_LINE_DIST = 0;

        // Auto groups drive distances (measurements in feet)
        public static double[] AUTO_CENTER_DIST = {-4, 4};
        public static double[] AUTO_RIGHT_DIST = {1, 4};
        public static double AUTO_LEFT_DIST = 4;

        // Auto groups turn angles (in degrees)
        public static double AUTO_RIGHT_ANGLE = -90;


        /* Climber */
        // Velocities (% fraction of full speed)
        public static double CLIMBER_VELOCITY_U = 0.1;
        public static double CLIMBER_VELOCITY_D = -0.1;


        /* Controls/OI */
        // Enum for controls configurations and associated variable
        public static enum ControlsConfig {
                JOYSTICKS, XBOX, DUALDRIVERS
        };

        public static ControlsConfig controls = ControlsConfig.XBOX;

        // Joystick axis deadzone
        public static double DEADZONE = 0.1;


        /* Drive Train */
        // Distance traveled per rotation of the wheel
        public static int DIST_PER_ROTATION = 0;

        // Pulses Per Revolution of the MagEncoders on the drive train
        public static double ENCODER_PPR = 0; // TODO: check if val = 4096
        

        /* Indexer */
        // Velocities (% fraction of full speed)
        public static double INDEX_VELOCITY_F = 0.1;
        public static double INDEX_VELOCITY_R = -0.1;

        // Power Cell Capacity of the Indexer
        public static int PC_CAPACITY = 4;

        // Voltage Threshold for the Ultrasonic Sensors (AnalogInputs)
        // TODO: Update this with tested value
        public static double PC_DETECTION_VOLTAGE = 0;


        /* Intake */
        // Velocities (% fraction of full speed)
        public static double IN_VELOCITY_F = 0.1;
        public static double IN_VELOCITY_R = -0.1;


        /* Shooter */
        // Target Speed (% fraction of full speed)
        public static double SHOOTER_SPEED = 1;
        public static double SHOOTER_P = 0;
        public static double MAX_DIST = 12.453;


        /* Turret */
        // Turret Rotating Speed
        public static double TURRET_SPEED = 1;

        public static double TURRET_PZONE = 20;
        public static double VIS_DEADZONE = 0.25;

        // Variables Representing Ideal Inputs for MacroRotateTurret
        public static int TUR_LEFT = -1;
        public static int TUR_RIGHT = 1;        


        /* Vision */
        // Ultrasonic (AnalogOutput) Channel #s
        public static int p_US1 = 0;
        public static int p_US2 = 0;

        // TODO: What is this for, and can we get rid of it?
        // public static double B_ROTATION_SPD = 1;
}
