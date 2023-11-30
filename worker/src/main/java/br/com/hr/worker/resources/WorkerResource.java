package br.com.hr.worker.resources;

import br.com.hr.worker.entities.Worker;
import br.com.hr.worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;


    @PostMapping
    public ResponseEntity<Worker> save(@RequestBody Worker worker) {
        return ResponseEntity.ok(repository.save(worker));
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
       Worker worker =  repository.findById(id).get();
         return ResponseEntity.ok(worker);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> update(@PathVariable Long id, @RequestBody Worker worker){
        Worker workerOld = repository.findById(id).get();
        workerOld.setName(worker.getName());
        workerOld.setDailyIncome(worker.getDailyIncome());
        return ResponseEntity.ok(repository.save(workerOld));
    }

}
