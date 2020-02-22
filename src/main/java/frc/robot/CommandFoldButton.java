//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandFoldButton extends Command {
    public CommandFoldButton(){
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();

    }

    @Override
    protected void execute(){
        System.out.println("Pressed Command Fold");
        Robot.hazyIntake.switchDir();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}