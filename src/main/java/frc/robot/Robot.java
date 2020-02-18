/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Imports for the Robot
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.OI;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  //Variables for the Mechanum Drive
  public static HazyMecBase hazyMecBase; 
  public static MecanumCommand mecanumCommand;

  //Variables for the Color Sensor and Arm
  public static HazyColorSensor hazyColorSensor;
  public static HazyColorArm hazyColorArm;
  public static ColorCommand colorCommand;
  public static FoldCommand foldCommand;
  public static SpinWheelCommand spinWheelCommand;
  public static GoToColorCommand goToColorCommand;

  //Variables for the Intake
  public static HazyIntake hazyIntake;
  public static DropIntakeCommand dropIntakeCommand;
  public static SpitIntakeCommand spitIntakeCommand;
  public static SwallowIntakeCommand swallowIntakeCommand;
  
  //Variables for the End Arm
  public static HazyEndArm hazyEndArm;
  public static EndArmUpCommand endArmUpCommand;
  public static EndArmDownCommand endArmDownCommand;

  //Variables for the Shooter
  public static HazyShooter hazyShooter;
  public static ShooterSpitCommand shooterSpitCommand;
  public static ShooterSwallowCommand shooterSwallowCommand;

  @Override
  public void robotInit() {
    //Initialization Code for the Mechanum Drive
    hazyMecBase = new HazyMecBase();
    mecanumCommand = new MecanumCommand();

    Scheduler.getInstance().add(mecanumCommand);

    //Initialization Code for the Color Sensor and Arm
    hazyColorSensor = new HazyColorSensor();
    hazyColorArm = new HazyColorArm();
    colorCommand = new ColorCommand();
    foldCommand = new FoldCommand();
    spinWheelCommand = new SpinWheelCommand();
    goToColorCommand = new GoToColorCommand();

    //Initialization Code for the Intake
    hazyIntake = new HazyIntake();
    dropIntakeCommand = new DropIntakeCommand();
    spitIntakeCommand = new SpitIntakeCommand();
    swallowIntakeCommand = new SwallowIntakeCommand();

    //Initialization Code for the End Arm
    hazyEndArm = new HazyEndArm();
    endArmUpCommand = new EndArmUpCommand();
    endArmDownCommand = new EndArmDownCommand();

    //Initialization Code for the Shooter
    hazyShooter = new HazyShooter();
    shooterSpitCommand = new ShooterSpitCommand();
    shooterSwallowCommand = new ShooterSwallowCommand();

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    new DropIntakeCommand().execute(); //When the robot is originally run then the first thing that the robot will do is drop fown the Intake for the Robot
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run(); //Scheduler for the Mechanum Drive
    OI hazyOI = new OI(); //OI object for all the buttons and their resulting commands
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
