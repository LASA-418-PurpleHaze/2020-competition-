//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSwallowHighFeed extends Command {
    public CommandSwallowHighFeed(){
        super.requires(Robot.hazyHighFeeder);
    }
    
    @Override
    protected void initialize(){}
    
    @Override
    protected void execute(){
        Robot.hazyHighFeeder.swallow();
        //System.out.println("Pressed Move High Feed");
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted(){}
}