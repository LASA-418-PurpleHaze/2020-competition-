//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAuton extends Command {
    public CommandAuton() {
        super.requires(Robot.HazyAuton);
    }
    
    @Override
    protected void initialize(){

    }
    @Override
    protected void execute(){
        HazyAuton start = new HazyAuton();
        start.initialize();
        start.close();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}