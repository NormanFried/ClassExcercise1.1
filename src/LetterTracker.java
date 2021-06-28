public class LetterTracker {
    private int[] letters;
    private int size;

    public LetterTracker(String kasady) {
        kasady = kasady.replaceAll("[^a-zA-Z]", "").toLowerCase();
        size = kasady.length();
        letters = new int[26];
        for (char c : kasady.toCharArray()) {
            int index = c - 'a';
            letters[index]++;
        }
    }

    public int getLetterCount(char letter) {
        letter = Character.toLowerCase(letter);
        return letters[letter - 'a'];
    }

    public void setLetterCount(char letter, int value) {
        //taking into account changing of already in place value
        letter = Character.toLowerCase(letter);

        size -= letters[letter - 'a'];
        letters[letter - 'a'] = value;
        //readjusting total size
        size += letters[letter - 'a'];

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
    //Next two parts are for making the new LetterTrackers
    public LetterTracker add(LetterTracker secondTracker) {
        LetterTracker lt = new LetterTracker("");
        for (int i = 0; i < letters.length; i++) {
            char c = (char) (i + 'a');
            lt.setLetterCount(c, getLetterCount(c) + secondTracker.getLetterCount(c));
        }
        return lt;
    }

    public LetterTracker subtract(LetterTracker secondTracker) {
        LetterTracker lt = new LetterTracker("");
        for (int i = 0; i < letters.length; i++) {
            char c = (char) (i + 'a');
            lt.setLetterCount(c, getLetterCount(c) - secondTracker.getLetterCount(c));
        }
        return lt;
    }
}