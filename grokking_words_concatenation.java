import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    // TODO: Write your code here
    Map<String, Integer> wordsCountMap = new HashMap<String, Integer>();
    for (String s : words) {
      wordsCountMap.put(s, wordsCountMap.getOrDefault(s, 0) + 1);
    }

    int wordsCount = words.length, wordLength = words[0].length();

    for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
      Map<String, Integer> wordsSeen = new HashMap<>();
      for (int j = 0; j < wordsCount; j++) {
        int nextWordIndex = i + j * wordLength;
        String word = str.substring(nextWordIndex, nextWordIndex + wordLength);

        // if the wordsCountMap does not have this word, then we do not need this word, so break.
        if (!wordsCountMap.containsKey(word)) {
          break;
        }

        wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

        // if we have seen more words than we need, then this is not valid, so break.
        if (wordsSeen.get(word) > wordsCountMap.getOrDefault(word, 0)) {
          break;
        }

        if (j + 1 == wordsCount) {
          resultIndices.add(i);
        }
      }
    }

    return resultIndices;
  }
}












