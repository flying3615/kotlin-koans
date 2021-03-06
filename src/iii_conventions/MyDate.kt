package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int):Comparable<MyDate>{

    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)
operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval,1)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)


class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)


class DateRange(val start: MyDate, val endInclusive: MyDate):Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
    //reuse compare
    operator fun contains(d: MyDate) = start<=d && d<=endInclusive
}

class DateIterator(val dateRange:DateRange): Iterator<MyDate> {

    var current:MyDate = dateRange.start

    override fun hasNext(): Boolean = current <= dateRange.endInclusive

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

}
