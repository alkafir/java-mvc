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

import wisedevil.mvc.msg.Message;
import wisedevil.mvc.msg.ModelMessage;
import wisedevil.mvc.msg.ViewMessage;

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
	 * <blockquote>Implementations should override this method to return a more specific superclass of AbstractView.</blockquote>
	 *
	 * @return The associated view object
	 */
	public AbstractView getView() { return view; }
	
	/**
	 * Returns the associated model object.
	 *
	 * <blockquote>Implementations should override this method to return a more specific superclass of AbstractModel.</blockquote>
	 *
	 * @return The associated model object
	 */
	public AbstractModel getModel() { return model; }
	
	/**
	 * Sets a new model.
	 *
	 * @param m The new model
	 */
	public void setModel(AbstractModel m) {
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
	 * This method is called whenever an instance of the model or view is updated.
	 *
	 * @param <M> The source type (view or model)
	 * @param msg The update message
	 */
	<M> void update(Message<M> msg) {
		if(msg instanceof ModelMessage)
			modelUpdate((ModelMessage)msg);
		else if(msg instanceof ViewMessage)
			viewUpdate((ViewMessage)msg);
	}
	
	/**
	 * Called whenever a model update message is received.
	 *
	 * @param m The message sent by the model
	 */
	protected abstract void modelUpdate(ModelMessage m);
	
	/**
	 * Called whenever a view update message is received.
	 *
	 * @param m The message sent by the view
	 */
	protected abstract void viewUpdate(ViewMessage m);
}

