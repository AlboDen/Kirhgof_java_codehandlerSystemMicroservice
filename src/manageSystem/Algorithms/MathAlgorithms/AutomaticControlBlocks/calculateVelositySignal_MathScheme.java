package manageSystem.Algorithms.MathAlgorithms.AutomaticControlBlocks;
import realSystem.realSystem;
import realSystem.systemElements.Manipulator;
//import realSystem.systemElements.Manipulator;

import java.util.ArrayList;

public class calculateVelositySignal_MathScheme {
    public calculateVelositySignal_MathScheme(String nextPose, double timeMovement){
        //preliminary  calculations
        getDeltaAngels(nextPose);
        calcAverageVelocities(timeMovement);

        createComparators();
        createAperiodicBlocks(timeMovement);

        //run async processes
        AlgorithmicSchemeElements.asyncRun();

        double o5 = AlgorithmicSchemeElements.EdgeLinks.get(1).output -1;
    }

    public void createAperiodicBlocks(double timeMovement){
        for (int i = 0; i < realSystem.ManipulatorJoints.manipulatorJointsNumber; i++){
            AperiodicLinkSecondDegree aper = new AperiodicLinkSecondDegree(
                    timeMovement,
                    jointMovementParameters.averageVelosity.get(i)
                    );
            AlgorithmicSchemeElements.EdgeLinks.add(aper);

        }
    }

    public void createComparators(){
        for (int i = 0; i < realSystem.ManipulatorJoints.manipulatorJointsNumber; i++){
            AutomaticComparator comp = new AutomaticComparator(realSystem.currentPose.getAngel(i), jointMovementParameters.threeQuarterOfAngelPath.get(i));
            AlgorithmicSchemeElements.comparatorsThreeQuarterOfPath.add(comp);
        }
    }
/*
    public void calcRizingEdgeLinksParameters(double timeMovement){
        for (int i = 0; i < realSystem.ManipulatorJoints.manipulatorJointsNumber; i++){
            AlgorithmicSchemeElements.EdgeLinks.get(i);
        }
    }//*/

    public void calcAverageVelocities(double timeMovement){
        for (int i = 0; i < realSystem.ManipulatorJoints.manipulatorJointsNumber; i++){
            jointMovementParameters.averageVelosity.add(jointMovementParameters.deltaAngels.get(i)/(0.75*timeMovement));
        }
    }

    public void getDeltaAngels(String nextPose){
        realSystem.PoseConstruct nextPoseConstruct = realSystem.Poses.get(nextPose); //ArrayList<Double> jointAngelsInPose
        for (int i = 0; i < realSystem.ManipulatorJoints.manipulatorJointsNumber; i++){
            jointMovementParameters.deltaAngels.add(nextPoseConstruct.getAngel(i) - realSystem.currentPose.getAngel(i));
            jointMovementParameters.deltaAngelsQuarter.add((nextPoseConstruct.getAngel(i) - realSystem.currentPose.getAngel(i))/4);
            jointMovementParameters.quarterOfAngelPath.add(
                    realSystem.currentPose.getAngel(i) + jointMovementParameters.deltaAngelsQuarter.get(i)
            );
            jointMovementParameters.threeQuarterOfAngelPath.add(
                    realSystem.currentPose.getAngel(i) + 3*jointMovementParameters.deltaAngelsQuarter.get(i)
            );
        }
    }

    public class jointMovementParameters{
        static ArrayList<Double> deltaAngels = new ArrayList<Double>();
        static ArrayList<Double> deltaAngelsQuarter = new ArrayList<Double>();
        static ArrayList<Double> quarterOfAngelPath = new ArrayList<Double>();
        static ArrayList<Double> threeQuarterOfAngelPath = new ArrayList<Double>();


        static ArrayList<Double> averageVelosity = new ArrayList<Double>();
    }
    static public class AlgorithmicSchemeElements{
        public static ArrayList<AperiodicLinkSecondDegree> EdgeLinks = new ArrayList<AperiodicLinkSecondDegree>();
        public static ArrayList<AutomaticComparator> comparatorsThreeQuarterOfPath = new ArrayList<AutomaticComparator>();

        public static void asyncRun(){
            for(int i = 0; i< Manipulator.ManipulatorJoints.manipulatorJointsNumber; i++){
                comparatorsThreeQuarterOfPath.get(i).comparing.asyncRun();
            }
            for(int i = 0; i< Manipulator.ManipulatorJoints.manipulatorJointsNumber; i++){
                EdgeLinks.get(i).simulateMethod.asyncRun();
            }


        }
    }
}
