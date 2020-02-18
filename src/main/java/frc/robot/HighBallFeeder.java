//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HighBallFeeder extends Subsystem {

    private TalonSRX highFeederTalon; 

    public HighBallFeeder(){
        highFeederTalon = new TalonSRX(RobotMap.HIGHFEEDERTALON);
    }
    

    
    public void move() {
        highFeederTalon.set(ControlMode.PercentOutput, .4);
    }
    
    @Override
    public void initDefaultCommand(){}

}