package Command;
import Object.Comp;

public class CreateCommand implements Command{
    private Comp comp;

    public CreateCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute(){
        comp.create();
    }
}
