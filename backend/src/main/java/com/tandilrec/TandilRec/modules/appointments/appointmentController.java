package com.tandilrec.TandilRec.modules.appointments;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class appointmentController {

    @GetMapping("/my/history")
    public void getUserHistorial() {
        System.out.println(" getUserAppointments");
    }

    @GetMapping("/my")
    public String getUserAppointmentDate(@RequestParam String date) {
        System.out.println(date);
        return date;

    }

    @PostMapping("/my")
    public void postUserAppointments() {

    }

    @PostMapping("/my/{id}/report")
    public void reportUserAppointments(@PathVariable int id) {
        System.out.println(id);
    }

    @DeleteMapping("my/{id}")
    public void deleteUserAppointments(@PathVariable int id) {
        System.out.println(id);
    }

    // ¿Conviene separar por roles o que sea la misma URL y se separe internamente en roles? Es decir, evaluaría el rol (citizen, municipal) y de ahí decidiría la base de datos a buscar
}
