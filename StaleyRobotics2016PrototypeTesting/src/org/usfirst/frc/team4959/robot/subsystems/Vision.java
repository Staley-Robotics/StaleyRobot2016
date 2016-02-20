package org.usfirst.frc.team4959.robot.subsystems;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Vision.RobotComm;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *  It don't work ¯\_(ツ)_/¯
 */
public class Vision extends Subsystem {
	
//	NetworkTable server;
//	
//	public Vision() {
//		server = NetworkTable.getTable("SmartDashboard");
//	}
//	
//	public void printImageCount() {
//		try {
//			double imageCount = server.getNumber("IMAGE_COUNT", 0.0);
//			
//			System.out.println(imageCount);
//		}
//		catch(TableKeyNotDefinedException exp) {
//		}
//	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

