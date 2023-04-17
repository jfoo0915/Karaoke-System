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
public class AdtSet<T> implements SetInterface<T> {

    private Node firstNode;                                 
    private Node lastNode;                                  
    private int numberOfElement = 0;

    public AdtSet() {
        firstNode = null;
        lastNode = null;
        numberOfElement = 0;
    }

    @Override
    public boolean add(T newElement) {

        Node newNode = new Node(newElement, null);

        if (isEmpty()) {                                                        //the set have no element yet 
            firstNode = newNode;                                                //add to the first node 
            numberOfElement++;
            lastNode = newNode;
            return true;
        } else {
            if (this.contains(newElement)) {
                return false;
            }

            lastNode.next = newNode;                                            //assign new node to the current next 
            lastNode = newNode;                                                 //lastnode point to new node 
        }
        numberOfElement++;
        return true;
    }

    @Override
    public boolean remove(T anElement) {
        if (!isEmpty()) {

            if (this.contains(anElement)) {
                if (firstNode.next == null) {                                   //case 1: only have 1 element 
                    firstNode = null;                                           //the set = null
                    numberOfElement--;
                    return true;
                }
                if (firstNode.data.equals(anElement)) {                         //case 2: if first node = anElement 
                    firstNode = firstNode.next;                                 //pointing to second element 
                    numberOfElement--;
                    return true;
                }
                Node beforeNode = firstNode;                                    //current node = 1
                while (beforeNode.next != null) {                               //case 3: firstnode != anElement
                    if (beforeNode.next.data.equals(anElement)) {               //before node.next = anElement
                        if (beforeNode.next.next != null) {
                            beforeNode.next = beforeNode.next.next;             //point to .next.next element
                            numberOfElement--;                                  //decrease the number of element 

                            return true;                                         //go out from the method 

                        } else {
                            beforeNode.next = null;                             //point to .next.next element
                            numberOfElement--;                                  //decrease the number of element 
                            lastNode = beforeNode;

                            return true;                                        //go out from the method 
                        }
                    }
                    beforeNode = beforeNode.next;                               //go thru the set
                }
                return true;
            } else {
                return false;                                                   //the set doesn't contain the element
            }

        } else {
            return false;                                                       //the set is empty 
        }
    }

    @Override
    public int size() {
        return numberOfElement;
    }

    @Override
    public boolean contains(T anElement) {                                      //existingmember.contain(mem);
        Node currentSetNode = firstNode;
        while (currentSetNode != null) {
            if (currentSetNode.data.equals(anElement)) {
                return true;
            }
            currentSetNode = currentSetNode.next;
        }
        return false;
    }

    @Override
    public boolean checkSubset(SetInterface anotherSet) {                       //member.isSubset(memSpeakChinese);

        AdtSet aSet = (AdtSet) anotherSet;

        Node anotherSetNode = aSet.firstNode;
        if (aSet.numberOfElement > this.numberOfElement) {
            return false;
        }
        while (anotherSetNode != null) {
            if (!this.contains(anotherSetNode.data)) {
                return false;
            }
            anotherSetNode = anotherSetNode.next;
        }
        return true;
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {

        AdtSet newSet = new AdtSet();
        AdtSet aSet = (AdtSet) anotherSet;
        Node currentSetNode = firstNode;
        Node anotherSetNode = aSet.firstNode;
        while (currentSetNode != null) {
            newSet.add(currentSetNode.data);
            currentSetNode = currentSetNode.next;
        }

        while (anotherSetNode != null) {

            newSet.add(anotherSetNode.data);
            anotherSetNode = anotherSetNode.next;
        }

        return newSet;
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {

        AdtSet newSet = new AdtSet();

        AdtSet aSet = (AdtSet) anotherSet;
        Node currentSetNode = firstNode;

        if (!isEmpty() && !anotherSet.isEmpty()) {
            while (currentSetNode != null) {
                if (aSet.contains(currentSetNode.data)) {                       //new add
                    newSet.add(currentSetNode.data);
                }
                currentSetNode = currentSetNode.next;
            }
        }
        return newSet;
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {

        AdtSet newSet = new AdtSet();
        AdtSet aSet = (AdtSet) anotherSet;
        Node currentSetNode = firstNode;

        if (!isEmpty() && !anotherSet.isEmpty()) {
            while (currentSetNode != null) {
                if (!aSet.contains(currentSetNode.data)) {
                    newSet.add(currentSetNode.data);
                }
                currentSetNode = currentSetNode.next;
            }
        }

        return newSet;
    }

    @Override
    public boolean isEmpty() {

        return numberOfElement == 0;
    }

    @Override
    public boolean setEquality(SetInterface anotherSet) {

        AdtSet aSet = (AdtSet) anotherSet;

        if (aSet.numberOfElement != this.numberOfElement) {
            return false;
        }
        return this.checkSubset(anotherSet);
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    public Iterator<T> getIterator() {
        return new AdtSetIterator();
    }

    private class AdtSetIterator implements Iterator<T> {

        private Node currentNode;

        public AdtSetIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnData = currentNode.data;
                currentNode = currentNode.next;
                return returnData;
            } else {
                return null;
            }
        }
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
