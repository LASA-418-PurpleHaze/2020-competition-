//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MoveHighFeedCommand extends Command {
    public MoveHighFeedCommand()
    {
        super.requires(Robot.highBallFeeder);
    }
    
    @Override
    protected void initialize(){}
    

    @Override
    protected void execute()
    {
        Robot.highBallFeeder.move();
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