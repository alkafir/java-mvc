package wisedevil.mvc;

/**
 * This class represents a controller object.
 */
public abstract class AbstractController {
	/**
	 * The associated model.
	 */
	private final AbstractModel model;
	
	/**
	 * The associated view.
	 */
	private AbstractView view;
	
	/**
	 * Initializes a new instance of this class.
	 *
	 * @param model The associated model object.
	 */
	protected AbstractController(AbstractModel model) {
		this.model = model;
	}
	
	/**
	 * Returns the associated view object.
	 *
	 * @return The associated view object
	 */
	public AbstractView getView() { return view; }
	
	/**
	 * Returns the associated model object.
	 *
	 * @return The associated model object
	 */
	public AbstractModel getModel() { return model; }
	
	/**
	 * Returns whether the controller has an associated view or not.
	 *
	 * @return True if there is an associated view, false if there isn't
	 */
	public boolean hasView() { return (view != null); }
	
	/**
	 * Sets the associated view object.
	 *
	 * @param v The view to associate with this controller
	 */
	void setView(AbstractView v) { view = v; }
}

