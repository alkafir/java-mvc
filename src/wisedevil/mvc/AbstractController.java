/*
 * Wisedevil's MVC: MVC library for the Java platform
 *    Copyright (C) 2014  Alfredo Mungo
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package wisedevil.mvc;

/**
 * This class represents a controller object.
 */
public abstract class AbstractController {
	/**
	 * The associated model.
	 */
	private AbstractModel model;
	
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
		
		// Register against the model for observation
		setModel(model);
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
	 * Sets a new model.
	 *
	 * @param m The new model (<code>null</code> to unset)
	 */
	protected void setModel(AbstractModel m) {
		if(model != null)
			m.removeController(this);
		
		model = m;
		
		if(model != null)
			m.addController(this);
	}
	
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
	void setView(AbstractView v) {
		view = v;
	}
	
	/**
	 * This method is called whenever a message is received by the controller.
	 *
	 * @param msg The update message
	 */
	protected abstract void update(Message msg);
	
	/**
	 * Disposes of the controller.
	 */
	public void dispose() {
		setModel(null);
	}
}

