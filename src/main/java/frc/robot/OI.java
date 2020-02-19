//Imports fot the OI
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



public class OI
{
    //Declare and initialize all input devices
    public static Joystick leftJoystick = new Joystick(RobotMap.LEFTJOYSTICKPORT);
    public static Joystick rightJoystick = new Joystick(RobotMap.RIGHTJOYSTICKPORT);

    public static JoystickButton rightTrigger = new JoystickButton(rightJoystick, 1);
    public static JoystickButton leftTrigger = new JoystickButton(leftJoystick, 1);

    public static JoystickButton leftThumbButton = new JoystickButton(leftJoystick, 2);
    public static JoystickButton rightThumbButton = new JoystickButton(rightJoystick, 2);

    public static JoystickButton leftMidButton = new JoystickButton(leftJoystick, 3);
    public static JoystickButton rightMidButton = new JoystickButton(rightJoystick, 3);

    public static JoystickButton leftLeftButton = new JoystickButton(leftJoystick, 4);
    public static JoystickButton rightLeftButton = new JoystickButton(rightJoystick, 4);
    
    public static HazyController controller = new HazyController(RobotMap.CONTROLLERPORT);
    

    public OI(){
        //Set commands to run on button press for the XBOX Controller - Operator
        //We need to talk with the Operator to see how they want this laid out
        controller.getXButton().whenPressed(Robot.commandFold); //Whenever this button is pushed the color arm is either dropped or pulled up

        controller.getBButton().whenPressed(Robot.commandDropIntake); //Whenever this button is pushed the intake is dropped or pulled up

        controller.getAButton().whenPressed(Robot.commandGoToColor);//Whenever this button is pushed it will go to the color based on the number of times the button has been previously pressed

        controller.getYButton().whenPressed(Robot.commandSpinWheel);//When this button is pushed it will spin the disk a predeignated amount

        controller.getLeftBumper().whileHeld(Robot.commandEndArmUp); //Will run the execute on the command only when the button is being held down

        controller.getRightBumper().whileHeld(Robot.commandEndArmDown);//Switches the direction of which the end arm motor is rotating

        //Set commands to run on the Joysticks - Driver 
        rightTrigger.whenPressed(Robot.commandSwallowIntake); //Will allow the driver to swallow with the intake whenever the button is pushed

        leftTrigger.whenPressed(Robot.commandSpitIntake); //Will allow the driver to spit with the intake whenever the button is pushed

        if(controller.getHazyTriggers().getLeftAxis()){ //Shoots the ball with the bottom right trigger
            Robot.commandShooterSpit.execute();
        }

        if(controller.getHazyTriggers().getRightAxis()){ //Sucks the ball in with bottom left trigger
            Robot.commandShooterSwallow.execute();
        }

    }
    
    //Getter methods for all our input devices
    public static double getControllerLeftX()
    {
        return controller.getHazyJoysticks().getLeftXAxis();
    }

    public static double getControllerLeftY()
    {
        return controller.getHazyJoysticks().getLeftYAxis();
    }

    public static double getControllerRightX()
    {
        return controller.getHazyJoysticks().getRightXAxis();
    }

    public static double getControllerRightY()
    {
        return controller.getHazyJoysticks().getRightYAxis();   
    }
    
    public static double getLeftX(){
        return leftJoystick.getX();
    }

    public static double getLeftY(){
        return leftJoystick.getY();
    }

    public static double getRightX(){
        return rightJoystick.getX();
    }

    public static double getRightY(){
        return rightJoystick.getY();
    }
}

    




    