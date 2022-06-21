package co.com.sofka.ddd.tienda.event;

import co.com.sofka.ddd.tienda.value.NombreProducto;
import co.com.sofka.ddd.tienda.value.ProductoId;
import co.com.sofka.ddd.tienda.value.TipoCategoria;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class ProductoCreado extends DomainEvent {
    private final ProductoId identity;
    private final NombreProducto nombreProducto;
    private final TipoCategoria tipoCategoria;

    public ProductoCreado(ProductoId identity, NombreProducto nombreProducto, TipoCategoria tipoCategoria) {
        super("tienda.ProductoCreado");
        this.identity = identity;
        this.nombreProducto = nombreProducto;
        this.tipoCategoria = tipoCategoria;
    }

    public ProductoId getIdentity() {
        return identity;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }
}
