package pl.slaszu.tictactoe.ui.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slaszu.tictactoe.domain.Player;
import pl.slaszu.tictactoe.domain.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAll() {

        Iterable<Player> result = playerRepository.findAll();

        return (List<Player>) result;
    }

    @PostMapping
    public Player create() {

        int min = 10, max = 10000;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        Player player = new Player(randomNum, "Test "+ String.valueOf(randomNum));

        this.playerRepository.save(player);

        return player;
    }

}
