//Client classes more or less doing same thing
//created methods toString() && toString2() to cover every format from Client classes
public class Person {
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	@Override
	public String toString() {
		return ((first == null ? "" : (first + " ")) + (middle == null ? "" : (middle + " ")) + (last == null ? "" : last));

	}
	public String toString2() {
		return ((last == null ? "" : (last + ", ")) + (first == null ? "" : (first)) + (middle == null ? "" : " " + middle));
	}

}