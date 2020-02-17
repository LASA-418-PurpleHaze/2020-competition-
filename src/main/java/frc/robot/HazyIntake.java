//Imports fot the Subsystem and its functions
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;


public class HazyIntake extends Subsystem
{
    
    private TalonSRX liftTalon, spinTalon;
    private static HazyIntake instance;
    DigitalInput inputLow = new DigitalInput(0);
    DigitalInput inputHigh = new DigitalInput(1);
    private boolean isUp;

 

    
    public HazyIntake(){

        isUp = true;
        liftTalon = new TalonSRX(RobotMap.LIFTINTAKETALON); //change ports after testing?
        spinTalon = new TalonSRX(RobotMap.SPININTAKETALON);
    }
    
    public void initialize(){
        //all initialization code should be done in this initialize function and not the default constructor
    }
    
    public static HazyIntake getInstance(){
        if (instance==null)
            instance = new HazyIntake();
        return instance;
    }

    //Functions actually used by commands
    public void moveIntake(){
        if(isUp && !inputLow.get()){
            liftTalon.set(ControlMode.PercentOutput, RobotMap.LIFTTALONSPEED);
            isUp = false;
        }  
        
        else if(!isUp && !inputHigh.get()){
            liftTalon.set(ControlMode.PercentOutput, -RobotMap.LIFTTALONSPEED);
            isUp = true;
        }
    }

    public void intakeSwallow(){
        spinTalon.set(ControlMode.PercentOutput, RobotMap.SPINTALONSPEED);
    }

    public void intakeSpit(){
        spinTalon.set(ControlMode.PercentOutput, -RobotMap.SPINTALONSPEED);
    }

    @Override
    public void initDefaultCommand(){}


}