//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandMoveLowFeed extends Command {
    public CommandMoveLowFeed ()
    {
        super.requires(Robot.hazyLowFeeder);
    }
    
    @Override
    protected void initialize(){}
    

    @Override
    protected void execute()
    {
        Robot.hazyLowFeeder.move();
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