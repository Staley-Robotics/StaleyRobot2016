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
	public static SpeedController lDriveMotor;
	public static SpeedController rDriveMotor;
	//Above are my two drive motors
	public static RobotDrive driveTrain;
	
	
	public static void init(){
		lDriveMotor = new Talon(1);
		rDriveMotor = new Talon(2);
		driveTrain = new RobotDrive(lDriveMotor, rDriveMotor);

    	driveTrain.setSafetyEnabled(true);
    	driveTrain.setExpiration(0.1);
    	driveTrain.setSensitivity(0.5);
    	driveTrain.setMaxOutput(1);
	}
}
