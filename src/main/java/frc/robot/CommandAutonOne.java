//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAutonOne extends Command { 

    public CommandAutonOne(){
        super.requires(Robot.hazyAuton);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyAuton.autonOne();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}