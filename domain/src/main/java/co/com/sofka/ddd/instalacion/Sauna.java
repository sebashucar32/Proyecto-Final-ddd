package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.value.Hora;
import co.com.sofka.ddd.instalacion.value.Madera;
import co.com.sofka.ddd.instalacion.value.SaunaId;
import co.com.sofka.ddd.instalacion.value.Temperatura;
import co.com.sofka.domain.generic.Entity;

public class Sauna extends Entity<SaunaId> {
    protected Madera madera;
    protected Temperatura temperatura;
    protected Hora hora;

    public Sauna(SaunaId entityId, Madera madera, Temperatura temperatura, Hora hora) {
        super(entityId);
        this.madera = madera;
        this.temperatura = temperatura;
        this.hora = hora;
    }

    public Madera madera() {
        return madera;
    }

    public Temperatura temperatura() {
        return temperatura;
    }

    public Hora hora() {
        return hora;
    }
}
