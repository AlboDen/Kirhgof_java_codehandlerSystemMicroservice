package manageSystem;

import manageSystem.Algorithms.InterruptsMonitoring;
import manageSystem.Algorithms.ProgramManager;

public class ManageAutomaticSystem {
    ProgramManager programManager;
    InterruptsMonitoring interruptsMonitoring;

    public ManageAutomaticSystem(){
        //
        programManager = new ProgramManager();
        interruptsMonitoring = new InterruptsMonitoring();

        programManager.runProgram(programManager.mainProgram);
    }

}
