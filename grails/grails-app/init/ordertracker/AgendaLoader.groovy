package ordertracker

import ordertracker.constants.Keywords

class AgendaLoader {
    
    private long generateTimeInMs(Calendar calendar, int year, int month, int day, int hour, int minutes) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DATE, day)
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minutes)
        calendar.set(Calendar.SECOND, 0)
        
        return calendar.getTimeInMillis()
    }

    private int getDayOfTheWeek(Calendar calendar, int day) {
        calendar.set(Calendar.DAY_OF_WEEK, day)
        return calendar.get(Calendar.DAY_OF_MONTH)
    }

    def load() {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(Keywords.AR_TIMEZONE.toString()))
        calendar.setFirstDayOfWeek(calendar.SUNDAY)

        int year = calendar.get(Calendar.YEAR)
        int month = calendar.get(Calendar.MONTH)

        int sunday = this.getDayOfTheWeek(calendar, Calendar.SUNDAY)
        int monday = this.getDayOfTheWeek(calendar, Calendar.MONDAY)
        int tuesday = this.getDayOfTheWeek(calendar, Calendar.TUESDAY)
        int wednesday = this.getDayOfTheWeek(calendar, Calendar.WEDNESDAY)
        int thursday = this.getDayOfTheWeek(calendar, Calendar.THURSDAY)
        int friday = this.getDayOfTheWeek(calendar, Calendar.FRIDAY)
        int saturday = this.getDayOfTheWeek(calendar, Calendar.SATURDAY)

        new Agenda(seller_id:1, client_id:1,date: this.generateTimeInMs(calendar, year, month, monday, 19, 30), day:2, time:'19:30').save()
        new Agenda(seller_id:1, client_id:2,date: this.generateTimeInMs(calendar, year, month, wednesday, 12, 30), day:4, time:'12:30').save()
        new Agenda(seller_id:1, client_id:3,date: this.generateTimeInMs(calendar, year, month, friday, 14, 30), day:6, time:'14:30').save()
        new Agenda(seller_id:1, client_id:4,date: this.generateTimeInMs(calendar, year, month, friday, 11, 30), day:6, time:'11:30').save()
        new Agenda(seller_id:1, client_id:5,date: this.generateTimeInMs(calendar, year, month, saturday, 15, 30), day:7, time:'15:30').save()
        new Agenda(seller_id:1, client_id:6,date: this.generateTimeInMs(calendar, year, month, thursday, 14, 00), day:5, time:'14:00').save()
        new Agenda(seller_id:1, client_id:7,date: this.generateTimeInMs(calendar, year, month, tuesday, 12, 00), day:3, time:'12:00').save()
        new Agenda(seller_id:1, client_id:8,date: this.generateTimeInMs(calendar, year, month, wednesday, 11, 00), day:4, time:'11:00').save()
        new Agenda(seller_id:1, client_id:9,date: this.generateTimeInMs(calendar, year, month, thursday, 12, 00), day:5, time:'12:00').save()
        new Agenda(seller_id:1, client_id:10,date: this.generateTimeInMs(calendar, year, month, friday, 13, 00), day:6, time:'13:00').save()
        new Agenda(seller_id:1, client_id:11,date: this.generateTimeInMs(calendar, year, month, saturday, 14, 00), day:7, time:'14:00').save()
        new Agenda(seller_id:1, client_id:12,date: this.generateTimeInMs(calendar, year, month, monday, 12, 00), day:2, time:'12:00').save()
        new Agenda(seller_id:1, client_id:13,date: this.generateTimeInMs(calendar, year, month, tuesday, 16, 00), day:3, time:'16:00').save()
        new Agenda(seller_id:1, client_id:14,date: this.generateTimeInMs(calendar, year, month, wednesday, 17, 00), day:4, time:'17:00').save()
        new Agenda(seller_id:1, client_id:15,date: this.generateTimeInMs(calendar, year, month, thursday, 9, 00), day:1, time:'09:00').save()
        new Agenda(seller_id:2, client_id:16,date: this.generateTimeInMs(calendar, year, month, friday, 10, 00), day:6, time:'10:00').save()
        new Agenda(seller_id:2, client_id:17,date: this.generateTimeInMs(calendar, year, month, saturday, 11, 00), day:1, time:'11:00').save()
        new Agenda(seller_id:2, client_id:18,date: this.generateTimeInMs(calendar, year, month, monday, 12, 00), day:2, time:'12:00').save()
        new Agenda(seller_id:2, client_id:19,date: this.generateTimeInMs(calendar, year, month, tuesday, 14, 00), day:3, time:'14:00').save()
        new Agenda(seller_id:2, client_id:20,date: this.generateTimeInMs(calendar, year, month, wednesday, 14, 00), day:4, time:'14:00').save()
        new Agenda(seller_id:2, client_id:21,date: this.generateTimeInMs(calendar, year, month, thursday, 15, 00), day:5, time:'15:00').save()
        new Agenda(seller_id:2, client_id:22,date: this.generateTimeInMs(calendar, year, month, friday, 16, 00), day:6, time:'16:00').save()
        new Agenda(seller_id:2, client_id:23,date: this.generateTimeInMs(calendar, year, month, saturday, 17, 00), day:7, time:'17:00').save()
        new Agenda(seller_id:2, client_id:24,date: this.generateTimeInMs(calendar, year, month, monday, 9, 00), day:2, time:'09:00').save()
        new Agenda(seller_id:2, client_id:25,date: this.generateTimeInMs(calendar, year, month, tuesday, 14, 00), day:3, time:'14:00').save()
        new Agenda(seller_id:2, client_id:26,date: this.generateTimeInMs(calendar, year, month, wednesday, 11, 00), day:4, time:'11:00').save()
        new Agenda(seller_id:2, client_id:27,date: this.generateTimeInMs(calendar, year, month, thursday, 12, 00), day:5, time:'12:00').save()
        new Agenda(seller_id:2, client_id:28,date: this.generateTimeInMs(calendar, year, month, friday, 13, 00), day:6, time:'13:00').save()
        new Agenda(seller_id:2, client_id:29,date: this.generateTimeInMs(calendar, year, month, saturday, 14, 00), day:7, time:'14:00').save()
        new Agenda(seller_id:2, client_id:30,date: this.generateTimeInMs(calendar, year, month, monday, 15, 00), day:2, time:'15:00').save()
        new Agenda(seller_id:3, client_id:31,date: this.generateTimeInMs(calendar, year, month, tuesday, 16, 00), day:3, time:'16:00').save()
        new Agenda(seller_id:3, client_id:32,date: this.generateTimeInMs(calendar, year, month, wednesday, 17, 00), day:4, time:'17:00').save()
        new Agenda(seller_id:3, client_id:33,date: this.generateTimeInMs(calendar, year, month, thursday, 9, 00), day:5, time:'09:00').save()
        new Agenda(seller_id:3, client_id:34,date: this.generateTimeInMs(calendar, year, month, friday, 10, 00), day:6, time:'10:00').save()
        new Agenda(seller_id:3, client_id:35,date: this.generateTimeInMs(calendar, year, month, saturday, 11, 00), day:7, time:'11:00').save()
        new Agenda(seller_id:3, client_id:36,date: this.generateTimeInMs(calendar, year, month, monday, 14, 00), day:2, time:'14:00').save()
        new Agenda(seller_id:3, client_id:37,date: this.generateTimeInMs(calendar, year, month, tuesday, 13, 00), day:3, time:'13:00').save()
        new Agenda(seller_id:3, client_id:38,date: this.generateTimeInMs(calendar, year, month, wednesday, 14, 00), day:4, time:'14:00').save()
        new Agenda(seller_id:3, client_id:39,date: this.generateTimeInMs(calendar, year, month, thursday, 15, 00), day:5, time:'15:00').save()
        new Agenda(seller_id:3, client_id:40,date: this.generateTimeInMs(calendar, year, month, friday, 16, 00), day:6, time:'16:00').save()
        new Agenda(seller_id:3, client_id:41,date: this.generateTimeInMs(calendar, year, month, saturday, 14, 00), day:7, time:'14:00').save()
        new Agenda(seller_id:3, client_id:42,date: this.generateTimeInMs(calendar, year, month, monday, 9, 00), day:2, time:'09:00').save()
        new Agenda(seller_id:3, client_id:43,date: this.generateTimeInMs(calendar, year, month, tuesday, 10, 00), day:3, time:'10:00').save()
        new Agenda(seller_id:3, client_id:44,date: this.generateTimeInMs(calendar, year, month, wednesday, 11, 00), day:4, time:'11:00').save()
        new Agenda(seller_id:3, client_id:45,date: this.generateTimeInMs(calendar, year, month, thursday, 12, 00), day:5, time:'12:00').save()
        new Agenda(seller_id:4, client_id:46,date: this.generateTimeInMs(calendar, year, month, friday, 13, 00), day:6, time:'13:00').save()
        new Agenda(seller_id:4, client_id:47,date: this.generateTimeInMs(calendar, year, month, saturday, 14, 00), day:7, time:'14:00').save()
        new Agenda(seller_id:4, client_id:48,date: this.generateTimeInMs(calendar, year, month, monday, 15, 00), day:2, time:'15:00').save()
        new Agenda(seller_id:4, client_id:49,date: this.generateTimeInMs(calendar, year, month, tuesday, 16, 00), day:3, time:'16:00').save()
        new Agenda(seller_id:4, client_id:50,date: this.generateTimeInMs(calendar, year, month, wednesday, 17, 00), day:4, time:'17:00').save()
        new Agenda(seller_id:4, client_id:51,date: this.generateTimeInMs(calendar, year, month, thursday, 9, 00), day:5, time:'09:00').save()
        new Agenda(seller_id:4, client_id:52,date: this.generateTimeInMs(calendar, year, month, friday, 10, 00), day:6, time:'10:00').save()
        new Agenda(seller_id:4, client_id:53,date: this.generateTimeInMs(calendar, year, month, saturday, 11, 00), day:7, time:'11:00').save()
        new Agenda(seller_id:4, client_id:54,date: this.generateTimeInMs(calendar, year, month, monday, 12, 00), day:2, time:'12:00').save()
        new Agenda(seller_id:4, client_id:55,date: this.generateTimeInMs(calendar, year, month, tuesday, 13, 00), day:1, time:'13:00').save()
        new Agenda(seller_id:4, client_id:56,date: this.generateTimeInMs(calendar, year, month, wednesday, 14, 00), day:4, time:'14:00').save()
        new Agenda(seller_id:4, client_id:57,date: this.generateTimeInMs(calendar, year, month, thursday, 15, 00), day:5, time:'15:00').save()
        new Agenda(seller_id:4, client_id:58,date: this.generateTimeInMs(calendar, year, month, friday, 16, 00), day:6, time:'16:00').save()
        new Agenda(seller_id:4, client_id:1,date: this.generateTimeInMs(calendar, year, month, saturday, 17, 00), day:7, time:'17:00').save()
        new Agenda(seller_id:4, client_id:2,date: this.generateTimeInMs(calendar, year, month, wednesday, 14, 00), day:4, time:'14:00').save()
        new Agenda(seller_id:5, client_id:3,date: this.generateTimeInMs(calendar, year, month, wednesday, 14, 00), day:4, time:'14:00').save()

    }
}
