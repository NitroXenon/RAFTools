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
package net.vs49688.rafview.wwise.objects;

// Will be used when I can be bothered parsing Wwise events.
public class WwiseObject {
	private final long m_Length;
	private final int m_ID;
	
	/**
	 * Get the globally-unique ID of this object.
	 * This ie equivalent to calling hashCode()
	 * @return 
	 */
	public int getID() {
		return hashCode();
	}
	
	public WwiseObject(int id, long length) {
		m_Length = length;
		m_ID = id;
	}
	
	@Override
	public int hashCode() {
		return m_ID;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final WwiseObject other = (WwiseObject) obj;
		if (this.m_ID != other.m_ID) {
			return false;
		}
		return true;
	}
}
