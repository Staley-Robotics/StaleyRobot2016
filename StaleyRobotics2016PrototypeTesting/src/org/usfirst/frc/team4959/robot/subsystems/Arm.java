package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	SpeedController armTalon = RobotMap.armMotor;
	Encoder armEncoder = RobotMap.armEncoder;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runArm(double power) {
    	armTalon.set(power);
    	System.out.println(getArmPos());
    }
    
    public void stopArm() {
    	armTalon.set(0);;
    }
    
    public double getArmPos() {
    	return armEncoder.getRaw();
    }
    
    public void zeroArmEncoder() {
    	armEncoder.reset();
    }
}

