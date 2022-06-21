package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.value.Descripcion;
import co.com.sofka.ddd.instalacion.value.MaquinaId;
import co.com.sofka.ddd.instalacion.value.TipoMaquina;
import co.com.sofka.domain.generic.Entity;

public class Maquina extends Entity<MaquinaId> {
    private TipoMaquina tipoMaquina;
    private Descripcion descripcion;

    public Maquina(MaquinaId entityId, TipoMaquina tipoMaquina, Descripcion descripcion) {
        super(entityId);
        this.tipoMaquina = tipoMaquina;
        this.descripcion = descripcion;
    }

    public TipoMaquina tipoMaquina() {
        return tipoMaquina;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
