package co.com.sofka.ddd.tienda.command;

import co.com.sofka.ddd.instalacion.MaquinaFactory;
import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.ddd.tienda.SillaFactory;
import co.com.sofka.ddd.tienda.value.TiendaId;
import co.com.sofka.domain.generic.Command;

public class AgregarSillaCommand extends Command {
    private final SillaFactory sillaFactory;
    private final TiendaId tiendaId;

    public AgregarSillaCommand(SillaFactory sillaFactory, TiendaId tiendaId) {
        this.sillaFactory = sillaFactory;
        this.tiendaId = tiendaId;
    }

    public SillaFactory getSillaFactory() {
        return sillaFactory;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
