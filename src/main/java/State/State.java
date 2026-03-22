package State;

public abstract class State {
    private Game game;

    public State(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    abstract void action();
}
