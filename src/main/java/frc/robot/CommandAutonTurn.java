//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAutonTurn extends Command {
    private double degs; 

    public CommandAutonTurn(double in){
        super.requires(Robot.hazyAuton);
        degs = in;
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyAuton.turn(degs);
        //System.out.println("Pressed Drop Intake");
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}