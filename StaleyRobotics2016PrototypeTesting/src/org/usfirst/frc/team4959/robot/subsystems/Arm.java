package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.PIDSpeedController;
import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	SpeedController motor = RobotMap.armMotor;
	Encoder encoder = RobotMap.armEncoder;
	PIDSpeedController pid;
	
	public Arm() {
		encoder.setPIDSourceType(PIDSourceType.kRate);
		pid = new PIDSpeedController(encoder, motor, "Arm", "Speed Control");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void goToAngle(double angle, double power) {
    	System.out.println("Angle: " + getArmPos());

    	if(getArmPos() > angle) {
    		runArm(-power * 1.5);
    		System.out.println("going down");
    	} else if(getArmPos() < angle) {
    		runArm(power);
    		System.out.println("going up");
    	}
    }
    
    public double getArmPos() {
    	double clicksPerRotation = 214.5;
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
    
    public void stopArm() {
    	motor.set(0);
    }
}

