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

import java.util.Observer;
import java.util.Observable;

/**
 * This class represents a controller object.
 *
 * @param <M> The model type which is going to be controlled
 */
public abstract class AbstractController<M extends AbstractModel> implements Observer {
	/**
	 * The associated model.
	 */
	private M model;
	
	/**
	 * The associated view.
	 */
	private AbstractView<M> view;
	
	/**
	 * Initializes a new instance of this class.
	 *
	 * @param model The associated model object.
	 */
	protected AbstractController(M model) {
		this.model = model;
		
		// Register against the model for observation
		setModel(model);
	}
	
	/**
	 * Returns the associated view object.
	 *
	 * @return The associated view object
	 */
	public AbstractView<M> getView() { return view; }
	
	/**
	 * Returns the associated model object.
	 *
	 * @return The associated model object
	 */
	public M getModel() { return model; }
	
	/**
	 * Sets a new model.
	 *
	 * @param model The new model
	 */
	 public void setModel(M model) {
		if(this.model != null)
			this.model.deleteObserver(this);
		
		this.model = model;
		
		if(model != null)
			model.addObserver(this);
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
	void setView(AbstractView<M> v) { view = v; }
	
	/**
	 * This method is called whenever a model object is updated.
	 *
	 * The general contract for this method is to call the <code>update(Object)</code> method whenever an object (of the class of the associated controller's model) is updated.
	 *
	 * @see java.util.Observer#update(java.util.Observable, Object)
	 * @see #update(Object)
	 */
	public void update(Observable o, Object arg) {
		Class<? extends AbstractModel> cls = getModel().getClass();
		
		if(cls.isInstance(o))
			update(arg);
	}
	
	/**
	 * This method is called whenever an instance of the model is updated.
	 *
	 * @param arg The updated object in the model instance
	 *
	 * @see #update(java.util.Observable, Object)
	 */
	protected abstract void update(Object arg);
}

