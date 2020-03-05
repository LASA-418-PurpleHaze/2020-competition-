//Imports fot the Subsystem and its functions
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class HazyShooter extends Subsystem {

    private static TalonSRX shooterTalon;
    private static HazyIntake instance;
    
  private static SmartDashboard smartdashboard;

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
    public static void UpdateRPM() {
        //System.out.println("SmartDashboard is a go");
        SmartDashboard.putNumber("TPR", shooterTalon.getSelectedSensorVelocity());

    }

    public void shooterSpit(){ //Functions actually used by commands
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
        //setDefaultCommand(Robot.commandShooterDefault);
    }
}