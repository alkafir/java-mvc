package wisedevil.mvc;

import java.util.Observer;
import java.util.Observable;

/**
 * This class represents a view object.
 */
public abstract class AbstractView implements Observer, Viewable {
	/**
	 * The associated controller object.
	 */
	private final AbstractController controller;
	
	/**
	 * A value representing the visibility of the object (defaults to <code>false</code>).
	 */
	private boolean visible = false;
	
	/**
	 * Initialize a new instance of this class.
	 *
	 * <blockquote>Upon construction, the view is automatically registered against the model for observation.</blockquote>
	 *
	 * @param c The associated controller
	 *
	 * @throws NullPointerException if <code>c</code> is null
	 */
	protected AbstractView(AbstractController c) throws NullPointerException {
		
		if(c != null) {
			// Set the controller
			controller = c;
			
			// Register against the controller
			c.setView(this);
			
			// Register against the model for observation
			c.getModel().addObserver(this);
		} else throw new NullPointerException(); // Controller cannot be null
	}
	
	/**
	 * Returns the associated controller object.
	 *
	 * @return The associated controller object
	 */
	public AbstractController getController() { return controller; }
	
	/**
	 * This method is called whenever a model object is updated.
	 *
	 * The general contract for this method is to call the <code>update(Object)</code> method whenever an object (of the class of the associated controller's model) is updated.
	 *
	 * @see java.util.Observer#update(java.util.Observable, Object)
	 * @see #update(Object)
	 */
	public void update(Observable o, Object arg) {
		Class<? extends AbstractModel> cls = getController().getModel().getClass();
		
		if(cls.isInstance(o))
			update(arg);
	}
	
	/**
	 * This method is called whenever an instance of the model is updated.
	 *
	 * @see #update(java.util.Observable, Object)
	 */
	protected abstract void update(Object arg);
	
	/**
	 * Sets the visibility of the view.
	 *
	 * <blockquote>This method only sets a visibility variable and thus should be overridden.</blockquote>
	 *
	 * @see Viewable#isVisible(boolean)
	 */
	public void isVisible(boolean v) {
		visible = v;
	}
	
	/**
	 * @see Viewable#isVisible()
	 */
	public boolean isVisible() { return visible; }
}

