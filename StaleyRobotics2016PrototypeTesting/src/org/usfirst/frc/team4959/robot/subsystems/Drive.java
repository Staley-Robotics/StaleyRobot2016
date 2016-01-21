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
	
    SpeedController lDrive = RobotMap.lDriveMotor;
    SpeedController rDrive = RobotMap.rDriveMotor;
    
    Gyro gyro = RobotMap.gyro;
    
    RobotDrive drive = RobotMap.driveTrain;
    
    public Drive() {
    	gyro.reset();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void yoloDrive(double speed) {
//    	drive.tankDrive(-speed, -speed);
    	drive.tankDrive(speed, speed);
    }
    
    public void stopDrive(){
    	drive.drive(0, 0);
    }
    
    public double getAngle() {
    	return gyro.getAngle();
    }
    
    public double getRotationRate() {
    	return gyro.getRate();
    }
    
}

