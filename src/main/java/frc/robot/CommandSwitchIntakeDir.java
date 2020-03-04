//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSwitchIntakeDir extends Command {
    public CommandSwitchIntakeDir(){
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyIntake.switchDir();
        //System.out.println("SWITHCINTAKEDIR");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}