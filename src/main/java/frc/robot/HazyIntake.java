//Imports fot the Subsystem and its functions
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Victor;

public class HazyIntake extends Subsystem {

    private TalonSRX liftTalon;
    public Victor spinVictor;
    private static HazyIntake instance;
    DigitalInput inputLow = new DigitalInput(0);
    DigitalInput inputHigh = new DigitalInput(2);
    private boolean isUp;

 
    public HazyIntake(){
        isUp = true;
        liftTalon = new TalonSRX(RobotMap.LIFTINTAKETALON); //change ports after testing?
        spinVictor = new Victor(RobotMap.SPININTAKEVICTOR);
    }
    
    public static HazyIntake getInstance(){
        if (instance==null)
            instance = new HazyIntake();
        return instance;
    }

    public void printButtons(){
        if(!inputLow.get())
            System.out.println("Low Pressed");

        else if(!inputHigh.get())
            System.out.println("High Pressed");
        
        else
            System.out.println("Not Pressed");
    }

    //Functions actually used by commands
    public void moveIntake(){
        if(isUp){
            if(inputLow.get())
                liftTalon.set(ControlMode.PercentOutput, RobotMap.LIFTTALONSPEED);
            
            else if(!inputLow.get()){
                liftTalon.set(ControlMode.PercentOutput, 0);
                isUp = false;
            } 
        }  
        
        else if(!isUp){

            if(inputHigh.get())
                liftTalon.set(ControlMode.PercentOutput, -RobotMap.LIFTTALONSPEED);
            
            else if(!inputHigh.get()){
                liftTalon.set(ControlMode.PercentOutput, 0);
                isUp = true;
            }
            
        }
    }

    public void intakeStopLift(){
        liftTalon.set(ControlMode.PercentOutput, 0);
    }

    public void intakeSwallow(){
        spinVictor.set(RobotMap.SPINVICTORSPEED);
    }

    public void intakeSpit(){
        spinVictor.set(-RobotMap.SPINVICTORSPEED);
    }

    public void intakeStopSpin(){
        spinVictor.set(0);
    }

    @Override
    public void initDefaultCommand(){
        //setDefaultCommand(Robot.commandIntakeDefault);
    }


}