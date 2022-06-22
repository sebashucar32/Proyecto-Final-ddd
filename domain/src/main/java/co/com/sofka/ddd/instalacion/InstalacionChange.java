package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.event.InstalacionCreada;
import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.ddd.instalacion.event.TemperaturaCambiada;
import co.com.sofka.ddd.persona.event.NombreCompletoCambiado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class InstalacionChange extends EventChange {
    public InstalacionChange(Instalacion instalacion) {
        apply((InstalacionCreada event) -> {
            instalacion.sauna = null;
            instalacion.turco = new Turco();
            instalacion.maquinas = new HashSet<>();
            instalacion.sede = null;
        });

        apply((MaquinaAgregada event) -> {
            instalacion.maquinas.add(new Maquina(event.getIdentity(), event.getTipoMaquina(), event.getDescripcion()));
        });

        apply((TemperaturaCambiada event) -> {
            //instalacion.sauna.temperatura() = event.getTemperatura();
        });
    }
}
