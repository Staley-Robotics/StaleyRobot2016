package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Delay;
import org.usfirst.frc.team4959.robot.commands.Arm.SetArm;
import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRoughTerrain extends CommandGroup {
    
    public  AutoRoughTerrain() {
    	addSequential(new ZeroEncoder());
    	addParallel(new SetArm(35));
    	addSequential(new DriveFoward(0.8, 5.3));
    }
}
