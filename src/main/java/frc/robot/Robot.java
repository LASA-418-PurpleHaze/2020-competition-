/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Imports for the Robot
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.Timer;


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
  public static CommandFoldUp commandFoldUp;
  public static CommandFoldDown commandFoldDown;
  public static CommandSpinWheel commandSpinWheel;
  public static CommandGoToColor commandGoToColor;
  public static CommandColorArmDefault commandColorArmDefault;
  public static CommandToggleColorArm commandToggleColorArm;

  //Variables for the Intake
  public static HazyIntake hazyIntake;
  public static CommandMoveIntakeDefault commandMoveIntakeDefault;
  public static CommandSpitIntake commandSpitIntake;
  public static CommandSwallowIntake commandSwallowIntake;
  public static CommandIntakeDefault commandIntakeDefault;
  public static CommandSwitchIntakeDir commandSwitchIntakeDir;
  public static CommandStopSpinning commandStopSpinning;
  //public static CommandSpinIntakeDefault commandSpinIntakeDefault;

   //Variables for Low Ball Feeder
   public static HazyLowFeeder hazyLowFeeder;
   public static CommandSwallowLowFeed commandSwallowLowFeed;
   public static CommandSpitLowFeed commandSpitLowFeed;
   public static CommandLowFeedDefault commandLowFeedDefault;

  //Variables for High Ball Feeder
  public static HazyHighFeeder hazyHighFeeder;
  public static CommandSwallowHighFeed commandSwallowHighFeed;

  public static CommandSpitHighFeed commandSpitHighFeed;
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

 //IMU initialization
  

  //Serial Port 
  public static SerialPort hazyPort;
  // public static CommandGetData commandGetData;
  public static Solenoid solenoidToLight; 


  //auton
  public static CommandAuton commandAuton;
  public static HazyAuton hazyAuton;
  public static CommandFollowVision commandFollowVision;
  public static CommandAutonMove commandAutonMove;
  // public static CommandAutonTurn commandAutonTurn;
  public static CommandToggleTurn commandToggleTurn;
  // public static CommandGroupAuton commandGroupAuton;
  public static Timer hazyTime;
  int count;
  OI hazyOI; //OI object for all the buttons and their resulting commands

  @Override
  public void robotInit() {
    //Initialization Code for the Mechanum Drive
    hazyMecBase = new HazyMecBase();
    commandMecanum = new CommandMecanum();
    //Scheduler.getInstance().add(commandMecanum);

    //Initialization Code for the Color Sensor and Arm
    hazyColorSensor = new HazyColorSensor();
    hazyColorArm = new HazyColorArm();
    commandColor = new CommandColor();
    commandFoldUp = new CommandFoldUp();
    commandFoldDown = new CommandFoldDown();
    commandSpinWheel = new CommandSpinWheel();
    commandGoToColor = new CommandGoToColor();
    commandColorArmDefault = new CommandColorArmDefault();
    commandToggleColorArm = new CommandToggleColorArm();
    //Scheduler.getInstance().add(commandGoToColor);

    //Initialization Code for the Intake
    hazyIntake = new HazyIntake();
    commandMoveIntakeDefault = new CommandMoveIntakeDefault();
    commandSpitIntake = new CommandSpitIntake();
    commandSwallowIntake = new CommandSwallowIntake();
    commandIntakeDefault = new CommandIntakeDefault();
    commandSwitchIntakeDir = new CommandSwitchIntakeDir();
    commandStopSpinning = new CommandStopSpinning();
    //Scheduler.getInstance().add(commandMoveIntakeDefault);

    //Initialization Code for End Arm
    hazyEndArm = new HazyEndArm();
    commandEndArmUp = new CommandEndArmUp();
    commandEndArmDown = new CommandEndArmDown();
    commandEndArmDefault = new CommandEndArmDefault();
    //Scheduler.getInstance().add(commandEndArmDefault);

    //Initialization Code for Low Ball Feeder
    hazyLowFeeder = new HazyLowFeeder();
    commandSwallowLowFeed = new CommandSwallowLowFeed();
    commandSpitLowFeed = new CommandSpitLowFeed();
    commandLowFeedDefault = new CommandLowFeedDefault();
    //Scheduler.getInstance().add(commandLowFeedDefault);

    //Initialization Code for High Ball Feeder
    hazyHighFeeder = new HazyHighFeeder();
    commandSwallowHighFeed = new CommandSwallowHighFeed();
    commandSpitHighFeed = new CommandSpitHighFeed();
    commandHighFeedDefault = new CommandHighFeedDefault();
    //Scheduler.getInstance().add(commandHighFeedDefault);

    //Initialization Code for Shooter
    hazyShooter = new HazyShooter();
    commandShooterSpit = new CommandShooterSpit();
    commandShooterSwallow = new CommandShooterSwallow();
    commandShooterDefault =  new CommandShooterDefault();
 
    //Auton init
    hazyAuton = new HazyAuton();
    commandAuton = new CommandAuton();
    solenoidToLight = new Solenoid(0);
    hazyTime = new Timer();
    commandFollowVision = new CommandFollowVision();
    // commandAutonTurn = new CommandAutonTurn(180.0);
    commandAutonMove = new CommandAutonMove(7.0);
    commandToggleTurn = new CommandToggleTurn();
    //commandGroupAuton = new CommandGroupAuton();
    //Scheduler.getInstance().add(commandAutonTurn);
    

    //Initialization Code for Serial Port
    
    // commandGetData = new CommandGetData();
    //Scheduler.getInstance().add(commandGetData);


    hazyOI = new OI(); //OI object for all the buttons and their resulting commands
  }

  @Override
  public void autonomousInit() {
    hazyAuton.resetEncoders();

    // Scheduler.getInstance().removeAll();
    //System.out.println("AUTOOOOOOOOOOOOOOO");
    // Scheduler.getInstance().add(commandMoveIntakeDefault);
    // Scheduler.getInstance().add(commandAutonTurn);
    // Scheduler.getInstance().add(commandHighFeedDefault);

    commandAutonMove.execute();
      // new WaitCommand(0.5);
    System.out.println("AFTER MOVe");
    commandShooterSpit.execute();
    double milStart = java.lang.System.currentTimeMillis();
    while (java.lang.System.currentTimeMillis() < milStart + 2000) {}
    for(int i = 0; i < 3; i++){
      milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 1000) {
        commandSwallowHighFeed.execute();
      }
      milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 2000) {
        commandHighFeedDefault.execute();
      }
      new WaitCommand(50);
    }
    commandShooterDefault.execute();
     //When the robot is originally run then the first thing that the robot will do is drop fown the Intake for the Robot
    count = 0;
  }

  @Override
  public void autonomousPeriodic() {
    //System.out.println("AUTOOOOOLOOOOOPPPP");
    //System.out.println(count);
    // Scheduler.getInstance().run();
    // if(count < 1){
      
    //   //Robot.commandGroupAuton.start();
    //   count += 1;
    // }
  }

  @Override
  public void teleopInit() {
    Scheduler.getInstance().removeAll();
    Scheduler.getInstance().add(commandMecanum);
    Scheduler.getInstance().add(commandGoToColor);
    Scheduler.getInstance().add(commandMoveIntakeDefault);
    Scheduler.getInstance().add(commandEndArmDefault);
    Scheduler.getInstance().add(commandLowFeedDefault);
    Scheduler.getInstance().add(commandHighFeedDefault);
    System.out.println("TELEOPPPPPPPPPPPPP");
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run(); //Scheduler for the Mechanum Drive
    hazyOI.runAllMethods();
    
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
