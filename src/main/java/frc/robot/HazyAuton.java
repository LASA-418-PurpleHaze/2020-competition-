//Imports fot the Subsystem and its functions
package frc.robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class HazyAuton extends Subsystem {

  private TalonSRX rightFrontTalon;
  private TalonSRX leftFrontTalon;
  private TalonSRX leftBackTalon;
  private TalonSRX rightBackTalon;
  private PigeonIMU _pigeon;
  private double[] ypr;
  private static HazyAuton instance;


    public HazyAuton() {
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
      ypr = new double[3];
      _pigeon = new PigeonIMU(0);
      //PigeonIMU _pigeon = new PigeonIMU(0);
    }
    public void initialize() {
      StartGame();
    }
    public double UpdateYPR() {
      _pigeon.getYawPitchRoll(ypr);
      return ypr[2];
    }
    public void MoveSeven() {
      leftBackTalon.set(ControlMode.Position, -8957.83);
      rightBackTalon.set(ControlMode.Position, -8957.83);
    }
    public void turn(Double deg) {
      
      while ( UpdateYPR() != deg ) {
        leftBackTalon.set(ControlMode.Position, -8957.83);
        rightFrontTalon.set(ControlMode.Position, 8957.83);
      }
    }
    public void ShootThat() {
      long t= System.currentTimeMillis();
      long end = t+10000;
      while(System.currentTimeMillis() < end) {
        Robot.commandShooterSpit.execute();
      }
    }
    public void StartGame() {
      //starting positions are from left to right on the perspective of the driver
      int position = 0;
      //position 1
      if (position == 0) {
        MoveSeven();
        turn(180.0);
        ShootThat();
      turn(180.0);
      MoveSeven();
      }
      if (position == 1) {
        MoveSeven();
        turn(225.0);
        ShootThat();
        turn(45.0);
        MoveSeven();
        


      }
      if (position == 2) {
        MoveSeven();

      }
    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(Robot.CommandAuton);
    }
    public static HazyAuton getInstance(){
      if (instance==null)
          instance = new HazyAuton();
      return instance;
  }
}