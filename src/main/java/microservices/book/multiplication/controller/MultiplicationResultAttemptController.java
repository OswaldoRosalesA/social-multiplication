package microservices.book.multiplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;
    private final int serverPort;

    public MultiplicationResultAttemptController(MultiplicationService multiplicationService, @Value("${server.port}") int serverPort) {
        this.multiplicationService = multiplicationService;
        this.serverPort = serverPort;
    }

    @PostMapping
    public ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        MultiplicationResultAttempt attemptCopy = multiplicationService.checkAttempt(multiplicationResultAttempt);;
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    public ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(
                multiplicationService.getStatsForUser(alias)
        );
    }

    @GetMapping(path = "/{resultId}")
    public ResponseEntity<MultiplicationResultAttempt> getResultById(@PathVariable("resultId") long resultId) {
        log.info("Retrieving result {} from server @ {}", resultId, serverPort);
        MultiplicationResultAttempt resultAttempt = multiplicationService.getResultById(resultId);
        return ResponseEntity.ok(resultAttempt);
    }

}
