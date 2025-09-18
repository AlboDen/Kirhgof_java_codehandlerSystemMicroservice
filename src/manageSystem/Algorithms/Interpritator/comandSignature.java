package manageSystem.Algorithms.Interpritator;

import java.util.ArrayList;

class comandSignature {
    public comandSignature(){}
    ArrayList<String> comandsList = new ArrayList<String>();
    //static ArrayList<String> comandsString_BUFFER = new ArrayList<String>();
    public void researchStringCode(String[] comandsString) {
//            System.out.println("START Print current massive");
//            for(int i = 0; i < comandsString.length; i++){
//                System.out.println("\t" + comandsString[i]);
//            }
//            System.out.println("END Print current massive");
        // System.out.println("PPP "+ comandsString[0]);

        //comandsString_BUFFER = new ArrayList<String>();
        for(int i = 0; i < comandsString.length; i++){
            //comandsString_BUFFER.add(comandsString[i]);
        }

        System.out.println("SSSSSSSSSSSSSSSSIIIIZEEEEEEEEEEEE " +comandsString.length+" ");
        //System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD " +Arrays.asList(comandsString));
        String buf_str;
        boolean thereAreAttachments = false;
        for(int i = 0; i < (comandsString.length); i++){
            buf_str = "";
            System.out.println("D " + i + " "+comandsString[i]);
            //comandsList.add("ioioioioi "+i);
            if (comandsString[i].indexOf("controls_ifelse") != -1){
                int u = 0;
                //comandsString_BUFFER.add(i,  "IF");
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
//                        researchStringCode(buf);

                addToArray(i, "DO");
                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[0]);
                addToArray(i, "ELSE");
                addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[1]);
                addToArray(i, "IF_END");
//                    comandsString_BUFFER.add(i,   );
//                    comandsString_BUFFER.add(i,  "DO");
//                    comandsString_BUFFER.add( i,    );
//                    comandsString_BUFFER.add(i,  "ELSE");
//                    comandsString_BUFFER.add( i,   buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[1] );
//                    comandsString_BUFFER.add(i,  "IF_END");
                thereAreAttachments = true;
            }
            else{
                if (comandsString[i].indexOf("initialPosition") != -1){
                    //System.out.println("iiiiiiiiiiiiiiiiii  "+i);
                    buf_str = "INIT_POSE " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                    //System.out.println("\t\tPreparated code string: " + buf_str);
                    addToArray(i, buf_str);
                }
                else {
                    if (comandsString[i].indexOf("moveTo") != -1){
                        buf_str = "PTP " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                        //System.out.println("\t\tPreparated code string: " + buf_str);
                        addToArray(i, buf_str);
                    }
                    else {
                        if (comandsString[i].indexOf("debug_activate_notification") != -1){
                            buf_str = "MESSAGE " + comandsString[i].split("\"TEXT\":\"")[1].split("\"")[0];
                            //System.out.println("\t\tPreparated code string: " + buf_str);
                            addToArray(i, buf_str);
                        }
                        else {
                            if (comandsString[i].indexOf("wait_seconds") != -1){
                                buf_str = "WAIT_SEC " + comandsString[i].split("\"SECONDS\":")[1].split("\"")[0].split("}")[0];
                                //System.out.println("\t\tPreparated code string: " + buf_str);
                                addToArray(i, buf_str);
                            }
                            else {
                                if (comandsString[i].indexOf("getCurrentPosition") != -1){
                                    buf_str = "GET_CURRENT_POSE " + comandsString[i].split("\"AXIS\":")[1].split("\"")[1];
                                    //System.out.println("\t\tPreparated code string: " + buf_str);
                                    addToArray(i, buf_str);
                                }
                                else {
                                    if (comandsString[i].indexOf("math_number") != -1){
                                        buf_str = "NUMBER ";// + comandsString[i].split("\"NUM\":")[1].split("\"")[0];
                                        //\"math_number\",\"id\":\"vRTy,s/#LhX;_qP6,D7)\",\"fields\":{\"NUM\":0
                                        addToArray(i, buf_str);
                                    }
                                    else {
                                        if (comandsString[i].indexOf("logic_compare") != -1){
                                            buf_str = "LOGIC_OPERATION " + comandsString[i].split("\"OP\":\"")[1].split("\"")[0];
                                            //\"math_number\",\"id\":\"vRTy,s/#LhX;_qP6,D7)\",\"fields\":{\"NUM\":0
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
            System.out.println("iiiiiiiiiii " + i + " " + buf_str);

        }
        //System.out.println("START Print current massive");
//            for(int i = 0; i < comandsString_BUFFER.size(); i++){
//                if (comandsString_BUFFER.get(i) == "") {
//                    comandsString_BUFFER.remove(i);
//                }
//                //System.out.println("\t" + comandsString_BUFFER);
//            }
        //System.out.println("END Print current massive");


        if(thereAreAttachments){
            comandsList.add("");
            comandsList.add("ITERATION");
            comandsList.add("");

            String[] dblArray = new String[comandsList.size()];
            dblArray = comandsList.toArray(dblArray);
            researchStringCode(dblArray);
            thereAreAttachments = false;
        }

        //DOP ITERATION


        //comandsList = comandsString_BUFFER;


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

    public void printComandsList(){
        System.out.println("Code spliting:");
        System.out.println("START Print current massive" + comandsList.size());
        for(int i = 0; i < comandsList.size(); i++){

            System.out.println("\t" + comandsList.get(i));
        }
        System.out.println("END Print current massive");
    }
}