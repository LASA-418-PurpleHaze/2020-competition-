/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Imports for the Robot
package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

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
  //Variables for the Mecanum Drive
  public static HazyMecBase hazyMecBase; 
  public static CommandMecanum commandMecanum;

  //Variables for the Color Sensor and Arm
  public static HazyColorSensor hazyColorSensor;
  public static HazyColorArm hazyColorArm;
  public static CommandColor commandColor;
  public static CommandFold commandFold;
  public static CommandSpinWheel commandSpinWheel;
  public static CommandGoToColor commandGoToColor;
  public static CommandColorArmDefault commandColorArmDefault;

  //Variables for the Intake
  public static HazyIntake hazyIntake;
  public static CommandDropIntake commandDropIntake;
  public static CommandSpitIntake commandSpitIntake;
  public static CommandSwallowIntake commandSwallowIntake;
  public static CommandIntakeDefault commandIntakeDefault;
  //public static CommandSpinIntakeDefault commandSpinIntakeDefault;

   //Variables for Low Ball Feeder
   public static HazyLowFeeder hazyLowFeeder;
   public static CommandMoveLowFeed commandmoveLowFeed;
   public static CommandLowFeedDefault commandLowFeedDefault;

  //Variables for High Ball Feeder
  public static HazyHighFeeder hazyHighFeeder;
  public static CommandMoveHighFeed commandMoveHighFeed;
  public static CommandHighFeedDefault commandHighFeedDefault;
 
  //Variables for the End Arm
  public static HazyEndArm hazyEndArm;
  public static CommandEndArmUp commandEndArmUp;
  public static CommandEndArmDown commandEndArmDown;
  public static CommandEndArmDefault commandEndArmDefault;

  //Variables for the Shooter
  public static HazyShooter hazyShooter;
  public static CommandShooterSpit commandShooterSpit;
  public static CommandShooterSwallow commandShooterSwallow;
  public static CommandShooterDefault commandShooterDefault;

  //Serial Port 
  public static SerialPort hazyPort;

  @Override
  public void robotInit() {
    //Initialization Code for the Mechanum Drive
    hazyMecBase = new HazyMecBase();
    commandMecanum = new CommandMecanum();
    Scheduler.getInstance().add(commandMecanum);

    //Initialization Code for the Color Sensor and Arm
    hazyColorSensor = new HazyColorSensor();
    hazyColorArm = new HazyColorArm();
    commandColor = new CommandColor();
    commandFold = new CommandFold();
    commandSpinWheel = new CommandSpinWheel();
    commandGoToColor = new CommandGoToColor();
    commandColorArmDefault = new CommandColorArmDefault();

    //Initialization Code for the Intake
    hazyIntake = new HazyIntake();
    commandDropIntake = new CommandDropIntake();
    commandSpitIntake = new CommandSpitIntake();
    commandSwallowIntake = new CommandSwallowIntake();
    commandIntakeDefault = new CommandIntakeDefault();
    //commandSpinIntakeDefault = new CommandSpinIntakeDefault();

    //Initialization Code for End Arm
    hazyEndArm = new HazyEndArm();
    commandEndArmUp = new CommandEndArmUp();
    commandEndArmDown = new CommandEndArmDown();
    commandEndArmDefault = new CommandEndArmDefault();

    //Initialization Code for Low Ball Feeder
    hazyLowFeeder = new HazyLowFeeder();
    commandmoveLowFeed = new CommandMoveLowFeed();
    commandLowFeedDefault = new CommandLowFeedDefault();

    //Initialization Code for High Ball Feeder
    hazyHighFeeder = new HazyHighFeeder();
    commandMoveHighFeed = new CommandMoveHighFeed();
    commandHighFeedDefault = new CommandHighFeedDefault();

    //Initialization Code for Shooter
    hazyShooter = new HazyShooter();
    commandShooterSpit = new CommandShooterSpit();
    commandShooterSwallow = new CommandShooterSwallow();
    commandShooterDefault =  new CommandShooterDefault();

    //Initialization Code for Serial Port
    //hazyPort = new SerialPort(RobotMap.SERIALPORTNUMBER,Port.kMXP);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    Robot.commandDropIntake.execute(); //When the robot is originally run then the first thing that the robot will do is drop fown the Intake for the Robot
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
