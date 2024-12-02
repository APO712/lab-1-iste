package es.upm.dit.apsv.traceserver.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import es.upm.dit.apsv.traceserver.repository.TraceRepository;
import es.upm.dit.apsv.traceserver.model.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TraceController {

    private final TraceRepository tr;

    public TraceController(TraceRepository tr) {
        this.tr = tr;
    }

    @GetMapping("/traces")
    public List<Trace> all() {
        return (List<Trace>) tr.findAll();
    }

    @PostMapping("/traces")
    public Trace newTraze(@RequestBody Trace newTrace) {
        return tr.save(newTrace);
    }

    @GetMapping("/traces/{id}")
    public Trace one(@PathVariable String id) {
        return tr.findById(id).orElseThrow();
    }

    @PutMapping("/traces/{id}")
    public Trace replaceTraze(@RequestBody Trace newTrace, @PathVariable String id) {
        return tr.findById(id).map(trace -> {
            trace.setTraceId(newTrace.getTraceId());
            trace.setTruck(newTrace.getTruck());
            trace.setLastSeen(newTrace.getLastSeen());
            trace.setLat(newTrace.getLat());
            trace.setLng(newTrace.getLng());
            return tr.save(trace);
        }).orElseGet(() -> {
            newTrace.setTraceId(id);
            return tr.save(newTrace);
        });
    }

    @DeleteMapping("/traces/{id}")
    public void deleteTraze(@PathVariable String id) {
        tr.deleteById(id);
    }
}
