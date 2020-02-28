//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandToggleTurn extends Command {
    public CommandToggleTurn() {
        super.requires(Robot.hazyAuton);
    }
    
    @Override
    protected void initialize(){

    }
    @Override
    protected void execute(){
        Robot.hazyAuton.toggleTurn();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}