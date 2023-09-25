package service;

import java.util.*;

public class LazyIterator<T> implements Iterable<T> {
    private final ValueLoader valueLoader;

    private long offset = 0;
    private int limit = 10;
    private List<T> data = new ArrayList<>();
    private int index;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public void setData() {
        List<T> result = this.valueLoader.load(offset, limit);
        if (result != null) {
            this.data.addAll(result);
        }
        offset += limit;
    }

    public LazyIterator(ValueLoader valueLoader) {
        this.valueLoader = valueLoader;
    }

    private class Itr implements Iterator<T> {
        @Override
        public boolean hasNext() {
            //第一次加载数据
            if (data.size() == 0)
                setData();

            //没值了，加载一次，再做判断
            if (index >= data.size()) {
                setData();
            }

            return index < data.size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) data.get(index++);
            }
            throw new NoSuchElementException("值不存在");
        }
    }

    public interface ValueLoader<T> {
        List<T> load(long offset, int limit);
    }


    public static void main(String[] args) {
        ValueLoader valueLoader = new ValueLoader() {
            @Override
            public List load(long offset, int limit) {
                List<String> strings = new ArrayList<>();
                if (offset == 0) {
                    strings.add("1");
                    strings.add("2");
                    strings.add("3");
                    strings.add("4");
                    strings.add("5");
                } else if (offset == 10) {
                    strings.clear();
                    strings.add("6");
                    strings.add("7");
                    strings.add("8");
                    strings.add("9");
                    strings.add("10");
                }
                return strings;
            }
        };

        LazyIterator<String> lazyIterator = new LazyIterator<>(valueLoader);

        for (String s : lazyIterator) {
            System.out.println(s);
        }

    }

}
