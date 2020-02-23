//Imports fot the Joystick and its functions
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class HazyDPad extends XboxController{
    
    public HazyDPad(int p){
        super(p);
    }

    public boolean getTop(){
        return this.getPOV() == 0;
    }
    public boolean getRight(){
        return this.getPOV() == 90;
    }
    public boolean getBot(){
        return this.getPOV() == 180;
    }
    public boolean getLeft(){
        return this.getPOV() == 270;
    }
}