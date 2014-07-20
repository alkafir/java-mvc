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

import java.util.LinkedHashSet;
import java.util.Set;

import wisedevil.mvc.msg.ModelMessage;

/**
 * This class represents a model object.
 */
public abstract class AbstractModel {
	/**
	 * The set of controllers using this model.
	 */
	private Set<AbstractController> ctrls; // Controllers
	
	/**
	 * Initializes a new instance of this class.
	 */
	public AbstractModel() {
		ctrls = new LinkedHashSet<AbstractController>();
	}
	
	/**
	 * Adds a controller for update notification.
	 *
	 * @param c The controller
	 */
	void addController(AbstractController c) {
		ctrls.add(c);
	}
	
	/**
	 * Removes a controller from the set of update-notified controllers.
	 *
	 * @param c The controller
	 */
	void removeController(AbstractController c) {
		ctrls.remove(c);
	}
	
	/**
	 * Notifies the controller that this model has been updated.
	 *
	 * @param msg An application-dependent integer representation of the performed action
	 * @param arg An optional application-dependent argument of the message
	 */
	protected void notifyUpdate(int msg, Object arg) {
		for(AbstractController c: ctrls)
			c.update(new ModelMessage(this, msg, arg));
	}
	
	/**
	 * Disposes of the model.
	 */
	public abstract void dispose();
}

