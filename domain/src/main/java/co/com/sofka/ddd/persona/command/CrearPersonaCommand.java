package co.com.sofka.ddd.persona.command;

import co.com.sofka.ddd.persona.value.Correo;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearPersonaCommand extends Command {
    private final NombreCompleto nombreCompleto;
    private final Correo correo;

    public CrearPersonaCommand(NombreCompleto nombreCompleto, Correo correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Correo getCorreo() {
        return correo;
    }
}
