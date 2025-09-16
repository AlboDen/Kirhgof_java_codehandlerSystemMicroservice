package manageSystem;

import manageSystem.Algorithms.InterruptsMonitoring;
import manageSystem.Algorithms.ProgramManager;

public class ManageAutomaticSystem {
    public ManageAutomaticSystem(){
        ProgramManager programManager = new ProgramManager();
        InterruptsMonitoring interruptsMonitoring = new InterruptsMonitoring();

        programManager.runProgram(programManager.mainProgram);
    }

}
