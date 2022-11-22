package Object;

import Command.Command;

public class User {
    private final Command update;
    private final Command delete;
    private final Command create;
    private final Command refresh;

    public User( Command update, Command delete, Command create, Command refresh) {
        this.update = update;
        this.delete = delete;
        this.create = create;
        this.refresh = refresh;
    }

    public void updateBouquest(){
        update.execute();
    }
    public void deleteBouquest(){
        delete.execute();
    }
    public void createBouquest(){
        create.execute();
    }
    public void refreshBouquest() {refresh.execute();}
}
