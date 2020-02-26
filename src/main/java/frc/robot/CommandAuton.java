//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAuton extends Command {
    public CommandAuton() {
        super.requires(Robot.hazyAuton);
    }
    
    @Override
    protected void initialize(){

    }
    @Override
    protected void execute(){
        Robot.hazyAuton.startGame();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}