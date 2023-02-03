package easy;

public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        boolean output = new StudentAttendanceRecordI().studentAttendanceRecordI("PPALLP");
        boolean output1 = new StudentAttendanceRecordI().studentAttendanceRecordI("PPALLL");
        assert output;
        assert !output1;
    }

    public boolean studentAttendanceRecordI(String s) {
        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A' -> {
                    absent++;
                    late = 0;
                }
                case 'L' -> {
                    late++;
                    if (late == 3) {
                        return false;
                    }
                }
                case 'P' -> late = 0;
                default -> throw new IllegalArgumentException("ERROR");
            }
        }
        return absent < 2;
    }
}
