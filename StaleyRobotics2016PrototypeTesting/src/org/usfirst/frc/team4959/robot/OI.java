package org.usfirst.frc.team4959.robot;

import org.usfirst.frc.team4959.robot.commands.RunIntake;
import org.usfirst.frc.team4959.robot.commands.RunIntakeButton;
import org.usfirst.frc.team4959.robot.commands.RunShooter;
import org.usfirst.frc.team4959.robot.commands.RunShooterButton;
import org.usfirst.frc.team4959.robot.commands.SetArm;
import org.usfirst.frc.team4959.robot.commands.ShootSequence;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	public Joystick xboxController;
	public Joystick joystick;
	
	public OI(){
		
	// Xbox Controller
		xboxController = new Joystick(RobotMap.XBOX_PORT);
		
		
	// Joystick
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		
	// shoot button
		Button shoot = new JoystickButton(joystick, RobotMap.BUTTON_ONE);
		shoot.whileHeld(new RunShooter());
//		shoot.whenPressed(new RunShooterButton(3));
		
	// intake button
		Button intake = new JoystickButton(joystick, RobotMap.BUTTON_TWO);	
		intake.whileHeld(new RunIntake());
		
	// set arm button
		Button setArm = new JoystickButton(joystick, RobotMap.BUTTON_THREE);
		setArm.whenPressed(new SetArm());
		
	}
	
	// xbox controller left joystick
	public double getLeftStickX() {
		return xboxController.getRawAxis(RobotMap.LEFT_X_AXIS);
	}
	public double getLeftStickY() {
		return xboxController.getRawAxis(RobotMap.LEFT_Y_AXIS);
	}
	
	// xbox controller right joystick
	public double getRightStickX() {
		return xboxController.getRawAxis(RobotMap.RIGHT_X_AXIS);
	}
	public double getRightStickY() {
		return xboxController.getRawAxis(RobotMap.RIGHT_Y_AXIS);
	}
	
	// xbox controller triggers
	public double getLeftTrigger() {
		return xboxController.getRawAxis(RobotMap.LEFT_TRIGGER);
	}
	public double getRightTrigger() {
		return xboxController.getRawAxis(RobotMap.RIGHT_TRIGGER);
	}
	
	// joystick
	
}

