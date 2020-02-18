package frc.robot;

import java.util.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.followers.DistanceFollower;
import jaci.pathfinder.modifiers.SwerveModifier;
import jaci.pathfinder.modifiers.TankModifier;
import jaci.pathfinder.*;
import com.ctre.phoenix.sensors.PigeonIMU;


//import edu.wpi.first.wpilibj.drive.RobotDriveBase;

import edu.wpi.first.wpiutil.math.MathUtil;
public class HazyMecBase extends Subsystem
{
    
    private Talon rightFrontTalon;
    private Talon leftFrontTalon;
    private Talon rightBackTalon;
    private Talon leftBackTalon;
    private Encoder rightFrontEncoder;
private Encoder leftFrontEncoder;
private Encoder rightBackEncoder;
private Encoder leftBackEncoder;
    private MecanumDrive mecDrive;
    public static HazyMecBase instance;

    public HazyMecBase(){
        
    }
    public void pathfinding() {
      //trajectory poins for now, since encoder thing isnt working
      Waypoint[] points = new Waypoint[] {
        new Waypoint(-4, -1,Pathfinder.r2d(-45)),      
        new Waypoint(-2, -2, 0),                        
        new Waypoint(0, 0, 0)                           
    };
    int encoder_position_left = 0;
    int encoder_position_right = 0;
    double wheel_diameter = 0.0;
    double angleDiff = 0.0;
    

    jaci.pathfinder.Trajectory.Config config = new jaci.pathfinder.Trajectory.Config(jaci.pathfinder.Trajectory.FitMethod.HERMITE_CUBIC, jaci.pathfinder.Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
    jaci.pathfinder.Trajectory trajectory = Pathfinder.generate(points, config);
    TankModifier modifier = new TankModifier(trajectory).modify(0.5);
  SpeedControllerGroup leftMotors, rightMotors;
    
    EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
    EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());

    jaci.pathfinder.Trajectory leftTrajectory;
    jaci.pathfinder.Trajectory rightTrajectory;
    rightFrontTalon = new Talon(RobotMap.RIGHTFRONTTALONPORT);
    leftFrontTalon = new Talon(RobotMap.LEFTFRONTTALONPORT);
    rightBackTalon = new Talon(RobotMap.RIGHTBACKTALONPORT);
    leftBackTalon = new Talon(RobotMap.LEFTBACKTALONPORT);    
    rightFrontEncoder = new Encoder(RobotMap.LEFTFRONTENCODERPORT, RobotMap.LEFTFRONTENCODERPORT);
    leftFrontEncoder = new Encoder(RobotMap.LEFTFRONTENCODERPORT, RobotMap.LEFTFRONTENCODERPORT);
    rightBackEncoder = new Encoder(RobotMap.RIGHTBACKENCODERNPORT, RobotMap.RIGHTBACKENCODERNPORT);
    leftBackEncoder = new Encoder(RobotMap.LEFTBACKENCODERPORT, RobotMap.LEFTBACKENCODERPORT);

    mecDrive = new MecanumDrive(leftFrontTalon,leftBackTalon,rightFrontTalon,rightBackTalon);

		leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
    rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

    double l = left.calculate(encoder_position_left);
    double r = right.calculate(encoder_position_right);

    //double gyro_heading = da gyro
//     double desired_heading = Pathfinder.r2d(left.getHeading());  // Should also be in degrees

// // This allows the angle difference to respect 'wrapping', where 360 and 0 are the same value
//     double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
//     angleDifference = angleDifference % 360.0;
//     if (Math.abs(angleDifference) > 180.0) {
//       angleDiff = (angleDifference > 0) ? angleDifference - 360 : angleDiff + 360;
//     } 

//     double turn = 0.8 * (-1.0/80.0) * angleDifference;

//     setLeftMotors(l + turn);
//     setRightMotors(r - turn);





double maxVel = 9.256463818; // Feet/second
  double maxAccl = 9.84251969; // Feet/second^2
  double maxJerk = 196.850394; // Feet/second^3
  PigeonIMU gyro = new PigeonIMU(0);
   

    modifier.modify(1.9191667);

    leftTrajectory  = modifier.getLeftTrajectory();       // Get the Left Side
    rightTrajectory = modifier.getRightTrajectory();      // Get the Right Side

    left.configurePIDVA(1.0, 0.0, 0.6, 1 / maxVel, 0);
    right.configurePIDVA(1.0, 0.0, 0.3, 1 / maxVel, 0);

    
    if (!left.isFinished() || !right.isFinished()) {
      double l = left.calculate(encoder.getLeftDistanceFeet());
      double r = right.calculate(encoder.getRightDistanceFeet());
//fix with da encoders
      double gyro_heading = gyro.getAngle();
      double desired_heading = Pathfinder.r2d(left.getHeading());

      double angleDifference = 0.8 * (-1.0 / 80.0) * Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
      double turn = 0.8 * (-1.0 / 80.0) * angleDifference;

      System.out.println(l + turn);

      leftMotors.set(l + turn);
      rightMotors.set(r - turn);
    } else {
      leftMotors.set(0);
      rightMotors.set(0);
      //autoNotifier.stop();
    }
  // The distance between the left and right sides of the wheelbase is 0.6m



    

    }
    
        protected void normalize(double[] wheelSpeeds) {
          double maxMagnitude = Math.abs(wheelSpeeds[0]);
          for (int i = 1; i < wheelSpeeds.length; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) 
            {
              maxMagnitude = temp;
            }
        }
        if (maxMagnitude > 1.0) {
            for (int i = 0; i < wheelSpeeds.length; i++) {
            wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
            }
        }
        }

        double applyDeadband(double value, double deadband) {
            if (Math.abs(value) > deadband) {
              if (value > 0.0) {
                return (value - deadband) / (1.0 - deadband);
              } else {
                return (value + deadband) / (1.0 - deadband);
              }
            } else {
              return 0.0;
            }
          }
        
    public void initialize(){
        //all initialization code should be done in this initialize function and not the default constructor
        rightFrontTalon = new Talon(RobotMap.RIGHTFRONTTALONPORT);
        leftFrontTalon = new Talon(RobotMap.LEFTFRONTTALONPORT);
        rightBackTalon = new Talon(RobotMap.RIGHTBACKTALONPORT);
        leftBackTalon = new Talon(RobotMap.LEFTBACKTALONPORT);      
        mecDrive = new MecanumDrive(leftFrontTalon,leftBackTalon,rightFrontTalon,rightBackTalon);
    }
    public static HazyMecBase getInstance(){
        if (instance==null)
            instance = new HazyMecBase();
        return instance;
    }
    public void driveCartesian(double x, double y, double angle)
    {
    y = MathUtil.clamp(y, -1.0, 1.0);
    y = applyDeadband(y, RobotMap.DEADBAND);

    x = MathUtil.clamp(x, -1.0, 1.0);
    x = applyDeadband(x, RobotMap.DEADBAND);


            double[] wheelSpeeds = new double[4];
            wheelSpeeds[0] = x + y + angle;
            wheelSpeeds[1] = -x + y - angle;
            wheelSpeeds[2] = -x + y + angle;
            wheelSpeeds[3] = x + y - angle;
        
            normalize(wheelSpeeds);
        
            leftFrontTalon.set(wheelSpeeds[0] );
            rightFrontTalon.set(wheelSpeeds[1] * -1);
            leftBackTalon.set(wheelSpeeds[2]);
            rightBackTalon.set(wheelSpeeds[3]*-1);

    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new MecanumCommand());
    }


}
