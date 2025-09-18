package manageSystem.dataBase;

public class DataBaseAccess {
    public static class getPrograms{

        public static getPrograms(){

        }
        public static String getMainProgramJSONstring(){
            return  "\"{\"blocks\":{\"languageVersion\":0,\"blocks\":[{\"type\":\"initialPosition\",\"id\":\"X-6.BN2w0B(+#]Q:$UC1\",\"x\":164,\"y\":131,\"fields\":{\"POSITION_NAME\":\"positionA\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"jL-lUsLjyLX/t(n;Q.Qx\",\"fields\":{\"POSITION_NAME\":\"positionB\"},\"next\":{\"block\":{\"type\":\"moveTo\",\"id\":\"(_;sXN7]sN29VdZ_dRsh\",\"fields\":{\"POSITION_NAME\":\"positionC\"},\"next\":{\"block\":{\"type\":\"controls_ifelse\",\"id\":\"^vZ[5aNVFBuM#GuS1scY\",\"inputs\":{\"IF0\":{\"block\":{\"type\":\"logic_compare\",\"id\":\"(.I#v.28`(XP_9(3W:kx\",\"fields\":{\"OP\":\"EQ\"},\"inputs\":{\"A\":{\"block\":{\"type\":\"getCurrentPosition\",\"id\":\"QRAZEL*O$Y`Ndp1}wp7x\",\"fields\":{\"AXIS\":\"X\"}}},\"B\":{\"block\":{\"type\":\"math_number\",\"id\":\"vRTy,s/#LhX;_qP6,D7)\",\"fields\":{\"NUM\":0}}}}}},\"DO0\":{\"block\":{\"type\":\"moveTo\",\"id\":\"*ytlf_?N^Au{D*j4.O{o\",\"fields\":{\"POSITION_NAME\":\"positionD\"}}},\"ELSE\":{\"block\":{\"type\":\"wait_seconds\",\"id\":\"Q4$oBH9m.st)[)Xaj]Px\",\"fields\":{\"SECONDS\":1}}}},\"next\":{\"block\":{\"type\":\"debug_activate_notification\",\"id\":\"z]K?d%(;a!P):N*g3o]a\",\"fields\":{\"TEXT\":\"Текст уведомления\"}}}}}}}}}}]}}\"\n";
        }
    }
}
