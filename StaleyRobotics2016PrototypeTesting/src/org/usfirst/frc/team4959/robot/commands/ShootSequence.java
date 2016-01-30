package org.usfirst.frc.team4959.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootSequence extends CommandGroup {
	
	private static final double RUN_SHOOTER_TIME = 5;
	private static final double DELAY_TIME = 2;
    
    public  ShootSequence() {
    	addParallel(new RunShooterButton(RUN_SHOOTER_TIME));
    	addSequential(new Delay(DELAY_TIME));
    }
}
