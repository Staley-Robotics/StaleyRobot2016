package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.SetArm;
import org.usfirst.frc.team4959.robot.commands.Shooter.RunShooterButton;
import org.usfirst.frc.team4959.robot.commands.Shooter.ShootSequence;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowBar extends CommandGroup {
    
    public  AutoLowBar() {
    	// drive forward for (speed, time)
    	addSequential(new DriveFoward(.7, 2));
    	addSequential(new DriveFoward(.5, 3));
    	// turn for (speed, time)
    	addSequential(new Turn(.5, .5));
    	// set arm to (angle)
    	addSequential(new SetArm(60));
    	addSequential(new ShootSequence());
    }
}
