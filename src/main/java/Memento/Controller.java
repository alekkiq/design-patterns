package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoHistory;
    private List<IMemento> timeline;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public List<IMemento> getTimeline() {
        return this.timeline;
    }

    public void setOption(int optionNumber, int choice) {
        this.saveToHistory();
        this.redoHistory.clear();
        this.model.setOption(optionNumber, choice);
        this.timeline.add(this.model.createMemento());
    }

    public int getOption(int optionNumber) {
        return this.model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        this.saveToHistory();
        this.redoHistory.clear();
        this.model.setIsSelected(isSelected);
        this.timeline.add(this.model.createMemento());
    }

    public boolean getIsSelected() {
        return this.model.getIsSelected();
    }

    public void undo() {
        if (!this.history.isEmpty()) {
            System.out.println("Memento found in history");
            this.redoHistory.add(this.model.createMemento());
            IMemento previousState = this.history.remove(this.history.size() - 1);
            this.model.restoreState(previousState);
            this.gui.updateGui();
        }
    }

    public void redo() {
        if (!this.redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            this.history.add(this.model.createMemento());
            IMemento nextState = this.redoHistory.remove(this.redoHistory.size() - 1);
            this.model.restoreState(nextState);
            this.gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = this.model.createMemento();
        this.history.add(currentState);
    }

    public void restoreHistoryPoint(int index) {
        IMemento memento = this.timeline.get(index);
        this.model.restoreState(memento);
        this.history.clear();
        this.redoHistory.clear();
        this.gui.updateGui();
    }
}
