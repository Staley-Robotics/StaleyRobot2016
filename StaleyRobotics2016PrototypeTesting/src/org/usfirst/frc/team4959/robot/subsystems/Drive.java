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
    
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void yoloDrive(double left, double right) {
    	drive.tankDrive(-left, -right);
    }
    
    public void worldOfTanksDrive(double forward, double backward, double rotate) {
    	if(backward > 0) {
    		drive.arcadeDrive(-backward, rotate);
    	} else if (forward > 0) {
    		drive.arcadeDrive(forward, -rotate);
    	} else {
    		drive.arcadeDrive(0, -rotate);
    	}
    }
    
    public void stopDrive(){
    	drive.drive(0, 0);
    }
    
}

