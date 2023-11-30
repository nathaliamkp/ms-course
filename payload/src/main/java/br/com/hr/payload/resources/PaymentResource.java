package br.com.hr.payload.resources;

import br.com.hr.payload.entities.Payment;
import br.com.hr.payload.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentResource {
    
    @Autowired
    private PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days){
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

}
