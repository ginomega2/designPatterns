package iterators;

public class PuedeDarPremioImpl implements PuedeDarPremio {
    Persona persona;

    public PuedeDarPremioImpl(Persona persona) {
        this.persona = persona;

    }

    @Override
    public Persona premiar() {
        double premio= persona.getSaldo()*1.2;
        System.out.println("ganaste un premio "+premio);
        System.out.println("saldo aterior "+persona.getSaldo());
        persona.setSaldo(premio);
        System.out.println("tu nuevo saldo "+premio);
        return persona;
    }
}
