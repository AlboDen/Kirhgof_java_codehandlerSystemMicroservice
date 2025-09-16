package realSystem.systemElements;

import java.util.ArrayList;
import java.util.HashMap;

public class Manipulator {
    //public static ArrayList<PoseConstruct> Poses = new ArrayList<PoseConstruct>();
    static public HashMap<String, PoseConstruct> Poses = new HashMap<String, PoseConstruct>();
    static public PoseConstruct currentPose = new PoseConstruct();

    public Manipulator() {
        pullPosesFromMemory();

        //Manipulator.manipulatorJoints.get(1);
    }

    private void pullPosesFromMemory(){
        //PULL from SQL
        String namePose = "jjj"; //pull from memory
        double[] listAngelsOfPose = new double[0]; //pull from memory
        for(;;){
            Poses.put(namePose, createPose(listAngelsOfPose) );
        }
    }
    private PoseConstruct createPose(double[] jointAngels){
        PoseConstruct constructor = new PoseConstruct();
        for(int i = 0; i < jointAngels.length; i++){
            constructor.jointAngelsInPose.add(jointAngels[i]);
        }
        return constructor;
    }

    public static class PoseConstruct {
        ArrayList<Double> jointAngelsInPose = new ArrayList<Double>();

        public ArrayList<Double> getAngels(){
            ArrayList<Double> buffer = new ArrayList<Double>();
            for (int i = 0; i < jointAngelsInPose.size(); i++){
                buffer.add(jointAngelsInPose.get(i));
            }
            return buffer;
        }
        public double getAngel(int i){
            return jointAngelsInPose.get(i);
        }
        public int lengh(){
            return jointAngelsInPose.size();
        }

    }

    static public class ManipulatorJoints {
        public static ArrayList<ManipulatorJoint> manipulatorJoints = new ArrayList<ManipulatorJoint>();
        static public int manipulatorJointsNumber;

        public ManipulatorJoints() {
            createConstructObjects();
            manipulatorJointsNumberCalc();
        }

        public void manipulatorJointsNumberCalc() {
            this.manipulatorJointsNumber = manipulatorJoints.size();
        }

        private void createConstructObjects() { //add functional head, rails and other
            ManipulatorJoint jointTableRobot = new ManipulatorJoint(0, 50);
            manipulatorJoints.add(jointTableRobot);
            ManipulatorJoint joint0_1 = new ManipulatorJoint(0, 50);
            manipulatorJoints.add(joint0_1);
            ManipulatorJoint joint1_2 = new ManipulatorJoint(0, 50);
            manipulatorJoints.add(joint1_2);
            ManipulatorJoint joint1_3 = new ManipulatorJoint(0, 30);
            manipulatorJoints.add(joint1_3);
            checkAditionallyElementsAndAdd();
        }

        private void checkAditionallyElementsAndAdd() { //add functional head, rails and other

        }

        static class ManipulatorJoint {
            static double initialAngle, lenthNextBone;
            ManipulatorJoint(double initialAngle, double lenthNextBone) {
                ManipulatorJoint.initialAngle = initialAngle;
                ManipulatorJoint.lenthNextBone = lenthNextBone;
            }
        }
    }
}