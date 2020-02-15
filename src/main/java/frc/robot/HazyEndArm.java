package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyEndArm extends Subsystem {
    private TalonSRX elbowTalon; 
    private boolean isUp;
    
    public void initialize () {
        elbowTalon = new TalonSRX(RobotMap.ELBOWTALONPORT);
        isUp = false;
    }
    /*
    This is just the code from Color Arm -> This needs to be remade so that it works with then end arm
    
    We dicide that we are going to code this so that when the button is held down then it will be running the program.
    To tell wether or not the they want the arm to go up or down the operator will have a seperate button to choose between if its gonna go up or down.
    */
    public void fold() {  
        if(!isUp){
            elbowTalon.set(ControlMode.Position, -3700); //These numbers need to be changed inorder to work with the End Arm
        }

        else{
            elbowTalon.set(ControlMode.Position, 0);//These numbers need to be changed inorder to work with the End Arm
        }
        //elbowTalon.set(ControlMode.PercentOutput, -0.1);
        //elbowTalon.setPosition();
    }
    

    public void changeDirection(){
        if (isUp){
            isUp = false;
        }
        else{
            isUp = true;
        }
    }
    @Override
    public void initDefaultCommand(){}

}