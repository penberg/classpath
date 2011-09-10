/* MethodHandle.java -- Method handle for invokedynamic.
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

import java.util.List;

/** A MethodHandle is a handle to executable reference to a method,
 * constructor, or field used by theinvokedynamic bytecode instruction.
 *
 * @since 1.7
 */
public abstract class MethodHandle
{
  VMMethodHandle m;

  /**
   * This class is uninstantiable outside this package.
   */
  MethodHandle(VMMethodHandle m)
  {
    this.m = m;
    m.m = this;
  }

  public MethodHandle asCollector(Class<?> type, int len)
  {
    throw new UnsupportedOperationException();
  }

  public MethodHandle asFixedArity()
  {
    throw new UnsupportedOperationException();
  }

  public MethodHandle asSpreader(Class<?> type, int len)
  {
    throw new UnsupportedOperationException();
  }

  public MethodHandle asType(MethodType type)
  {
    throw new UnsupportedOperationException();
  }

  public MethodHandle asVarargsCollector(Class<?> type)
  {
    throw new UnsupportedOperationException();
  }

  public MethodHandle bindTo(Object obj)
  {
    throw new UnsupportedOperationException();
  }

  public final Object invoke(Object... args) throws Throwable
  {
    return m.invoke(args);
  }

  public final Object invokeExact(Object... args) throws Throwable
  {
    return m.invoke(args);
  }

  public Object invokeWithArguments(List<?> args) throws Throwable
  {
    return m.invoke(args.toArray());
  }

  public Object invokeWithArguments(Object... args) throws Throwable
  {
    return m.invoke(args);
  }

  public boolean isVarargsCollector()
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    return "MethodHandle" + type().toString();
  }

  public MethodType type()
  {
    throw new UnsupportedOperationException();
  }
}
