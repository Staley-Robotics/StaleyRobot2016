
package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.RunShooter;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
     
	SpeedController shooterMotor = RobotMap.shooterMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void runShooter(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stopShooter() {
    	shooterMotor.set(0);
    }
}

