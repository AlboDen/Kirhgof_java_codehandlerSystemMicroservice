import manageSystem.Algorithms.InterpritatorClases.ComandSignature ;
import manageSystem.dataBase.DataBaseAccess;


public class Main {
    public static void main(String[] args) {
        //MAIN
        System.out.println("START BRAIN!");
        ComandSignature mainComandsSignature = new ComandSignature(DataBaseAccess.getPrograms.getMainProgramJSONstring());
        mainComandsSignature.printComandsList();


        }


    }
