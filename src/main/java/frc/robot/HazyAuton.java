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

    public HazyAuton() {
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
      //PigeonIMU _pigeon = new PigeonIMU(0);
    }
    public void initialize (){
      
    }
    public void MoveSeven() {
      leftBackTalon.set(ControlMode.Position, -8957.83);
      rightBackTalon.set(ControlMode.Position, -8957.83);
    }
    public void turn(Double deg, Double[] ypr_deg) {
      while ( ypr_deg[2] != deg ) {
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
    public void StartGame(Double[] ypr_deg) {
      //starting positions are from left to right on the perspective of the driver
      int position = 0;
      //position 1
      if (position == 0) {
        MoveSeven();
        turn(180.0, ypr_deg);
        ShootThat();
      turn(180.0, ypr_deg);
      MoveSeven();
      }
      if (position == 1) {
        MoveSeven();
        turn(225.0, ypr_deg);
        ShootThat();
        turn(45.0, ypr_deg);
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
}
/* 
    public void Auto() {
      //starting positions are from left to right on the perspective of the driver
      int position = 0;
      if (position == 0) {
        leftBackEncoder.set(ControlMode.Position, -8957.83);
        while ( pigeon.getYawPitchRoll(ypr_deg) != 180) {
          leftBackEncoder.set(ControlMode.Position, -8957.83);
          rightFrontEncoder.set(ControlMode.Position, -8957.83);
        }
       //turn around
       long t= System.currentTimeMillis();
      long end = t+10000;
      while(System.currentTimeMillis() < end) {
        Robot.commandShooterSpit.execute();
      }
      leftBackEncoder.set(ControlMode.Position, -3839.07);


      }
      if (position == 1) {


        leftBackEncoder.set(ControlMode.Position, -8957.83);
        while ( pigeon.getYawPitchRoll(ypr_deg) != 45) {
          leftBackEncoder.set(ControlMode.Position, -8957.83);
          rightFrontEncoder.set(ControlMode.Position, -8957.83);
        }
        leftBackEncoder.set(ControlMode.Position, -8957.83);
        while ( pigeon.getYawPitchRoll(ypr_deg) != -45) {
          leftBackEncoder.set(ControlMode.Position, -8957.83);
          rightFrontEncoder.set(ControlMode.Position, -8957.83);
        }
        long t= System.currentTimeMillis();
        long end = t+10000;
        while(System.currentTimeMillis() < end) {
          Robot.commandShooterSpit.execute();
        }


      }
      if (position == 2) {
        leftBackEncoder.set(ControlMode.Position, -3839.07);

      }

    }

*/