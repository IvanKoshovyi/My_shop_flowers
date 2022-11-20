package Command;
import Object.Comp;

public class DeleteCommand implements Command {
    private Comp comp;

    public DeleteCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute(){
        comp.delete();
    }
}
