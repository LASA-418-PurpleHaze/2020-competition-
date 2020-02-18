//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyEndArm extends Subsystem {
    private TalonSRX elbowTalon; 
    
    public void initialize () {
        elbowTalon = new TalonSRX(RobotMap.ELBOWTALONPORT);
    }
    //This command will cause the motor to either reel the arm in or extend it out depending on wether or not the operator has set the direction of isUp
    public void foldUp() {  
        elbowTalon.set(ControlMode.PercentOutput, 1);
        //elbowTalon.set(ControlMode.PercentOutput, -0.1);
        //elbowTalon.setPosition();
    }
    public void foldDown() {  
        elbowTalon.set(ControlMode.PercentOutput, 1);
        //elbowTalon.set(ControlMode.PercentOutput, -0.1);
         //elbowTalon.setPosition();
    }
    @Override
    public void initDefaultCommand(){}

}