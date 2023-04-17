/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author Lim Zhen Foo
 */
public interface SetInterface<T> {

    public boolean add(T newElement);

    public boolean remove(T anElement);

    public int size();

    public boolean contains(T anElement);

    public boolean checkSubset(SetInterface anotherSet);

    public SetInterface union(SetInterface anotherSet);

    public SetInterface intersection(SetInterface anotherSet);

    public SetInterface difference(SetInterface anotherSet);

    public boolean isEmpty();

    public boolean setEquality(SetInterface anotherSet);

    public Iterator<T> getIterator();
}
