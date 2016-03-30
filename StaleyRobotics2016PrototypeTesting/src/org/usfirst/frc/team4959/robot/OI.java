package org.usfirst.frc.team4959.robot;

import org.usfirst.frc.team4959.robot.commands.Arm.ClearAngle;
import org.usfirst.frc.team4959.robot.commands.Arm.SetArm;
import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;
import org.usfirst.frc.team4959.robot.commands.Drive.JoystickDrive;
import org.usfirst.frc.team4959.robot.commands.Flipper.LowerFlipper;
import org.usfirst.frc.team4959.robot.commands.Flipper.RaiseFlipper;
import org.usfirst.frc.team4959.robot.commands.Shooter.RunIntake;
import org.usfirst.frc.team4959.robot.commands.Shooter.ShootSequence;
import org.usfirst.frc.team4959.robot.commands.Vision.AutoLineUp;
import org.usfirst.frc.team4959.robot.commands.Vision.AutoSetArm;

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
	
	
	public static Joystick xboxController;
	public static Joystick joystick;
	
	public OI(){
		
	// Xbox Controller
		xboxController = new Joystick(RobotMap.XBOX_PORT);
		
		// lower flipper button
		Button lowerFlipper = new JoystickButton(xboxController, RobotMap.LEFT_BUMPER);
		lowerFlipper.whileHeld(new  LowerFlipper(0.6));
		
		// raise flipper button
		Button raiseFlipper = new JoystickButton(xboxController, RobotMap.RIGHT_BUMPER);
		raiseFlipper.whileHeld(new RaiseFlipper(0.6));
		
		// low power button
		Button lowSpeed = new JoystickButton(xboxController, RobotMap.A_BUTTON);
		lowSpeed.whileHeld(new JoystickDrive(0.7));
		
		
		
	// Joystick
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		// shoot button
		Button shoot = new JoystickButton(joystick, 1);
		shoot.whenPressed(new ShootSequence());
		
		// Intakes button
		Button intake = new JoystickButton(joystick, 2);
		intake.whileHeld(new RunIntake());
		
		// clear arm button
		Button clearAngle = new JoystickButton(joystick, 3);
		clearAngle.whenPressed(new ClearAngle());
		
		// reset encoder button
		Button zeroEncoder = new JoystickButton(joystick, 5);
		zeroEncoder.whenPressed(new ZeroEncoder());
		
		// auto aim
		Button autoAim = new JoystickButton(joystick, 4);
		autoAim.whenPressed(new AutoSetArm());
		
		// auto line up
		Button autoLineUp = new JoystickButton(joystick, 6);
		autoLineUp.whenPressed(new AutoLineUp());
		
		// set arm buttons
		Button setArm30 = new JoystickButton(joystick, 7);
		setArm30.whenPressed(new SetArm(30));
		
		Button setArm45 = new JoystickButton(joystick, 8);
		setArm45.whenPressed(new SetArm(45));

		Button setArm60 = new JoystickButton(joystick, 9);
		setArm60.whenPressed(new SetArm(60));
	
		Button setArm65 = new JoystickButton(joystick, 10);
		setArm65.whenPressed(new SetArm(65));
		
		Button setArm70 = new JoystickButton(joystick, 11);
		setArm70.whenPressed(new SetArm(70));
		
		Button setArm79 = new JoystickButton(joystick, 12);
		setArm79.whenPressed(new SetArm(81));
		
//		Button setServo = new JoystickButton(joystick, 4);
//		setServo.whenPressed(new SetServoSequence());
//		
//		Button setArmLow = new JoystickButton(joystick, 4);
//		setArmLow.whenPressed(new SetArm(1));
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
	public double getJoystickY() {
		return joystick.getRawAxis(RobotMap.JOYSTICK_Y);
	}
}

