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

    private void codeFromSQLtoString(){
        String code; // fill from sql
        //pass:
        code = "\"{\"blocks\":{\"languageVersion\":0,\"blocks\":[{\"type\":\"initialPosition\",\"id\":\"X-6.BN2w0B(+#]Q:$UC1\",\"x\":164,\"y\":131,\"fields\":{\"POSITION_NAME\":\"positionA\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"jL-lUsLjyLX/t(n;Q.Qx\",\"fields\":{\"POSITION_NAME\":\"positionB\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"(_;sXN7]sN29VdZ_dRsh\",\"fields\":{\"POSITION_NAME\":\"positionC\"},\"next\":{\"block\":{\"type\":\"controls_ifelse\",\"id\":\"^vZ[5aNVFBuM#GuS1scY\",\"inputs\":{\"IF0\":{\"block\":{\"type\":\"logic_compare\",\"id\":\"(.I#v.28`(XP_9(3W:kx\",\"fields\":{\"OP\":\"EQ\"},\"inputs\":{\"A\":{\"block\":{\"type\":\"getCurrentPosition\",\"id\":\"QRAZEL*O$Y`Ndp1}wp7x\",\"fields\":{\"AXIS\":\"X\"}}},\"B\":{\"block\":{\"type\":\"math_number\",\"id\":\"vRTy,s/#LhX;_qP6,D7)\",\"fields\":{\"NUM\":0}}}}}},\"DO0\":{\"block\":{\"type\":\"moveTo\",\"id\":\"*ytlf_?N^Au{D*j4.O{o\",\"fields\":{\"POSITION_NAME\":\"positionD\"}}},\"ELSE\":{\"block\":{\"type\":\"wait_seconds\",\"id\":\"Q4$oBH9m.st)[)Xaj]Px\",\"fields\":{\"SECONDS\":1}}}},\"next\":{\"block\":{\"type\":\"debug_activate_notification\",\"id\":\"z]K?d%(;a!P):N*g3o]a\",\"fields\":{\"TEXT\":\"Текст уведомления\"}}}}}}}}}}]}}\"\n";

        System.out.printf("Code splited\n" +code.split("block"));
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
