package org.example;

public class File extends Component {
    public File(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(getTab()+"- File => "+name);
    }
}
