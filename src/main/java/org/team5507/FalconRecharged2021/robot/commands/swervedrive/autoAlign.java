/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team5507.FalconRecharged2021.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team5507.FalconRecharged2021.robot.subsystems.Drive.SwerveDriveSubsystem;


public class autoAlign extends CommandBase {
  private SwerveDriveSubsystem swerveDriveSubsystem;
  
  /**
   * Creates a new autoAlign.
   */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    swerveDriveSubsystem.setFieldOriented(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {
  //   limelight.align();
  // }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // limelight.resetErrs();
    swerveDriveSubsystem.setFieldOriented(true);
  }

  // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return limelight.isAligned();
//   }
 }
