package br.com.hr.payload.service;

import br.com.hr.payload.clients.WorkerFeignClient;
import br.com.hr.payload.entities.Payment;
import br.com.hr.payload.entities.Worker;
import br.com.hr.payload.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;
    @Autowired
    private PaymentRepository repository;

    public Payment getPayment(long workId, int days){

        Worker worker = client.findById(workId).getBody();
        assert worker != null;

        return repository.save(new Payment(worker.getName(), worker.getDailyIncome(), days));
    }

}
