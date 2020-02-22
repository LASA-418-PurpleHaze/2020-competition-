//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSpitHighFeed extends Command {
    public CommandSpitHighFeed(){
        super.requires(Robot.hazyHighFeeder);
    }
    
    @Override
    protected void initialize(){}
    
    @Override
    protected void execute(){
        Robot.hazyHighFeeder.spit();
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