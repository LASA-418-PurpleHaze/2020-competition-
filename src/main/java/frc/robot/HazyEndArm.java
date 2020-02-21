//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyEndArm extends Subsystem {
    private TalonSRX endArmTalon; 
    
    public HazyEndArm() {
        endArmTalon = new TalonSRX(RobotMap.ENDARMTALONPORT);
    }
    
    public void foldUp() {  //This command will cause the motor to either reel the arm in or extend it out depending on wether or not the operator has set the direction of isUp
        endArmTalon.set(ControlMode.PercentOutput, 1);
        System.out.println("End Arm Going Up");
    }

    public void foldDown() {  
        endArmTalon.set(ControlMode.PercentOutput, -1);
        System.out.println("End Arm Going Down");
    }

    public void stopMotors(){
        endArmTalon.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    public void initDefaultCommand(){
        setDefaultCommand(Robot.commandEndArmDefault);
    }
}