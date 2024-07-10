import javax.swing.*;

/*
Abstract component builder template.
 */
public abstract class ComponentBuilder {
    protected JFrame frame;

    public final void buildComponent(JFrame frame) {
        this.frame = frame;
        createComponent();
        addSubcomponents();
        display();
    }

    public abstract void createComponent();
    public abstract void addSubcomponents();
    public abstract void display();
}