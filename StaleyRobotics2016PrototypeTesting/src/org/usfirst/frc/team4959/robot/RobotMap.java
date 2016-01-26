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
	
	
	// Ports
	public static final int LEFT_DRIVE_MOTOR = 1;
	public static final int RIGHT_DRIVE_MOTOR = 2;
	public static final int SHOOTER_MOTOR = 3;
	public static final int INTAKE_MOTOR = 4;


//******************************Objects and Initializations******************************\\
		
		
	// Drivetrain
	public static SpeedController lDriveMotor = new Talon(LEFT_DRIVE_MOTOR);
	public static SpeedController rDriveMotor = new Talon(RIGHT_DRIVE_MOTOR);
		
	public static RobotDrive driveTrain = new RobotDrive(lDriveMotor, rDriveMotor);

		
	// Shooter
	public static SpeedController shooterMotor = new Talon(SHOOTER_MOTOR);
		
		
	// Intake
	public static SpeedController intakeMotor = new Talon(INTAKE_MOTOR);
		
		
	public static void init(){		
    	driveTrain.setSafetyEnabled(true);
    	driveTrain.setExpiration(0.1);
    	driveTrain.setSensitivity(0.5);
    	driveTrain.setMaxOutput(1);
 	}
}
