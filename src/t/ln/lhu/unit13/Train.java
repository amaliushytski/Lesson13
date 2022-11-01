package t.ln.lhu.unit13;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Train {

	private String destination;
	private int trainNumber;
	private int departureHours;
	private int departureMinutes;

	public Train(String destination, int trainNumber, int departureHours, int departureMinutes) {
		super();
		this.destination = destination;
		this.trainNumber = trainNumber;
		this.departureHours = departureHours;
		this.departureMinutes = departureMinutes;

	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public int getDepartureHours() {
		return departureHours;
	}

	public void setDepartureHours(int departureHours) {
		this.departureHours = departureHours;
		if (departureHours > 23 || departureHours < 0) {
			this.departureHours = 0;
		} else {
			this.departureHours = departureHours;
		}
	}

	public int getDepartureMinutes() {
		return departureMinutes;
	}

	public void setDepartureMinutes(int departureMinutes) {
		if (departureMinutes > 59 || departureMinutes < 0) {
			this.departureMinutes = 0;
		} else {
			this.departureMinutes = departureMinutes;
		}
	}

	public void addMinutes(int x) {
		if (x < 60) {
			this.departureMinutes = this.departureMinutes + x;
		} else {
			this.departureMinutes = x / 60;
			this.departureHours = this.departureHours + departureMinutes / 60;
			this.departureMinutes = departureMinutes % 60;
		}
	}

	public void addHours(int x) {
		if (x < 24) {
			this.departureHours = departureHours + x;
		} else {
			this.departureHours = departureHours % 24;
		}
	}

	public static void print(List<Train> trains) {
		for (Train tr : trains) {
			System.out.print("\nDestination: " + tr.destination + "\nTrain Number: " + tr.trainNumber
					+ "\nDeparture Time = " + tr.departureHours + ":" + tr.departureMinutes);
			System.out.println();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(departureHours, departureMinutes, destination, trainNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return departureHours == other.departureHours && departureMinutes == other.departureMinutes
				&& Objects.equals(destination, other.destination) && trainNumber == other.trainNumber;
	}

	public static void trainByRequest(List<Train> trains) {
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите номер поезда");
		System.out.print("> ");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.print("Неверный ввод. Введите значение: ");
		}
		x = sc.nextInt();

		for (Train tr : trains) {
			if (tr.getTrainNumber() == x) {
				System.out.print("\nDestination: " + tr.getDestination() + "\nTrain Number: " + tr.getTrainNumber()
						+ "\nDeparture Time = " + tr.getDepartureHours() + ":" + tr.getDepartureMinutes());
				System.out.println();
			}

		}
		System.out.println("-----------------------");
	}

}
