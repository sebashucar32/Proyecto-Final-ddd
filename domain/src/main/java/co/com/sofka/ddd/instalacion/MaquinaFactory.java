package co.com.sofka.ddd.instalacion;

import co.com.sofka.ddd.instalacion.value.Descripcion;
import co.com.sofka.ddd.instalacion.value.MaquinaId;
import co.com.sofka.ddd.instalacion.value.TipoMaquina;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MaquinaFactory {
    private Set<Maquina> maquinas;
    private static MaquinaFactory instance;

    private MaquinaFactory() {
        maquinas = new HashSet<>();
    }

    public static MaquinaFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new MaquinaFactory();
            return instance;
        }
        return instance;
    }

    public MaquinaFactory add(MaquinaId entityId, TipoMaquina tipoMaquina, Descripcion descripcion) {
        maquinas.add(new Maquina(entityId, tipoMaquina, descripcion));
        return this;
    }

    public Set<Maquina> maquinas() {
        return maquinas;
    }
}
