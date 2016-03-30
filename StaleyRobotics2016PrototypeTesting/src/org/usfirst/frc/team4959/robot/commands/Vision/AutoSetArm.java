package org.usfirst.frc.team4959.robot.commands.Vision;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AutoSetArm extends Command {
	private double height;

	public AutoSetArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	height = NetworkTable.getTable("SmartDashboard").getNumber("BlobHeight", 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (height > 27) {
    		System.out.println("height = 28 or greater. Going to angle 80");
    		Robot.arm.goToAngle(80, .4);
    	} else if (height > 25) {
    		System.out.println("height = 26 or 27. Going to angle 80");
    		Robot.arm.goToAngle(75, .4);
    	} else if (height > 23) {
    		System.out.println("height = 24 or 25. Going to angle 80");
    		Robot.arm.goToAngle(70, .4);
    	} else if (height > 21) {
    		System.out.println("height = 22 or 23. Going to angle 80");
    		Robot.arm.goToAngle(65, .4);
    	} else if (height > 19) {
    		System.out.println("height = 20 or 21. Going to angle 80");
    		Robot.arm.goToAngle(60, .4);
    	} else if(height == 0) {
    		System.out.println("Not picking up blob, and or broken table!");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	return Robot.shooter.checkForShooting();
    	return true;
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
