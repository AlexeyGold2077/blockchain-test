package ru.leshaserver.blockchain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Blockchain blockchain = new Blockchain();

    @GetMapping("/block/data")
    public String blockchain(@RequestParam(value = "blockNumber", defaultValue = "0") Integer blockNumber) {
        return blockchain.getBlockData(blockNumber);
    }
}
