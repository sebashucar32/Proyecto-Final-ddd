package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.value.ClienteId;
import co.com.sofka.ddd.persona.value.Huella;
import co.com.sofka.ddd.persona.value.Plan;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {
    private Plan plan;
    private Huella huella;

    public Cliente(ClienteId entityId, Plan plan, Huella huella) {
        super(entityId);
        this.plan = plan;
        this.huella = huella;
    }

    public Plan getPlan() {
        return plan;
    }

    public Huella getHuella() {
        return huella;
    }
}
