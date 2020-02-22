package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpiutil.math.MathUtil;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class HazyPathBase extends Subsystem
{

    private TalonSRX rightFrontTalon, leftFrontTalon, rightBackTalon, leftBackTalon;
    private MecanumDrive mecDrive;

    public static HazyMecBase instance;
    public static boolean initialized = false;

    public HazyPathBase(){   
    }

    public void initialize(){
      //all initialization code should be done in this initialize function and not the default constructor
      if(!initialized){
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);    
      rightFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      leftFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      rightBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      leftBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      // reminder: in process of updating everything with new naming conventions
      // we using talon SRX right now, so learn from HazyColorArm. Change things in Robot.java and RobotMap,


      mecDrive = new MecanumDrive(leftFrontTalon,leftBackTalon,rightFrontTalon,rightBackTalon);
      }
    }

    public static HazyMecBase getInstance(){
      if (instance==null)
          instance = new HazyMecBase();
      return instance;
    }
    
    protected void normalize(double[] wheelSpeeds) {
      double maxMagnitude = Math.abs(wheelSpeeds[0]);
      for (int i = 1; i < wheelSpeeds.length; i++) {
        double temp = Math.abs(wheelSpeeds[i]);
        if (maxMagnitude < temp) {
          maxMagnitude = temp;
        }
      }
        if (maxMagnitude > 1.0) {
            for (int i = 0; i < wheelSpeeds.length; i++) {
            wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
            }
        }
    }

    private double applyDeadband(double value, double deadband) {
      if (Math.abs(value) > deadband) {
        if (value > 0.0) 
          return (value - deadband) / (1.0 - deadband);
        
        else 
          return (value + deadband) / (1.0 - deadband);  
      } 

      else 
        return 0.0;
    }

    public void driveCartesian(double x, double y, double angle){
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

    public void followPath(HazyPath path)
    {
      for(int i = 0; i < path.getPath().size(); i++){
        //put if statements to move robot based on whether or not current positions (use default methods to get encoder readings), are more or less than the trajectory positions
        //double currVel = 
      }

    }
    public void Auto() {
      //starting positions are from left to right on the perspective of the driver
      int position = 0;
      if (position == 0) {
        //move from left pos
      }
      if (position == 1) {
        //move from middle pos
      }
      if (position == 2) {
        //move from right pos
      }

      //below to put the code to spin and shoot

    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new MecanumCommand());
    }


}