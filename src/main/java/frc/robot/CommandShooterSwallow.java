//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandShooterSwallow extends Command {
    public CommandShooterSwallow(){
        super.requires(Robot.hazyShooter);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyShooter.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyShooter.shooterSwallow();
        //System.out.println("Pressed Shooter Swallow");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){}
}