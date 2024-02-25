package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class SUB_Shooter extends SubsystemBase{

  private final static TalonSRX shootMotor = new TalonSRX(40);
  private final static TalonSRX feedMotor = new TalonSRX(41);
  public boolean shootBool;
  public boolean feedBool;
  public double adjShootSpeed;
  public double adjFeedSpeed;
  
  public void setShooter1Speed(double speed){
    shootMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void setShooter2Speed(double speed){
    feedMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void setFeedSpeed(double speed){
    shootMotor.set(TalonSRXControlMode.PercentOutput, -speed);
    feedMotor.set(TalonSRXControlMode.PercentOutput, -speed);
  }

  public void increaseShootSpeed(){
      adjShootSpeed += .05;
  }
  public void decreaseShootSpeed(){
      adjShootSpeed -= .05;
  }
  public void increaseFeedSpeed(){
      adjFeedSpeed += .05;
  }
  public void decreaseFeedSpeed(){
      adjFeedSpeed -= .05;
  }


  public SUB_Shooter() {
    shootMotor.enableCurrentLimit(true);
    shootMotor.configPeakCurrentLimit(50);
    feedMotor.enableCurrentLimit(true);
    feedMotor.configPeakCurrentLimit(50);
    
  }

  public void periodic(){
    SmartDashboard.putNumber("Feed Speed", adjFeedSpeed);
    SmartDashboard.putNumber("Shoot Speed", adjShootSpeed);
  }
}

