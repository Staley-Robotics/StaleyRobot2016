package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	SpeedController motor = RobotMap.armMotor;
	Encoder encoder = RobotMap.armEncoder;
	
	Servo servo = RobotMap.servo;

		
	public Arm() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void goToAngle(double angle, double power) {
    	double buffer = 5;
    	
    	System.out.println("Angle: " + getArmPos());
    	
    	double desiredAngle = Math.abs(getArmPos());

    	if((desiredAngle < angle + buffer) && (desiredAngle > angle - buffer)){
    		runArm(0);
    	} else if(desiredAngle > angle - buffer) {
    		runArm(power);
    		System.out.println("going down");
    	} else if(desiredAngle < angle + buffer) {
    		runArm(-power);
    		System.out.println("going up");
    	}
    }
    
    public double getArmPos() {
    	double clicksPerRotation = 480;
//    	double clicksPerRotation = 214.5;
    	double conversionFactor = clicksPerRotation / 360;
    	
    	double clicks = encoder.getDistance();
    	clicks = (clicks / clicksPerRotation) - (int)(clicks / clicksPerRotation);
    	return  (clicks * clicksPerRotation) / conversionFactor;
    }
    
    public void resetEncoder() {
    	encoder.reset();
    }
    
    public void runArm(double power) {
    	motor.set(power);
    }
    
    public void setServo(double angle) {
    	servo.set(angle);
    }
}

