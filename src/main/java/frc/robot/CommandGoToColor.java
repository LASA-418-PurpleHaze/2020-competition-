//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class CommandGoToColor extends Command {

    public CommandGoToColor(){
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();
        // Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute(){ 
        // String gameData = DriverStation.getInstance().getGameSpecificMessage();
        
        // if (gameData.length() > 0) {
        //     Robot.hazyColorArm.goToColor(gameData.charAt(0));
        // }

        Robot.hazyColorArm.goToColor('B');
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}