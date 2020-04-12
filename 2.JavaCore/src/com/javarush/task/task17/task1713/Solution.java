package com.javarush.task.task17.task1713;

/* 
Общий список
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }
    public synchronized int size(){
        return original.size();
    }
    public synchronized boolean isEmpty(){
        return original.isEmpty();
    }
    public synchronized boolean contains(Object o){
        return original.contains(o);
    }
    public synchronized Iterator<Long> iterator(){
        return original.iterator();
    }
    public synchronized Object[] toArray(){
        return original.toArray();
    }
    public synchronized <T> T[] toArray(T[] a){
        return original.toArray(a);
    }
    public synchronized boolean add(Long e){
        return original.add(e);
    }
    public synchronized boolean remove(Object o){
        return original.remove(o);
    }
    public synchronized boolean containsAll(Collection <?> c){
        return original.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> c) {
        return original.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        return original.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return original.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return original.retainAll(c);
    }

    @Override
    public synchronized void clear() {
            original.clear();
    }

    @Override
    public synchronized Long get(int index) {
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    public synchronized void add(int index, Long element) {
            original.add(index, element);
    }

    @Override
    public synchronized Long remove(int index) {
        return original.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int index) {
        return original.listIterator(index);
    }

    @Override
    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }
}
