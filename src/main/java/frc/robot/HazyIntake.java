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
    private boolean shouldMove;

    public HazyIntake(){
        isUp = true;
        liftTalon = new TalonSRX(RobotMap.LIFTINTAKETALON); //change ports after testing?
        spinVictor = new Victor(RobotMap.SPININTAKEVICTOR);
        shouldMove = false;
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

    public void moveIntake(){ //Functions actually used by commands
        shouldMove = true;
        if(isUp){
            while(shouldMove){
                if(!inputLow.get()){
                    shouldMove = false;
                    isUp = false;
                }
                liftTalon.set(ControlMode.PercentOutput, -RobotMap.LIFTTALONSPEED);
            }
        }
        if(!isUp){
            while(shouldMove){
                if(!inputHigh.get()){
                    shouldMove = false;
                    isUp = true;
                }
                liftTalon.set(ControlMode.PercentOutput, RobotMap.LIFTTALONSPEED);
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