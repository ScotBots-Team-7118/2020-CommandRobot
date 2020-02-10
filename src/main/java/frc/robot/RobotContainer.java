/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
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
  /**
   * Top level commands
   */
  public final AutoGroup cg_AutoGroup = new AutoGroup();
  public final TeleopGroup cg_TeleopGroup = new TeleopGroup();

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

  private OI oi;
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer()
  {
    oi=Robot.oi;
    // Configure the button bindings
    addButtons();

    // //set defaults
    // s_DriveTrain.setDefaultCommand(cg_TeleopGroup);
  }

  public void addButtons()
  {
    switch(Constants.controls)
    { 
      //oi.addButton(name, joy, num);
      //Xbox controller, assigning numbers on drive station to buttons on the controller
      case XBOX:
        oi.addButton("btnxA", "Xbox", 1);
        oi.addButton("btnxB", "Xbox", 2);
        oi.addButton("btnxX", "Xbox", 3);
        oi.addButton("btnxY", "Xbox", 4);
        oi.addButton("btnxLB","Xbox", 5);
        oi.addButton("btnxRB","Xbox", 6);
        oi.addButton("btnxback","Xbox", 7);
        
        //Referencing the added buttons for when pressed
        oi.getButton("btnxA").whileHeld(/* Run the shooter */ new MacroRunShooter());
        oi.getButton("btnxX").toggleWhenPressed(/* Intake In */new MacroIntakeF());
        oi.getButton("btnxB").toggleWhenPressed(/* Intake Out */ new MacroIntakeR());
        oi.getButton("btnxY").whenPressed(/* Indexer F */new MacroIndexerF());
        oi.getButton("btnxback").whenPressed(/* Indexer R */new MacroIndexerR());
        oi.getButton("btnxRB").whileHeld(/* Climbing up*/new MacroClimbUp());
        oi.getButton("btnxLB").whileHeld(/* Climbing down */new MacroClimbDown());
      break;

      //Left and right joystick controllers, assigning numbers on drive station to buttons on the controller

      case JOYSTICKS:
        //right joystick
        oi.addButton("btn1","JoyR", 1);
        oi.addButton("btn3","JoyR", 3);
        oi.addButton("btn2","JoyR", 2);
        oi.addButton("btn4","JoyR", 4);
        oi.addButton("btn5","JoyR", 5);
        //left joystick
        oi.addButton("btn3","JoyL", 3);
        oi.addButton("btn2","JoyL", 2);

        //Referencing the added buttons when pressed

        oi.getButton("btn1").whileHeld(/* Run the shooter */ new MacroRunShooter());
        oi.getButton("btn3").toggleWhenPressed(/* Intake In */new MacroIntakeF());
        oi.getButton("btn2").toggleWhenPressed(/* Intake Out */ new MacroIntakeR());
        oi.getButton("btn3").whenPressed(/* Indexer F */new MacroIndexerF());
        oi.getButton("btn2").whenPressed(/* Indexer R */new MacroIndexerR());
        oi.getButton("btn4").whileHeld(/* Climbing down !!! need an up/down climb!!*/new MacroClimbDown());
        oi.getButton("btn5").whileHeld(/* Climbing up -!!! need an up/down climb!! */new MacroClimbUp());
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
