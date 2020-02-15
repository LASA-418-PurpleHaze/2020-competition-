/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
  public static HazyColorSensor colorSensor;
  public static HazyColorArm colorArm;
  public static ColorCommand colorCommand;
  public static FoldCommand foldCommand;
  public static SpinWheelCommand goToWeelCommand;
  public static GoToColorCommand goToColorCommand;

  //Variables for the Intake
  public static HazyIntake hazyIntake;
  
  //Variables for the End Arm
  public static HazyEndArm hazyEndArm;
  public static EndArmCommand endArmCommand;

  @Override
  public void robotInit() {
    //Initialization Code for the Mechanum Drive
    hazyMecBase = new HazyMechBase();
    mecanumCommand = new MecanumCommand();

    Scheduler.getInstance().add(mecanumCommand);

    //Initialization Code for the Color Sensor and Arm
    hazyColorSensor = new new HazyColorSensor();
    hazyColorArm = new HazyColorArm();
    colorCommand = new ColorCommand();
    foldCommand = new FoldCommand();
    spinWheelCommand = new SpinWheelCommand();
    goToColorCommand = new GoToColorCommand();

    //Initialization Code for the Intake
    hazyIntake = new HazyIntake();

    //Initialization Code for End Arm
    hazyEndArm = new HazyEndArm();
    endArmCommand = new endArmCommand();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    new DropIntakeCommand().execute();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance.run();
    OI hazyOI = new OI();
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
