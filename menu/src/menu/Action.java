package menu;

/**
 * The {@code Action} interface represents a generic action that can be executed.
 * This interface can be implemented by any class that needs to define a specific
 * action to be performed. The action is executed using the {@code execute()} method.
 */
public interface Action 
{
    /**
     * Executes the action defined by the implementing class.
     */
    void execute();
}