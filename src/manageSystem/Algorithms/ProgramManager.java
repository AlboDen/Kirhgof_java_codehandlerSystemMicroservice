package manageSystem.Algorithms;

import java.util.Arrays;

/*
* class which contains all programs and reading string by string
* */
public class ProgramManager {
    public static String mainProgram;
    static String[] permanentPrograms;

    public ProgramManager(){
        pullAllPrograms();

    }
    private void pullAllPrograms(){ //pulling programs texts and properties from SQL to class objects
        String[][] programmsAndProperties = new String[1][];
        //programmsAndProperties = filling from SQL;
        mainProgram = programmsAndProperties[0][0];
        for(int i = 1; i<programmsAndProperties[0].length; i++){
            Arrays.fill(permanentPrograms, programmsAndProperties[0][i]);
        }
    }

    //Async
    public static void runProgram(String prog){ //calling async reader of code program strings
        Interpritator interpritator = new Interpritator();
        for (;;){
            interpritator.executeString(prog);
        }
    }

    public static void pauseProgram(String prog){ //calling async reader of code program strings

    }

}
