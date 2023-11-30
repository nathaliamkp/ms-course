package br.com.hr.payload.clients;

import br.com.hr.payload.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8081", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id);



}
