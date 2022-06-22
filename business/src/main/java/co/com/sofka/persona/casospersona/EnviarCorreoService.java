package co.com.sofka.persona.casospersona;

import co.com.sofka.ddd.persona.value.Correo;

public interface EnviarCorreoService {
    void enviarCorreo(Correo correo, String body);
}
