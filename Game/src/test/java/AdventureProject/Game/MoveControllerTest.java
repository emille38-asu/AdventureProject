package AdventureProject.Game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Spring Security test imports
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import com.fasterxml.jackson.databind.ObjectMapper;

import AdventureProject.Game.Controllers.MoveController;
import AdventureProject.Game.Requests.MoveRequest;
import AdventureProject.Game.Services.MoveService;

// Mockito imports
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

// Spring MVC test imports
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(MoveController.class)
public class MoveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoveService moveService;

    @Test
    @WithMockUser
    public void movePlayerTest() throws Exception {
        // Arrange
        String direction = "north";
        MoveRequest moveRequest = new MoveRequest(direction);
        given(moveService.movePlayer(any())).willReturn("You moved " + direction);

        // Act & Assert
        mockMvc.perform(post("/game/move")
        .with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(moveRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("You moved " + direction));
    }
}
