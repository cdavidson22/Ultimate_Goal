/* Created by Team 5115 at Windsor High School for the 2017-18 Season
This OpMode runs motors in the following configuration:

       ////            \\\\
      /F1/ ------------ \F2\
     //// |            | \\\\
          |            |
          |            |
     \\\\ |            | ////
      \R1\ ------------ /R2/
       \\\\            ////

 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="holonomic motors", group="teleop")
//@Disabled

public class RomeroHolonomicMotorsOnly extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor F1 = null;
    private DcMotor F2 = null;
    private DcMotor R1 = null;
    private DcMotor R2 = null;

    //Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        // Set up the hardware
        telemetry.addData("Status", "Initialized");

        F1 = hardwareMap.get(DcMotor.class, "F1");
        F2 = hardwareMap.get(DcMotor.class, "F2");
        R1 = hardwareMap.get(DcMotor.class, "R1");
        R2 = hardwareMap.get(DcMotor.class, "R2");

        F1.setDirection(DcMotorSimple.Direction.FORWARD);
        F2.setDirection(DcMotorSimple.Direction.FORWARD);
        R1.setDirection(DcMotorSimple.Direction.FORWARD);
        R2.setDirection(DcMotorSimple.Direction.FORWARD);
        //Winch.setDirection(DcMotorSimple.Direction.FORWARD);

        F1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        F2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        telemetry.addData("Status", "Initialized v1");
    }
    //Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double leftstick_x_sqr;
        double leftstick_y_sqr;
        double power;
        double angle;

        double powerF1;
        double powerF2;
        double powerR1;
        double powerR2;

        angle = Math.atan2(gamepad1.left_stick_x, gamepad1.left_stick_y);//finds angle of joystick
        telemetry.addData("angle: ", angle);//adds telemetry for troubleshooting code

        leftstick_x_sqr = gamepad1.left_stick_x * gamepad1.left_stick_x;
        leftstick_y_sqr = gamepad1.left_stick_y * gamepad1.left_stick_y;
        power = Math.sqrt(leftstick_x_sqr + leftstick_y_sqr);//finds relative power of joystick using pythagorean theorem
        telemetry.addData("power: ", power);

        double Pi = Math.PI/4;//to avoid having to type this everytime

        powerF2 = (power * Math.cos(angle - Pi)) + gamepad1.right_stick_x;
        powerF1 = (power * -Math.cos(angle + Pi)) + gamepad1.right_stick_x;//assigning each motor power based on calculated sin wave
        powerR1 = (power * -Math.cos(angle - Pi)) + gamepad1.right_stick_x;//right stick is used for y axis rotation
        powerR2 = (power * Math.cos(angle + Pi)) + gamepad1.right_stick_x;

        powerF1 = Range.clip(powerF1,-1.0, 1.0);//clips values to avoid program errors
        powerF2 = Range.clip(powerF2,-1.0, 1.0);
        powerR1 = Range.clip(powerR1,-1.0, 1.0);
        powerR2 = Range.clip(powerR2,-1.0, 1.0);

        telemetry.addData("right stick x: ", gamepad1.right_stick_x);

        if(power > .1 || Math.abs(gamepad1.right_stick_x)>.1){
            F1.setPower(powerF1);
            F2.setPower(powerF2);//applies motor power if joystick is moved
            R1.setPower(powerR1);
            R2.setPower(powerR2);
        }
        else{
            F1.setPower(0);
            F2.setPower(0);
            R1.setPower(0);//stops robot when no joystick is pressed 
            R2.setPower(0);
        }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}