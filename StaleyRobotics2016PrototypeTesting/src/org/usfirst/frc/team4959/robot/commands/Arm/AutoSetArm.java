package org.usfirst.frc.team4959.robot.commands.Arm;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AutoSetArm extends Command {
	private double displacement;
	private double angle;
	private double blob;
	private double center;

    public AutoSetArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double buffer = 10;
//    	boolean cheack = false;
//    	displacement = NetworkTable.getTable("SmartDashboard").getNumber("displacement", 0.0);
    	center = NetworkTable.getTable("SmartDashboard").getNumber("Center", 0.0);
    	blob = NetworkTable.getTable("SmartDashboard").getNumber("Blob", 0.0);
    	angle = Math.abs(Robot.arm.getArmPos());
    	
    	displacement = (blob - center);
    	
//    	System.out.println("Blob: " + blob);
//    	System.out.println("Center: " + center);
//    	System.out.println("Diff" + (blob - center));
    	
    	if (displacement < buffer && displacement > -buffer ) {
    		Robot.arm.goToAngle(angle, 0.0);
//    		cheack = true;
    	}
    	else if (displacement > buffer) {
    		angle += 1;
    		Robot.arm.goToAngle(angle, .3);
    		System.out.println("Going up displacement");
    	}
    	else if (displacement < -buffer) {
    		angle -= 1;
    		Robot.arm.goToAngle(angle, .1);
    		System.out.println("Going down displacement");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if (displacement < 5.0 && displacement > -5.0) {
//    		return true;
//    	} else {
//        return false;
//    	}
    	return Robot.shooter.getTest();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setShooting(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
