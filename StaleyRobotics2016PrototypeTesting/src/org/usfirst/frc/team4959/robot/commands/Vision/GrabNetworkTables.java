package org.usfirst.frc.team4959.robot.commands.Vision;

import java.util.logging.Level;
import java.util.logging.Logger;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/*
 * It still don't work ¯\_(ツ)_/¯
 */
public class GrabNetworkTables {
	
	double imageCount;
	boolean connect;
	
	public static void main(String [] args) {
		new GrabNetworkTables().run();
	}
	
	public void run() {
//		NetworkTable.setTeam(4959);
//		NetworkTable.setClientMode();
//		NetworkTable.setIPAddress("roborio-4959-FRC.local");
//		NetworkTable.setPort(1735);
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(GrabNetworkTables.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			connect =  table.isConnected();
			imageCount = table.getNumber("Blob", 0.0);
			System.out.println("Image Count: " + imageCount);
			System.out.println(connect);
		}
	}
}