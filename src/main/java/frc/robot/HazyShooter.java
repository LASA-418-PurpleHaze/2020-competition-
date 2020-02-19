//Imports fot the Subsystem and its functions
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class HazyShooter extends Subsystem
{
    
    private TalonSRX shooterTalon;
    private static HazyIntake instance;

    
    public HazyShooter(){
        shooterTalon = new TalonSRX(RobotMap.SHOOTERTALONPORT);
    }
    
    // public void initialize(){
    //     //all initialization code should be done in this initialize function and not the default constructor
    // }
    
    public static HazyIntake getInstance(){
        if (instance==null)
            instance = new HazyIntake();
        return instance;
    }

    //Functions actually used by commands
    public void shooterSpit(){
        shooterTalon.set(ControlMode.PercentOutput, -RobotMap.SHOOTERSPEED);
    }

    public void shooterSwallow(){
        shooterTalon.set(ControlMode.PercentOutput, RobotMap.SHOOTERSPEED);
    }

    public void stopShooter(){
        shooterTalon.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void initDefaultCommand(){
        setDefaultCommand(Robot.commandShooterDefault);
    }


}