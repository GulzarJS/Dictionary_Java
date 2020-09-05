/**
 * Created by Gulzar Safar on 9/5/2020
 *
 * The purpose of this program is provide users with Azerbaijani-English and English-Azerbaijani dictionary
 * Users can look for translations of wanted words.
 * If translations of wanted words don't exist in dictionaries, users can add new translations.
 *
 */

import java.util.*;

public class Dictionary {

    public static void main(String[] args) {

        // Initializing lists which contain words
        List<String> az = Arrays.asList("kitab", "stol", "qelem", "masin");
        List<String> en = Arrays.asList("book", "table", "pen", "car");

        // Initializing dictionaries
        Map<String, String> azEnMap = new HashMap<>();
        Map<String, String> enAzMap = new HashMap<>();

        // Filling dictionaries
        fillDictionary(azEnMap,az,en);
        fillDictionary(enAzMap,en,az);

        // Printing dictionaries (just to be sure of the result)
/*        System.out.println("Azerbaijani-English Dictionary:");
          printDictionary(azEnMap);
          System.out.println("English-Azerbaijani Dictionary");
          printDictionary(enAzMap);
 */

        // For getting input from users
        Scanner scanner = new Scanner(System.in);

        // String for wanted word
        String word;

        // String for new word's translation
        String translation;

        // String for answers of questions
        String answer;

        // String for defining language of word
        String lang;

        // Getting wanted word from user
        System.out.print("Enter the word: ");

        word = scanner.next();

        // Searching translation in dictionaries
        // When it does not exist, add it to dictionaries if user wants
        if(!getTranslation(azEnMap, enAzMap, word)){

            System.out.print("Do you want to add this word to dictionary? (yes/no): ");
            answer = scanner.next();

            if(answer.equals("yes")){

                // Getting translation and language of new word from user
                System.out.println("Enter translation of this word: ");
                translation = scanner.next();
                System.out.println("What language is this word? (az/en): ");
                lang = scanner.next();

                // Adding new word and its translation to dictionary according to the language
                if(lang.equals("az")){
                    addDictionary(azEnMap, word, translation);
                    addDictionary(enAzMap, translation, word);

                    System.out.println("New word was successfully added to the dictionary. Thank tou for your support!");
                }else if (lang.equals("en")){
                    addDictionary(enAzMap, word, translation);
                    addDictionary(azEnMap, translation, word);

                    System.out.println("New word was successfully added to the dictionary. Thank tou for your support!");
                }else{
                    System.out.println("We don't have dictionary for this language");
                }
            }
        }

        // Printing dictionaries (just to be sure of the result)
/*        System.out.println("Azerbaijani-English Dictionary:");
          printDictionary(azEnMap);
          System.out.println("English-Azerbaijani Dictionary");
          printDictionary(enAzMap);
 */


    }

    // For filling created dictionary with words and their translations
    public static void fillDictionary(Map<String, String> dictionary, List<String> words, List<String> translations){

        Iterator<String> iterator1 = words.iterator();
        Iterator<String> iterator2 = translations.iterator();

        while(iterator1.hasNext() && iterator2.hasNext()){
            dictionary.put(iterator1.next(),iterator2.next());
        }

    }

    // For adding new words to dictionaries
    public static void addDictionary(Map<String, String> dictionary, String word, String translation){
        dictionary.put(word,translation);
    }

    // For getting translations of wanted words
    public static boolean getTranslation(Map<String, String> dictionary_1, Map<String, String> dictionary_2, String word){
        if(dictionary_1.containsKey(word)) {
            System.out.println("Translation: " + dictionary_1.get(word));
            return true;
        }else if (dictionary_2.containsKey(word)) {
            System.out.println("Translation: " + dictionary_2.get(word));
            return true;
        } else {
            System.out.println("The word you are looking for does not exist in the dictionary");
            return false;
        }
    }

    // For printing dictionaries
    public static void printDictionary(Map<String, String> dictionary){
        Set<String> keySet = dictionary.keySet();
        for (String key : keySet) {
            System.out.println(key + " = " + dictionary.get(key));
        }
    }


}
