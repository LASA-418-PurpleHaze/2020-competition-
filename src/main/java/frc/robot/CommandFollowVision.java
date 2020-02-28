//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandFollowVision extends Command {
    public CommandFollowVision(){
        super.requires(Robot.hazyMecBase);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyEndArm.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyMecBase.goToTarget();

        //System.out.println("Pressed End Arm Down");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}