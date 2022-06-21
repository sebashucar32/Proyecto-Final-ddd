package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.tienda.value.NombreProducto;
import co.com.sofka.ddd.tienda.value.ProductoId;
import co.com.sofka.ddd.tienda.value.TipoCategoria;
import co.com.sofka.domain.generic.Entity;

public class Producto extends Entity<ProductoId> {
    private NombreProducto nombreProducto;
    private TipoCategoria tipoCategoria;

    public Producto(ProductoId entityId, NombreProducto nombreProducto, TipoCategoria tipoCategoria) {
        super(entityId);
        this.nombreProducto = nombreProducto;
        this.tipoCategoria = tipoCategoria;
    }

    public NombreProducto nombreProducto() {
        return nombreProducto;
    }

    public TipoCategoria tipoCategoria() {
        return tipoCategoria;
    }
}
