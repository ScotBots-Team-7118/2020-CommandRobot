/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.startgame.AutoGroup;
import frc.robot.commands.startgame.TeleopGroup;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
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

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Pass back teleop group
   * 
   * @return the command to run in teleop
   */
  public Command getTeleopCommand(){
    return cg_TeleopGroup;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return cg_AutoGroup;
  }
}
