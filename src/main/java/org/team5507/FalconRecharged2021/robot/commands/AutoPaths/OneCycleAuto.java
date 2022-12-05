/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team5507.FalconRecharged2021.robot.commands.AutoPaths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import org.team5507.FalconRecharged2021.robot.DaphneTwoConstants;
import org.team5507.FalconRecharged2021.robot.TrajectoryHelper;
import org.team5507.FalconRecharged2021.robot.commands.swervedrive.AutoRotate;
import org.team5507.FalconRecharged2021.robot.commands.swervedrive.Autonomous;
import org.team5507.FalconRecharged2021.robot.commands.swervedrive.GoToDistance;
import org.team5507.FalconRecharged2021.robot.subsystems.Drive.SwerveDriveSubsystem;
import org.team5507.FalconRecharged2021.robot.utility.TrajectoryMaker;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class OneCycleAuto extends SequentialCommandGroup {
  /**
   * Creates a new OneCycleAuto.
   */
  public OneCycleAuto(SwerveDriveSubsystem swerveDriveSubsystem, int inputRPM, double delayInSeconds) {
    // Start at Initiation Line
    // This is all theoretical code with no actual field measurements. 
    // MAKE SURE TO MEASURE AND SWAP VALUES BEFORE TESTING - Kyle
    /**
     * 
     * The Robot starts at the initiation line.
     * 
     * 
     * 
     */


    TrajectoryMaker traj = TrajectoryHelper.createLineToTargetZone();
    TrajectoryMaker trajBack = TrajectoryHelper.createTargetZoneToLine();
    addCommands(
      new WaitCommand(delayInSeconds),
      new Autonomous(swerveDriveSubsystem, traj.getTrajectory(), traj.getAngle(), true),
      new Autonomous(swerveDriveSubsystem, trajBack.getTrajectory(), trajBack.getAngle(), false)
    );
  }
}
