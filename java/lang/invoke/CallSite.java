/* CallSite.java -- Call site for invokedynamic.
   Copyright (C) 2011 Free Software Foundation

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

package java.lang.invoke;

/**
 * <code>CallSite</code> is a holder for <code>MethodHandle</code> which
 * represents target method of a call-site. A call-site may be linked to zero,
 * one, or multiple <code>invokedynamic</code> instructions.
 *
 * @since 1.7
 */
public abstract class CallSite
{
  CallSite(MethodType type)
  {
    if (type == null)
      throw new NullPointerException();

    this.type = type;
  }

  /**
   * Returns a <code>MethodHandle</code> that is linked to this <code>CallSite</code>
   *
   * The returned <code>MethodHandle</code> is equivalent to a
   * <code>invokedynamic</code> instruction that is linked to this
   * <code>CallSite</code>.
   *
   * @return a <code>MethodHandle</code> that is linked to this * <code>CallSite</code>
   */
  public abstract MethodHandle dynamicInvoker();

  /**
   * Returns <code>CallSite</code> target.
   * @return <code>CallSite</code> target.
   */
  public abstract MethodHandle getTarget();

  /**
   * Updates <code>CallSite</code> target.
   * @param target new <code>CallSite</code> target.
   * @throws NullPointerException if <code>target</code> is <code>null</code>
   * @throws WrongMethodTypeException if <code>target</code> type does not match <code>CallSite</code>
   */
  public abstract void setTarget(MethodHandle target);

  /**
   * Returns <code>CallSite</code> target <code>MethodType</code>.
   * @return <code>CallSite</code> target <code>MethodType</code>.
   */
  public MethodType type()
  {
    return type;
  }

  private final MethodType type;
}
