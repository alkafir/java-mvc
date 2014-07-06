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

import java.util.Observable;

/**
 * This class represents a view object.
 */
public abstract class AbstractView extends Observable {
	/**
	 * The associated controller object.
	 */
	private final AbstractController controller;
	
	/**
	 * Initialize a new instance of this class.
	 *
	 * <blockquote>Upon construction, the view is automatically registered against the model for observation.</blockquote>
	 *
	 * @param c The associated controller
	 *
	 * @throws NullPointerException if <code>c</code> is null
	 */
	protected AbstractView(AbstractController c) {
		super();
		
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
	 * <blockquote>Implementations should override this method to return a more specific superclass of AbstractController.</blockquote>
	 *
	 * @return The associated controller object
	 */
	public AbstractController getController() { return controller; }
}

