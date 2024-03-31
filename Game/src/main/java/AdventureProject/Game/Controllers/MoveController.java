package AdventureProject.Game.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AdventureProject.Game.Requests.MoveRequest;
import AdventureProject.Game.Services.MoveService;


@RestController
@RequestMapping("/game")
public class MoveController {

    @Autowired
    private MoveService moveService;

    @PostMapping("/move")
    public ResponseEntity<String> movePlayer(@RequestBody MoveRequest moveRequest) {
    String result = moveService.movePlayer(moveRequest.getDirection());
    return ResponseEntity.ok(result);
}

}
