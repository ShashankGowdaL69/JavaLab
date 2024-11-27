package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] externalMarks = new int[5];

    public External(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void setMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            externalMarks[i] = marks[i];
        }
    }
}
