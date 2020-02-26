//Imports fot the Subsystem and its functions
package frc.robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class HazyAuton extends Subsystem {

  private TalonSRX rightFrontTalon;
  private TalonSRX leftFrontTalon;
  private TalonSRX leftBackTalon;
  private TalonSRX rightBackTalon;
  private PigeonIMU pigeon;
  private double[] ypr;
  private static HazyAuton instance;

    public HazyAuton() {
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
      ypr = new double[3];
      pigeon = new PigeonIMU(0);
      //PigeonIMU _pigeon = new PigeonIMU(0);
    }

    public void initialize() {
      startGame();
    }

    public double UpdateYPR() {
      pigeon.getYawPitchRoll(ypr);
      return ypr[2];
    }

    public void move(double feet) {
      leftBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
    }

    public void turn(double deg) {
      while (UpdateYPR() != deg ) {
        leftBackTalon.set(ControlMode.Position, 7*RobotMap.TICKSPERFEET);
        rightFrontTalon.set(ControlMode.Position, -7*RobotMap.TICKSPERFEET);
      }
    }

    public void shootThat() {
      long t = System.currentTimeMillis();
      long end = t+10000;
      while(System.currentTimeMillis() < end) {
        Robot.commandShooterSpit.execute();
      }
    }

    public void startGame() {
      //starting positions are from left to right on the perspective of the driver
      int position = 0;
      //position 1
      if (position == 0) {
        move(7.0);
        turn(180.0);
        shootThat();
        turn(180.0);
        move(7.0);
      }
      if (position == 1) {
        move(7.0);
        turn(225.0);
        shootThat();
        turn(45.0);
        move(7.0);
      }
      if (position == 2) {
        move(7.0);
      }
    }
    
    @Override
    public void initDefaultCommand()
    {
//        setDefaultCommand(Robot.commandAuton);
    }

  //   public static HazyAuton getInstance(){
  //     if (instance==null)
  //         instance = new HazyAuton();
  //     return instance;
  // }
}