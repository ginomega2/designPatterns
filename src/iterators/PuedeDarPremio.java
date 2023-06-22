package iterators;

public  interface PuedeDarPremio {
    static Persona premiar(Persona persona) {
        persona.setSaldo(persona.getSaldo()*1.2);
        return persona;
    }

}
