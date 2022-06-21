package co.com.sofka.ddd.tienda.command;

import co.com.sofka.ddd.instalacion.MaquinaFactory;
import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.ddd.tienda.ProductoFactory;
import co.com.sofka.ddd.tienda.value.TiendaId;
import co.com.sofka.domain.generic.Command;

public class AgregarProductoCommand extends Command {
    private final ProductoFactory productoFactory;
    private final TiendaId tiendaId;

    public AgregarProductoCommand(ProductoFactory productoFactory, TiendaId tiendaId) {
        this.productoFactory = productoFactory;
        this.tiendaId = tiendaId;
    }

    public ProductoFactory getProductoFactory() {
        return productoFactory;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
