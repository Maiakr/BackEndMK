package com.portfolio.mk.Controller;

import com.portfolio.mk.Entity.Persona;
import com.portfolio.mk.Service.ImpPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontendmk-a7321.web.app")

public class PersonaController {
    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre")String nuevoNombre,
                                @RequestParam("apellido")String nuevoApellido,
                                @RequestParam("img")String nuevoImg) {
        Persona persona = personaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        personaService.savePersona(persona);
        return persona;

    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return personaService.findPersona((long)1);
    }
}
