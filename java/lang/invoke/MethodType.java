/* MethodType.java -- Method handle argument and return types.
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

import java.io.Serializable;
import java.util.List;

/**
 * A MethodType represents argument and return types of method handles.
 *
 * @since 1.7
 */
public final class MethodType
  implements Serializable
{
  MethodType(Class<?> rtype, Class<?>[] ptypes)
  {
    this.rtype  = rtype;
    this.ptypes = ptypes;
  }

  public static MethodType methodType(Class<?> rtype, Class<?>[] ptypes)
  {
    return new MethodType(rtype, ptypes);
  }

  public static MethodType methodType(Class<?> rtype, List<Class<?>> ptypes)
  {
    return methodType(rtype, ptypes.toArray(new Class<?>[0]));
  }

  public static MethodType methodType(Class<?> rtype, Class<?> ptype0, Class<?>... ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodType methodType(Class<?> rtype)
  {
    return methodType(rtype, new Class<?>[0]);
  }

  public static MethodType methodType(Class<?> rtype, Class<?> ptype0)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodType methodType(Class<?> rtype, MethodType ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodType genericMethodType(int paramCount, boolean lastIsArray)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodType genericMethodType(int paramCount)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType changeParameterType(int idx, Class<?> nptype)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType insertParameterTypes(int idx, Class<?>... ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType appendParameterTypes(Class<?>... ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType insertParameterTypes(int idx, List<Class<?>> ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType appendParameterTypes(List<Class<?>> ptypes)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType dropParameterTypes(int start, int end)
  {
    throw new UnsupportedOperationException();
  }

  public MethodType changeReturnType(Class<?> type)
  {
    throw new UnsupportedOperationException();
  }

  public boolean hasPrimitives()
  {
    throw new UnsupportedOperationException();
  }

  public boolean hasWrappers()
  {
    throw new UnsupportedOperationException();
  }

  public MethodType erase()
  {
    throw new UnsupportedOperationException();
  }

  public MethodType generic()
  {
    throw new UnsupportedOperationException();
  }

  public MethodType wrap()
  {
    throw new UnsupportedOperationException();
  }

  public MethodType unwrap()
  {
    throw new UnsupportedOperationException();
  }

  public Class<?> parameterType(int idx)
  {
    throw new UnsupportedOperationException();
  }

  public int parameterCount()
  {
    return ptypes.length;
  }

  public Class<?> returnType()
  {
    return rtype;
  }

  public List<Class<?>> parameterList()
  {
    throw new UnsupportedOperationException();
  }

  public Class<?>[] parameterArray()
  {
    return ptypes;
  }

  public boolean equals(Object object)
  {
    throw new UnsupportedOperationException();
  }

  public int hashCode()
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    throw new UnsupportedOperationException();
  }

  public static MethodType fromMethodDescriptorString(String descriptor, ClassLoader loader) throws IllegalArgumentException, TypeNotPresentException
  {
    throw new UnsupportedOperationException();
  }

  public String toMethodDescriptorString()
  {
    throw new UnsupportedOperationException();
  }

  private final Class<?> rtype;
  private final Class<?>[] ptypes;

  private static final long serialVersionUID = -1L;
}
