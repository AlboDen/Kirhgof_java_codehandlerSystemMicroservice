import manageSystem.ManageAutomaticSystem;

import java.util.ArrayList;

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
        for(int i = 0; i < comandsList.size(); i++){
            System.out.println("\t" + comandsList.get(i));
        }
        System.out.println("Code spliting:");


        }

        static ArrayList<String> comandsList = new ArrayList<String>();
        public static void researchStringCode(String[] comandsString) {
//            System.out.println("START Print current massive");
//            for(int i = 0; i < comandsString.length; i++){
//                System.out.println("\t" + comandsString[i]);
//            }
//            System.out.println("END Print current massive");
           // System.out.println("PPP "+ comandsString[0]);
            ArrayList<String> comandsString_BUFFER = new ArrayList<String>(comandsString.length);
            String buf_str;
            boolean thereAreAttachments = false;
            for(int i = 0; i < comandsString.length; i++){
                buf_str = "";

                //comandsList.add("ioioioioi "+i);
                if (comandsString[i].indexOf("controls_ifelse") != -1){
                    int u = 0;
                    comandsList.add("IF");
                    while (comandsString[i + u].indexOf("next") == -1){
                        buf_str += comandsString[i + u];
                        u += 1;
                    }
                    buf_str += comandsString[i + u];
                    i += u;
                    comandsList.add(  buf_str.split("IF0")[1].split(",\"DO0\":")[0] );
                    comandsList.add("DO");
                    comandsList.add(  buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[0] );
                    comandsList.add("ELSE");
                    comandsList.add(  buf_str.split("IF0")[1].split(",\"DO0\":")[1].split("\"ELSE\"")[1] );
                    comandsList.add("IF_END");
                    thereAreAttachments = true;
                }
                else{
                    if (comandsString[i].indexOf("initialPosition") != -1){
                        //System.out.println("iiiiiiiiiiiiiiiiii  "+i);
                        buf_str = "INIT_POSE " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                        //System.out.println("\t\tPreparated code string: " + buf_str);
                        comandsList.add(buf_str);
                    }
                    else {
                        if (comandsString[i].indexOf("moveTo") != -1){
                            buf_str = "PTP " + comandsString[i].split("POSITION_NAME\":\"")[1].split("\"")[0].trim();
                            //System.out.println("\t\tPreparated code string: " + buf_str);
                            comandsList.add(buf_str);
                        }
                        else {
                            if (comandsString[i].indexOf("debug_activate_notification") != -1){
                                buf_str = "MESSAGE " + comandsString[i].split("\"TEXT\":\"")[1].split("\"")[0];
                                //System.out.println("\t\tPreparated code string: " + buf_str);
                                comandsList.add(buf_str);
                            }
                            else {
                                if (comandsString[i].indexOf("wait_seconds") != -1){
                                    buf_str = "WAIT_SEC " + comandsString[i].split("\"SECONDS\":")[1].split("\"")[0].split("}")[0];
                                    //System.out.println("\t\tPreparated code string: " + buf_str);
                                    comandsList.add(buf_str);
                                }
                                else {
                                    if (comandsString[i].indexOf("getCurrentPosition") != -1){
                                        buf_str = "GET_CURRENT_POSE " + comandsString[i].split("\"AXIS\":")[1].split("\"")[1];
                                        //System.out.println("\t\tPreparated code string: " + buf_str);
                                        comandsList.add(buf_str);
                                    }
                                    else {
                                        if (comandsString[i].indexOf("math_number") != -1){
                                            buf_str = "NUMBER " + comandsString[i].split("\"NUM\":")[1].split("\"")[0];
                                            //System.out.println("\t\tPreparated code string: " + buf_str);
                                            comandsList.add(buf_str);
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
            System.out.println("START Print current massive");
            for(int i = 0; i < comandsString.length; i++){
                //System.out.println("\t" + comandsString[i]);
            }
            System.out.println("END Print current massive");

            if(thereAreAttachments){
                comandsList.add("");
                comandsList.add("ITERATION");
                comandsList.add("");

                String[] dblArray = new String[comandsList.size()];
                dblArray = comandsList.toArray(dblArray);
                researchStringCode(dblArray);
                thereAreAttachments = false;
            }


        }
    }
