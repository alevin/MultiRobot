/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team5507.FalconRecharged2021.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import org.team5507.FalconRecharged2021.robot.subsystems.LimelightPortal;

/**
 * Add your docs here.
 */
public class ReadLimelight extends InstantCommand {

  LimelightPortal ll;
  /**
   * Add your docs here.
   */
  public ReadLimelight(LimelightPortal limel) {
    super();
    ll = limel;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(ll);
  }

  // Called once when the command executes
  @Override
  public void initialize() {

    ll.printLoc();

  }

}
