package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpiutil.math.MathUtil;

public class PathMecBase extends Subsystem
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
    public static boolean initialized = false;

    public PathMecBase(){   
    }

    public void initialize(){
      //all initialization code should be done in this initialize function and not the default constructor
      if(!initialized){
      rightFrontTalon = new Talon(RobotMap.RIGHTFRONTTALONPORT);
      leftFrontTalon = new Talon(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new Talon(RobotMap.RIGHTBACKTALONPORT);
      leftBackTalon = new Talon(RobotMap.LEFTBACKTALONPORT);    
      rightFrontEncoder = new Encoder(RobotMap.LEFTFRONTENCODERPORT, RobotMap.LEFTFRONTENCODERPORT);
      leftFrontEncoder = new Encoder(RobotMap.LEFTFRONTENCODERPORT, RobotMap.LEFTFRONTENCODERPORT);
      rightBackEncoder = new Encoder(RobotMap.RIGHTBACKENCODERNPORT, RobotMap.RIGHTBACKENCODERNPORT);
      leftBackEncoder = new Encoder(RobotMap.LEFTBACKENCODERPORT, RobotMap.LEFTBACKENCODERPORT);

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
      //positions are from left to right on the perspective of the driver
      int position = 0;
      if (position == 0) {
        //go left
      }
      if (position == 1) {
        //go middle
      }
      if (position == 2) {
        //go right
      }

      //spinny spin?

    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new MecanumCommand());
    }


}