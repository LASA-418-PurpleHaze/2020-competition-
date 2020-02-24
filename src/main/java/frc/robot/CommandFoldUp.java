//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandFoldUp extends Command {
    public CommandFoldUp(){
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();

    }

    @Override
    protected void execute(){
        Robot.hazyColorArm.foldUp();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}