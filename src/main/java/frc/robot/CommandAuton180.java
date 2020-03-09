//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAuton180 extends Command { 

    public CommandAuton180(){
        super.requires(Robot.hazyAuton);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyAuton.turn180();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}