/* FilerException.java -- Attempt to violate a Filer guarantee.
   Copyright (C) 2012  Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */

package javax.annotation.processing;

import java.io.IOException;

/**
 * Thrown when a {@link Filer} detects an attempt to violate one
 * of its guarantees.  This may be an attempt to create the same
 * file multiple times, an attempt to create multiple files of the
 * same type or an attempt to create a file for a type with an
 * invalid name.
 *
 * @author Andrew John Hughes (gnu_andrew@member.fsf.org)
 * @since 1.6
 */
public class FilerException
  extends IOException
{

  /**
   * Compatible with OpenJDK 1.6+
   */
  private static final long serialVersionUID = 8426423106453163293L;

  /**
   * Constructs a new {@code FilerException} with the specified
   * message.  The message should contain the name of the file
   * attempting to be opened.
   *
   * @param message the reason for the exception, or {@code null}.
   */
  public FilerException(String message)
  {
    super(message);
  }

}
