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

import static javax.swing.SwingUtilities.isEventDispatchThread;
import static javax.swing.SwingUtilities.invokeLater;

/**
 * This class represents a view made of Swing components.
 */
public abstract class SwingView extends AbstractView {
	/**
	 * Initializes a new instance of this class.
	 *
	 * @param c The associated controller
	 *
	 * @throws NullPointerException if <code>c</code> is null
	 */
	public SwingView(AbstractController c) {
		super(c);
	}
	
	/**
	 * Runs a chunk of code in the EDT.
	 *
	 * @param code The chunk of code to run
	 */
	protected void runViewCode(Runnable code) {
		if(isEventDispatchThread())
			code.run();
		else
			invokeLater(code);
	}
}
