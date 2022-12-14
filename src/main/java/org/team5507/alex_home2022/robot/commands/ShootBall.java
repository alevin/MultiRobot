// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.alex_home2022.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team5507.alex_home2022.robot.Constants;
import org.team5507.alex_home2022.robot.subsystems.Shooter;

public class ShootBall extends CommandBase {
  Shooter shooter;

  /** Creates a new ShootBall. */
  public ShootBall(Shooter s) {
    shooter = s;
    addRequirements(shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   shooter.shootBall(Constants.SHOOTER_SPEED);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
