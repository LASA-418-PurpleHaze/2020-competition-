//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandStopSpinning extends Command {
    public CommandStopSpinning(){
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute(){
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