package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantFilter {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(arr -> (veganFriendly != 1 || arr[2] == veganFriendly) && arr[3] <= maxPrice && arr[4] <= maxDistance)
                .sorted((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0])
                .map(e -> e[0])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        RestaurantFilter restaurantFilter = new RestaurantFilter();

        System.out.println(restaurantFilter.filterRestaurants(restaurants, 1, 50, 10));
    }
}
