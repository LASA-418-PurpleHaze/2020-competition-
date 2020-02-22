//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSwallowLowFeed extends Command {
    public CommandSwallowLowFeed(){
        super.requires(Robot.hazyLowFeeder);
    }
    
    @Override
    protected void initialize(){}
    
    @Override
    protected void execute(){
        Robot.hazyLowFeeder.swallow();
        //System.out.println("Pressed Move Low Feed");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}