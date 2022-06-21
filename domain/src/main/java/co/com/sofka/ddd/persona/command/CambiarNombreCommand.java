package co.com.sofka.ddd.persona.command;

import co.com.sofka.ddd.persona.value.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CambiarNombreCommand extends Command {
    private final NombreCompleto nombreCompleto;
    private final NombreCompleto nombreCambiado;

    public CambiarNombreCommand(NombreCompleto nombreCompleto, NombreCompleto nombreCambiado) {
        this.nombreCambiado = nombreCambiado;
        this.nombreCompleto = getNombreCambiado();
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public NombreCompleto getNombreCambiado() {
        return nombreCambiado;
    }
}
