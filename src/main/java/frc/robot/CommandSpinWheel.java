//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSpinWheel extends Command {
    public CommandSpinWheel(){
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();
        // Robot.hazyColorSensor.initialize();
        Robot.hazyColorArm.setInitColor();
    }

    @Override
    protected void execute(){
        Robot.hazyColorArm.spinWheel(4);
        //System.out.println("Pressed Spin Color Wheel");
    }

    @Override
    protected boolean isFinished(){
        return Robot.hazyColorArm.spinWheelIsFinished();
    }

    @Override
    protected void interrupted(){}
}