//Imports fot the Subsystem and its functions
package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Timer;


public class HazyAuton extends Subsystem {

  private TalonSRX rightFrontTalon;
  private TalonSRX leftFrontTalon;
  private TalonSRX leftBackTalon;
  private TalonSRX rightBackTalon;
  private PigeonIMU pigeon;
  private double[] ypr;
  boolean shouldTurn;

    public HazyAuton() {
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);

      rightFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      rightFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);
      rightFrontTalon.config_kI(0, RobotMap.DRIVEI, 30);
      rightFrontTalon.config_kD(0, RobotMap.DRIVED, 30);

      rightBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      rightBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      rightBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      rightBackTalon.config_kD(0, RobotMap.DRIVED, 30);

      leftFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      leftFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);
      leftFrontTalon.config_kI(0, RobotMap.DRIVEI, 30);
      leftFrontTalon.config_kD(0, RobotMap.DRIVED, 30);

      leftBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      leftBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      leftBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      leftBackTalon.config_kD(0, RobotMap.DRIVED, 30);
      // ypr = new double[3];
      // pigeon = new PigeonIMU(0);
      shouldTurn = false;

      //PigeonIMU _pigeon = new PigeonIMU(0);
    }

    public void move(double feet) {
      //System.out.println("MOVE FUNCTION IN SUBSYSTEN");
      rightFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);

      rightBackTalon.config_kP(0, RobotMap.DRIVEP, 30);


      leftFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);


      leftBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      leftFrontTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      leftBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet*RobotMap.TICKSPERFEET);
      rightFrontTalon.set(ControlMode.Position, feet*RobotMap.TICKSPERFEET);
    }

    public void moveTrench(double feet) {
      //System.out.println("MOVE FUNCTION IN SUBSYSTEN");
      rightFrontTalon.config_kP(0, RobotMap.TRENCHP, 30);

      rightBackTalon.config_kP(0, RobotMap.TRENCHP, 30);


      leftFrontTalon.config_kP(0, RobotMap.TRENCHP, 30);


      leftBackTalon.config_kP(0, RobotMap.TRENCHP, 30);

      leftFrontTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      leftBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet*RobotMap.TICKSPERFEET);
      rightFrontTalon.set(ControlMode.Position, feet*RobotMap.TICKSPERFEET);
    }

    public void resetEncoders(){
      leftFrontTalon.setSelectedSensorPosition(0);
      leftBackTalon.setSelectedSensorPosition(0);
      rightFrontTalon.setSelectedSensorPosition(0);
      rightBackTalon.setSelectedSensorPosition(0);

    }

    public void strafeLeft(double feet){
      rightFrontTalon.config_kP(0, RobotMap.STRAFEP, 30);

      rightBackTalon.config_kP(0, RobotMap.STRAFEP, 30);


      leftFrontTalon.config_kP(0, RobotMap.STRAFEP, 30);


      leftBackTalon.config_kP(0, RobotMap.STRAFEP, 30);


      rightFrontTalon.set(ControlMode.Position, feet * -RobotMap.SIDETICKSPERFEET);
      leftFrontTalon.set(ControlMode.Position, feet * -RobotMap.SIDETICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet * RobotMap.SIDETICKSPERFEET);
      leftBackTalon.set(ControlMode.Position, feet * RobotMap.SIDETICKSPERFEET);
    }

    public void strafeRight(double feet){
      rightFrontTalon.config_kP(0, RobotMap.STRAFEP, 30);
 

      rightBackTalon.config_kP(0, RobotMap.STRAFEP, 30);

      leftFrontTalon.config_kP(0, RobotMap.STRAFEP, 30);

      leftBackTalon.config_kP(0, RobotMap.STRAFEP, 30);
      rightFrontTalon.set(ControlMode.Position, feet * RobotMap.SIDETICKSPERFEET);
      leftFrontTalon.set(ControlMode.Position, feet * RobotMap.SIDETICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet * -RobotMap.SIDETICKSPERFEET);
      leftBackTalon.set(ControlMode.Position, feet * -RobotMap.SIDETICKSPERFEET);
    }

    public void autonZero(){
      double delay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay + RobotMap.STARTAUTONDELAY){}
      resetEncoders();
      move(RobotMap.INITIALFEET);
    }

    public void autonOne(){
      //Start lined up to the target
      double delay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay + RobotMap.STARTAUTONDELAY){}

      resetEncoders();
      move(RobotMap.INITIALFEET);
      Robot.commandShooterSpit.execute();
      Robot.commandToggleDelay.execute();
      // double delay1 = java.lang.System.currentTimeMillis();
      // while(java.lang.System.currentTimeMillis() < delay1 + 3000){}
      double milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 4000){
        //Robot.commandFollowVision.execute();
      }

      milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 1000){}

      int count = 0;
      boolean wasGreater = false;
      while(count < 3){
        //System.out.println("IN LOOP");
        if(Robot.hazyShooter.getShooterRPM() >= RobotMap.SHOOTRPM){
          //System.out.println("MOVING UP");
          Robot.hazyHighFeeder.swallow();
          wasGreater = true;
        }
        else if(Robot.hazyShooter.getShooterRPM() < RobotMap.SHOOTRPM){
          //System.out.println("SLOWED");
          Robot.hazyHighFeeder.stop();
          if(wasGreater){
            count += 1;
            wasGreater = false;
          }
        }
      }
      Robot.solenoidToLight.set(false);
      Robot.commandShooterDefault.execute();
    }

    public void autonTwo(){
      //start in the middle of the field (13.5 feet from either edge)
      double delay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay + RobotMap.STARTAUTONDELAY){}
      resetEncoders();
      move(RobotMap.INITIALFEET);
      strafeRight(5.4);

      double milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 4000){
        Robot.commandFollowVision.execute();
      }

      
      milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 1000){}

      int count = 0;
      boolean wasGreater = false;
      while(count < 3){
        //System.out.println("IN LOOP");
        if(Robot.hazyShooter.getShooterRPM() >= RobotMap.SHOOTRPM){
          //System.out.println("MOVING UP");
          Robot.hazyHighFeeder.swallow();
          wasGreater = true;
        }
        else if(Robot.hazyShooter.getShooterRPM() < RobotMap.SHOOTRPM){
          //System.out.println("SLOWED");
          Robot.hazyHighFeeder.stop();
          if(wasGreater){
            count += 1;
            wasGreater = false;
          }
        }
      }

      Robot.solenoidToLight.set(false);
      Robot.commandShooterDefault.execute();
    }

    public void autonThree(){
      //start in front of the trench run to pick up two more to shoot 5
      double delay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay + RobotMap.STARTAUTONDELAY){}

      Robot.hazyIntake.moveIntakeDownAuton();
      
      double intakeDelay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < intakeDelay + 750.0){} //Amount of time the intake motor will drop the intake

      Robot.hazyIntake.stopIntakeAuton();
      Robot.commandSwallowIntake.execute();

      intakeDelay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < intakeDelay + 1000.0){}//Amount of time to wait after intake is dropped to start moving

      resetEncoders();
      moveTrench(-13.6);

      double delay2 = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay2 + 5000.0){}//Amount of time to wait for robot to travel down the trench to pick up balls

      resetEncoders();
      turn180();
      Robot.commandStopSpinning.execute();
      Robot.commandToggleDelay.execute();
      Robot.commandShooterSpit.execute();

      double milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 4000){ //Amount of time for robot to use vision to lock on
        Robot.commandFollowVision.execute();
      }

      milStart = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < milStart + 1000){}//Amount of time to wait between locking on with vision and shooting

      int count = 0;
      boolean wasGreater = false;

      while(count < 3){
        //System.out.println("IN LOOP");
        if(Robot.hazyShooter.getShooterRPM() >= RobotMap.SHOOTRPM){
          //System.out.println("MOVING UP");
          Robot.hazyHighFeeder.swallow();
          wasGreater = true;
        }
        else if(Robot.hazyShooter.getShooterRPM() < RobotMap.SHOOTRPM){
          //System.out.println("SLOWED");
          Robot.hazyHighFeeder.stop();
          if(wasGreater){
            count += 1;
            wasGreater = false;
          }
        }
      }
    
      Robot.solenoidToLight.set(false);
      Robot.commandShooterDefault.execute();
    }
    
    
    // public void turnRight() {
    //   if(shouldTurn) {
    //     leftBackTalon.set(ControlMode.PercentOutput, 0.3);
    //     rightBackTalon.set(ControlMode.PercentOutput, -0.3);
    //     double milStart = java.lang.System.currentTimeMillis();
    //     while (java.lang.System.currentTimeMillis() < milStart + 4000){
    //       Robot.commandFollowVision.execute();
    // }
    //     shouldTurn = false;
    //   }
    //   if(!shouldTurn) {
    //     leftBackTalon.set(ControlMode.Position, 0);
    //     rightBackTalon.set(ControlMode.Position, 0);
    //   }
    // }

    public void turn180(){
      rightFrontTalon.config_kP(0, RobotMap.TURNP, 30);

      rightBackTalon.config_kP(0, RobotMap.TURNP, 30);


      leftFrontTalon.config_kP(0, RobotMap.TURNP, 30);


      leftBackTalon.config_kP(0, RobotMap.TURNP, 30);

      rightFrontTalon.set(ControlMode.Position, -RobotMap.TURN180TICKS);
      rightBackTalon.set(ControlMode.Position, -RobotMap.TURN180TICKS);
      leftFrontTalon.set(ControlMode.Position, -RobotMap.TURN180TICKS);
      leftBackTalon.set(ControlMode.Position, -RobotMap.TURN180TICKS);

    }

    public void goToTrench(){
      resetEncoders();
      turn180();
      double delay0 = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay0 + 3000){}
      resetEncoders();
      strafeLeft(5.57);
      Robot.commandSwallowIntake.execute();
      resetEncoders();
     // move(16.3);
      move(2.0);
      double delay = java.lang.System.currentTimeMillis();
      while (java.lang.System.currentTimeMillis() < delay + 3000){}
      Robot.hazyIntake.intakeStopSpin();
    }
    
    public void toggleTurn() {
      shouldTurn = true;

    }

    @Override
    public void initDefaultCommand()
    {
//        setDefaultCommand(Robot.commandAuton);
    }
}