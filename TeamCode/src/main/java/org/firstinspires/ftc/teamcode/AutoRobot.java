package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="AutoRobot: Autonomous drive", group="Team Robot")
//@Disabled
public class AutoRobot extends LinearOpMode {
    // OpMode properties
    TeamRobot robot = new TeamRobot();
    ElapsedTime runtime = new ElapsedTime();
    final double FORWARD_SPEED = 0.6;
    final double TURN_SPEED = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize robot
        robot.init(hardwareMap);

        // Send telemetry data
        telemetry.addData("Status", "Ready to Run");
        telemetry.update();

        // for autonomous mode
        waitForStart();

        // Step 1: forward for 3 seconds
        robot.leftDrive.setPower(FORWARD_SPEED);
        robot.rightDrive.setPower(FORWARD_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 3.0) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2: spin for 1.3 seconds
        robot.leftDrive.setPower(TURN_SPEED);
        robot.rightDrive.setPower(-TURN_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1.3) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //step 3.0: drive backwards for 1 second
        robot.leftDrive.setPower(-FORWARD_SPEED);
        robot.rightDrive.setPower(-FORWARD_SPEED);

        while(opModeIsActive() && runtime.seconds() < 1) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //turn for 3rd leg
        robot.leftDrive.setPower(TURN_SPEED);
        robot.rightDrive.setPower(-TURN_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1.3) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //3rd leg
        robot.leftDrive.setPower(FORWARD_SPEED);
        robot.rightDrive.setPower(FORWARD_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 3.0) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        //turn for 4th leg
        robot.leftDrive.setPower(-TURN_SPEED);
        robot.rightDrive.setPower(TURN_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1.3) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //4th leg
        robot.leftDrive.setPower(FORWARD_SPEED);
        robot.rightDrive.setPower(FORWARD_SPEED);
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 3.0) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }
}