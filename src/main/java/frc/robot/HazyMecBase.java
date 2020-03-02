//Imports fot the Subsystem and its functions
package frc.robot;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpiutil.math.MathUtil;

import javax.lang.model.util.ElementScanner6;

//import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.SerialPort;

public class HazyMecBase extends Subsystem{
    
    private TalonSRX rightFrontTalon;
    private TalonSRX leftFrontTalon;
    private TalonSRX leftBackTalon;
    private TalonSRX rightBackTalon;
    private double offset; 
    private double distance;
    
    // PigeonIMU _pigeon = new PigeonIMU(0);
    // ArrayList<Double> ypr_deg = new ArrayList<Double>();

    public static HazyMecBase instance;
    
    public HazyMecBase(){
      rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
      leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);
      leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
      rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
      Robot.hazyPort = new SerialPort(RobotMap.BAUDRATE, SerialPort.Port.kMXP);
      Robot.hazyPort.enableTermination();
      //pigeon = new PigeonIMU(RobotMap.PIGEONIMU);
      
      // rightFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      // rightFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);
      // rightFrontTalon.config_kI(0, RobotMap.DRIVEI, 30);
      // rightFrontTalon.config_kD(0, RobotMap.DRIVED, 30);

      // rightBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      // rightBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      // rightBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      // rightBackTalon.config_kD(0, RobotMap.DRIVED, 30);

      // leftFrontTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      // leftFrontTalon.config_kP(0, RobotMap.DRIVEP, 30);
      // leftFrontTalon.config_kI(0, RobotMap.DRIVEI, 30);
      // leftFrontTalon.config_kD(0, RobotMap.DRIVED, 30);

      // leftBackTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
      // leftBackTalon.config_kP(0, RobotMap.DRIVEP, 30);
      // leftBackTalon.config_kI(0, RobotMap.DRIVEI, 30);
      // leftBackTalon.config_kD(0, RobotMap.DRIVED, 30);

      //mecDrive = new MecanumDrive(leftFrontTalon,leftBackTalon,rightFrontTalon,rightBackTalon);
    }

    public void initialize(){
      //all initialization code should be done in this initialize function and not the default constructor
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
    
        leftFrontTalon.set(ControlMode.PercentOutput, -wheelSpeeds[0] );
        rightFrontTalon.set(ControlMode.PercentOutput, -wheelSpeeds[1] * -1);
        leftBackTalon.set(ControlMode.PercentOutput, -wheelSpeeds[2]);
        rightBackTalon.set(ControlMode.PercentOutput, -wheelSpeeds[3]*-1);
    }
    
    public void goToTarget(){
        Robot.solenoidToLight.set(true);
        double travelDistance = RobotMap.SHOOTDISTANCE - distance;
        double turnPower = clamp(RobotMap.VISIONTURN * offset);
        double forwardPower =clamp( -travelDistance*RobotMap.VISIONSPEED);
        System.out.println("turn: " + turnPower + " forward: " + forwardPower);
        driveCartesian(0, -forwardPower, -turnPower);
    }

    public void readData(){
      String data = Robot.hazyPort.readString();
      if(!data.equals("")){
        System.out.println(data);
        try{
        offset = Double.parseDouble(data.substring(8,data.indexOf("distance")));
        distance = Double.parseDouble(data.substring(data.indexOf("distance")+10));
        }
        catch (Exception e){
          e.printStackTrace();
        }
      }
        
    }

    private double clamp(double input){
      if(input>RobotMap.MAXVISIONSPEED)
        return RobotMap.MAXVISIONSPEED; 
      else if (input < -RobotMap.MAXVISIONSPEED)
        return -RobotMap.MAXVISIONSPEED;
      return input;
    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(Robot.commandMecanum);
    }
}
