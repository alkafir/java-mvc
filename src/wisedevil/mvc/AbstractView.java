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
 * This class represents a view object.
 *
 * @param <M> The model type which is going to be viewed
 */
public abstract class AbstractView<M extends AbstractModel> implements Viewable {
	/**
	 * The associated controller object.
	 */
	private final AbstractController<M> controller;
	
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
	protected AbstractView(AbstractController<M> c) {
		
		if(c != null) {
			// Set the controller
			controller = c;
			
			// Register against the controller
			c.setView(this);
		} else throw new NullPointerException(); // Controller cannot be null
	}
	
	/**
	 * Returns the associated controller object.
	 *
	 * @return The associated controller object
	 */
	public AbstractController<M> getController() { return controller; }
	
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

