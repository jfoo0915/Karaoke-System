/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author Lim Wen Jing
 * @param <T>
 *
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }

    private int binarySearch(T searchEntry) {
        int first = 0;
        int last = numberOfEntries - 1;

        while (first <= last) {                                     //stop when array have one element
            int mid = (first + last) / 2;
            if (searchEntry.equals(array[mid])) //searchEntry is equals to array[mid]  --> stopping condition
            {
                return mid;
            } else if (searchEntry.compareTo(array[mid]) < 0) //searchEntry is less than the array[mid]  --> searchEntry present before the mid
            {
                last = mid - 1;
            } else //searchEntry is greater than the array[mid]  --> searchEntry present after the mid
            {
                first = mid + 1;
            }
        }
        return -(last + 1);     //searchEntry not exist in the array
    }

    @Override
    public boolean add(T newEntry) {
        int i = binarySearch(newEntry);

        if (contains(newEntry)) {
            return false;
        } else if (isEmpty()) {  //if array is empty, put the newEntry at the first place
            array[0] = newEntry;
            numberOfEntries++;
            return true;
        } else {
            if (isArrayFull()) {
                doubleArray();
            }
            //if the array is not empty and newEntry does not exist in the array
            makeRoom(-(i) + 1);             //create a space to shift the current entry at [i] to one place behind
            array[-(i)] = newEntry;         //newEntry replace the current entry at [i] 
            numberOfEntries++;
            return true;
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int i = lastIndex; i >= newIndex; i--) {  //start to shift the last entry to the next place, then the previous entry to the current place, until all the entries at the place where the newEnry is added are shift to one place behind the original. 
            array[i + 1] = array[i]; //move the entry one place behind their originla position
        }
    }

    @Override
    public boolean remove(T anEntry) {
        if (numberOfEntries == 0) {
            return false;
        }
        if (!contains(anEntry)) {
            return false;
        } else {
            int i = binarySearch(anEntry);
            removeGap(i + 1);
            numberOfEntries--;
            return true;
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int i = removedIndex; i < lastIndex; i++) {  //start from the removed index, shift the entry at the next to then current index, until reach the last index
            array[i] = array[i + 1];
        }
    }

    @Override
    public boolean contains(T anEntry) {
        int i = binarySearch(anEntry);
        if (anEntry == array[0]) {
            return true;
        } else if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldArray = array;
        int oldSize = oldArray.length;

        array = (T[]) new Comparable[2 * oldSize];
        System.arraycopy(oldArray, 0, array, 0, oldSize); //copy the oldArray st position 0 to array at position 0 with the length of old size

    }

    @Override
    public String toString() {
        String output = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            output += array[index] + "\n";
        }
        return output;
    }

    @Override
    public Iterator<T> getIterator() {
        return new SortedArrayListIterator();
    }

    private class SortedArrayListIterator implements Iterator<T> {

        private int nextIndex;

        private SortedArrayListIterator() {
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextEntry = array[nextIndex];
                nextIndex++; // advance iterator
                return nextEntry;
            } else {
                return null;
            }
        }
    }

}
