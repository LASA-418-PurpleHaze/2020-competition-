package frc.robot;
import edu.wpi.first.wpilibj.I2C;

public class RobotMap   //Static port variables

{
    //Joysticks 
    public static final int LEFTJOYSTICKPORT = 2;
    public static final int RIGHTJOYSTICKPORT = 1;

    //Controller
    public static final int CONTROLLERPORT = 0;
    
    //HazyMecBase
    public static final int RIGHTFRONTTALONPORT = 9;
    public static final int LEFTFRONTTALONPORT = 1;
    public static final int RIGHTBACKTALONPORT = 3;
    public static final int LEFTBACKTALONPORT = 2;

    //ColorSensor
    public static final I2C.Port COLORSENSORPORT = I2C.Port.kOnboard;

    //ColorArm
    public static final int ELBOWTALONPORT = 1;
    public static final int COLORWHEELTALONPORT = 0;

    //PID
    public static final double DEADBAND = 0.02;

    //HazyIntake
    public static final int LIFTINTAKETALON = 0;
    public static final int SPININTAKETALON = 0;
    public static final double LIFTTALONSPEED = 0.3;
    public static final double SPINTALONSPEED = 0.5;

    //End Arm
    
}