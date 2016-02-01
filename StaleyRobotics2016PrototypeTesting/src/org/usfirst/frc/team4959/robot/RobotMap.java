package org.usfirst.frc.team4959.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
//******************************Constants******************************\\
	
	
	// Controller
	public static final int XBOX_PORT = 0;
	public static final int JOYSTICK_PORT = 1;
	
	public static final int LEFT_X_AXIS = 0;
	public static final int LEFT_Y_AXIS = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_X_AXIS = 4;
	public static final int RIGHT_Y_AXIS = 5;
	
	// Joystick
	public static final int BUTTON_ONE = 1;
	public static final int BUTTON_TWO = 2;
	public static final int BUTTON_THREE = 3;
	public static final int BUTTON_FOUR = 4;
	
	
	// Ports
	public static final int LEFT_DRIVE_MOTOR_PORT = 1;
	public static final int RIGHT_DRIVE_MOTOR_PORT = 2;
	public static final int LEFT_SHOOTER_MOTOR_PORT = 3;
	public static final int RIGHT_SHOOTER_MOTOR_PORT = 4;
	public static final int SHOOTER_PUSHER_MOTOR_PORT = 6;
	public static final int ARM_MOTOR_PORT = 5;
	public static final int ARM_ENCODER_PORT_ONE = 0;
	public static final int ARM_ENCODER_PORT_TWO = 1;
	public static final int LIMIT_SWITCH_PORT = 3;


//******************************Objects and Initializations******************************\\
		
		
	// Drivetrain
	public static SpeedController lDriveMotor = new Talon(LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController rDriveMotor = new Talon(RIGHT_DRIVE_MOTOR_PORT);
		
	public static RobotDrive driveTrain = new RobotDrive(lDriveMotor, rDriveMotor);

		
	// Shooter
	public static SpeedController leftShooterMotor = new Talon(LEFT_SHOOTER_MOTOR_PORT);
	public static SpeedController rightShooterMotor = new Talon(RIGHT_SHOOTER_MOTOR_PORT);
	public static SpeedController shooterPusherMotor = new Talon(SHOOTER_PUSHER_MOTOR_PORT);
	public static DigitalInput limitSwitch = new DigitalInput(LIMIT_SWITCH_PORT);
	public static Encoder armEncoder = new Encoder(ARM_ENCODER_PORT_ONE, ARM_ENCODER_PORT_TWO);
	public static SpeedController armMotor = new Talon(ARM_MOTOR_PORT);
		
		
	public static void init(){		
    	driveTrain.setSafetyEnabled(true);
    	driveTrain.setExpiration(0.1);
    	driveTrain.setSensitivity(0.5);
    	driveTrain.setMaxOutput(1);
    	    	    	
//    	armEncoder.setMaxPeriod(.1);
//    	armEncoder.setMinRate(10);
//    	armEncoder.setDistancePerPulse(5);
//    	armEncoder.setReverseDirection(false);
//    	armEncoder.setSamplesToAverage(7);
 	}
}
