package frc.robot.Vision;

import frc.robot.RobotContainer;

public class VisionHandler {

    double _pxOffset;
    double _degOffset;

    public VisionHandler() {

    }

    public void update() {
        _pxOffset = RobotContainer.s_Turret.getHeading();
        _degOffset = 0.43 * (_pxOffset - 80 /* center 0 */) - 1.46;
    }

    public double getError(){
        return _degOffset;
    }
}