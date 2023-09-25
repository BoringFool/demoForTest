package service;

import java.util.ArrayList;
import java.util.List;

public class BService {
    public static void main(String[] args) throws Exception {
        List<Integer> testList = new ArrayList<>();

        for (int i = 0; i < 53; i++) {
            testList.add(i);
        }

        List<Integer> resultList = BService.get(testList);
        System.out.println("resultList = " + resultList);
    }


    public static List<Integer> get(List<Integer> ids) throws Exception {
        int idsSize;
        if ((idsSize = ids.size()) > 100) {
            throw new Exception("最多支持最多传入100个id");
        }

        AService aService = new AService();
        List<Integer> subList = new ArrayList<>(10);
        List<Integer> resultList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < idsSize; i++) {
            subList.add(ids.get(i));
            //满10个，或者最后一组
            if (++count == 10 || i == idsSize - 1) {
                resultList.addAll(aService.get(subList));
                count = 0;
            }
        }

        return resultList;

    }

    static class AService {
        public List<Integer> get(List<Integer> ids) {
            List<Integer> result = new ArrayList<>();
            for (Integer id : ids) {
                //id此处处理逻辑
                result.add(id);
            }

            ids.clear();

            return result;
        }
    }
}
