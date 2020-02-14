package frc.robot.Vision;

public class VisionHandler {

    double _pxOffset;
    double _degOffset;

    public VisionHandler() {

    }

    public void update() {
        _degOffset = 0.43 * (_pxOffset - 80 /* center 0 */) - 1.46;
    }

    public double getError(){
        return _degOffset;
    }
}