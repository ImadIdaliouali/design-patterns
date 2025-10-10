package org.example;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {
    private List<Component> Components=new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(getTab()+"- Folder : "+name);
        for (Component c : Components){
            c.display();
        }
    }

    public Component add(Component c){
        this.Components.add(c);
        c.level = this.level +1;
        return c;
    }
    public void remove(Component Component){
        Components.remove(Component);
    }
}
