package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.event.InstalacionCreada;
import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.ddd.instalacion.event.TemperaturaCambiada;
import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.ddd.instalacion.value.Sede;
import co.com.sofka.ddd.instalacion.value.Temperatura;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Instalacion extends AggregateEvent<InstalacionId> {
    protected Sauna sauna;
    protected Turco turco;
    protected Set<Maquina> maquinas;
    protected Sede sede;

    public Instalacion(InstalacionId instalacionId, Sede sede) {
        super(instalacionId);
        subscribe(new InstalacionChange(this));
        appendChange(new InstalacionCreada(sede)).apply();
    }

    public Instalacion(InstalacionId instalacionId) {
        super(instalacionId);
        subscribe(new InstalacionChange(this));
    }

    public Instalacion(InstalacionId instalacionId, Temperatura temperatura, Temperatura temperaturaCambiada) {
        super(instalacionId);
        subscribe(new InstalacionChange(this));
        appendChange(new TemperaturaCambiada(temperatura, temperaturaCambiada)).apply();
    }

    public static Instalacion from(InstalacionId instalacionId, List<DomainEvent> eventsBy) {
        var instalacion = new Instalacion(instalacionId);
        eventsBy.forEach(instalacion::applyEvent);
        return instalacion;
    }

    public void addMaquinas(MaquinaFactory maquinaFactory) {
        maquinaFactory.maquinas()
                .forEach(maquina ->
                    appendChange(
                            new MaquinaAgregada(maquina.identity(), maquina.tipoMaquina(), maquina.descripcion())
                    ).apply()
                );
    }
}
