package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        this.saveToHistory();
        this.model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return this.model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        this.saveToHistory();
        this.model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return this.model.getIsSelected();
    }

    public void undo() {
        if (!this.history.isEmpty()) {
            System.out.println("Memento not found in history");
            IMemento previousState = this.history.remove(this.history.size() - 1);
            this.model.restoreState(previousState);
            this.gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = this.model.createMemento();
        this.history.add(currentState);
    }
}
