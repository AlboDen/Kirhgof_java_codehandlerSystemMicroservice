package manageSystem.Algorithms.InterpritatorClases;

import java.util.ArrayList;

public class ComandSignature {
    ArrayList<String> comandsList = new ArrayList<String>();

    public ComandSignature(String code){
        String[] comandsString = code.split("block");
        this.researchStringCode(comandsString);
        this.sweep_up_the_dirt();
    }

    public void researchStringCode(String[] comandsString) {
        String buf_str;
        boolean thereAreAttachments = false;
        for(int i = 0; i < (comandsString.length); i++){
            buf_str = "";
            if (comandsString[i].indexOf("controls_ifelse") != -1){
                /*int u = 0;
                addToArray(i, "IF");
                while (comandsString[i + u].indexOf("next") == -1){
                    buf_str += comandsString[i + u];
                    u += 1;
                }
                buf_str += comandsString[i + u];
                i += u;
                String[] buf =  buf_str.split("IF0")[1].split(",\"DO0\":")[0].split("type");
                for (int j = 0; j < buf.length; j++){
                    addToArray(i, buf[j]);
                }

                addToArray(i, "DO");
                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[0]);
                addToArray(i, "ELSE");
                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[1]);
                addToArray(i, "IF_END");
                thereAreAttachments = true;
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
    private void sweep_up_the_dirt(){
        for (int i = 0; i < comandsList.size(); i ++){
            if (comandsList.get(i).indexOf("\"") != -1){
                comandsList.remove(i);
            }
        }
    }

    public void printComandsList(){
        System.out.println("Code splited:");
        System.out.println("START Print current massive" + comandsList.size());
        for(int i = 0; i < comandsList.size(); i++){

            System.out.println("\t" + comandsList.get(i));
        }
        System.out.println("END Print current massive");
    }
}