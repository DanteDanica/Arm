// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class ExampleSubsystem extends SubsystemBase {
  private CANSparkMax motor;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor=new CANSparkMax(OperatorConstants.MOTOR_ID,MotorType.kBrushless);
    setDefaultCommand(stopMotorsCommand());
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command runMotor(double speed) {
    return new RunCommand(()->{
      motor.set(OperatorConstants.ARM_SPEED);
    },this);
  }
  public Command stopMotorsCommand() {
    return new RunCommand(() -> {
        motor.set(0);
    }, this);
  }
  public Command retractMotor(){
    return new RunCommand(()->{
      motor.set(-OperatorConstants.ARM_SPEED);
    },this);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //to smartdash,board
    SmartDashboard.putNumber("Motor Speed", motor.get());

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
