package t.ln.lhu.unit13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Train a1 = new Train("Minsk", 3, 6, 47);
		Train a2 = new Train("Minsk", 12, 6, 31);
		Train a3 = new Train("Paris", 11, 19, 22);
		Train a4 = new Train("Warsaw", 1, 23, 59);
		Train a5 = new Train("London", 55, 19, 22);
		Train a6 = new Train("Madrid", 16, 00, 01);

		List<Train> trains = new ArrayList<Train>();
		trains.add(a1);
		trains.add(a2);
		trains.add(a3);
		trains.add(a4);
		trains.add(a5);
		trains.add(a6);

		System.out.println("Сортировка коллекции по пункту назначения");
		trains.sort((train1, train2) -> train1.getDestination().compareTo(train2.getDestination()));

		Train.print(trains);

		// Вывод информации о поезде, номер которого введен пользователем
		Train.trainByRequest(trains);

		System.out.println("Сортировка элементов коллекции по номерам поездов");
		trains.sort((train1, train2) -> train1.getTrainNumber() - train2.getTrainNumber());

		Train.print(trains);

		System.out.println("Сортировка коллекции по пункту назначения c учетом времени");
		Comparator<Train> comparator = Comparator.comparing(Train -> Train.getDestination());
		comparator = comparator.thenComparing(Comparator.comparing(Train -> Train.getDepartureHours()));
		comparator = comparator.thenComparing(Comparator.comparing(Train -> Train.getDepartureMinutes()));
		Stream<Train> trainStream = trains.stream().sorted(comparator);
		List<Train> sortedTrains = trainStream.collect(Collectors.toList());

		Train.print(sortedTrains);

	}

}
