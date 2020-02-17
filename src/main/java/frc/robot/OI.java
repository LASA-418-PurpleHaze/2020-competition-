package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;



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
        controller.getXButton().whenPressed(new FoldCommand());

        controller.getYButton().whenPressed(new DropIntakeCommand());

        controller.getAButton().whenPressed(new GoToColorCommand());

        controller.getBButton().whenPressed(new SpinWheelCommand());

        controller.getLeftBumper().whileHeld(new EndArmCommand());

        //Set commands to run on the Joysticks - Driver 
        rightTrigger.whenPressed(new SwallowIntakeCommand());
        leftTrigger.whenPressed(new SpitIntakeCommand());

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

    




    