//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class CommandColorArmDefault extends Command {

    public CommandColorArmDefault(){
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize(){}

    @Override
    protected void execute(){ 
        // String gameData = DriverStation.getInstance().getGameSpecificMessage();
        
        // if (gameData.length() > 0) {
        //     Robot.hazyColorArm.goToColor(gameData.charAt(0));
        // }

        Robot.hazyColorArm.goToColor('B');
        Robot.hazyColorArm.spinWheel(4);
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}