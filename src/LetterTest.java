public class LetterTest {
    public static void main (String[] args) {
        LetterTracker lt1 = new LetterTracker("Computer Science");
        System.out.println(lt1.getLetterCount('C'));
        System.out.println(lt1.size());
        System.out.println(lt1.isEmpty());
        System.out.println(lt1.toString());
        lt1.setLetterCount('C', 10);
        System.out.println(lt1.toString());
        System.out.println(lt1.getLetterCount('C'));
        LetterTracker lt2 = new LetterTracker("Programming III");
        System.out.println(lt2.toString());
        LetterTracker lt3 = new LetterTracker("III");
        LetterTracker lt4 = lt2.subtract(lt3);
        System.out.println(lt4.toString());
        lt4 = lt2.add(lt3);
        System.out.println(lt2.toString());
    }
}
