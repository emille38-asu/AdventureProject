package AdventureProject.Game.Requests;

public class MoveRequest {

    private String direction;

    // Default constructor for JSON parsing
    public MoveRequest() {
    }

    public MoveRequest(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    // hashCode, equals, and toString methods can be added as needed
}

