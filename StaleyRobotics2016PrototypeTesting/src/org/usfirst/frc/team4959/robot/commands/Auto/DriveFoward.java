package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveFoward extends Command {
	
	public static Timer TIMER = new Timer();
	
	RobotDrive drive = RobotMap.driveTrain;
	
	double speed;
	double time;

    public DriveFoward(double speed1, double time1) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = speed1;
    	time = time1;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	TIMER.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(speed);
    	System.out.println("Drive Forward");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (TIMER.get() < time) {
    		return false;
    	} else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	TIMER.stop();
    	TIMER.reset();
    	Robot.drive.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
