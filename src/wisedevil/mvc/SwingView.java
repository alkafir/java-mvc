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

import java.awt.Component;

import javax.swing.JOptionPane;

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
	
	/**
	 * Shows a warning message.
	 *
	 * @param parent The parent of the JOptionPane that will pop-up
	 * @param message The message to display
	 * @param title The title of the message
	 *
	 * @throws java.awt.HeadlessException If GraphicsEnvironment.isHeadless returns true
	 */
	protected void showWarning(Component parent, Object message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Shows an error message.
	 *
	 * @param parent The parent of the JOptionPane that will pop-up
	 * @param message The message to display
	 * @param title The title of the message
	 *
	 * @throws java.awt.HeadlessException If GraphicsEnvironment.isHeadless returns true
	 */
	protected void showError(Component parent, Object message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Shows an information message.
	 *
	 * @param parent The parent of the JOptionPane that will pop-up
	 * @param message The message to display
	 * @param title The title of the message
	 *
	 * @throws java.awt.HeadlessException If GraphicsEnvironment.isHeadless returns true
	 */
	protected void showInformation(Component parent, Object message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
