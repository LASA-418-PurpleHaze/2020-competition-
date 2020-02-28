//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAutonMove extends Command {
    private double feet; 

    public CommandAutonMove(double in){
        super.requires(Robot.hazyAuton);
        feet = in;
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
        System.out.println("MOVE COMMAND RUNNING");
        Robot.hazyAuton.move(feet);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}