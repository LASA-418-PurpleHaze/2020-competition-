//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MoveLowFeedCommand extends Command {
    public MoveLowFeedCommand ()
    {
        super.requires(Robot.lowBallFeeder);
    }
    
    @Override
    protected void initialize(){}
    

    @Override
    protected void execute()
    {
        Robot.lowBallFeeder.move();
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