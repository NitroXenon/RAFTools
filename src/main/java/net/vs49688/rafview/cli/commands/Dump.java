/*
 * RAFTools - Copyright (C) 2015 Zane van Iperen.
 *    Contact: zane.vaniperen@uqconnect.edu.au
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2, and only
 * version 2 as published by the Free Software Foundation. 
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Any and all GPL restrictions may be circumvented with permission from the
 * the original author.
 */
package net.vs49688.rafview.cli.commands;

import java.io.*;
import net.vs49688.rafview.cli.Model;
import net.vs49688.rafview.interpreter.*;

public class Dump implements ICommand {

	private final Model m_Model;
	private final PrintStream m_Console;
	
	public Dump(PrintStream out, Model model) {
		m_Console = out;
		m_Model = model;
	}
	
	@Override
	public void process(String cmdLine, String[] args) throws CommandException, Exception {
		if(args.length != 2)
			throw new CommandException(cmdLine, "dump: Invalid arguments");

		PrintStream stream;
		if(args[1].equals("-")) {
			stream = m_Console;
		} else {
			stream = new PrintStream(new File(args[1]));
		}
		
		m_Model.getVFS().dumpPaths(stream);
	}

	@Override
	public String getCommand() {
		return "dump";
	}

	@Override
	public String getUsageString() {
		return "[-|path_to_file]";
	}
	
	@Override
	public String getDescription() {
		return "Dump the currently-loaded VFS index.";
	}
}
