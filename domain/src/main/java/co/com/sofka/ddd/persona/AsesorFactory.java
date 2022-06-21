package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.value.AsesorId;
import co.com.sofka.ddd.persona.value.EstudiosAsesor;
import co.com.sofka.ddd.persona.value.RolAsesor;

import java.util.Objects;

public class AsesorFactory {
    private final Asesor asesor;
    private static AsesorFactory instance;

    public AsesorFactory() {
        this.asesor = new Asesor(AsesorId.of("fpdg"), new RolAsesor("sads"), new EstudiosAsesor("odfsk"));
    }

    public static AsesorFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new AsesorFactory();
            return instance;
        }
        return instance;
    }

    public AsesorFactory agregar(AsesorId asesorId, RolAsesor rolAsesor, EstudiosAsesor estudiosAsesorl) {
        asesor.setEstudiosAsesor(estudiosAsesorl);
        asesor.setRolAsesor(rolAsesor);
        return this;
    }

    public Asesor asesor() {
        return asesor;
    }
}
