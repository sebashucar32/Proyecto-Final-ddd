package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.tienda.event.ProductoCreado;
import co.com.sofka.ddd.tienda.event.SillaCreada;
import co.com.sofka.ddd.tienda.event.TiendaCreada;
import co.com.sofka.ddd.tienda.value.ProductoId;
import co.com.sofka.ddd.tienda.value.SillaId;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class TiendaChange extends EventChange {
    public TiendaChange(Tienda tienda) {
        apply((TiendaCreada event) -> {
            tienda.productos = new HashSet<>();
            tienda.televisor = new Televisor();
            tienda.sillas = new HashSet<>();
            tienda.accesorios = null;
        });

        apply((ProductoCreado event) -> {
            tienda.productos.add(new Producto(event.getIdentity(), event.getNombreProducto(), event.getTipoCategoria()));
        });

        apply((SillaCreada event) -> {
            tienda.sillas.add(new Silla(event.getIdentity(), event.getPeso(), event.getLongitud()));
        });
    }
}
