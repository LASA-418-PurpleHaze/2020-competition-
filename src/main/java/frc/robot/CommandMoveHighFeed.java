//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandMoveHighFeed extends Command {
    public CommandMoveHighFeed()
    {
        super.requires(Robot.hazyHighFeeder);
    }
    
    @Override
    protected void initialize(){}
    

    @Override
    protected void execute()
    {
        Robot.hazyHighFeeder.move();
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted()
    {
        
    }
}