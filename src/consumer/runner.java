package consumer;

public class runner {
    public static void main(String[] args) {

        //ASIGNACION DE UNA IMPLEMENTACION ANONIMA A UNA VARIABLE
        var misueldo = new ImpuestoGrabavle() {
            @Override
            public double grabar(double ingreso) {
                return ingreso * .16;
            }
        };
        System.out.println(misueldo.grabar(100));

    }


}

