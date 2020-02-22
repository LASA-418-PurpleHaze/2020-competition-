//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandDropIntake extends Command {
    public CommandDropIntake(){
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyIntake.moveIntake();
        Robot.hazyIntake.intakeStopSpin();
        //System.out.println("Pressed Drop Intake");
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}