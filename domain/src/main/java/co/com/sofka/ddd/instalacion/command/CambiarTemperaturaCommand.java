package co.com.sofka.ddd.instalacion.command;

import co.com.sofka.ddd.instalacion.value.Temperatura;
import co.com.sofka.domain.generic.Command;

public class CambiarTemperaturaCommand extends Command  {
    private final Temperatura temperatura;
    private final Temperatura temperaturaCambiada;

    public CambiarTemperaturaCommand(Temperatura temperatura, Temperatura temperaturaCambiada) {
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
