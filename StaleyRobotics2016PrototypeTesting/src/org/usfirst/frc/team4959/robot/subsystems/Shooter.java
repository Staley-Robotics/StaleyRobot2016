
package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Shooter.RunShooterButton;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
     
	SpeedController leftMotor = RobotMap.leftShooterMotor;
	SpeedController rightMotor = RobotMap.rightShooterMotor;
			
	private boolean check;
	private boolean test;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void runShooter(double speed) {
    	leftMotor.set(-speed);
    	rightMotor.set(speed);
    }
    
    public void stopShooter() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    }
    
    public boolean checkForShooting() {
    	return check;
    }
    
    public void setShooting(boolean isShooting) {
    	check = isShooting;
    }
    
    public boolean getTest() {
    	return test;
    }
    
    public void setTest(boolean sTest) {
    	test = sTest;
    }

}

