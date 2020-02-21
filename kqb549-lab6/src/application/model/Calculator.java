package application.model;

/**
 * 
 * @author huaweisun
 *
 */
public class Calculator {
	private int sum = 0;
	private int buffer = 0;
	private int total = 0;
	private int getTextfieldTo = 0;

	// get text and split up
	public void getTextSp(String name) {
		String[] tokens = name.split(" ");
		int count = tokens.length;
		for (int i = 0; i < tokens.length; i++) {
			try {
				if (tokens[i].trim().isEmpty()) {
					sum += 0;
				} else if (tokens[i].matches("\\d+")) {
					int getnumber = Integer.parseInt(tokens[i]);
					sum += getnumber;
				} else {
					setBuffer(getBuffer() + 1);
					if (count >1)
					count--;
				}
			} catch (NumberFormatException e) {
				System.out.println("average calculate not allow letters please check");
			}
		}
		Average(sum, count);
	}

	// average sum/count
	public int Average(int num, int count) {
			sum = num / count;
		return sum;
	}

	// getter for sum
	public int getSum() {
		return sum;
	}

	// setter for sum
	public void setSum(int sum) {
		this.sum = sum;
	}

	// getter for buffer
	public int getBuffer() {
		return buffer;
	}

	// setter for buffer
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	// calculating grade
	public void calculategrade(double Slider, String Textfield) {
		int gettextnum = 0;
		double getslidernum = 0;
		if (Textfield.trim().isEmpty()) {
			total += 0;
		} else {
			volidate(Textfield);
			gettextnum = Integer.parseInt(Textfield);
			getslidernum = Slider * 0.01;
			total += (int) Math.round(gettextnum * getslidernum);
		}
	}

	// volidate check all Textfield plus together if it is 100
	public void volidate(String Textfield) {
		setGetTextfieldTo(getGetTextfieldTo() + Integer.parseInt(Textfield));

	}

	// check using for letter grade
	public String check(int result) {
		String letter;
		if (result < 70)
			letter = "F";
		else if (result >= 70 && result < 80)
			letter = "C";
		else if (result >= 80 && result < 90)
			letter = "B";
		else
			letter = "A";
		return letter;

	}

	// getter total
	public int getTotal() {
		return total;
	}

	// setter total
	public void setTotal(int total) {
		this.total = total;
	}

	// getter gettextfield
	public int getGetTextfieldTo() {
		return getTextfieldTo;
	}

	// setter gettextfield
	public void setGetTextfieldTo(int getTextfieldTo) {
		this.getTextfieldTo = getTextfieldTo;
	}

}
