package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.value.AsesorId;
import co.com.sofka.ddd.persona.value.EstudiosAsesor;
import co.com.sofka.ddd.persona.value.RolAsesor;
import co.com.sofka.domain.generic.Entity;

public class Asesor extends Entity<AsesorId> {
    private RolAsesor rolAsesor;
    private EstudiosAsesor estudiosAsesor;

    public Asesor(AsesorId entityId, RolAsesor rolAsesor, EstudiosAsesor estudiosAsesor) {
        super(entityId);
        this.rolAsesor = rolAsesor;
        this.estudiosAsesor = estudiosAsesor;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public EstudiosAsesor getEstudiosAsesor() {
        return estudiosAsesor;
    }

    public void setRolAsesor(RolAsesor rolAsesor) {
        this.rolAsesor = rolAsesor;
    }

    public void setEstudiosAsesor(EstudiosAsesor estudiosAsesor) {
        this.estudiosAsesor = estudiosAsesor;
    }
}
