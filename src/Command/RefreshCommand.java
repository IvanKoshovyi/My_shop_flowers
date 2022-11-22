package Command;
import Object.Comp;

public class RefreshCommand implements Command {
    private Comp comp;

    public RefreshCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.refresh();
    }
}
