//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyLowFeeder extends Subsystem {

    private TalonSRX lowFeederTalon; 
    
    public HazyLowFeeder(){
        lowFeederTalon = new TalonSRX(RobotMap.LOWFEEDERTALON);
    }

    public void move() {
        lowFeederTalon.set(ControlMode.PercentOutput, .4);
    }
    
    @Override
    public void initDefaultCommand(){}

}