package manageSystem.Algorithms.MathAlgorithms.AutomaticControlBlocks;
import manageSystem.Algorithms.MathAlgorithms.AsynchronousProcesses;
import manageSystem.Algorithms.MathAlgorithms.AsynchronousProcesses.AutomaticControlBlocks.aperiodicLinksSecondPowerSimulate;

import java.util.ArrayList;

public class AperiodicLinkSecondDegree {
    public double output;
    RungeCutta RungeCuttaMethod;
    public aperiodicLinksSecondPowerSimulate simulateMethod = new aperiodicLinksSecondPowerSimulate() {

                @Override
                public void generateFront() {

                    if(this.edgeWitchGenerating == typeOfEdge.RIZEFRONT){
                        output = RungeCuttaMethod.calculatedValuesOfTransitionFunction.get(simulateMethod.generateStepCounter);
                        simulateMethod.generateStepCounter++;
                    }
                    else {
                        output = RungeCuttaMethod.calculatedValuesOfTransitionFunction.get(simulateMethod.generateStepCounter);
                        simulateMethod.generateStepCounter--;
                    }
                }
            };



//ArrayList<Double> currentPose, int numerOfJoint, ArrayList<Double> angelsForComparing
    public AperiodicLinkSecondDegree(double timeMovement_sec, double averageVelosity) {
        double movingTimeWithAcceleration_sec = timeMovement_sec/4;

        RungeCutta RC = new RungeCutta(movingTimeWithAcceleration_sec, averageVelosity);
        RC.calculateValuesOfTransitionFunctionInTime();
        RungeCuttaMethod = RC;
    }


    class RungeCutta {
        public double T1;
        public double T2;
        public double K;
        public double movingTimeWithAcceleration_sec;
        public ArrayList<Double> calculatedValuesOfTransitionFunction = new ArrayList<Double>();
        public RungeCutta(){}
        public RungeCutta(double movingTimeWithAcceleration_sec, double averageVelosity){
            this.T1 = movingTimeWithAcceleration_sec/4;
            this.T2 = movingTimeWithAcceleration_sec/8;
            this.K = averageVelosity;
            this.movingTimeWithAcceleration_sec = movingTimeWithAcceleration_sec;
        }

        public void calculateValuesOfTransitionFunctionInTime() {
            double Xo, Yo, Y1, Zo, Z1;
            double k1, k2, k4, k3, h;
            double q1, q2, q4, q3;
            /*
             *Начальные условия
             */
            Xo = 0;
            Yo = 0;
            Zo = 0;

            h = AsynchronousProcesses.AutomaticControlBlocks.quantumOfTime_ms /1000; // шаг секунды

            System.out.println("\tX\t\tY\t\tZ");
            int k = 2; //коэффициент округления
            for(; r(Xo,2)<movingTimeWithAcceleration_sec; Xo += h){

                k1 = h * f(Xo, Yo, Zo);
                q1 = h * g(Xo, Yo, Zo);

                k2 = h * f(Xo + h/2.0, Yo + q1/2.0, Zo + k1/2.0);
                q2 = h * g(Xo + h/2.0, Yo + q1/2.0, Zo + k1/2.0);

                k3 = h * f(Xo + h/2.0, Yo + q2/2.0, Zo + k2/2.0);
                q3 = h * g(Xo + h/2.0, Yo + q2/2.0, Zo + k2/2.0);

                k4 = h * f(Xo + h, Yo + q3, Zo + k3);
                q4 = h * g(Xo + h, Yo + q3, Zo + k3);

                Z1 = Zo + (k1 + 2.0*k2 + 2.0*k3 + k4)/6.0;
                Y1 = Yo + (q1 + 2.0*q2 + 2.0*q3 + q4)/6.0;
                System.out.println("\t" + r(Xo + h, k) + "\t\t" + r(Y1 ,k) + "\t\t" + r(Z1 ,k));
                Yo = Y1;
                Zo = Z1;
            }

        }
        /**
         * функция для округления и отбрасывания "хвоста"
         */
        public static double r(double value, int k){
            return (double)Math.round((Math.pow(10, k)*value))/Math.pow(10, k);
        }
        /**
         * функции, которые получаются из системы
         */
        //z'= f(x,y,z)
        public double f(double x, double y, double z){
            double T1T2 = this.T1 * this.T2;
            double T1plusT2 = this.T1 + this.T2;
            return (this.K/T1T2 + T1plusT2*z/T1T2 + y/T1T2);
        }
        //y'= g(x,y,z)
        public static double g(double x, double y, double z){
            return (z);
        }

    }
}
