class MyCalendar {
    List<Tuple> bookings = new ArrayList<>();

    public MyCalendar() {}

    public boolean book(int start, int end) {
        Tuple t = new Tuple(start, end - 1);
        if (isRangeBooked(t)) {
            return false;
        }
        bookings.add(t);
        return true;
    }

    // reserved=10..19  t=15..24
    // reserved=2..8   t=1..3
    // reserved=3..8   t=1..4
    // reserved=2..3   t=1..2
    boolean isRangeBooked(Tuple t) {
        for (Tuple reserved : bookings) {
            if (t.start >= reserved.start && t.start <= reserved.end) {
                return true;
            } else if (t.end >= reserved.start && t.end <= reserved.end) {
                return true;
            } else if (t.start <= reserved.start && t.end >= reserved.end) {
                return true;
            }
        }
        return false;
    }

    static class Tuple {
        int start;
        int end;

        public Tuple(int s, int e) {
            start = s;
            end = e;
        }
    }
}
