//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class ShooterSwallowCommand extends Command {

    public ShooterSwallowCommand()
    {
        super.requires(Robot.hazyShooter);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyShooter.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyShooter.shooterSwallow();
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted(){}
}