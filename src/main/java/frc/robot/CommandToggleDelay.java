//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandToggleDelay extends Command {
    public CommandToggleDelay(){
        super.requires(Robot.hazyMecBase);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();
        // Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute(){ 
        Robot.hazyMecBase.toggleDelayed();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}