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

import gnu.java.lang.CPStringBuilder;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

/**
 * A MethodType represents argument and return types of method handles.
 *
 * @since 1.7
 */
public final class MethodType
  implements Serializable
{
  private static final long serialVersionUID = -1L;

  private final Class<?> rtype;
  private final List<Class<?>> ptypes;

  MethodType(Class<?> rtype, List<Class<?>> ptypes)
  {
    if (rtype == null || ptypes == null)
      throw new NullPointerException();

    this.rtype  = rtype;
    this.ptypes = ptypes;

    checkParamTypes();
  }

  private void checkParamTypes()
  {
    for (Class<?> p : ptypes)
    {
      if (void.class.equals(p))
        throw new IllegalArgumentException();
    }
  }

  public static MethodType methodType(Class<?> rtype, Class<?>[] ptypes)
  {
    return methodType(rtype, Arrays.asList(ptypes));
  }

  public static MethodType methodType(Class<?> rtype, List<Class<?>> ptypes)
  {
    return new MethodType(rtype, ptypes);
  }

  public static MethodType methodType(Class<?> rtype, Class<?> ptype0, Class<?>... ptypes)
  {
    LinkedList<Class<?>> nptypes = new LinkedList<Class<?>>();

    nptypes.add(ptype0);
    nptypes.addAll(Arrays.<Class<?>>asList(ptypes));

    return methodType(rtype, nptypes);
  }

  public static MethodType methodType(Class<?> rtype)
  {
    return methodType(rtype, Collections.<Class<?>>emptyList());
  }

  public static MethodType methodType(Class<?> rtype, Class<?> ptype)
  {
    return methodType(rtype, Arrays.<Class<?>>asList(ptype));
  }

  public static MethodType methodType(Class<?> rtype, MethodType ptypes)
  {
    return methodType(rtype, ptypes.ptypes);
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
    List<Class<?>> nptypes = new LinkedList<Class<?>>(ptypes);

    nptypes.set(idx, nptype);

    return methodType(rtype, nptypes);
  }

  public MethodType insertParameterTypes(int idx, Class<?>... ptypes)
  {
    return insertParameterTypes(idx, Arrays.<Class<?>>asList(ptypes));
  }

  public MethodType appendParameterTypes(Class<?>... ptypes)
  {
    return appendParameterTypes(Arrays.<Class<?>>asList(ptypes));
  }

  public MethodType insertParameterTypes(int idx, List<Class<?>> types)
  {
    List<Class<?>> nptypes = new LinkedList<Class<?>>(ptypes);

    nptypes.addAll(idx, types);

    return methodType(rtype, nptypes);
  }

  public MethodType appendParameterTypes(List<Class<?>> types)
  {
    List<Class<?>> nptypes = new LinkedList<Class<?>>(ptypes);

    nptypes.addAll(types);

    return methodType(rtype, nptypes);
  }

  public MethodType dropParameterTypes(int start, int end)
  {
    if (start < 0 || start > parameterCount() || end < 0 || end > parameterCount() || end > start)
      throw new IndexOutOfBoundsException();

    int len = end-start;

    List<Class<?>> nptypes = new LinkedList<Class<?>>(ptypes);

    while (len-- > 0)
      nptypes.remove(start);

    return methodType(rtype, nptypes);
  }

  public MethodType changeReturnType(Class<?> type)
  {
    return methodType(type, ptypes);
  }

  public boolean hasPrimitives()
  {
    if (rtype.isPrimitive())
      return true;

    for (Class<?> p : ptypes) {
      if (p.isPrimitive())
        return true;
    }

    return false;
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
    return ptypes.get(idx);
  }

  public int parameterCount()
  {
    return ptypes.size();
  }

  public Class<?> returnType()
  {
    return rtype;
  }

  public List<Class<?>> parameterList()
  {
    return Collections.unmodifiableList(ptypes);
  }

  public Class<?>[] parameterArray()
  {
    return ptypes.toArray(new Class<?>[0]);
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;

    if (!(obj instanceof MethodType))
      return false;

    MethodType mh = (MethodType) obj;

    return rtype.equals(mh.rtype) && ptypes.equals(mh.ptypes);
  }

  public int hashCode()
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    Iterator<Class<?>> itr = ptypes.iterator();
    CPStringBuilder r = new CPStringBuilder("(");
    boolean hasNext = itr.hasNext();
    while (hasNext)
      {
        Class<?> current = itr.next();
        r.append(current.getSimpleName());
        hasNext = itr.hasNext();
        if (hasNext)
          r.append(",");
      }
    r.append(")");
    r.append(rtype.getSimpleName());
    return r.toString();
  }

  public static MethodType fromMethodDescriptorString(String descriptor, ClassLoader loader) throws IllegalArgumentException, TypeNotPresentException
  {
    throw new UnsupportedOperationException();
  }

  public String toMethodDescriptorString()
  {
    Iterator<Class<?>> itr = ptypes.iterator();
    CPStringBuilder r = new CPStringBuilder("(");
    for (Class<?> ptype : ptypes)
      {
        appendClassDescriptor(r, ptype);
      }
    r.append(")");
    appendClassDescriptor(r, rtype);
    return r.toString();
  }

  private static void appendClassDescriptor(CPStringBuilder r, Class<?> klass)
  {
    if (klass.isPrimitive())
      {
        if (byte.class.equals(klass))
          r.append('B');
        else if (char.class.equals(klass))
          r.append('C');
        else if (double.class.equals(klass))
          r.append('D');
        else if (float.class.equals(klass))
          r.append('F');
        else if (int.class.equals(klass))
          r.append('I');
        else if (long.class.equals(klass))
          r.append('J');
        else if (short.class.equals(klass))
          r.append('S');
        else if (boolean.class.equals(klass))
          r.append('Z');
        else if (void.class.equals(klass))
          r.append('V');
      }
    else
      {
        r.append('L');
        r.append(klass.getName().replace('.','/'));
        r.append(';');
      }
  }
}
