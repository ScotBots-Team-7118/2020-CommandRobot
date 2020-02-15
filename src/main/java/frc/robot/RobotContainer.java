/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/* Imports */
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.*;
import frc.robot.commands.macros.*;
import frc.robot.commands.startgame.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  /* Class Variable Declaration */

  /**
   * Top level commands
   */
  public final AutoGroup cg_AutoGroup = new AutoGroup();
  public final TeleopGroup cg_TeleopGroup = new TeleopGroup();


  private OI oi;

  /**
   * Subsystems
   */
  public static Climber s_Climber = new Climber();
  public static DriveTrain s_DriveTrain = new DriveTrain();
  public static Indexer s_Indexer = new Indexer();
  public static Intake s_Intake = new Intake();
  public static Shooter s_Shooter = new Shooter();
  public static Vision s_Vision = new Vision();
  public static Turret s_Turret = new Turret();

  

  /**
   * Constructs the RobotContainer.
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer()
  {
    /* Class Variable Instantiation */
    oi = Robot.oi;

    // Configure the button bindings
    configureButtonBindings();

    // TODO: Nathaniel, is this necessary or not?
    // //set defaults
    // s_DriveTrain.setDefaultCommand(cg_TeleopGroup);
  }

  /**
   * Configure the command-button bindings according to the controls configuration stated in Constants.
   */
  public void configureButtonBindings()
  {
    // Configure button bindings as dictated by the controls configuration from Constants
    switch(Constants.controls)
    { 
      // Xbox controller, assigning numbers on drive station to buttons on the controller
      case XBOX:
        // TODO: This section is currently commented out for testing purposes

        // oi.addButton("btnxA", "Xbox", 1);
        // oi.addButton("btnxB", "Xbox", 2);
        // oi.addButton("btnxX", "Xbox", 3);
        // oi.addButton("btnxY", "Xbox", 4);
        // oi.addButton("btnxLB","Xbox", 5);
        // oi.addButton("btnxRB","Xbox", 6);
        // oi.addButton("btnxback","Xbox", 7);
        
        // Referencing the added buttons for when pressed
        // oi.getButton("btnxA").whileHeld(/* Run the shooter */ new MacroRunShooter());
        // oi.getButton("btnxX").toggleWhenPressed(/* Intake In */new MacroIntakeF());
        // oi.getButton("btnxB").toggleWhenPressed(/* Intake Out */ new MacroIntakeR());
        // oi.getButton("btnxY").whenPressed(/* Indexer F */new MacroIndexerF());
        // oi.getButton("btnxback").whenPressed(/* Indexer R */new MacroIndexerR());
        // oi.getButton("btnxRB").whileHeld(/* Climbing up*/new MacroClimbDown());
        // oi.getButton("btnxLB").whileHeld(/* Climbing down */new MacroClimbUp());
      break;

      // Left and right joystick controllers, assigning numbers on drive station to buttons on the controller
      case JOYSTICKS:
        // Right joystick
        oi.addButton("btn1","JoyR", 1);
        oi.addButton("btn3","JoyR", 3);
        oi.addButton("btn2","JoyR", 2);
        oi.addButton("btn4","JoyR", 4);
        oi.addButton("btn5","JoyR", 5);
        // Left joystick
        oi.addButton("btn3","JoyL", 3);
        oi.addButton("btn2","JoyL", 2);

        // Referencing the added buttons when pressed
        oi.getButton("btn1").whileHeld(/* Run the shooter */ new MacroRunShooter());
        oi.getButton("btn3").toggleWhenPressed(/* Intake In */new MacroIntakeF());
        oi.getButton("btn2").toggleWhenPressed(/* Intake Out */ new MacroIntakeR());
        oi.getButton("btn3").whenPressed(/* Indexer F */new MacroIndexerF());
        oi.getButton("btn2").whenPressed(/* Indexer R */new MacroIndexerR());
        oi.getButton("btn4").whileHeld(/* Climbing down !!! need an up/down climb!!*/new MacroClimbDown());
        oi.getButton("btn5").whileHeld(/* Climbing up -!!! need an up/down climb!! */new MacroClimbUp());
      break;

      case DUALDRIVERS:
        // TODO: Review these button bindings as a programming subteam, add additional button bindings for DUALDRIVERS

        // //adding turret buttons
        // oi.addButton("Left", "TurC", 5);
        // oi.addButton("Right", "TurC", 6);

        // oi.getButton("Left").whileHeld(new MacroRotateTurret(Constants.LEFT));
        // oi.getButton("Right").whileHeld(new MacroRotateTurret(Constants.RIGHT));

        /* Intake buttons */
        oi.addButton("R1", "JoyR", 1);
        oi.addButton("L1", "JoyL", 1);
        oi.addButton("LB", "Xbox", 5);
        oi.addButton("RB", "Xbox", 6);

        // Referencing the added buttons when pressed
        oi.getButton("R1").toggleWhenPressed(/* Intake In */ new MacroIntakeF());
        oi.getButton("L1").toggleWhenPressed(/* Intake Out */ new MacroIntakeR());
        oi.getButton("LB").whileHeld(new MacroRotateTurret(1));
        oi.getButton("RB").whileHeld(new MacroRotateTurret(-1));

        break;


      default:
        System.out.println("Controls configuration not selected");
      break;
    }
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  /**
   * Pass back teleop group
   * 
   * @return the command to run in teleop
   */
  public Command getTeleopCommand()
  {
    return cg_TeleopGroup;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    return cg_AutoGroup;
  }
}
