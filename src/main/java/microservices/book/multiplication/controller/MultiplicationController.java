package microservices.book.multiplication.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/multiplications")
final class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @GetMapping("/random")
    public Multiplication getRandomMultiplication(){
        return multiplicationService.createRandomMultiplication();
    }

}
