/* MethodHandles.java -- Method handle helper methods.
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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * MethodHandles contains static helper methods for method handles.
 *
 * @since 1.7
 */
public class MethodHandles
{
  public static MethodHandles.Lookup lookup()
  {
    return new MethodHandles.Lookup();
  }

  public static MethodHandles.Lookup publicLookup()
  {
    return new MethodHandles.Lookup();
  }

  public static MethodHandle arrayElementGetter(Class<?> type) throws IllegalArgumentException
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle arrayElementSetter(Class<?> type) throws IllegalArgumentException
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle spreadInvoker(MethodType type, int count)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle exactInvoker(MethodType type)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle invoker(MethodType type)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle explicitCastArguments(MethodHandle target, MethodType type)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle permuteArguments(MethodHandle target, MethodType type, int... reorder)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle constant(Class<?> type, Object value)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle identity(Class<?> type)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle insertArguments(MethodHandle target, int pos, Object... values)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle dropArguments(MethodHandle target, int pos, List<Class<?>> types)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle dropArguments(MethodHandle target, int pos, Class<?>... types)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle filterArguments(MethodHandle target, int pos, MethodHandle... filters)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle filterReturnValue(MethodHandle target, MethodHandle filter)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle foldArguments(MethodHandle target, MethodHandle combiner)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle guardWithTest(MethodHandle test, MethodHandle target, MethodHandle fallback)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle catchException(MethodHandle target, Class<? extends Throwable> type, MethodHandle handler)
  {
    throw new UnsupportedOperationException();
  }

  public static MethodHandle throwException(Class<?> returnType, Class<? extends Throwable> type)
  {
    throw new UnsupportedOperationException();
  }

  public static final class Lookup
  {
    public static final int PUBLIC = 1;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 3;
    public static final int PACKAGE = 4;

    Lookup()
    {
    }

    public Class<?> lookupClass()
    {
      throw new UnsupportedOperationException();
    }

    public int lookupModes()
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandles.Lookup in(Class<?> type)
    {
      throw new UnsupportedOperationException();
    }

    public String toString()
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle findStatic(Class<?> refc, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException
    {
      return VMMethodHandles.findStatic(this, refc, name, type);
    }

    public MethodHandle findVirtual(Class<?> refc, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException
    {
      return VMMethodHandles.findVirtual(this, refc, name, type);
    }

    public MethodHandle findConstructor(Class<?> refc, MethodType type) throws NoSuchMethodException, IllegalAccessException
    {
      return VMMethodHandles.findConstructor(this, refc, type);
    }

    public MethodHandle findSpecial(Class<?> refc, String name, MethodType type, Class<?> specialCaller) throws NoSuchMethodException, IllegalAccessException
    {
      return VMMethodHandles.findSpecial(this, refc, name, type, specialCaller);
    }

    public MethodHandle findGetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException
    {
      return VMMethodHandles.findGetter(this, refc, name, type);
    }

    public MethodHandle findSetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException
    {
      return VMMethodHandles.findSetter(this, refc, name, type);
    }

    public MethodHandle findStaticGetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException
    {
      return VMMethodHandles.findStaticGetter(this, refc, name, type);
    }

    public MethodHandle findStaticSetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException
    {
      return VMMethodHandles.findStaticSetter(this, refc, name, type);
    }

    public MethodHandle bind(Object obj, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle unreflect(Method method) throws IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle unreflectSpecial(Method method, Class<?> specialCaller) throws IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle unreflectConstructor(Constructor<?> ctor) throws IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle unreflectGetter(Field field) throws IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }

    public MethodHandle unreflectSetter(Field field) throws IllegalAccessException
    {
      throw new UnsupportedOperationException();
    }
  }
}
