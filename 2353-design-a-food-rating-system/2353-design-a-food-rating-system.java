class FoodRatings {
	HashMap<String, TreeSet<String>> hm = new HashMap<>();
	HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
	HashMap<String, String> hm3 = new HashMap<String, String>();

	public FoodRatings(String[] foods, String[] C, int[] ratings) {
		int n = foods.length;
		for (int i = 0; i < n; i++) {
			if (hm.get(C[i]) == null) {
				hm.put(C[i], new TreeSet<String>(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						String ar1[] = o1.split(":");
						String ar2[] = o2.split(":");
						String f1 = ar1[0], f2 = ar2[0];
						int r1 = Integer.parseInt(ar1[1]), r2 = Integer.parseInt(ar2[1]);
						if (r1 == r2) {
							return f1.compareTo(f2);
						}
						return r2 - r1;
					}

				}));
			} 
			hm.get(C[i]).add(foods[i] + ":" + ratings[i]);
			hm2.put(foods[i], ratings[i]);
			hm3.put(foods[i], C[i]);
		}
		// System.out.println("-----------------");
		// System.out.print(hm);
		// System.out.println("-----------------");
	}

	public void changeRating(String food, int newRating) {
		int old = hm2.get(food);
		String key = food + ":" + old;
		String newKey = food + ":" + newRating;
		hm2.put(food, newRating);
		String cuisine = hm3.get(food);
		hm.get(cuisine).remove(key);
		hm.get(cuisine).add(newKey);
		// System.out.println("-----------------");
		// System.out.print(hm);
		// System.out.println("-----------------");
	}

	public String highestRated(String cuisine) {
		return hm.get(cuisine).first().split(":")[0];
	}
}
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */