
package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.RunShooter;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
     
	SpeedController leftMotor = RobotMap.leftShooterMotor;
	SpeedController rightMotor = RobotMap.rightShooterMotor;
	Servo servo = RobotMap.servo;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void runShooter(double speed) {
    	leftMotor.set(speed);
    	rightMotor.set(speed);
    }
    
    public void stopShooter() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    }
    
    public void setServo(double angle) {
    	servo.setAngle(angle);
    }
}

