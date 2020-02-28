//Imports fot the Subsystem and its functions
package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.WaitCommand;


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
      rightBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      rightBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      rightBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      rightBackTalon.config_kD(0, RobotMap.DRIVED, 30);

      leftBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      leftBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      leftBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      leftBackTalon.config_kD(0, RobotMap.DRIVED, 30);
      ypr = new double[3];
      pigeon = new PigeonIMU(0);
      shouldTurn = false;

      //PigeonIMU _pigeon = new PigeonIMU(0);
    }

    // public void initialize() {
    //   startGame();
    // }

    public double UpdateYPR() {
      pigeon.getYawPitchRoll(ypr);
      return ypr[2];
    }

 

    public void move(double feet) {
      System.out.println("MOVE FUNCTION IN SUBSYSTEN");
      leftBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
      rightBackTalon.set(ControlMode.Position, feet*-RobotMap.TICKSPERFEET);
    }

    public void turnRight() {
      shouldTurn = true;
      if(shouldTurn) {
        leftBackTalon.set(ControlMode.PercentOutput, 0.3);
        rightBackTalon.set(ControlMode.PercentOutput, -0.3);
        new WaitCommand(3);
        shouldTurn = false;
      }
      if(!shouldTurn) {
        leftBackTalon.set(ControlMode.Position, 0);
        rightBackTalon.set(ControlMode.Position, 0);
      }
    }

    public void toggleTurn() {
      shouldTurn = true;

    }

    // public void shootThat() {
    //   long t = System.currentTimeMillis();
    //   long end = t+10000;
    //   while(System.currentTimeMillis() < end) {
    //     Robot.commandShooterSpit.execute();
    //   }
    // }

    // public void startGame() {
    //   //starting positions are from left to right on the perspective of the driver
    //   int position = RobotMap.STARTINGPOSITION;
    //   //position 1
    //   if (position == 1) {
    //     move(7.0);
    //     turn(225.0);
    //     shootThat();
    //     turn(45.0);
    //     move(7.0);
    //   }
    //   if (position == 2) {
    //     move(7.0);
    //   }
    // }
    
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