package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.event.InstalacionCreada;
import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class InstalacionChange extends EventChange {
    public InstalacionChange(Instalacion instalacion) {
        apply((InstalacionCreada event) -> {
            instalacion.sauna = new Sauna();
            instalacion.turco = new Turco();
            instalacion.maquinas = new HashSet<>();
            instalacion.sede = null;
        });

        apply((MaquinaAgregada event) -> {
            instalacion.maquinas.add(new Maquina(event.getIdentity(), event.getTipoMaquina(), event.getDescripcion()));
        });
    }
}
