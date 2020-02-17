//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyEndArm extends Subsystem {
    private TalonSRX elbowTalon; 
    private boolean isUp;
    private int location;
    private int change;
    
    public void initialize () {
        elbowTalon = new TalonSRX(RobotMap.ELBOWTALONPORT);
        isUp = false;
        location = 0; //Used to show the current location the motor is at
        change = 5; // How much the motor will move every time the fold function is called -> This value needs to be changed so that it works correctly
    }
    //This command will cause the motor to either reel the arm in or extend it out depending on wether or not the operator has set the direction of isUp
    public void fold() {  
        if(!isUp){
            if(location > -10000){ //This value needs to be changed so that it equals the max distance which the motor can spin
                location = location-change;
                elbowTalon.set(ControlMode.Position, location);
            }
        }

        else{
            if(location < 0){
                location = location+change;
                elbowTalon.set(ControlMode.Position, location);
            }
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