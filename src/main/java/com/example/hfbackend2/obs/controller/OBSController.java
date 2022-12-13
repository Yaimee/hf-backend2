package com.example.hfbackend2.obs.controller;

import com.example.hfbackend2.obs.service.OBSService;
import com.example.hfbackend2.obs.model.OBS;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/obs")
public class OBSController {

    private final OBSService service;

    @GetMapping
    public ResponseEntity<List<OBS>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OBS> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<OBS> add(@Valid @RequestBody OBS object) {
        return ResponseEntity.ok().body(service.add(object));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<OBS> delete(@PathVariable("id") Long id) {
        OBS result = service.findById(id);
        service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OBS> put (@PathVariable("id") Long id, @Valid @RequestBody OBS request){
        return ResponseEntity.ok().body(service.update(id, request, false));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<OBS> patch(@PathVariable("id") Long id, @Valid @RequestBody OBS object){
        return ResponseEntity.ok().body(service.update(id, object, true));
    }
}
