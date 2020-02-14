package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class HazyColorArm extends Subsystem {
    private TalonSRX elbowTalon; 
    private TalonSRX colorWheelTalon;
    private String initColor; //the color the wheel starts on (set using setInitColor())
    private String currentColor;
    private String candidateColor;
    private int spinNum; //the number of times the wheel has spun (used in spinWheel())
    private int spinTo;
    private int colorCount;
    
    public void initialize () {
        elbowTalon = new TalonSRX(RobotMap.ELBOWTALONPORT);
        colorWheelTalon = new TalonSRX(RobotMap.COLORWHEELTALONPORT);
        elbowTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        initColor = "";
        currentColor = "";
        candidateColor="";
        spinNum = 0;
        colorCount=0;
    }
    
    public void fold () {
        elbowTalon.set(ControlMode.Position, -3700); //negative goes up (-3700)
        //elbowTalon.set(ControlMode.PercentOutput, -0.1);
        //elbowTalon.setPosition();
    }

    //when run, this method sees the starting color and records it as the base color
    //always call before spinWheel() so that it does it right
    public void setInitColor () {
        initColor = Robot.colorSensor.getColor();
        currentColor = initColor;
    }

    //spins the wheel a specified number of times spinTo
    public void spinWheel (int spinTo) {
        this.spinTo = spinTo;
        //hasn't spun spinTo times yet, keep motor going
        

        if (spinNum < spinTo*2 ) {
            if(spinNum < spinTo*2-2){
                colorWheelTalon.set(ControlMode.PercentOutput, 0.4);
            }
            else {
                colorWheelTalon.set(ControlMode.PercentOutput, 0.3);
            }
        }

        //gotten to initColor again - means it's gone half a spin
        String col = Robot.colorSensor.getColor();
        if (!col.equals(candidateColor)){
            System.out.println("candidate switch! old: " +candidateColor+" new: "+col);
            colorCount=0;
            candidateColor=col;
        }
        else{
            colorCount++;
            System.out.println(colorCount+" "+ col+" current:"+currentColor);
        }
            if (!candidateColor.equals(currentColor)) {

                if(colorCount > 6){
                    if (col.equals(initColor) && !(col.equals(currentColor))) {
                        System.out.println("spins ++++");
                        spinNum++;
                    }
                    System.out.println("new color: " + col);
                    currentColor = col;
                    System.out.println("spins: " + spinNum);
                }

            }
            else{
                
            }

        //has spun spinTo times, turn motor off
        if (spinNum >= spinTo*2 ) {
            colorWheelTalon.set(ControlMode.PercentOutput, 0);
        }
    }

    public void testColorWheel () {
        String theColor = Robot.colorSensor.getColor();
        if (theColor.equals(Robot.colorSensor.getColor())) {
            colorWheelTalon.set(ControlMode.PercentOutput, 0.3);
        } else {
            long mili = System.currentTimeMillis();
            while (mili < 500) {
                colorWheelTalon.set(ControlMode.PercentOutput, 0);
                mili = System.currentTimeMillis();
            }
            theColor = Robot.colorSensor.getColor();
            System.out.println(theColor);
        }
    }

    public boolean spinWheelIsFinished () {
        int temp = spinNum;
        if(spinNum == spinTo*2){
            spinNum = 0;
        }
        return temp == spinTo*2;
    }

    //spins the wheel to a specified color col
    public void goToColor (String col) {
        System.out.println(Robot.colorSensor.getColor() + "- "+ col);
        if (!Robot.colorSensor.getColor().equals(col)) {
            System.out.println("going!");
            colorWheelTalon.set(ControlMode.PercentOutput, 0.3);
        }
        else {
            System.out.println("stopped");
            colorWheelTalon.set(ControlMode.PercentOutput, 0);
        }
    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new FoldCommand());
    }
}