package br.com.hr.payload.repository;


import br.com.hr.payload.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {



}
