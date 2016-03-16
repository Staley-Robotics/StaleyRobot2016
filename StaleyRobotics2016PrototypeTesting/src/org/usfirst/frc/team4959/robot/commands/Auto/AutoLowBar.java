package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.SetArm;
import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;
import org.usfirst.frc.team4959.robot.commands.Shooter.RunShooterButton;
import org.usfirst.frc.team4959.robot.commands.Shooter.ShootSequence;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowBar extends CommandGroup {
    
    public  AutoLowBar() {
    	// drive forward for (speed, time)
    	addParallel(new ZeroEncoder());
    	addSequential(new DriveFoward(0.8, 4));
    }
}
