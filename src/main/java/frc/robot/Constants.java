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
public final class Constants {

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
        public static int p_TAL_RM = 8;
        public static int p_TAL_RF = 5;
        public static int p_TAL_LM = 7;
        public static int p_TAL_LF = 4;

        /* Indexer */
        // Talon Port Number
        public static int p_TAL_ID_1 = 2;
        public static int p_TAL_ID_2 = 3;

        /* Intake */
        // Talon Port Number3
        public static int p_TAL_IN = 1;

        /* Shooter */
        // Talon Port Number
        public static int p_TAL_SH = 9;

        /* Turret */
        // Talon Port Number
        public static int p_TAL_TUR = 0;
        public static int p_SWITCH_LEFT = 0;
        public static int p_SWITCH_RIGHT = 1;

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
        public static double AUTO_CENTER_DIST = -4;
        public static double[] AUTO_RIGHT_DIST = { 1, -4 };
        public static double AUTO_LEFT_DIST = -4;

        // Auto groups turn angles (in degrees)
        public static double AUTO_RIGHT_ANGLE = 90;

        // Auto groups rotate turret angle (in degrees)
        public static int AUTO_RIGHT_TURRET_ANGLE = -20;
        public static int AUTO_LEFT_TURRET_ANGLE = 35;

        /* Climber */
        // Velocities (% fraction of full speed)
        public static double CLIMBER_VELOCITY_U = 0.1;
        public static double CLIMBER_VELOCITY_D = -0.1;

        /* Controls/OI */
        // Enum for controls configurations and associated variable
        public static enum ControlsConfig {
                JOYSTICKS, XBOX, DUALDRIVERS
        };

        public static ControlsConfig controls = ControlsConfig.DUALDRIVERS;

        // Joystick axis deadzone
        public static double DEADZONE = 0.1;

        /* Drive Train */
        // Distance traveled per rotation of the wheel
        public static double DIST_PER_ROTATION = 1.577341667;

        public static double RAMP_TIME = 0.4;

        // max set speeed for tals
        public static double SUPER_CAP = 0.95;

        // Pulses Per Revolution of the MagEncoders on the drive train
        public static double ENCODER_PPR = 4096; // TODO: check if val = 4096

        /* Indexer */
        // Velocities (% fraction of full speed)
        public static double INDEX_VELOCITY_F = 1;
        public static double INDEX_VELOCITY_R = -1;
        public static double SHOOT_TIME = 0.5;
        public static double WAIT_TIME = 1.5;
        public static double SHOOT_SPEED = 1;

        // Power Cell Capacity of the Indexer
        public static int PC_CAPACITY = 4;

        // Voltage Threshold for the Ultrasonic Sensors (AnalogInputs)
        // TODO: Update this with tested value
        public static double PC_DETECTION_VOLTAGE = 0;

        /* Intake */
        // Velocities (% fraction of full speed)
        public static double IN_VELOCITY_F = 1;
        public static double IN_VELOCITY_R = -1;

        /* Shooter */
        // Target Speed (% fraction of full speed)
        public static double SHOOTER_SPEED = 1;
        public static double SHOOTER_P = 1;
        public static double MAX_DIST = 12.453;
        public static int ENCODER_REVP = 2000;

        /* Teleop */
        // C = 0
        public static double JOYDRIVE_A = 0.68;
        public static double JOYDRIVE_B = 0.32;
        public static double TRIPPED = 0;

        /* Turret */
        // Turret Rotating Speed
        public static double TURRET_SPEED = 1;
        public static double TURRET_P = 0.2;
        public static double TURRET_PZONE = 20;
        public static double VIS_DEADZONE = 0.25;

        // Variables Representing Ideal Inputs for MacroRotateTurret
        public static int TUR_LEFT = -1;
        public static int TUR_RIGHT = 1;
        
        //Variable Representing the Meaning of Life
        public final int meaningOfLife = 42;
}
