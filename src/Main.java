import manageSystem.ManageAutomaticSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //MAIN
        System.out.println("START BRAIN!");
        //ManageAutomaticSystem system = new ManageAutomaticSystem();

        //DEV
        //new RungeCutta();
        //String currentComand = "PTP(killerPose, 1.25);";
        String code; // fill from sql
        //pass:
        code = "\"{\"blocks\":{\"languageVersion\":0,\"blocks\":[{\"type\":\"initialPosition\",\"id\":\"X-6.BN2w0B(+#]Q:$UC1\",\"x\":164,\"y\":131,\"fields\":{\"POSITION_NAME\":\"positionA\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"jL-lUsLjyLX/t(n;Q.Qx\",\"fields\":{\"POSITION_NAME\":\"positionB\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"(_;sXN7]sN29VdZ_dRsh\",\"fields\":{\"POSITION_NAME\":\"positionC\"},\"next\":{\"block\":{\"type\":\"controls_ifelse\",\"id\":\"^vZ[5aNVFBuM#GuS1scY\",\"inputs\":{\"IF0\":{\"block\":{\"type\":\"logic_compare\",\"id\":\"(.I#v.28`(XP_9(3W:kx\",\"fields\":{\"OP\":\"EQ\"},\"inputs\":{\"A\":{\"block\":{\"type\":\"getCurrentPosition\",\"id\":\"QRAZEL*O$Y`Ndp1}wp7x\",\"fields\":{\"AXIS\":\"X\"}}},\"B\":{\"block\":{\"type\":\"math_number\",\"id\":\"vRTy,s/#LhX;_qP6,D7)\",\"fields\":{\"NUM\":0}}}}}},\"DO0\":{\"block\":{\"type\":\"moveTo\",\"id\":\"*ytlf_?N^Au{D*j4.O{o\",\"fields\":{\"POSITION_NAME\":\"positionD\"}}},\"ELSE\":{\"block\":{\"type\":\"wait_seconds\",\"id\":\"Q4$oBH9m.st)[)Xaj]Px\",\"fields\":{\"SECONDS\":1}}}},\"next\":{\"block\":{\"type\":\"debug_activate_notification\",\"id\":\"z]K?d%(;a!P):N*g3o]a\",\"fields\":{\"TEXT\":\"Текст уведомления\"}}}}}}}}}}]}}\"\n";
        String[] comandsString = code.split("block");
        researchStringCode(comandsString);

        System.out.println("Code spliting:");
        System.out.println("START Print current massive" + comandsList.size());
        for(int i = 0; i < comandsList.size(); i++){

            System.out.println("\t" + comandsList.get(i));
        }
        System.out.println("END Print current massive");

        }

        static ArrayList<String> comandsList = new ArrayList<String>();
        static ArrayList<String> comandsString_BUFFER = new ArrayList<String>();
        public static void researchStringCode(String[] comandsString) {
//            System.out.println("START Print current massive");
//            for(int i = 0; i < comandsString.length; i++){
//                System.out.println("\t" + comandsString[i]);
//            }
//            System.out.println("END Print current massive");
           // System.out.println("PPP "+ comandsString[0]);

            comandsString_BUFFER = new ArrayList<String>();
            for(int i = 0; i < comandsString.length; i++){
                //comandsString_BUFFER.add(comandsString[i]);
            }

            System.out.println("SSSSSSSSSSSSSSSSIIIIZEEEEEEEEEEEE " +comandsString.length+" "+ comandsString_BUFFER.size());
            //System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD " +Arrays.asList(comandsString));
            String buf_str;
            boolean thereAreAttachments = false;
            for(int i = 0; i < (comandsString.length); i++){
                buf_str = "";
                System.out.println("D " + i + " "+comandsString_BUFFER.size());
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
                    addToArray(i, buf_str.split("IF0")[1].split(",\"DO0\":")[0]);
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
                                            buf_str = "NUMBER " + comandsString[i].split("\"NUM\":")[1].split("\"")[0];
                                            //System.out.println("\t\tPreparated code string: " + buf_str);
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
                System.out.println("iiiiiiiiiii " + i + " " + buf_str);

            }
            //System.out.println("START Print current massive");
            for(int i = 0; i < comandsString_BUFFER.size(); i++){
                if (comandsString_BUFFER.get(i) == "") {
                    comandsString_BUFFER.remove(i);
                }
                //System.out.println("\t" + comandsString_BUFFER);
            }
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

            //comandsList = comandsString_BUFFER;


        }

        private static void addToArray(int i, String k){
            try {
                comandsList.remove(i);
            comandsList.add(i, k);
            }
            catch (IndexOutOfBoundsException e){
                comandsList.add(k);
            }
        }
    }
