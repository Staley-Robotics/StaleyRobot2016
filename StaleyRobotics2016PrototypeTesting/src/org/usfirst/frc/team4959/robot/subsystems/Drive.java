package org.usfirst.frc.team4959.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.JoystickDrive;

/**
 *  Tyler sucks @ building!
 */
public class Drive extends Subsystem {

    RobotDrive drive = RobotMap.driveTrain;
    Gyro gyro = RobotMap.gyro;
    double angle;
    
    public Drive() {
    	gyro.calibrate();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void yoloDrive(double left, double right) {
    	drive.tankDrive(-left, -right);
    }
    
    public void worldOfTanksDrive(double forward, double backward, double rotate) {
    	double speedModifier = 0.8;
    	double turnSpeedModifier = 0.5;
    	
    	if(backward * speedModifier > 0) {
    		drive.arcadeDrive(-backward * speedModifier, rotate * turnSpeedModifier);
    	} else if (forward > 0) {
    		drive.arcadeDrive(forward * speedModifier, -rotate * turnSpeedModifier);
    	} else {
    		drive.arcadeDrive(0, -rotate * turnSpeedModifier);
    	}
    }
    
    public void stopDrive(){
    	drive.drive(0, 0);
    }
    
    public double getGyroAngle() {
    	double angle = gyro.getAngle() * 100;
    	System.out.println(angle);
    	return Math.abs(angle);
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public void turnRightAngle(double angle) {
    	double rotationSpeed = 0.6;
    	drive.arcadeDrive(0, rotationSpeed);
    }
}

