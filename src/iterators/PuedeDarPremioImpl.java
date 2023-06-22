package iterators;

public  class PuedeDarPremioImpl implements PuedeDarPremio {
    private Persona persona;

    public  Persona premiar(Persona persona) {
        persona.setSaldo(800);
        return persona;
    }
}
