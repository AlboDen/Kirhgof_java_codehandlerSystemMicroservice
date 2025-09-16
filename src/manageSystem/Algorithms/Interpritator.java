package manageSystem.Algorithms;

import realSystem.realSystem;
import manageSystem.Algorithms.MathAlgorithms.AutomaticControlBlocks.calculateVelositySignal_MathScheme;


public class Interpritator {
    public Interpritator(){
    }
    public void executeString(String currentComand){
        // = filling current comand
        currentComand = "PTP(killerPose, 1.25);";
        Comands_Base comands = new Comands_Base();
        switch(currentComand) {
            case "PTP":
                comands.PTP(currentComand);
                break;
            case "DELAY":
                comands.DELAY(currentComand);
                break;
            default:
                // code block
        }
    }

    private void readingMainProgramStrings_process(){

    }

    private class Comands_Base {
        void PTP(String codeString){
            codeString = codeString.trim();
            codeString = codeString.split("\\(")[1].trim();
            codeString = codeString.split("\\)")[0].trim();
            String[] data = codeString.split(",");

            //THE INPUT VARIABLES OF SCHEME
            //the following code corresponds to algorithmic scheme file "PTP scheme" from the folder of this class
            String nextPose = data[0].trim();
            double timeMovement = Double.valueOf(data[1].trim());

            new calculateVelositySignal_MathScheme(nextPose, timeMovement);

        }
        void DELAY(String codeString){

        }
    }

}
