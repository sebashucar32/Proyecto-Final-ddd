package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.tienda.value.NombreProducto;
import co.com.sofka.ddd.tienda.value.ProductoId;
import co.com.sofka.ddd.tienda.value.TipoCategoria;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductoFactory {
    private Set<Producto> productos;
    private static ProductoFactory instance;

    private ProductoFactory() {
        productos = new HashSet<>();
    }

    public static ProductoFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new ProductoFactory();
            return instance;
        }
        return instance;
    }

    public ProductoFactory add(ProductoId productoId, NombreProducto nombreProducto, TipoCategoria tipoCategoria) {
        productos.add(new Producto(productoId, nombreProducto, tipoCategoria));
        return this;
    }

    public Set<Producto> productos() {
        return productos;
    }
}
