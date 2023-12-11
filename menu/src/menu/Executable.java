package menu;

/**
 * The {@code Executable} class encapsulates an action that can be executed.
 * It is designed to hold an instance of an {@code Action} and allows for
 * the execution of the encapsulated action. This class provides a way to
 * defer the execution of an action or to pass it around.
 */
public class Executable 
{
    private Action action;

    /**
     * Constructs an {@code Executable} object with the specified {@code Action}.
     * 
     * @param action The {@code Action} to be encapsulated within this {@code Executable}.
     *               The action represents a task or operation to be executed.
     */
    public Executable(Action action) 
    {
        this.action = action;
    }

    /**
     * Executes the action encapsulated by this {@code Executable}.
     * If the action is non-null, it calls the {@code execute} method of the {@code Action} interface.
     * If the action is null, this method does nothing.
     */
    public void execute() 
    {
        if(action != null) 
        {
            action.execute();
        }
    }
}
