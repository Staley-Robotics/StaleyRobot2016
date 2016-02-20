package org.usfirst.frc.team4959.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Drive.JoystickDrive;

/**
 *  Tyler sucks @ building!
 */
public class Drive extends Subsystem {

    RobotDrive drive = RobotMap.driveTrain;
    double angle;
    
    SpeedController fl = RobotMap.flDriveMotor;
    SpeedController bl = RobotMap.blDriveMotor;
    SpeedController fr = RobotMap.frDriveMotor;
    SpeedController br = RobotMap.brDriveMotor;
    
    
    public Drive() {
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive(1));
    }
    
    public void worldOfTanksDrive(double forward, double backward, double rotate) {
    	double speedModifier = 1;
    	double turnSpeedModifier = 1;
    	
    	if(backward * speedModifier > 0) {
    		drive.arcadeDrive(-backward * speedModifier, rotate * turnSpeedModifier);
    	} else if (forward > 0) {
    		drive.arcadeDrive(forward * speedModifier, -rotate * turnSpeedModifier);
    	} else {
    		drive.arcadeDrive(0, -rotate * turnSpeedModifier);
    	}
    }
    
    public void tankDrive(double left, double right) {
    	drive.tankDrive(left, right);
    }
    
    public void testDrive(double left, double right) {
    	fl.set(left * 1);
    	bl.set(left * 0.9);
    	
    	fr.set(right);
    	br.set(right * 0.98);
    }
    
    public void stopDrive(){
    	drive.drive(0, 0);
    }
    
    public void turn(double turn) {
    	drive.tankDrive(turn, -turn);
    }
    
    public void driveStraight(double move) {
    	drive.tankDrive(move, move);
    }
}

