package org.usfirst.frc.team4959.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
//******************************Constants******************************\\
	
	
	// Controllers
	public static final int XBOX_PORT = 0;
	public static final int JOYSTICK_PORT = 1;
	
	public static final int LEFT_X_AXIS = 0;
	public static final int LEFT_Y_AXIS = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_X_AXIS = 4;
	public static final int RIGHT_Y_AXIS = 5;
	
	public static final int RIGHT_BUMPER = 5;
	public static final int LEFT_BUMPER = 6;
	
	public static final int A_BUTTON = 1;
	
	public static final int JOYSTICK_Y = 1;
	
	
	// Ports
	public static final int FRONT_LEFT_DRIVE_MOTOR_PORT = 1;
	public static final int BACK_LEFT_DRIVE_MOTOR_PORT = 2;
	public static final int FRONT_RIGHT_DRIVE_MOTOR_PORT = 3;
	public static final int BACK_RIGHT_DRIVE_MOTOR_PORT = 4;
	
	public static final int LEFT_SHOOTER_MOTOR_PORT = 5;
	public static final int RIGHT_SHOOTER_MOTOR_PORT = 6;
		
	public static final int ARM_MOTOR_PORT = 7;
	
	public static final int FLIPPER_MOTOR_PORT = 8;
	
	public static final int SERVO_PORT = 9;
	
	public static final int ARM_ENCODER_PORT_ONE = 0;
	public static final int ARM_ENCODER_PORT_TWO = 1;
	
	public static final int SHOOTER_LIMIT_SWITCH_PORT = 3;
	
	public static final int FLIPPER_LIMIT_SWITCH_PORT = 4;
		


//******************************Objects and Initializations******************************\\
		
		
	// Drivetrain
	public static SpeedController flDriveMotor = new Talon(FRONT_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController blDriveMotor = new Talon(BACK_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController frDriveMotor = new Talon(FRONT_RIGHT_DRIVE_MOTOR_PORT);
	public static SpeedController brDriveMotor = new Talon(BACK_RIGHT_DRIVE_MOTOR_PORT);
		
	public static RobotDrive driveTrain = new RobotDrive(flDriveMotor, blDriveMotor, frDriveMotor, brDriveMotor);
	
		
	// Shooter
	public static SpeedController leftShooterMotor = new Talon(LEFT_SHOOTER_MOTOR_PORT);
	public static SpeedController rightShooterMotor = new Talon(RIGHT_SHOOTER_MOTOR_PORT);
		
	public static Encoder armEncoder = new Encoder(ARM_ENCODER_PORT_ONE, ARM_ENCODER_PORT_TWO, false, Encoder.EncodingType.k4X);
	
	public static Servo servo = new Servo(SERVO_PORT);
	
	
	// Arm
	public static DigitalInput shooterLimitSwitch = new DigitalInput(SHOOTER_LIMIT_SWITCH_PORT);
	public static SpeedController armMotor = new Talon(ARM_MOTOR_PORT);
	
	
	// Flipper
	public static SpeedController flipperMotor = new Talon(FLIPPER_MOTOR_PORT);
	public static DigitalInput flipperLimitSwitch = new DigitalInput(FLIPPER_LIMIT_SWITCH_PORT);
	
	
		
	public static void init(){		
    	driveTrain.setSafetyEnabled(false);
    	driveTrain.setExpiration(0.1);
    	driveTrain.setSensitivity(0.5);
    	driveTrain.setMaxOutput(1);
   

    	LiveWindow.addActuator("Arm", "arm motor", (LiveWindowSendable) armMotor);
    	LiveWindow.addSensor("Arm", "arm encoder", armEncoder);
    	
 	}
}
