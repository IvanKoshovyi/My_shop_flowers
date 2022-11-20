package Command;
import Object.Comp;

public class UpdateCommand implements Command{

    private Comp comp;

    public UpdateCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute(){
        comp.update();
    }
}
