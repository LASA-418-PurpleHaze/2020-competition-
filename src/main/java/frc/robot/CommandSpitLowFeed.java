//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSpitLowFeed extends Command {
    public CommandSpitLowFeed(){
        super.requires(Robot.hazyLowFeeder);
    }
    
    @Override
    protected void initialize(){}
    
    @Override
    protected void execute(){
        Robot.hazyLowFeeder.spit();
        //System.out.println("Pressed Move Low Feed");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}