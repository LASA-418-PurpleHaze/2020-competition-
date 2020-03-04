//Imports fot the Subsystem and its functions
package frc.robot;

import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyColorArm extends Subsystem {
    
    private TalonSRX elbowTalon; 
    private TalonSRX colorWheelTalon;
    private char initColor; //the color the wheel starts on (set using setInitColor())
    // private char currentColor;
    // private char candidateColor;
    // private int spinNum; //the number of times the wheel has spun (used in spinWheel())
    private int spinTo;
    private int colorCount;
    private boolean shouldMove;
    private boolean shouldSpin;
    private boolean changeColor;
    private char col;
    private char[] colors = {'R', 'G', 'B', 'Y'};

    private int colorToTravelTo; //The Color which the color sensor will stop onHaz

    public HazyColorArm(){
        elbowTalon = new TalonSRX(RobotMap.ELBOWTALONPORT);
        colorWheelTalon = new TalonSRX(RobotMap.COLORWHEELTALONPORT);
        elbowTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		elbowTalon.config_kP(0, RobotMap.ELBOWP, 30);
		elbowTalon.config_kI(0, RobotMap.ELBOWI, 30);
        elbowTalon.config_kD(0, RobotMap.ELBOWD, 30);
        initColor = ' ';
        // currentColor = ' ';
        // candidateColor = ' ';
        // spinNum = 0;
        colorCount=0;
        col = ' ';
        shouldMove = false;
        shouldSpin = false;
        changeColor = false;
        colorToTravelTo = 0;
    }

    public void foldUp(){
        elbowTalon.set(ControlMode.Position, -4300); //negative goes up (-3700)
    }

    public void foldDown(){
        elbowTalon.set(ControlMode.Position, 0); //negative goes up (-3700)
    }

    //when run, this method sees the starting color and records it as the base color
    //always call before spinWheel() so that it does it right
    public void setInitColor(){
        initColor = Robot.hazyColorSensor.getColor();
        // currentColor = initColor;
    }

    public void stopSpin(){
        colorWheelTalon.set(ControlMode.PercentOutput, 0);
    }

   public void spinToggle(){
       shouldSpin = true;
   }
    //spins the wheel a specified number of times spinTo
    public void spinWheel(int spinNum){
        
        if(shouldMove && shouldSpin){
            shouldMove = false;
            shouldSpin = false;
        }

        else if(shouldSpin){
            spinTo = spinNum;
            System.out.println(colorCount);
            colorWheelTalon.set(ControlMode.PercentOutput, 0.4);
            col = Robot.hazyColorSensor.getColor();
            if(col != initColor)
                changeColor = true;
            if(changeColor){
                if(col == initColor){
                    colorCount += 1;
                    changeColor = false;
                }
            }
            if(colorCount / 2 == spinTo)
                shouldSpin = false;
        }  
        else if(!shouldSpin && !shouldMove){ //has spun spinTo times, turn motor off
                    colorWheelTalon.set(ControlMode.PercentOutput, 0);
        }
            // //hasn't spun spinTo times yet, keep motor going
            // if(spinNum >= spinTo)
            //     shouldSpin = false;
            // if(spinNum < spinTo*2){
            //     if(spinNum < spinTo*2-2){
            //         colorWheelTalon.set(ControlMode.PercentOutput, 0.4);
            //     }else{
            //         colorWheelTalon.set(ControlMode.PercentOutput, 0.3);
            //     }
            // }

            //gotten to initColor again - means it's gone half a spin
            //char col = Robot.hazyColorSensor.getColor();
            
            // if(col != candidateColor){
            //     colorCount = 0;
            //     candidateColor = col;
            // }
            // else
            //     colorCount++;
            // if(candidateColor != currentColor){
            //     if(colorCount > 6){
            //         if((col == initColor) && (col != currentColor))
            //             spinNum++;
            //         currentColor = col;
            //     }
            //  }
        
        
        
    }

    // public void testColorWheel () {
    //     String theColor = Robot.hazyColorSensor.getColor();
    //     if(theColor.equals(Robot.hazyColorSensor.getColor())){
    //         colorWheelTalon.set(ControlMode.PercentOutput, 0.3);
    //     }else{
    //         long mili = System.currentTimeMillis();
    //         while(mili < 500){
    //             colorWheelTalon.set(ControlMode.PercentOutput, 0);
    //             mili = System.currentTimeMillis();
    //         }
    //         theColor = Robot.hazyColorSensor.getColor();
    //         System.out.println(theColor);
    //     }
    // }

    // public boolean spinWheelIsFinished () {
    //     int temp = spinNum;
    //     if(spinNum == spinTo*2){
    //         spinNum = 0;
    //     }
    //     return temp == spinTo*2;
    // }

    public void moveToggle(){
        //System.out.println("Move Toggle");
        shouldMove = true;
    }

    public void goToColor (char col) { //spins the wheel to a specified color c
        //System.out.println(Robot.hazyColorSensor.getColor() + "- "+ col);
        int i = Arrays.binarySearch(colors, col);
        col = colors[(i+2)%4];

        if(shouldMove && shouldSpin){
            shouldMove = false;
            shouldSpin = false;
        }

        // that was because the actaul sensor on the field is 2 down from where we gotta go
        else if(shouldMove){
            if (Robot.hazyColorSensor.getColor() != col) 
                colorWheelTalon.set(ControlMode.PercentOutput, 0.2);
            if(Robot.hazyColorSensor.getColor() == col)
                shouldMove = false;
        }
        
        else if (!shouldMove && !shouldSpin){
            colorWheelTalon.set(ControlMode.PercentOutput, 0);
        }
    }

    public int returnColorToTravelTo(){
        return colorToTravelTo;
    }

    public void increaseColorToTravelTo(){
        colorToTravelTo = (colorToTravelTo+1)%4;
    }
    
    @Override
    public void initDefaultCommand(){
        setDefaultCommand(Robot.commandColorArmDefault);
    }
}