//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyHighFeeder extends Subsystem {

    private TalonSRX highFeederTalon; 

    public HazyHighFeeder(){
        highFeederTalon = new TalonSRX(RobotMap.HIGHFEEDERTALON);
    }
    
    public void move() {
        highFeederTalon.set(ControlMode.PercentOutput, .4);
    }

    public void stop(){
        highFeederTalon.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    public void initDefaultCommand(){
        setDefaultCommand(Robot.commandHighFeedDefault);
    }
}