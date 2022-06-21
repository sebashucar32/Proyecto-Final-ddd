package co.com.sofka.ddd.instalacion.command;

import co.com.sofka.ddd.instalacion.MaquinaFactory;
import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.domain.generic.Command;

public class AgregarMaquinaCommand extends Command {
    private final MaquinaFactory maquinaFactory;
    private final InstalacionId instalacionId;

    public AgregarMaquinaCommand(MaquinaFactory maquinaFactory, InstalacionId instalacionId) {
        this.maquinaFactory = maquinaFactory;
        this.instalacionId = instalacionId;
    }

    public MaquinaFactory getMaquinaFactory() {
        return maquinaFactory;
    }

    public InstalacionId getInstalacionId() {
        return instalacionId;
    }
}
