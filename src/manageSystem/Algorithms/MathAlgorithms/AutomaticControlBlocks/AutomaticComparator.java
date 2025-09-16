package manageSystem.Algorithms.MathAlgorithms.AutomaticControlBlocks;
import manageSystem.Algorithms.MathAlgorithms.AsynchronousProcesses;
import manageSystem.Algorithms.MathAlgorithms.AsynchronousProcesses.AutomaticControlBlocks.Comparating;
import manageSystem.Algorithms.MathAlgorithms.AutomaticControlBlocks.AperiodicLinkSecondDegree;

import java.util.ArrayList;

public class AutomaticComparator {
    //public boolean comparatorOutput = false;
    Comparating comparing;
    public AutomaticComparator(double currentPoseAngle, double angelForComparing) {
        comparing = new Comparating() {
            @Override
            public void Compare() {
                //comparatorOutput = currentPoseAngle > angelForComparing;
                if (currentPoseAngle > angelForComparing){
                    AsynchronousProcesses.AutomaticControlBlocks.
                            aperiodicLinksSecondPowerSimulate.edgeWitchGenerating =
                            AsynchronousProcesses.AutomaticControlBlocks.
                                    aperiodicLinksSecondPowerSimulate.typeOfEdge.FALLINGFRONT;
                }
                else{
                    AsynchronousProcesses.AutomaticControlBlocks.
                            aperiodicLinksSecondPowerSimulate.edgeWitchGenerating =
                            AsynchronousProcesses.AutomaticControlBlocks.
                                    aperiodicLinksSecondPowerSimulate.typeOfEdge.RIZEFRONT;
                }
            }
        };
    };

}

