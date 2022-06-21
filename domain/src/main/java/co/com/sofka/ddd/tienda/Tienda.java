package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.ddd.tienda.event.ProductoCreado;
import co.com.sofka.ddd.tienda.event.SillaCreada;
import co.com.sofka.ddd.tienda.event.TiendaCreada;
import co.com.sofka.ddd.tienda.value.Accesorios;
import co.com.sofka.ddd.tienda.value.TiendaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Tienda extends AggregateEvent<TiendaId> {
    protected Set<Producto> productos;
    protected Televisor televisor;
    protected Set<Silla> sillas;
    protected Accesorios accesorios;

    public Tienda(TiendaId tiendaId) {
        super(tiendaId);
        subscribe(new TiendaChange(this));
    }

    public Tienda(TiendaId tiendaId, Accesorios accesorios) {
        super(tiendaId);
        subscribe(new TiendaChange(this));
        appendChange(new TiendaCreada(accesorios)).apply();
    }

    public static Tienda from(TiendaId tiendaId, List<DomainEvent> eventsBy) {
        var tienda = new Tienda(tiendaId);
        eventsBy.forEach(tienda::applyEvent);
        return tienda;
    }

    public void addProductos(ProductoFactory productoFactory) {
        productoFactory.productos()
                .forEach(producto -> {
                    appendChange(
                            new ProductoCreado(producto.identity(), producto.nombreProducto(), producto.tipoCategoria())
                    ).apply();
                });
    }

    public void addSillas(SillaFactory sillaFactory) {
        sillaFactory.sillas()
                .forEach(silla -> {
                    appendChange(
                            new SillaCreada(silla.identity(), silla.peso(), silla.longitud())
                    ).apply();
                });
    }
}
