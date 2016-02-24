package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Arm.ControlArmWithJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Arm extends Subsystem {
	
	SpeedController motor = RobotMap.armMotor;
	Encoder encoder = RobotMap.armEncoder;
		
	public Arm() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ControlArmWithJoysticks());
    }
    
    public void goToAngle(double desiredAngle, double power) {
    	double buffer = 0.5;
    	
    	System.out.println("Angle: " + getArmPos());
    	
    	double angle = Math.abs(getArmPos());

    	if((angle > desiredAngle - buffer) && (angle < desiredAngle + buffer)){
    		runArm(-0.1);
//    		runArm(0);
    		System.out.println("Not going angle");
    	} else if(angle > desiredAngle - buffer) {
    		runArm(power);
    		System.out.println("going down angle");
    	} else if(angle < desiredAngle + buffer) {
    		runArm(-power);
    		System.out.println("going up angle");
    	}
    }
    
    public double getArmPos() {
    	double clicksPerRotation = 1572;
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
    
    public void printAngle() {
    	System.out.println(getArmPos());
    }
}

