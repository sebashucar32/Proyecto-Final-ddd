package co.com.sofka.ddd.instalacion.event;

import co.com.sofka.ddd.instalacion.value.Temperatura;
import co.com.sofka.domain.generic.DomainEvent;

public class TemperaturaCambiada extends DomainEvent {
    private final Temperatura temperatura;
    private final Temperatura temperaturaCambiada;

    public TemperaturaCambiada(Temperatura temperatura, Temperatura temperaturaCambiada) {
        super("instalacion.TemperaturaCambiada");
        this.temperatura = temperatura;
        this.temperaturaCambiada = temperaturaCambiada;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public Temperatura getTemperaturaCambiada() {
        return temperaturaCambiada;
    }
}
