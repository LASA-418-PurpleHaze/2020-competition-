//Imports fot the Subsystem and its functions
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;


public class HazyShooter extends Subsystem
{
    
    private TalonSRX spinTalon;
    private static HazyIntake instance;

    
    public HazyShooter(){
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
    public void shooterSpit(){
        spinTalon.set(ControlMode.PercentOutput, -RobotMap.SPINTALONSPEED);
    }

    public void shooterSwallow(){
        spinTalon.set(ControlMode.PercentOutput, RobotMap.SPINTALONSPEED);
    }

    @Override
    public void initDefaultCommand(){}


}