package Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the words (separated by spaces):");
		String dictionaryInput = scanner.nextLine();
		List<String> dictionary = Arrays.asList(dictionaryInput.split(" "));

		System.out.println("Enter the query words (separated by spaces):");
		String queryInput = scanner.nextLine();
		List<String> query = Arrays.asList(queryInput.split(" "));

		Anagram anagram = new Anagram();
		System.out.println(anagram.stringAnagram(dictionary, query));

		scanner.close();
	}

	private List<Integer> stringAnagram(List<String> dictionaryList, List<String> queryList) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> dictMap = new HashMap<>();
		dictionaryList.forEach(dict -> {
			char tempArray[] = dict.toCharArray();
			Arrays.sort(tempArray);
			String sortedDict = new String(tempArray);
			if (dictMap.containsKey(sortedDict)) {
				dictMap.put(sortedDict, dictMap.get(sortedDict) + 1);
			} else {
				dictMap.put(sortedDict, 1);
			}
		});
		queryList.forEach(query -> {
			char tempArray[] = query.toCharArray();
			Arrays.sort(tempArray);
			String sortedQuery = new String(tempArray);
			int count = 0;
			if (dictMap.containsKey(sortedQuery)) {
				count = dictMap.get(sortedQuery);
			}
			answer.add(count);
		});
		return answer;
	}
}





