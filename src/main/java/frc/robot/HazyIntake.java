//Imports fot the Subsystem and its functions
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class HazyIntake extends Subsystem {

    private TalonSRX liftTalon;
    public VictorSPX spinVictor;
    private static HazyIntake instance;
    DigitalInput inputLow = new DigitalInput(0);
    DigitalInput inputHigh = new DigitalInput(2);
    private boolean isUp;
    private boolean  shouldMove;

    public HazyIntake(){
        isUp = true;
        shouldMove = false;
        liftTalon = new TalonSRX(RobotMap.LIFTINTAKETALON); //change ports after testing?
        spinVictor = new VictorSPX(RobotMap.SPININTAKEVICTOR);
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
    public void switchDir (){
        shouldMove = true;
    }

    public void moveIntake(){ //Functions actually used by commands

        //System.out.println(inputLow.get());
        //System.out.println(inputHigh.get());
        if(shouldMove && isUp){
            if(inputLow.get()){
                liftTalon.set(ControlMode.PercentOutput, -RobotMap.LIFTTALONSPEED);
                //System.out.println("MOVING DOWN");   
            }
            
            if(!inputLow.get() && isUp){
                System.out.println("Low Pressed");
                shouldMove = false;
                isUp = false;
            }
        }
        else if(shouldMove && !isUp){
            if(inputHigh.get())
                liftTalon.set(ControlMode.PercentOutput, RobotMap.LIFTTALONSPEED);
                //System.out.println("MOVING UP");
            
            if(!inputHigh.get()){
                System.out.println("High Pressed");

                shouldMove = false;
                isUp = true;     
            }    
        }


        if(!shouldMove){
            liftTalon.set(ControlMode.PercentOutput, 0); 
        }
   

    }

    public void intakeStopLift(){
        liftTalon.set(ControlMode.PercentOutput, 0);
    }

    public void intakeSwallow(){
        //System.out.println("Swallowing");
        spinVictor.set(ControlMode.PercentOutput, RobotMap.SPINVICTORSPEED);
    }

    public void intakeSpit(){
        spinVictor.set(ControlMode.PercentOutput, -RobotMap.SPINVICTORSPEED);
    }

    public void intakeStopSpin(){
        spinVictor.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void initDefaultCommand(){
        setDefaultCommand(Robot.commandMoveIntakeDefault);
    }
}