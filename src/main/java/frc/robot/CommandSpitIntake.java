//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSpitIntake extends Command {
    public CommandSpitIntake()
    {
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyIntake.intakeSpit();
        //System.out.println("Pressed Spit Intake");
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted(){}
}