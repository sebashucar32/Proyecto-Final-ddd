package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.tienda.value.Longitud;
import co.com.sofka.ddd.tienda.value.Peso;
import co.com.sofka.ddd.tienda.value.ProductoId;
import co.com.sofka.ddd.tienda.value.SillaId;
import co.com.sofka.domain.generic.Entity;

public class Silla extends Entity<SillaId> {
    private Peso peso;
    private Longitud longitud;

    public Silla(SillaId entityId, Peso peso, Longitud longitud) {
        super(entityId);
        this.peso = peso;
        this.longitud = longitud;
    }

    public Peso peso() {
        return peso;
    }

    public Longitud longitud() {
        return longitud;
    }
}
