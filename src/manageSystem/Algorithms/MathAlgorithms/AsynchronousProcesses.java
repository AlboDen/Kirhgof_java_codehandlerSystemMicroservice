package manageSystem.Algorithms.MathAlgorithms;

public class AsynchronousProcesses {
    public class SystemCheck{
        public void checkEncoders(){ //fill Manipulator.currentPose pole by joint angles in radian
            //Manipulator.currentPose;
        }
    }

    public class AutomaticControlBlocks{
        public static double quantumOfTime_ms = 1;

        public static abstract class Comparating{
            public abstract void Compare();
            public void asyncRun(){
                this.Compare();
            }
        }

        public static abstract class aperiodicLinksSecondPowerSimulate{
            static public enum typeOfEdge {
                RIZEFRONT,
                FALLINGFRONT;
            }
            static public typeOfEdge edgeWitchGenerating = typeOfEdge.RIZEFRONT;
            public int generateStepCounter = 0;
            public abstract void generateFront();
            public void asyncRun(){

            }
        }
    }
}
