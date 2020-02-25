/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/* Imports */
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
  /* Class Variable Declaration */
  private Command cg_AutoGroup;
  private Command cg_TeleopGroup;
  public static OI oi;
  public static RobotContainer rC;
  public Testing tst;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit()
  {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    oi = new OI();
    rC = new RobotContainer();
    tst = new Testing(false);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic()
  {
    tst.PrintMe();

    // TODO: Can we maybe not use robotPeriodic? This runs when the robot is disabled too, which could be unsafe.
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit()
  {
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit()
  {
      cg_AutoGroup = rC.getAutonomousCommand();
      cg_AutoGroup.schedule();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic()
  {

  }

  @Override
  public void teleopInit()
  {
    // TODO: Pretty sure this is unnecessary but we should double-check
    try
    {
      cg_AutoGroup.cancel();
    }
    catch (NullPointerException npe)
    {
      System.out.println("Cannot cancel AutoGroup commands: none are scheduled.");
    }

    cg_TeleopGroup = rC.getTeleopCommand();
    cg_TeleopGroup.schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic()
  {
    //System.out.println("joy = " + oi.getController("Xbox").getRawAxis(1));
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit()
  {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic()
  {

  }
}
