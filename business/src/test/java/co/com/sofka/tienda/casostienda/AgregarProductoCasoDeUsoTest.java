package co.com.sofka.tienda.casostienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.instalacion.event.InstalacionCreada;
import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.ddd.instalacion.value.Descripcion;
import co.com.sofka.ddd.instalacion.value.MaquinaId;
import co.com.sofka.ddd.instalacion.value.TipoMaquina;
import co.com.sofka.ddd.tienda.ProductoFactory;
import co.com.sofka.ddd.tienda.command.AgregarProductoCommand;
import co.com.sofka.ddd.tienda.event.ProductoCreado;
import co.com.sofka.ddd.tienda.event.TiendaCreada;
import co.com.sofka.ddd.tienda.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

public class AgregarProductoCasoDeUsoTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarProductoCasoDeUso useCase;

    private List<DomainEvent> history() {
        Accesorios accesorios = new Accesorios();

        return List.of(
                new TiendaCreada(accesorios),
                new ProductoCreado(ProductoId.of("psfoe"),
                        new NombreProducto("per"),
                        new TipoCategoria("dpsfks"))
        );
    }

    @Test
    public void agregarProductoAlaTienda() {
        ProductoFactory factory = ProductoFactory.getInstance()
                .add(ProductoId.of("pro"), new NombreProducto("granola"), new TipoCategoria("Light"))
                .add(ProductoId.of("produ"), new NombreProducto("banano"), new TipoCategoria("frutas"));

        TiendaId tiendaId = new TiendaId();
        var command = new AgregarProductoCommand(factory, tiendaId);
        when(repository.getEventsBy(tiendaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Assertions.assertEquals(2, events.size());
    }
}
