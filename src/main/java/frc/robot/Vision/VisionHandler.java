package frc.robot.Vision;

import frc.robot.Networktable;


public class VisionHandler {

    double _pxOffset;
    double _degOffset;

    public VisionHandler() {

    }

    public void update() {
        _pxOffset = Networktable.getHeading();
        _degOffset = 0.43 * (_pxOffset - 80 /* center 0 */) - 1.46;
    }

    public double getError(){
        return _degOffset;
    }
}