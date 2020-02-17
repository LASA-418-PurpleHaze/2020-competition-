//Imports fot the Joystick and its functions
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;


public class HazyJoysticks extends XboxController{
    

    public HazyJoysticks(int p){
        super(p);
    }

    public double getRightXAxis(){
        return this.getX(Hand.kRight);
    }

    public double getRightYAxis(){
        return this.getY(Hand.kRight);
    }

    public double getLeftXAxis(){
        return this.getX(Hand.kLeft);
    }

    public double getLeftYAxis(){
        return this.getY(Hand.kLeft);
    }

    

}