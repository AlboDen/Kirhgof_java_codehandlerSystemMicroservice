package manageSystem.Algorithms.InterpritatorClases;

import java.util.ArrayList;

public class ComandSignature {
    ArrayList<String> comandsList = new ArrayList<String>();

    public ComandSignature(String code){
        String[] comandsString = code.split("block");
        for(int i = 0; i < (comandsString.length); i++){
            System.out.println("splited cose strings:     "+comandsString[i]);
        }

        this.researchStringCode(comandsString);
        this.sweep_up_the_dirt();
        //this.printComandsList();
    }

    public void researchStringCode(String[] comandsString) {
        String buf_str;
        boolean thereAreAttachments = false;
        for(int i = 0; i < (comandsString.length); i++){
            buf_str = "";
            System.out.println("o "+ i + "/" + comandsString.length +"  " + comandsString[i]);
            printComandsList();
            if (comandsString[i].indexOf("controls_ifelse") != -1){

                addToArray(i, "IF_CONSTRUCT");
                addToArray(i+1, "IF");
                int openingCurlyBraceCounter = 1, closingCurlyBraceCounter = 0;
                int[] buf_int;
                String[] buf_str_array = new String[3];
                int p_buf = 0;
                for(int p = 0 ; p < comandsString.length; p++){ // catch all text within curly braces
                    buf_int = this.countBraces(comandsString[i + p]);
                    openingCurlyBraceCounter += buf_int[0];
                    closingCurlyBraceCounter += buf_int[1];
                    if (openingCurlyBraceCounter > closingCurlyBraceCounter){
                        buf_str += comandsString[i + p];
                    }
                    else {
                        p_buf = p;
                        buf_str_array[0] = buf_str;
                        System.out.println("After IF:   " + buf_str);
                        break;
                    }
                }
                addToArray(i+2, buf_str);
                addToArray(i+3, "IF_END");
/*
                addToArray(i+4, "DO");
                buf_str = "";

                while (comandsString[i + u].indexOf("DO") == -1) { // search string with "DO"
                    u += 1;
                }
                i += u;

                openingCurlyBraceCounter = 1;
                closingCurlyBraceCounter = 0;
                for(int p = 0 ; p < comandsString.length; p++){ // catch all text within curly braces
                    buf_int = this.countBraces(comandsString[i + p]);
                    openingCurlyBraceCounter += buf_int[0];
                    closingCurlyBraceCounter += buf_int[1];
                    if (openingCurlyBraceCounter > closingCurlyBraceCounter){
                        buf_str += comandsString[i + p];
                    }
                    else {
                        i += p;
                        break;
                    }
                }
                //addToArray(i+4, buf_str);
                addToArray(i+5, "DO_END");

                addToArray(i+6, "ELSE");
                buf_str = "";
                while (comandsString[i + u].indexOf("ELSE") == -1) {
                    buf_str += comandsString[i + u];
                    u += 1;
                }
                addToArray(i+7, buf_str);
                addToArray(i+8, "ELSE_END");

//                addToArray(i, "DO");
//                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[0]);
//                addToArray(i, "ELSE");
//                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[1]);
//
                thereAreAttachments = true;

                i += u;
                //*/
            }
            else{
                if (comandsString[i].indexOf("initialPosition") != -1){
                    buf_str = "INIT_POSE " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                    addToArray(i, buf_str);
                }
                else {
                    if (comandsString[i].indexOf("moveTo") != -1){
                        buf_str = "PTP " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                        addToArray(i, buf_str);
                    }
                    else {
                        if (comandsString[i].indexOf("debug_activate_notification") != -1){
                            buf_str = "MESSAGE " + comandsString[i].split("\"TEXT\":\"")[1].split("\"")[0];
                            addToArray(i, buf_str);
                        }
                        else {
                            if (comandsString[i].indexOf("wait_seconds") != -1){
                                buf_str = "WAIT_SEC " + comandsString[i].split("\"SECONDS\":")[1].split("\"")[0].split("}")[0];
                                addToArray(i, buf_str);
                            }
                            else {
                                if (comandsString[i].indexOf("getCurrentPosition") != -1){
                                    buf_str = "GET_CURRENT_POSE " + comandsString[i].split("\"AXIS\":")[1].split("\"")[1];
                                    addToArray(i, buf_str);
                                }
                                else {
                                    if (comandsString[i].indexOf("math_number") != -1){
                                        buf_str = "NUMBER " + comandsString[i].split("\"NUM\":")[1].split("}")[0];
                                        addToArray(i, buf_str);
                                    }
                                    else {
                                        if (comandsString[i].indexOf("logic_compare") != -1){
                                            buf_str = "LOGIC_OPERATION " + comandsString[i].split("\"OP\":\"")[1].split("\"")[0];
                                            addToArray(i, buf_str);
                                        }
                                        else {

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(thereAreAttachments){
//            comandsList.add("");
//            comandsList.add("ITERATION");
//            comandsList.add("");

            String[] dblArray = new String[comandsList.size()];
            dblArray = comandsList.toArray(dblArray);
            researchStringCode(dblArray);
            thereAreAttachments = false;
        }
    }

    private void addToArray(int i, String k){
        try {
            comandsList.remove(i);
            comandsList.add(i, k);
        }
        catch (IndexOutOfBoundsException e){
            comandsList.add(k);
        }
    }
    private int[] countBraces(String str) {
        int openBraceCount = 0; // Счетчик открывающих фигурных скобок
        int closeBraceCount = 0; // Счетчик закрывающих фигурных скобок

        // Проходим по каждому символу в строке
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Получаем текущий символ

            // Проверяем, является ли символ открывающей фигурной скобкой
            if (ch == '{') {
                openBraceCount++; // Увеличиваем счетчик открывающих скобок
            }
            // Проверяем, является ли символ закрывающей фигурной скобкой
            else if (ch == '}') {
                closeBraceCount++; // Увеличиваем счетчик закрывающих скобок
            }
        }

        return new int[] {openBraceCount, closeBraceCount}; // Возвращаем массив с результатами
    }
    private void sweep_up_the_dirt(){
        for (int i = 0; i < comandsList.size(); i ++){
            if (comandsList.get(i).indexOf("\"") != -1){
                comandsList.remove(i);
            }
        }
    }

    public void printComandsList(){
        System.out.println("Code splited:");
        System.out.println("START Print current massive of size " + comandsList.size());
        for(int i = 0; i < comandsList.size(); i++){

            System.out.println("\t" + comandsList.get(i));
        }
        System.out.println("END Print current massive");
    }
}