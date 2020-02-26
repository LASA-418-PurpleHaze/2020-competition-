//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAuton extends Command {
    public CommandAuton() {
        super.requires(Robot.HazyAuton);
    }
    
    @Override
    protected void initialize(){
        //Robot.HazyAuton.initialize();
    }
    @Override
    protected void execute(){
        //System.out.println(Robot.hazyColorSensor.getColor());
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}