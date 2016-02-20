package org.usfirst.frc.team4959.robot.commands.Vision;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

public final class RobotComm {

    /**
     * Flag set if we happen to be interrupted.
     */
    private boolean _Interrupted;

    /**
     * Used when you want to communicate using the SmartDashboard fields.
     */
    private NetworkTable _SmartDashboard;

    /**
     * The key to use to control a smart dashboard command.
     */
    private static final String ENABLE_COMMAND_KEY = "running";

    /**
     * Constructs a new instance of the object associated with a specific IP
     * address.
     *
     * @param ipAddr The IP address of the cRIO unit on your robot (10.xx.xx.2
     * where xx.xx comes from your team number).
     */
    public RobotComm(String ipAddr) {
        _Interrupted = false;
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress(ipAddr);
        _SmartDashboard = NetworkTable.getTable("SmartDashboard");
    }

    /**
     * Returns access to the NetworkTable associated with the SmartDashboard
     * values.
     *
     * <p>
     * You can use this table to set/get values within the SmartDashboard. NOTE:
     * Use the TableViewer utility to examine the keys/values currently
     * available from your robot. Look for the TableViewer JAR file to launch
     * this tool in your sunspotfrcsdk/tools directory.</p>
     *
     * @return The NetworkTable where the SmartDashboard holds it key/value
     * pairs.
     */
    public NetworkTable getSmartDashboard() {
        return _SmartDashboard;
    }

    /**
     * Starts a SmartDashboard command.
     *
     * <p>
     * This method attempts to start a smart dashboard command (as if user press
     * the button on the smart dashboard).</p>
     *
     * @param key The name of the SmartDashboard command to start (typically the
     * label that appears on the button on the smart dashboard).
     */
    public void startSmartDashboardCommand(String key) {
        getCommand(key).putBoolean(ENABLE_COMMAND_KEY, true);
    }

    /**
     * Cancels (interrupts) a SmartDashboard command.
     *
     * <p>
     * This method attempts to start a smart dashboard command (as if user press
     * the button in the cancel state on the smart dashboard).</p>
     *
     * @param key The name of the SmartDashboard command to start (typically the
     * label that appears on the button on the smart dashboard).
     */
    public void cancelSmartDashboardCommand(String key) {
        getCommand(key).putBoolean(ENABLE_COMMAND_KEY, false);
    }

    /**
     * Helper method to get the table of values associated with with a
     * SmartDashboard command.
     *
     * @param key The key (name) associated with the command.
     *
     * @return The table of values associated with the key.
     */
    private ITable getCommand(String key) {
        return getSmartDashboard().getSubTable(key);
    }

    /**
     * Returns true if we were ever interrupted while sleeping.
     *
     * @return true if we've been interrupted, false if not.
     */
    public boolean interrupted() {
        return _Interrupted;
    }

    /**
     * Sleeps for the specified amount of time (unless interrupted).
     *
     * @param millis Number of milliseconds to sleep/delay. Note, we may sleep
     * less than this if the thread is interrupted.
     */
    public void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            _Interrupted = true;
        }
    }
}
